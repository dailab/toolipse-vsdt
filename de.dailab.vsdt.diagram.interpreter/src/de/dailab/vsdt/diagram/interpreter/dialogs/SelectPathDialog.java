package de.dailab.vsdt.diagram.interpreter.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import de.dailab.vsdt.ConditionType;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.GatewayType;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.util.VsdtHelper;

/**
 * This dialog is used in the Manual Simulation for selecting the branches the
 * process should take at a Gateway or another decision situation.  The user can
 * select from the several outgoing Sequence Flows and select, depending on 
 * whether it is an inclusive or exclusive Gateway, one or more branches.  The 
 * user can cancel the dialogue, too, in which case no selection is returned.
 * 
 * TODO this dialog should not provide a cancel button at all
 * 
 * @author kuester
 */
public class SelectPathDialog extends TitleAreaDialog {
	
	public static final String NL= System.getProperty("line.separator");
	public static final String TITLE= "Select Path";
	public static final String MESSAGE= "Select the Path to take at this branching point";
	public static final int WIDTH= 500;
	public static final int HEIGHT= 250;
	
	/** List of available {@link SequenceFlow}s */
	protected List<SequenceFlow> seqFlows;

	/** List of buttons */
	protected List<Button> buttons;
	
	/** The default button (may be null) */
	protected Button defaultButton;
	
	/** List of currently selected branches (the Buttons are disposed on closing the dialog) */
	protected List<SequenceFlow> selected;
	
	/** Whether it is an inclusive OR selection */ 
	protected boolean inclusiveOr= false;

	/**
	 * Constructor.
	 * 
	 * @param parentShell		the shell
	 * @param flowObject		Some FlowObject requiring this dialog
	 */
	public SelectPathDialog(Shell parentShell, FlowObject flowObject) {
		super(parentShell);
		if (flowObject == null) throw new IllegalArgumentException("Flowobject must not be null");
		this.setTitle(TITLE);
		this.setShellStyle(getShellStyle() | SWT.RESIZE);
		this.seqFlows= flowObject.getOutgoingSeq();
		this.inclusiveOr= ! (flowObject instanceof Gateway && 
				(((Gateway) flowObject).getGatewayType() == GatewayType.XOR_DATA|| 
				((Gateway) flowObject).getGatewayType() == GatewayType.XOR_EVENT));
	}

	@Override
	protected Control createContents(Composite parent) {
		Control superContent = super.createContents(parent);
//		parent.getShell().setMinimumSize( WIDTH, HEIGHT );
		parent.getShell().setSize( WIDTH, HEIGHT );
		parent.getShell().setText( TITLE );
		setMessage( MESSAGE);
		return superContent;
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite superComposite = (Composite) super.createDialogArea(parent);
		
		ScrolledComposite scrolledComposite= new ScrolledComposite(superComposite, SWT.V_SCROLL | SWT.H_SCROLL);
		scrolledComposite.setLayoutData( new GridData( GridData.FILL_BOTH ) );
		scrolledComposite.setLayout(new FillLayout());
		
		Composite composite = new Composite(scrolledComposite, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		composite.setBackground(parent.getBackground());

		buttons= new ArrayList<Button>();
		SequenceFlow defaultFlow= null;
		for (SequenceFlow sequenceFlow : seqFlows) {
			if (sequenceFlow.getConditionType() == ConditionType.DEFAULT) {
				defaultFlow= sequenceFlow;
				continue;
			} else {
				buttons.add(createBranchComponent(composite, sequenceFlow, inclusiveOr));
			}
		}
		if (defaultFlow != null) {
			defaultButton= createBranchComponent(composite, defaultFlow, false);
			defaultButton.setSelection(true);
			buttons.add(defaultButton);
		}
		calculateSelected(null);
		
		scrolledComposite.setContent(composite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		scrolledComposite.setMinHeight(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		return superComposite;
	}

	/**
	 * Create a component representing a branch, mainly consisting of a labeled 
	 * Button (CheckBox or Radio).
	 * 
	 * @param parent			The parent Composite
	 * @param sequenceFlow		Sequence Flow starting this branch
	 * @param multiSelect		Allow for multiple selection for this branch?
	 * @return					The newly created Button
	 */
	protected Button createBranchComponent(Composite parent, SequenceFlow sequenceFlow, boolean multiSelect) {
		final Button button= new Button(parent, multiSelect? SWT.CHECK : SWT.RADIO);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				calculateSelected(e);
			}
		});
		StringBuffer buffer= new StringBuffer();
		if (sequenceFlow.getName() != null && ! sequenceFlow.getName().isEmpty()) {
			buffer.append(sequenceFlow.getName()).append(" ");
		}
		FlowObject target= sequenceFlow.getTarget();
		buffer.append("to ").append(VsdtHelper.getDescriptiveName(target));
		if (sequenceFlow.getConditionType() != ConditionType.NONE) {
			buffer.append("; Condition: ");
			if (sequenceFlow.getConditionType() == ConditionType.DEFAULT) {
				buffer.append("default");
			} else {
				if (sequenceFlow.getConditionExpression() != null) {
					buffer.append(sequenceFlow.getConditionExpression().getExpression());
				} else {
					buffer.append("none");
				}
			}
		}
		button.setText(buffer.toString());
		button.setData(sequenceFlow);
		return button;
	}
	
	/**
	 * Calculate the selection.  This includes selecting the default branch in
	 * case of an Inclusive OR selection, as it depends on whether any of the 
	 * other branches are selected.  Finally, the buttons' selection is adopted
	 * to the list of selected branches.
	 * 
	 * @param event		Selection event, holding e.g. the source of the selection, or null
	 */
	protected void calculateSelected(SelectionEvent event) {
		// clear selection
		if (selected == null) {
			selected= new ArrayList<SequenceFlow>();
		}
		selected.clear();
		// handle default selection
		if (inclusiveOr && defaultButton != null) {
			if (event != null && event.getSource() == defaultButton) {
				// default selected -> un-select others
				for (Button b : buttons) {
					b.setSelection(b == defaultButton);
				}
			} else {
				// other selected -> derive selection of default
				boolean selectDefault= true;
				for (Button b : buttons) {
					selectDefault &= !( b != defaultButton && b.getSelection());
				}
				defaultButton.setSelection(selectDefault);
			}
		}
		// get selection from buttons
		for (Button button : buttons) {
			if (button.getSelection()) {
				selected.add((SequenceFlow) button.getData());
			}
		}
	}
	
	/**
	 * @return		The currently selected branches
	 */
	public List<SequenceFlow> getSelected() {
		return selected;
	}
	
}
