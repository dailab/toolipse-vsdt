package de.dailab.vsdt.diagram.dialogs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.dailab.common.gmf.Util;
import de.dailab.common.gmf.ui.dialogs.AbstractOrganizeElementsDialog;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.VsdtFactory;

/**
 * A dialog used for organizing participants of a BPMN model elements
 * 
 * No longer needed as participants are now handled in a separate diagram view.
 * 
 * FIXME warning: this class has not been adapted to the latest model changes!
 * 
 * @author kuester
 */
@Deprecated
public class OrganizeParticipantsDialog extends AbstractOrganizeElementsDialog<Participant> {

	public static final String LABEL_NAME= "Name";
	public static final String LABEL_ROLE= "Role";
	public static final String LABEL_ENTITY= "Entity";

	/**participant.name input field*/
	private Text nameText;
	
	/**participant.role input field*/
	private Text roleText;
	
	/**participant.entity input field*/
	private Text entityText;

	@Override
	public String getElementName() {
		return "Participant";
	}
	
	/**
	 * create a new Organize Participants Dialog
	 * 
	 * @param parentShell	the parent shell (will be blocked)
	 */
	public OrganizeParticipantsDialog(Shell parentShell, EObject parentElement) {
		super(parentShell, parentElement, true, 4);

		if (parentElement instanceof BusinessProcessDiagram) {
			elements= ((BusinessProcessDiagram) parentElement).getParticipants();
		}
	}

	@Override
	protected void createEditGroupControls(Group editGroup) {
		//input lines
		new Label(editGroup,SWT.NONE).setText(LABEL_NAME);
		nameText= new Text(editGroup, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
		nameText.addModifyListener(this);

		new Label(editGroup,SWT.NONE).setText(LABEL_ROLE);
		roleText= new Text(editGroup, SWT.BORDER);
		roleText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		roleText.addModifyListener(this);

		new Label(editGroup,SWT.NONE).setText(LABEL_ENTITY);
		entityText= new Text(editGroup, SWT.BORDER);
		entityText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		entityText.addModifyListener(this);
	}
	
	@Override
	protected Participant createNewElement() {
		Participant participant= VsdtFactory.eINSTANCE.createParticipant();
		return participant;
	}

	@Override
	protected void updateElementFromEditGroup(Participant participant) {
		if (participant != null) {
			participant.setName(Util.nullIfEmpty(nameText.getText()));
//			participant.setRole(Util.nullIfEmpty(roleText.getText()));
//			participant.setEntity(Util.nullIfEmpty(entityText.getText()));
		}
	}
	
	@Override
	protected Control getElementToFocus() {
		return nameText;
	}

	@Override
	protected void refreshEditGroup() {
		Participant participant= getSelectedElement();
		if (participant != null) {
			nameText.setText(Util.nonNull(participant.getName()));
//			roleText.setText(Util.nonNull(participant.getRole()));
//			entityText.setText(Util.nonNull(participant.getEntity()));
		}
		nameText.setEnabled(participant != null);
		roleText.setEnabled(participant != null);
		entityText.setEnabled(participant != null);
	}

	@Override
	protected String getString(Participant participant) {
		if (participant != null) {
			String nameString= participant.getName();
			StringBuffer buffer= new StringBuffer();
			buffer.append(nameString != null ? nameString : "<unnamed>"); //$NON-NLS-1$
			return buffer.toString();	
		}
		return super.getString(participant);
	}
}
