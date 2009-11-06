package de.dailab.vsdt.diagram.preferences;

import java.util.Locale;

import org.eclipse.gef.rulers.RulerProvider;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.diagram.ui.preferences.RulerGridPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;

import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramRulersAndGridPreferencePage extends RulerGridPreferencePage {

	/**
	 * Initializes the default preference values for the preferences.
	 * 
	 * copied from super, but changed default snap-to-behavior
	 * 
	 * @param IPreferenceStore preferences
	 * 
	 * @generated NOT
	 */
	public static void initDefaults(IPreferenceStore preferenceStore) {
		preferenceStore.setDefault(IPreferenceConstants.PREF_SHOW_RULERS, false);
		String defaultCountry = Locale.getDefault().getCountry();
		if (defaultCountry == null
				|| defaultCountry.equals(Locale.US.getCountry())
				|| defaultCountry.equals(Locale.CANADA.getCountry())) {
			preferenceStore.setDefault(IPreferenceConstants.PREF_RULER_UNITS,
					RulerProvider.UNIT_INCHES);
		} else {
			preferenceStore.setDefault(IPreferenceConstants.PREF_RULER_UNITS,
					RulerProvider.UNIT_CENTIMETERS);
		}
		preferenceStore.setDefault(IPreferenceConstants.PREF_SHOW_GRID, false);
		preferenceStore.setDefault(IPreferenceConstants.PREF_SNAP_TO_GRID, false);
		preferenceStore.setDefault(IPreferenceConstants.PREF_SNAP_TO_GEOMETRY, true);
		preferenceStore.setDefault(IPreferenceConstants.PREF_GRID_SPACING, 0.125);
	}
	
	
	/**
	 * @generated
	 */
	public DiagramRulersAndGridPreferencePage() {
		setPreferenceStore(VsdtDiagramEditorPlugin.getInstance()
				.getPreferenceStore());
	}
	
}
