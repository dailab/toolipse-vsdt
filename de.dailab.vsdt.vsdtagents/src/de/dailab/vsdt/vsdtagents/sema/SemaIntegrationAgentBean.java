package de.dailab.vsdt.vsdtagents.sema;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.dailab.jiactng.agentcore.action.AbstractMethodExposingBean;
import de.dailab.jiactng.agentcore.action.Action;
import de.dailab.jiactng.agentcore.action.scope.ActionScope;
import de.dailab.jiactng.owlsdescription.ServiceDescription;
import de.dailab.jiactng.owlsdescription.process.Param;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.DataType;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.vsdtagents.Util;

/**
 * This bean will later be used to push services from the SeMa2 into the VSDT.
 * 
 * TODO add another action (or action parameter) for service-templates?
 *
 * @author kuester
 */
public class SemaIntegrationAgentBean extends AbstractMethodExposingBean {
	
	public static final String BEAN_NAME = "de.dailab.vsdt.vsdtagents.sema#SemaIntegrationAgentBean";
	public static final String ACTION_PUSH_SERVICE = BEAN_NAME + "#PushServiceIntoVSDT";

	/**
	 * Create VSDT Service object from JIAC Action or ServiceDescription 
	 * and add it to the VSDT diagram opened in the active editor, if any.
	 * 
	 * @param action		the Action or ServiceDescription to add a corresponding VSDT service for
	 * @throws Exception	exception in case anything goes wrong
	 */
	@Expose(name=ACTION_PUSH_SERVICE, scope=ActionScope.NODE)
	public void pushServiceIntoVsdt(Action action) throws Exception {
		
		// get BPS from editor, thus checking whether current editor is VSDT editor
		final IWorkbenchWindow[] wbws = PlatformUI.getWorkbench().getWorkbenchWindows();
		final IEditorPart editor = wbws[0].getActivePage().getActiveEditor();
		final BusinessProcessSystem bps = Util.getVsdtModel(editor);
		
		if (bps != null) {

			// create VSDT Service object corresponding to ServiceDescription
			final Service service = (action instanceof ServiceDescription)
					? createService((ServiceDescription) action)
					: createService(action);

			// create VSDT DataType objects corresponding to those used by the service
			final Set<DataType> dataTypes = (action instanceof ServiceDescription)
					? createDatatypes((ServiceDescription) action)
					: createDatatypes(action);
					
			// this JIAC agent is not running in the UI thread, so we have to asynch-exec this
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					// also, we have to put this inside a command
					ICommandProxy command = new ICommandProxy(new AbstractTransactionalCommand(
							TransactionUtil.getEditingDomain(bps), "Import Semantic Service", 
							Collections.singletonList(WorkspaceSynchronizer.getFile(bps.eResource()))) {
						@Override
						protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
							// finally, add the service to the BPS' list of services
							bps.getServices().add(service);
							// add data types referred to by service
							for (DataType dataType : dataTypes) {
								// EObject does not implement equals, so we have to do this ugly loop...
								boolean exists = false;
								for (DataType existing : bps.getDataTypes()) {
									exists = exists || EcoreUtil.equals(dataType, existing);
								}
								if (! exists) {
									bps.getDataTypes().add(dataType);
								}
							}
							return CommandResult.newOKCommandResult(bps);
						}
					});
					((DiagramEditor) editor).getDiagramEditDomain().getDiagramCommandStack().execute(command);
				}
			});
			
		} else {
			throw new Exception("Could not get Business Process System from active Editor. "
					+ "Make sure the active editor is a VSDT process diagram editor.");
		}
	}
	
	/*
	 * METHODS FOR HANDLING JIAC ACTIONS
	 * Do we need those at all, or just ServiceDescriptions?
	 */
	
	/**
	 * Create VSDT service object from given JIAC Action
	 * 
	 * Mapping:
	 * - description <- undefined
	 * - operation   <- action name
	 * - interface   <- provider bean name, if not null
	 * - type        <- "JIAC Action"
	 * - location    <- undefined
	 * - participant <- undefined
	 * - input       <- inputTypeNames
	 * - output      <- resultTypeNames
	 * 
	 * @param action	some JIAC action
	 * @return			according VSDT Service
	 */
	private Service createService(Action action) {
		Service result = VsdtFactory.eINSTANCE.createService();

		// set service attributes; this should be compatible to how the mapping maps services to JIAC actions
		result.setOperation(action.getName());
		result.setType("JIAC Action");
		if (action.getProviderBean() != null) {
			result.setInterface(action.getProviderBean().getBeanName());
		}
//		result.setLocation(null);
//		result.setParticipant(null);
//		result.setDescription(null);

		// set input and output
		for (int i = 0; i < action.getInputTypeNames().size(); i++) {
			Property input = VsdtFactory.eINSTANCE.createProperty();
			input.setName(String.format("arg%d", i));
			input.setType(action.getInputTypeNames().get(i));
			result.getInput().add(input);
		}
		for (int i = 0; i < action.getResultTypeNames().size(); i++) {
			Property output = VsdtFactory.eINSTANCE.createProperty();
			output.setName(String.format("res%d", i));
			output.setType(action.getResultTypeNames().get(i));
			result.getOutput().add(output);
		}
		return result;
	}
	
	/**
	 * Create VSDT DataType objects corresponding to the OWL data types used in the service description.
	 * 
	 * Mapping:
	 * - name     <- last segment of type name
	 * - package  <- first segments of type name
	 * - URL      <- undefined
	 * - language <- "Java"
	 * 
	 * @param action	some JIAC action
	 * @return			VSDT DataTypes according to those used by action
	 */
	private Set<DataType> createDatatypes(Action action) {
		Set<DataType> result = new HashSet<>();

		List<String> allTypeNames = new ArrayList<>();
		allTypeNames.addAll(action.getInputTypeNames());
		allTypeNames.addAll(action.getResultTypeNames());

		for (String typeName : allTypeNames) {
			DataType dataType = VsdtFactory.eINSTANCE.createDataType();
			dataType.setLanguage("Java");
			int dot = typeName.lastIndexOf('.');
			dataType.setName(typeName.substring(dot + 1));
			dataType.setPackage(typeName.substring(0, dot));
//			dataType.setUrl(null);
			result.add(dataType);
		}
		return result;
	}

	/*
	 * METHODS FOR HANDLING SERVICE DESCRIPTIONS
	 */
	
	/**
	 * Create VSDT service object from given JIAC ServiceDescription
	 * 
	 * Mapping:
	 * - description <- profile.description
	 * - operation   <- service name
	 * - interface   <- undefined
	 * - type        <- "JIAC Semantic Service"
	 * - location    <- IRI
	 * - participant <- undefined
	 * - input       <- process.input
	 * - output      <- process.output
	 * - ???         <- precondition
	 * - ???         <- effect
	 * 
	 * @param serviceDescription	some JIAC ServiceDescription
	 * @return						according VSDT Service
	 */
	private Service createService(ServiceDescription serviceDescription) {
		Service result = VsdtFactory.eINSTANCE.createService();
		
		// set service attributes; this should be compatible to how the mapping maps services to JIAC actions
		result.setOperation(decode(serviceDescription.getServiceName()));
		result.setType("JIAC Semantic Service");
//		result.setInterface(action.getProviderBean().getBeanName());
		result.setLocation(serviceDescription.getIRI());
//		result.setParticipant(null);
		result.setDescription(serviceDescription.getProfile().getDescription());

		// set input and output
		for (Param param : serviceDescription.getProcess().getInput()) {
			Property input = VsdtFactory.eINSTANCE.createProperty();
			input.setName(param.getName());
			input.setType(getTypeFromTypeUri(param.getType()));
			result.getInput().add(input);
		}
		for (Param param : serviceDescription.getProcess().getOutput()) {
			Property output = VsdtFactory.eINSTANCE.createProperty();
			output.setName(param.getName());
			output.setType(getTypeFromTypeUri(param.getType()));
			result.getOutput().add(output);
		}

		// TODO add precondition and effect (need to be added to VSDT Service model first)
		
		return result;
	}

	/**
	 * Create VSDT DataType objects corresponding to the OWL data types used in the service description.
	 * 
	 * Mapping:
	 * - name     <- name from type URL
	 * - package  <- undefined
	 * - URL      <- type URL
	 * - language <- "OWL-S"
	 * 
	 * @param serviceDescription	some JIAC ServiceDescription
	 * @return						VSDT DataTypes according to those used by service
	 */
	private Set<DataType> createDatatypes(ServiceDescription serviceDescription) {
		Set<DataType> result = new HashSet<>();
		
		List<Param> allParams = new ArrayList<>();
		allParams.addAll(serviceDescription.getProcess().getInput());
		allParams.addAll(serviceDescription.getProcess().getOutput());

		for (Param param : allParams) {
			DataType dataType = VsdtFactory.eINSTANCE.createDataType();
			dataType.setLanguage("OWL-S");
			dataType.setName(getTypeFromTypeUri(param.getType()));
			// param.getJavaClass() would be useful here, but it is null
//			dataType.setPackage(null);
			dataType.setUrl(param.getType().toString());
			result.add(dataType);
		}
		return result;
	}
	
	/**
	 * Decode string (replace '%20' with ' ' etc.), or return original string if it fails.
	 * 
	 * XXX is this really a good idea, or should the string remain encoded?
	 * 
	 * @param encodedString		some encoded string
	 * @return					decoded version, or original in case of failure
	 */
	private String decode(String encodedString) {
		try {
			return URLDecoder.decode(encodedString, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.err.println("Could not decode service name: " + encodedString);
			return encodedString;
		}
	}
	
	/**
	 * Get the name of the data type from the URL. It appears at the end after '#'
	 * Example: http://dai-labor.de/~masuch/ontology/mams_types.owl#MessageText
	 * 
	 * @param uri		some URI like in above example
	 * @return			the part after the '#', being the name of the type
	 */
	private String getTypeFromTypeUri(URI uri) {
		String uriString = uri.toString();
		int hash = uriString.lastIndexOf('#');
		String typeName = uriString.substring(hash + 1);
		return typeName;
	}
	
}
