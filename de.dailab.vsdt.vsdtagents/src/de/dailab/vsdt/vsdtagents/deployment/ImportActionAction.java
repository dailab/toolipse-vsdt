package de.dailab.vsdt.vsdtagents.deployment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.dailab.jiactng.agentcore.ontology.IActionDescription;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.DataType;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.vsdtagents.VsdtAgents;
import de.dailab.vsdt.vxl.util.Util;

/**
 * Action for importing JIAC Action from Explorer View to VSDT. The Action that
 * is currently selected in the JIAC V Explorer View is taken and if the active 
 * Editor is a VSDT editor (which is determined by its ID), a corresponding VSDT
 * Service Implementation object along with input and result Messages and 
 * Properties is created and inserted into the VSDT model opened in the Editor.
 * 
 * @author kuester
 */
public class ImportActionAction extends Action {

	public static final String TITLE = "Import into VSDT";
	public static final String TOOLTIP = "Imports the selected element into the currently opened BPMN diagram.";

	public static final String MESSAGE_NO_ACTION = "Only Actions (Services) can be imported into VSDT";
	public static final String MESSAGE_NO_VSDT = "VSDT Diagram Editor must be opened for Import into VSDT";
	public static final String MESSAGE_ERROR = "Unable to import Action into VSDT Diagram";
	public static final String MESSAGE_CONFIRM = "Import selected Action into VSDT Diagram?";
	public static final String MESSAGE_SUCCESS = "Successfully imported Action into VSDT Diagram";

	public static final String[] ALLOWED_EDITOR_IDS = new String[] { "de.dailab.vsdt.diagram", "de.dailab.vsdt.diagram.meta" };

	/** This Map is holding the association from Java types to VSDT type names */
	public static final Map<String, String> typeMap;
	static {
		typeMap = new HashMap<String, String>();
		typeMap.put("java.lang.String",    Util.TYPE_STRING);
		typeMap.put("java.lang.Character", Util.TYPE_STRING);
		typeMap.put("char",                Util.TYPE_STRING);
		typeMap.put("java.lang.Boolean",   Util.TYPE_BOOLEAN);
		typeMap.put("boolean",             Util.TYPE_BOOLEAN);
		typeMap.put("java.lang.Byte",      Util.TYPE_INTEGER);
		typeMap.put("byte",                Util.TYPE_INTEGER);
		typeMap.put("java.lang.Short",     Util.TYPE_INTEGER);
		typeMap.put("short",               Util.TYPE_INTEGER);
		typeMap.put("java.lang.Integer",   Util.TYPE_INTEGER);
		typeMap.put("int",                 Util.TYPE_INTEGER);
		typeMap.put("java.lang.Long",      Util.TYPE_LONG);
		typeMap.put("long",                Util.TYPE_LONG);
		typeMap.put("java.lang.Float",     Util.TYPE_FLOAT);
		typeMap.put("float",               Util.TYPE_FLOAT);
		typeMap.put("java.lang.Double",    Util.TYPE_DOUBLE);
		typeMap.put("double",              Util.TYPE_DOUBLE);
	}

	/** the Viewer holding the Actions to be imported */
	private final Viewer viewer;

	/**
	 * Create Action instance.
	 * 
	 * @param viewer	the Viewer holding the Actions to be imported
	 */
	public ImportActionAction(Viewer viewer) {
		this.viewer = viewer;
		this.setText(TITLE);
		this.setToolTipText(TOOLTIP);
		this.setImageDescriptor(VsdtAgents.getImageDescriptor("export.gif"));
	}

