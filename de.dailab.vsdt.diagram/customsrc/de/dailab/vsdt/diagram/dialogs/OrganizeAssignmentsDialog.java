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
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.ui.ExpressionComposite;
import de.dailab.vsdt.diagram.ui.VsdtFeatureCombo;
import de.dailab.vsdt.util.VsdtHelper;
import de.dailab.vsdt.util.VsdtToStringHelper;

/**
 * A dialog used for organizing assignments of a BPMN model elements
 * 
 * @author kuester
 */
public class OrganizeAssignmentsDialog extends AbstractOrganizeElementsDialog<Assignment> {

	private static final String LABEL_TO= "To";
	private static final String LABEL_TOQUERY= "To-Query";
	private static final String LABEL_FROM= "From";
	private static final String LABEL_TIME= "AssignTime";

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
		if (parentElement instanceof FlowObject) {
			elements= ((FlowObject) parentElement).getAssignments();
			toProperties= VsdtHelper.getVisibleProperties(parentElement); 
		} else {
			throw new IllegalArgumentException("Parent element must be of type FlowObject");
		}
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
		return VsdtFactory.eINSTANCE.createAssignment();
	}
	
	@Override
	protected void updateElementFromEditGroup(Assignment assignment) {
		if (assignment != null) {
			assignment.setTo(assToCombo.getSelected());
					
			assignment.getFrom().setExpression(Util.nullIfEmpty(assFromText.getExpression()));
			assignment.getFrom().setLanguage(Util.nullIfEmpty(assFromText.getLanguage()));
			
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
			assFromText.setValues(assignment.getFrom());
			
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
			return VsdtToStringHelper.getString(assignment);
		}
		return super.getString(null);
	}

}
