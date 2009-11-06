package de.dailab.vsdt.diagram.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

import de.dailab.vsdt.diagram.figures.FigureHelper;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * Propagate preference changes to the responsible places...
	 * 
	 * @generated NOT
	 */
	static {
		final IPreferenceStore store= getStore();
		store.addPropertyChangeListener(new IPropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent event) {
				FigureHelper.setUseColor(DiagramAppearancePreferencePage.isUseAdditionalColors());
				FigureHelper.setUseActivityIcons(DiagramAppearancePreferencePage.isUseActivityIcons());
			}
		});
	}
	
	
	public static IPreferenceStore getStore() {
		return VsdtDiagramEditorPlugin.getInstance().getPreferenceStore();
	}

	/**
	 * @generated 
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		DiagramPrintingPreferencePage.initDefaults(store);
		DiagramGeneralPreferencePage.initDefaults(store);
		DiagramAppearancePreferencePage.initDefaults(store);
		DiagramConnectionsPreferencePage.initDefaults(store);
		DiagramRulersAndGridPreferencePage.initDefaults(store);
	}

	/**
	 * @generated 
	 */
	protected IPreferenceStore getPreferenceStore() {
		return VsdtDiagramEditorPlugin.getInstance().getPreferenceStore();
	}

}
