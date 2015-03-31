package de.dailab.vsdt.diagram.dialogs;

import java.util.List;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import de.dailab.common.swt.FormLayoutUtil;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.util.VsdtHelper;

/**
 * This very simple dialog can be used for quickly changing the selected
 * element's type.
 * 
 * @author kuester
 */
public class SetTypeDialog extends TitleAreaDialog {

	private static final int WIDTH= 400;
	private static final int HEIGHT= 200;
	private static final String TITLE= "Set Type";
	private static final String MESSAGE= "Set the new Type for the selected Element.";
	
	protected FlowObject flowObject;
	
	protected Combo typesCombo;
	
	protected String selected= null;

	/**
	 * Constructor.
	 * 
	 * @param parentShell		the shell
	 */
	public SetTypeDialog(Shell parentShell, FlowObject flowObject) {
		super(parentShell);
		this.flowObject= flowObject;
		this.setTitle(TITLE);
		this.setShellStyle(getShellStyle() | SWT.RESIZE);
	}

	@Override
	protected Control createContents(Composite parent) {
		Control superContent = super.createContents(parent);
		
		parent.getShell().setMinimumSize( WIDTH, HEIGHT );
		parent.getShell().setSize( WIDTH, HEIGHT );
		parent.getShell().setText( TITLE );
		setMessage( MESSAGE);
		
		return superContent;
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite superComposite = (Composite) super.createDialogArea(parent);
		Composite composite = FormLayoutUtil.createFlatFormComposite(parent);
		composite.setBackground(parent.getBackground());
		composite.setLayoutData( new GridData( GridData.FILL_BOTH ) );

		CLabel label= FormLayoutUtil.addLabel(composite, "Select Type", 0, 0);
		typesCombo= FormLayoutUtil.addCombo(composite, SWT.READ_ONLY, null, label, 100);
		List<Enum<?>> types= VsdtHelper.getPossibleTypes(flowObject);
		for (Enum<?> type : types) {
			typesCombo.add(type.name());
		}
		typesCombo.select(typesCombo.indexOf(VsdtHelper.getType(flowObject).name()));
		typesCombo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				selected= typesCombo.getItem(typesCombo.getSelectionIndex());
			}
		});
		return superComposite;
	}

	public String getSelected() {
		return selected;
	}
	
}
