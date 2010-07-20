package de.dailab.vsdt.diagram.dialogs;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.dailab.common.gmf.Util;
import de.dailab.common.swt.dialogs.AbstractOrganizeElementsDialog;
import de.dailab.vsdt.AssignTimeType;
import de.dailab.vsdt.Assignment;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.ui.ExpressionComposite;
import de.dailab.vsdt.diagram.ui.VsdtFeatureCombo;
import de.dailab.vsdt.util.VsdtHelper;

/**
 * A dialog used for organizing assignments of a BPMN model elements
 * 
 * @author kuester
 */
public class OrganizeAssignmentsDialog extends AbstractOrganizeElementsDialog<Assignment> {

	public static final String LABEL_TO= "To";
	public static final String LABEL_TOQUERY= "To-Query";
	public static final String LABEL_FROM= "From";
	public static final String LABEL_TIME= "AssignTime";
	public static final String ERROR__NO_GATE= "Sequence Flow does not have a Gate";
	public static final String ERROR__NO_PROCESS= "Pool does not have a Process object";

	@Override
	public String getElementName() {
		return "Assignment";
	}
	
	/**assignment.to input field*/
	private VsdtFeatureCombo<Property> assToCombo;
	
	/**assignment.from input field*/
	private ExpressionComposite assFromText;
	
	/**assignment.toQuery input field*/
	private Text assToQueryText;
	
	/**assignment.assignTime input field*/
	private Combo assTimeCombo;

	/**the list of possible properties*/
	private java.util.List<Property> toProperties= new ArrayList<Property>();
	
	/**
	 * create a new Organize Assignments Dialog
	 * 
	 * @param parentShell	the parent shell (will be blocked)
	 */
	public OrganizeAssignmentsDialog(Shell parentShell, EObject parentElement) {
		super(parentShell, parentElement, true, 4);

		//get assignments list from model element
//		if (parentElement instanceof BpmnProcess) {
//			elements= ((BpmnProcess) parentElement).getAssignments();
//			toProperties= ((BpmnProcess) parentElement).getVisibleProperties();
//		}
		if (parentElement instanceof FlowObject) {
			elements= ((FlowObject) parentElement).getAssignments();
			toProperties= VsdtHelper.getVisibleProperties(parentElement); 
		}
//		if (parentElement instanceof Gate) {
//			elements= ((Gate) parentElement).getAssignments();
//			toProperties= ((Gate) parentElement).getVisibleProperties();
//		}
//		if (parentElement instanceof SequenceFlow) {
//			Gate gate= ((SequenceFlow) parentElement).getGate();
//			if (gate != null) {
//				elements= gate.getAssignments();
//				toProperties= gate.getVisibleProperties();
//			} else {
//				errorMessage= ERROR__NO_GATE;
//				disable= true;
//			}
//		}
//		if (parentElement instanceof Pool) {
//			BpmnProcess process= ((Pool) parentElement).getProcess();
//			if (process != null) {
//				elements= process.getAssignments();
//				toProperties= process.getVisibleProperties();
//			} else {
//				errorMessage= ERROR__NO_PROCESS;
//				disable= true;
//			}
//		}
	}

	@Override
	protected void createEditGroupControls(Group editGroup) {
		//input lines
		new Label(editGroup,SWT.NONE).setText(LABEL_TO);
		assToCombo= new VsdtFeatureCombo<Property>(new Combo(editGroup,SWT.READ_ONLY));
		assToCombo.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
		assToCombo.getCombo().addSelectionListener(this);
		assToCombo.fillCombo(toProperties);
		
		new Label(editGroup,SWT.NONE).setText(LABEL_TOQUERY);
		assToQueryText= new Text(editGroup,SWT.BORDER);
		assToQueryText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		assToQueryText.addModifyListener(this);
		
		new Label(editGroup,SWT.NONE).setText(LABEL_TIME);
		assTimeCombo= new Combo(editGroup,SWT.READ_ONLY);
		assTimeCombo.addSelectionListener(this);
		for (AssignTimeType type : AssignTimeType.VALUES) {
			assTimeCombo.add(type.getName());
		}
		assTimeCombo.select(0);
		
		new Label(editGroup,SWT.NONE).setText(LABEL_FROM);
		assFromText= new ExpressionComposite(editGroup);
		assFromText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
		assFromText.getTextfield().addModifyListener(this);
	}
	
	@Override
	protected Assignment createNewElement() {
		Assignment assignment= VsdtFactory.eINSTANCE.createAssignment();
		return assignment;
	}
	
	@Override
	protected void updateElementFromEditGroup(Assignment assignment) {
		if (assignment != null) {
			assignment.setTo(assToCombo.getSelected());
					
			String expression= assFromText.getText();
			assignment.getFrom().setExpression(Util.nullIfEmpty(expression));
			
			String toQuery= assToQueryText.getText();
			assignment.setToQuery(Util.nullIfEmpty(toQuery));
			
			AssignTimeType assignTimeType= AssignTimeType.get(assTimeCombo.getSelectionIndex());
			assignment.setAssignTime(assignTimeType);
		}
	}
	
	@Override
	protected Control getElementToFocus() {
		return assToCombo.getCombo();
	}

	@Override
	protected void refreshEditGroup() {
		Assignment assignment= getSelectedElement();
		if (assignment != null) {
			assFromText.setOwnerAndFeature(assignment, VsdtPackage.eINSTANCE.getAssignment_From());
			
			//select property from ComboBox 
			Property toProp= assignment.getTo();
			assToCombo.setSelected(toProp);
			
			//set to-Query
			assToQueryText.setText(Util.nonNull(assignment.getToQuery()));
			
			//set expression
			String expression= assignment.getFrom() != null? assignment.getFrom().getExpression() : null;
			assFromText.setText(Util.nonNull(expression));
			
			//set assign time
			assTimeCombo.select(assignment.getAssignTime().getValue());
		}
		assToCombo.getCombo().setEnabled(assignment != null);
		assToQueryText.setEnabled(assignment != null);
		assTimeCombo.setEnabled(assignment != null);
		assFromText.setEnabled(assignment != null);
	}

	@Override
	protected String getString(Assignment assignment) {
		if (assignment != null) {
			Property to= assignment.getTo();
			Expression from= assignment.getFrom();
			StringBuffer buffer= new StringBuffer();
			buffer.append(assignment.getAssignTime() == AssignTimeType.START ? "S: " : "E: ");
			buffer.append(VsdtHelper.getPropertyString(to, true));
			if (assignment.getToQuery() != null) {
				buffer.append(" / "); //$NON-NLS-1$
				buffer.append(assignment.getToQuery());
			}
			buffer.append(" := ");//$NON-NLS-1$
			buffer.append(from != null ? (from.getExpression() != null ? from.getExpression() : "") : "<null>"); //$NON-NLS-1$
			return buffer.toString();
		}
		return super.getString(assignment);
	}

}
