package de.dailab.vsdt.diagram.preferences;

import org.eclipse.gmf.runtime.common.ui.preferences.ComboFieldEditor;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.preferences.ConnectionsPreferencePage;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramConnectionsPreferencePage extends ConnectionsPreferencePage {

	/** @generated NOT */
	public static final String PREF_ROUTING_ASSOCIATION= "vsdt.pref.connection.routing.association"; //$NON-NLS-1$
	public static final String PREF_ROUTING_MESSAGE= "vsdt.pref.connection.routing.message"; //$NON-NLS-1$
	public static final String PREF_ROUTING_SEQUENCE= "vsdt.pref.connection.routing.sequence"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public DiagramConnectionsPreferencePage() {
		setPreferenceStore(VsdtDiagramEditorPlugin.getInstance()
				.getPreferenceStore());
	}

	/**
	 * @generated NOT
	 */
	public static void initDefaults(IPreferenceStore preferenceStore) {
		ConnectionsPreferencePage.initDefaults(preferenceStore);
		
		preferenceStore.setDefault(PREF_ROUTING_ASSOCIATION, Routing.MANUAL);
		preferenceStore.setDefault(PREF_ROUTING_MESSAGE, Routing.RECTILINEAR);
		preferenceStore.setDefault(PREF_ROUTING_SEQUENCE, Routing.RECTILINEAR);
	}
	

	/**
	 * @generated NOT
	 */
	@Override
	protected void addFields(Composite parent) {
//		super.addFields(parent);

		createRoutingCombo(PREF_ROUTING_SEQUENCE, "Sequence Flow Routing", parent);
		createRoutingCombo(PREF_ROUTING_MESSAGE, "Message Flow Routing", parent);
		createRoutingCombo(PREF_ROUTING_ASSOCIATION, "Association Routing", parent);
	}

	/**
	 * @generated NOT
	 */
	private void createRoutingCombo(String name, String label, Composite parent) {
		ComboFieldEditor lineStyleFieldEditor = new ComboFieldEditor(
				name, label, parent,
				ComboFieldEditor.INT_TYPE, true, 0, 0, true);
		lineStyleFieldEditor.autoStorage = true;
		addField(lineStyleFieldEditor);
		Combo lineStyleCombo = lineStyleFieldEditor.getComboControl();
		lineStyleCombo.add(DiagramUIMessages.ConnectionsPreferencePage_ConnectionView_Manual_text);
		lineStyleCombo.add(DiagramUIMessages.ConnectionsPreferencePage_ConnectionView_Rectilinear_text);
	}
	
}