	/**
	 * Execute Action. Check for prerequisites (matching selection and diagram
	 * editor), create VSDT service description from action and add service 
	 * description to opened VSDT diagram editor using an undo-able command.
	 */
	@Override
	public void run() {
		DiagramEditPart diagramEditPart = null;
		IActionDescription selectedAction = null;

		// check whether editor is VSDT editor
		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IEditorPart editor = window.getActivePage().getActiveEditor();
		if (editor instanceof DiagramEditor) {
			DiagramEditor diagramEditor = (DiagramEditor) editor;
			if (Arrays.asList(ALLOWED_EDITOR_IDS).contains(diagramEditor.getContributorId())) {
				diagramEditPart = diagramEditor.getDiagramEditPart();
			}
		}

		// check whether viewer selection is action
		if (viewer.getSelection() instanceof TreeSelection) {
			TreeSelection selection = (TreeSelection) viewer.getSelection();
			if ((selection.getFirstElement() instanceof IActionDescription)) {
				selectedAction = (IActionDescription) selection.getFirstElement();
			}
		}

		// display messages on wrong selection
		if (diagramEditPart == null) {
			MessageDialog.openInformation(getShell(), TITLE, MESSAGE_NO_VSDT);
			return;
		}
		if (selectedAction == null) {
			MessageDialog.openInformation(getShell(), TITLE, MESSAGE_NO_ACTION);
			return;
		}

		// everything set; do the import
		if (MessageDialog.openConfirm(getShell(), TITLE, MESSAGE_CONFIRM)) {

			// get diagram editor's root element
			EObject modelElement = ((View) diagramEditPart.getModel()).getElement();
			final BusinessProcessSystem rootModel = (BusinessProcessSystem) getRoot(modelElement);
			final Service service = createService(selectedAction);
			final List<DataType> dataTypes = createDataTypes(selectedAction);

			// create command to put service into root element
			final AbstractTransactionalCommand command = new AbstractTransactionalCommand(TransactionUtil.getEditingDomain(modelElement),
			      TITLE, Collections.singletonList(WorkspaceSynchronizer.getFile(modelElement.eResource()))) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					try {
						// add service to root model
						rootModel.getServices().add(service);
						for (DataType type : dataTypes) {
							// check whether data type is already known
							boolean isKnown = false;
							for (DataType other : rootModel.getDataTypes()) {
								isKnown |= other.getName().equals(type.getName())
										&& other.getPackage().equals(type.getPackage());
							}
							if (! isKnown) {
								rootModel.getDataTypes().add(type);
							}
						}
						return CommandResult.newOKCommandResult();
					}
					catch (final Exception e) {
						return CommandResult.newErrorCommandResult(e);
					}
				}
			};
			diagramEditPart.getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(command));
			MessageDialog.openInformation(getShell(), TITLE, MESSAGE_SUCCESS);
		}
	}

	/**
	 * @return the viewer's shell
	 */
	private Shell getShell() {
		return this.viewer.getControl().getShell();
	}

	/**
	 * Create Service Implementation Object for given EAction.
	 * 
	 * @param action	Action to be called by the Service Implementation
	 * @return 			Service object for the Service
	 */
	private Service createService(IActionDescription action) {
		// create basic service description
		Service service = VsdtFactory.eINSTANCE.createService();
		service.setType("JIAC Service");
		service.setOperation(action.getName());
		service.setInterface(action.getProviderDescription().getName());

		// create input message
		for (int i = 0; i < action.getInputTypeNames().size(); i++) {
			Property property = VsdtFactory.eINSTANCE.createProperty();
			property.setName("arg" + i);
			property.setType(getType(action.getInputTypeNames().get(i)));
			service.getInput().add(property);
		}

		// create output message
		for (int i = 0; i < action.getResultTypeNames().size(); i++) {
			Property property = VsdtFactory.eINSTANCE.createProperty();
			property.setName("res" + i);
			property.setType(getType(action.getResultTypeNames().get(i)));
			service.getOutput().add(property);
		}

		return service;
	}
	
	/**
	 * Create a List of VSDT Data Types based on the Actions's Input and Output.
	 * 
	 * @param action	Action to be imported
	 * @return			List of DataTypes needed for this Action
	 */
	private List<DataType> createDataTypes(IActionDescription action) {
		List<DataType> datatypes = new ArrayList<DataType>();
		List<String> allTypeNames = new ArrayList<String>();
		allTypeNames.addAll(action.getInputTypeNames());
		allTypeNames.addAll(action.getResultTypeNames());
		for (String typeName : allTypeNames) {
			if (typeName.indexOf(".") != -1) {
				int lastDot = typeName.lastIndexOf(".");
				DataType type = VsdtFactory.eINSTANCE.createDataType();
				type.setName(typeName.substring(lastDot + 1));
				type.setPackage(typeName.substring(0, lastDot));
				type.setLanguage("Java");
				datatypes.add(type);
			}
		}
		return datatypes;
	}

	/**
	 * Get an EObject's root element, i.e. the EObject transitively containing 
	 * the given EObject which has no container other than the Resource.
	 * 
	 * @param object	some object
	 * @return 			that object's top-most container other than the Resource
	 */
	private EObject getRoot(EObject object) {
		return object.eContainer() == null ? object : this.getRoot(object.eContainer());
	}

	/**
	 * Get the substitution for the given Type, if any, or the type itself.
	 * 
	 * @param type		name of some Java class or primitive
	 * @return 			name of corresponding VSDT primitive, or original name
	 */
	private static String getType(String type) {
		return typeMap.containsKey(type) ? typeMap.get(type) : type;
	}
}
