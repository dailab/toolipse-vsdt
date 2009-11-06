package de.dailab.vsdt.diagram.preferences;

import org.eclipse.gmf.runtime.diagram.ui.preferences.DiagramsPreferencePage;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramGeneralPreferencePage extends DiagramsPreferencePage {

	/**
	 * @generated
	 */
	public DiagramGeneralPreferencePage() {
		setPreferenceStore(VsdtDiagramEditorPlugin.getInstance()
				.getPreferenceStore());
	}
	
	/*
	 * possible further options:
	 * - set individual colors for elements (if in color mode)
	 * - default connection styles to use
	 */
	
	/**
	 * @generated NOT
	 */
    @Override
    protected void addFields(Composite parent) {
        super.addFields(parent);

        Group group = createGroup(parent,"Other Settings");
        
        addField(new StringFieldEditor(
        		DiagramPreferenceInitializer.PREF_AUTHOR,
                "Author", group));
        
        Label label= new Label(group, SWT.NONE);
        label.setText("The following settings will take effect when a new file is opened.");
        
        addField(new BooleanFieldEditor(
        		DiagramPreferenceInitializer.PREF_USE_ACTIVITY_ICONS,
                "Enable Activity Icons",
                group));

        addField(new BooleanFieldEditor(
        		DiagramPreferenceInitializer.PREF_USE_ADDITIONAL_COLORS,
                "Use Additional Colors",
                group));
    }

    /**
     * @generated NOT
     */
    private Group createGroup(Composite parent, String label) {
    	Group group = new Group(parent, SWT.NONE);
        GridLayout gridLayout = new GridLayout(1, false);
        group.setLayout(gridLayout);
        GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
        gridData.grabExcessHorizontalSpace = true;
        group.setLayoutData(gridData);
        group.setText(label);
        return group;
    }
}
