package de.dailab.vsdt.diagram.preferences;

import org.eclipse.gmf.runtime.diagram.ui.preferences.DiagramsPreferencePage;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.widgets.Composite;

import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramGeneralPreferencePage extends DiagramsPreferencePage {

	/** @generated NOT */
	public static final String PREF_AUTHOR = "vsdt.pref.general.author"; //$NON-NLS-1$
	
	/** @generated NOT */
	public static final String PREF_ASSISTANCE= "vsdt.pref.general.assistance"; //$NON-NLS-1$
	
	/**
	 * @generated
	 */
	public DiagramGeneralPreferencePage() {
		setPreferenceStore(VsdtDiagramEditorPlugin.getInstance()
				.getPreferenceStore());
	}
	
	/**
	 * @generated NOT
	 */
	public static void initDefaults(IPreferenceStore preferenceStore) {
		DiagramsPreferencePage.initDefaults(preferenceStore);
		
		preferenceStore.setDefault(PREF_AUTHOR, "");
		preferenceStore.setDefault(PREF_ASSISTANCE, true);
	}

	/**
	 * @generated NOT
	 */
	@Override
	protected void addFields(Composite parent) {
		super.addFields(parent);

		addField(new StringFieldEditor(PREF_AUTHOR, "Author", parent));
		
		addField(new BooleanFieldEditor(PREF_ASSISTANCE, "Enable Modeling Assistance", parent));
	}

	public static String getAuthor() {
		return VsdtDiagramEditorPlugin.getInstance().getPreferenceStore().getString(PREF_AUTHOR);
	}
	
	public static boolean isAssistanceEnabled() {
		return VsdtDiagramEditorPlugin.getInstance().getPreferenceStore().getBoolean(PREF_ASSISTANCE);
	}
}
