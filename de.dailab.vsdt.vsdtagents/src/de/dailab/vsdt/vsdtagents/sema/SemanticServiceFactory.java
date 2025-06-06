package de.dailab.vsdt.vsdtagents.sema;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.semanticweb.owlapi.model.SWRLRule;

import de.dailab.jiactng.agentcore.action.Action;
import de.dailab.jiactng.owlsdescription.ServiceDescription;
import de.dailab.jiactng.owlsdescription.process.Param;
import de.dailab.vsdt.DataType;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.util.VsdtElementFactory;

/**
 * Class providing some of the helper methods formerly found in 
 * SemaIntegrationAgentBean. Moved here so the actual bean class
 * is smaller and easier to extend.
 *
 * @author kuester
 */
public class SemanticServiceFactory {

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
	public static Service createService(Action action) {
		Service result = VsdtFactory.eINSTANCE.createService();

		// set service attributes; this should be compatible to how the mapping maps services to JIAC actions
		result.setOperation(action.getName());
		result.setType("JIAC Action");
		if (action.getProviderBean() != null) {
			result.setInterface(action.getProviderBean().getBeanName());
		}
		result.setTemplate(true);
//		result.setLocation(null);
//		result.setParticipant(null);
//		result.setDescription(null);

		// set input and output
		for (int i = 0; i < action.getInputTypeNames().size(); i++) {
			Property input = VsdtFactory.eINSTANCE.createProperty();
			input.setName(String.format("arg%d", i));
			input.setType(getProperType(action.getInputTypeNames().get(i)));
			result.getInput().add(input);
		}
		for (int i = 0; i < action.getResultTypeNames().size(); i++) {
			Property output = VsdtFactory.eINSTANCE.createProperty();
			output.setName(String.format("res%d", i));
			output.setType(getProperType(action.getResultTypeNames().get(i)));
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
	public static Set<DataType> createDatatypes(Action action) {
		Set<DataType> result = new HashSet<>();

		List<String> allTypeNames = new ArrayList<>();
		allTypeNames.addAll(action.getInputTypeNames());
		allTypeNames.addAll(action.getResultTypeNames());

		for (String typeName : allTypeNames) {
			if (! OntoUtils.specialTypes.containsKey(typeName)) {
				DataType dataType = VsdtFactory.eINSTANCE.createDataType();
				dataType.setLanguage("Java");
				int dot = typeName.lastIndexOf('.');
				dataType.setName(typeName.substring(dot + 1));
				dataType.setPackage(typeName.substring(0, dot));
//				dataType.setUrl(null);
				result.add(dataType);
			}
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
	public static Service createService(ServiceDescription serviceDescription) {
		// restore transient fields
		try {
			serviceDescription = OntoUtils.reloadOntology(serviceDescription);
		} catch (final Exception e) {
			Display.getDefault().asyncExec(() -> MessageDialog.openWarning(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
							"Error loading Ontologies", "Could not load linked ontologies. Some semantic information might have been lost. "
									+ "Error was: " + e.getMessage()));
		}
		
		Service result = VsdtFactory.eINSTANCE.createService();
		
		// set service attributes; this should be compatible to how the mapping maps services to JIAC actions
		result.setOperation(decode(serviceDescription.getServiceName()));
		result.setType("JIAC Semantic Service");
//		result.setInterface(action.getProviderBean().getBeanName());
		result.setLocation(serviceDescription.getIRI());
//		result.setParticipant(null);
		result.setDescription(serviceDescription.getProfile().getDescription());
		
		// set input and output
		if (serviceDescription.getProcess().getInput() != null) {
			for (Param param : serviceDescription.getProcess().getInput()) {
				Property input = VsdtFactory.eINSTANCE.createProperty();
				input.setName(param.getName());
				input.setType(getTypeFromParam(param));
				result.getInput().add(input);
			}
		}
		if (serviceDescription.getProcess().getOutput() != null) {
			for (Param param : serviceDescription.getProcess().getOutput()) {
				Property output = VsdtFactory.eINSTANCE.createProperty();
				output.setName(param.getName());
				output.setType(getTypeFromParam(param));
				result.getOutput().add(output);
			}
		}
		// add precondition and effect, if reconstruction was successful
		if (serviceDescription.getProcess().getPreConditions() != null && serviceDescription.getProcess().getEffects() != null) {
			for (SWRLRule rule : serviceDescription.getProcess().getPreConditions().values()) {
				Expression expression = VsdtFactory.eINSTANCE.createExpression();
				expression.setExpression(OntoUtils.formatSwrlRule(rule));
				expression.setLanguage("SWRL");
				result.getPreconditions().add(expression);
			}
			for (SWRLRule rule : serviceDescription.getProcess().getEffects().values()) {
				Expression expression = VsdtFactory.eINSTANCE.createExpression();
				expression.setExpression(OntoUtils.formatSwrlRule(rule));
				expression.setLanguage("SWRL");
				result.getEffects().add(expression);
			}
		}
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
	public static Set<DataType> createDatatypes(ServiceDescription serviceDescription) {
		Set<DataType> result = new HashSet<>();
		
		List<Param> allParams = new ArrayList<>();
		allParams.addAll(emptyIfNull(serviceDescription.getProcess().getInput()));
		allParams.addAll(emptyIfNull(serviceDescription.getProcess().getOutput()));

		for (Param param : allParams) {
			String fullName = getTypeFromParam(param);
			if (! OntoUtils.specialTypes.containsKey(fullName)) {
				int sep = fullName.lastIndexOf('.');
				String pkg = sep != -1 ? fullName.substring(0, sep) : null;
				String name = sep != -1 ? fullName.substring(sep + 1) : fullName;

				result.add(VsdtElementFactory.createDatatype(name, pkg, "OWL-S", param.getType().toString()));
			}
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
	public static String decode(String encodedString) {
		try {
			return URLDecoder.decode(encodedString, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.err.println("Could not decode service name: " + encodedString);
			return encodedString;
		}
	}
	
	/**
	 * Get Type name from Param.
	 * 
	 * @param param		some OWL-S Param
	 * @return			the corresponding Java type name
	 */
	public static String getTypeFromParam(Param param) {
		String name = getTypeFromTypeUri(param.getType());
		if (OntoUtils.specialTypes.containsKey(name)) {
			return OntoUtils.specialTypes.get(name);
		} else {
			return param.getJavaClassName() != null
					? param.getJavaClassName()
					: param.getType().getFragment();
		}
	}
	
	/**
	 * Get the name of the data type from the URL. It appears at the end after '#'
	 * Example: http://dai-labor.de/~masuch/ontology/mams_types.owl#MessageText
	 * 
	 * @param uri		some URI like in above example
	 * @return			the part after the '#', being the name of the type
	 */
	public static String getTypeFromTypeUri(URI uri) {
		String uriString = uri.toString();
		int hash = uriString.lastIndexOf('#');
		String typeName = uriString.substring(hash + 1);
		return typeName;
	}
	
	/**
	 * Get substitution type, if necessary.
	 * 
	 * @param type		original type
	 * @return			substitution type, or original type
	 */
	public static String getProperType(String type) {
		if (OntoUtils.specialTypes.containsKey(type)) {
			return OntoUtils.specialTypes.get(type);
		} else {
			return type;
		}
	}

	/*
	 * other helper stuff
	 */

	private static <T> Collection<T> emptyIfNull(Collection<T> stuff) {
		return stuff == null ? Collections.emptyList() : stuff;
	}

}
