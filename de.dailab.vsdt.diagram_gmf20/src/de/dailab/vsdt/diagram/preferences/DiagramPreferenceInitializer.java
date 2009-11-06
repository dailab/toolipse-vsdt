package de.dailab.vsdt.diagram.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	public static IPreferenceStore getStore() {
		return VsdtDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
	
	/** @generated NOT */
	public static final String DEFAULT_AUTHOR= 					""; //$NON-NLS-1$
	public static final boolean DEFAULT_USE_ACTIVITY_ICONS= 	false;
	public static final boolean DEFAULT_USE_ADDITIONAL_COLORS=	false;

//	public static final Color DEFAULT_LANE_COLOR= 			new Color(null, 128, 128, 128);
//	public static final Color DEFAULT_POOL_COLOR= 			new Color(null, 128, 128, 128);
//	public static final Color DEFAULT_SEQUENCEFLOW_COLOR= 	new Color(null, 128, 0, 0);
//	public static final Color DEFAULT_MESSAGEFLOW_COLOR= 	new Color(null, 0, 0, 128);
//	public static final Color DEFAULT_GROUP_COLOR= 			new Color(null, 80, 80, 80);
//	public static final Color DEFAULT_GATEWAY_COLOR= 		new Color(null, 255, 0, 255);
//	public static final Color DEFAULT_INTERMEDIATE_COLOR= 	new Color(null, 255, 255, 0);
//	public static final Color DEFAULT_START_COLOR= 			new Color(null, 0, 255, 0);
//	public static final Color DEFAULT_END_COLOR= 			new Color(null, 255, 0, 0);
//	public static final Color DEFAULT_ACTIVITY_COLOR= 		new Color(null, 0, 255, 255);
//	public static final Color DEFAULT_ASSOCIATION_COLOR= 	new Color(null, 0, 128, 0);
//	public static final Color DEFAULT_DATAOBJECT_COLOR= 	new Color(null, 255, 255, 255);
	
	/** @generated NOT */
	public static final String PREF_AUTHOR= 				"vsdt.pref.general.author"; //$NON-NLS-1$
	public static final String PREF_USE_ACTIVITY_ICONS=		"vsdt.pref.general.icons"; //$NON-NLS-1$
	public static final String PREF_USE_ADDITIONAL_COLORS=	"vsdt.pref.general.colors"; //$NON-NLS-1$

//	public static final String PREF_LANE_COLOR=			"vsdt.pref.color.lane"; //$NON-NLS-1$
//	public static final String PREF_POOL_COLOR=			"vsdt.pref.color.pool"; //$NON-NLS-1$
//	public static final String PREF_SEQUENCEFLOW_COLOR=	"vsdt.pref.color.sequenceflow"; //$NON-NLS-1$
//	public static final String PREF_MESSAGEFLOW_COLOR=	"vsdt.pref.color.messageflow"; //$NON-NLS-1$
//	public static final String PREF_GROUP_COLOR=		"vsdt.pref.color.group"; //$NON-NLS-1$
//	public static final String PREF_GATEWAY_COLOR=		"vsdt.pref.color.gateway"; //$NON-NLS-1$
//	public static final String PREF_INTERMEDIATE_COLOR=	"vsdt.pref.color.intermediate"; //$NON-NLS-1$
//	public static final String PREF_START_COLOR=		"vsdt.pref.color.start"; //$NON-NLS-1$
//	public static final String PREF_END_COLOR=			"vsdt.pref.color.end"; //$NON-NLS-1$
//	public static final String PREF_ACTIVITY_COLOR= 	"vsdt.pref.color.activity"; //$NON-NLS-1$
//	public static final String PREF_ASSOCIATION_COLOR=	"vsdt.pref.color.association"; //$NON-NLS-1$
//	public static final String PREF_DATAOBJECT_COLOR=	"vsdt.pref.color.dataobject"; //$NON-NLS-1$
	
	/**
	 * @generated NOT
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		DiagramPrintingPreferencePage.initDefaults(store);
		DiagramGeneralPreferencePage.initDefaults(store);
		DiagramAppearancePreferencePage.initDefaults(store);
		DiagramConnectionsPreferencePage.initDefaults(store);
		DiagramRulersAndGridPreferencePage.initDefaults(store);
		
		store.setDefault(PREF_AUTHOR, DEFAULT_AUTHOR);
		store.setDefault(PREF_USE_ACTIVITY_ICONS, DEFAULT_USE_ACTIVITY_ICONS);
		store.setDefault(PREF_USE_ADDITIONAL_COLORS, DEFAULT_USE_ADDITIONAL_COLORS);
		
//		PreferenceConverter.setDefault(store,PREF_LANE_COLOR,DEFAULT_LANE_COLOR.getRGB());
//		PreferenceConverter.setDefault(store,PREF_POOL_COLOR,DEFAULT_POOL_COLOR.getRGB());
//		PreferenceConverter.setDefault(store,PREF_SEQUENCEFLOW_COLOR,DEFAULT_SEQUENCEFLOW_COLOR.getRGB());
//		PreferenceConverter.setDefault(store,PREF_MESSAGEFLOW_COLOR,DEFAULT_MESSAGEFLOW_COLOR.getRGB());
//		PreferenceConverter.setDefault(store,PREF_GROUP_COLOR,DEFAULT_GROUP_COLOR.getRGB());
//		PreferenceConverter.setDefault(store,PREF_GATEWAY_COLOR,DEFAULT_GATEWAY_COLOR.getRGB());
//		PreferenceConverter.setDefault(store,PREF_INTERMEDIATE_COLOR,DEFAULT_INTERMEDIATE_COLOR.getRGB());
//		PreferenceConverter.setDefault(store,PREF_START_COLOR,DEFAULT_START_COLOR.getRGB());
//		PreferenceConverter.setDefault(store,PREF_END_COLOR,DEFAULT_END_COLOR.getRGB());
//		PreferenceConverter.setDefault(store,PREF_ACTIVITY_COLOR,DEFAULT_ACTIVITY_COLOR.getRGB());
//		PreferenceConverter.setDefault(store,PREF_ASSOCIATION_COLOR,DEFAULT_ASSOCIATION_COLOR.getRGB());
//		PreferenceConverter.setDefault(store,PREF_DATAOBJECT_COLOR,DEFAULT_DATAOBJECT_COLOR.getRGB());
	}
		
	/**
	 * @generated 
	 */
	protected IPreferenceStore getPreferenceStore() {
		return VsdtDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
	
}
