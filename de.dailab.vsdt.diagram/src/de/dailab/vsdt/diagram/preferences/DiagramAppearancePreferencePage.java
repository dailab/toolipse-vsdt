package de.dailab.vsdt.diagram.preferences;

import org.eclipse.gmf.runtime.diagram.ui.preferences.AppearancePreferencePage;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramAppearancePreferencePage extends AppearancePreferencePage {

	/** @generated NOT */
	public static final String PREF_USE_ACTIVITY_ICONS = "vsdt.pref.appearance.icons"; //$NON-NLS-1$
	public static final String PREF_USE_ADDITIONAL_COLORS = "vsdt.pref.appearance.colors"; //$NON-NLS-1$
	public static final String PREF_SHOW_XORMARKER_BY_DEFAULT = "vsdt.pref.appearance.xormarker"; //$NON-NLS-1$
	public static final String PREF_META_DIAGRAM_STYLE = "vsdt.pref.appearance.metadiagramstyle"; //$NON-NLS-1$
	public static final String PREF_META_DIAGRAM_STYLE_USECASE = "vsdt.pref.appearance.metadiagramstyle.usecase"; //$NON-NLS-1$
	public static final String PREF_META_DIAGRAM_STYLE_CONVERSATION= "vsdt.pref.appearance.metadiagramstyle.conversation"; //$NON-NLS-1$
	
	
	/**
	 * @generated
	 */
	public DiagramAppearancePreferencePage() {
		setPreferenceStore(VsdtDiagramEditorPlugin.getInstance()
				.getPreferenceStore());
	}
	

	/**
	 * @generated NOT
	 */
	public static void initDefaults(IPreferenceStore preferenceStore) {
		AppearancePreferencePage.initDefaults(preferenceStore);
		
		preferenceStore.setDefault(PREF_USE_ACTIVITY_ICONS, true);
		preferenceStore.setDefault(PREF_USE_ADDITIONAL_COLORS, true);
		preferenceStore.setDefault(PREF_SHOW_XORMARKER_BY_DEFAULT, false);
		preferenceStore.setDefault(PREF_META_DIAGRAM_STYLE, PREF_META_DIAGRAM_STYLE_USECASE);
	}

	/**
	 * @generated NOT
	 */
	@Override
	protected void addFields(Composite parent) {
		super.addFields(parent);

		addField(new BooleanFieldEditor(PREF_USE_ACTIVITY_ICONS,
				"Enable Activity Icons *", parent));

		addField(new BooleanFieldEditor(PREF_USE_ADDITIONAL_COLORS,
				"Use Additional Colors *", parent));
		
		addField(new BooleanFieldEditor(PREF_SHOW_XORMARKER_BY_DEFAULT,
				"Show XOR-Marker for new Gateways", parent));

		addField(new RadioGroupFieldEditor(PREF_META_DIAGRAM_STYLE, 
				"Meta Diagram Style", 2, 
				new String[][]{{"Use Case", PREF_META_DIAGRAM_STYLE_USECASE},
				{"Conversation", PREF_META_DIAGRAM_STYLE_CONVERSATION}}, parent));
		
		Label label = new Label(parent, SWT.NONE);
		label.setText("*) These settings will only take effect when a diagram is opened.");
	}
	
	public static boolean isUseActivityIcons() {
		return VsdtDiagramEditorPlugin.getInstance().getPreferenceStore().getBoolean(PREF_USE_ACTIVITY_ICONS);
	}
	
	public static boolean isUseAdditionalColors() {
		return VsdtDiagramEditorPlugin.getInstance().getPreferenceStore().getBoolean(PREF_USE_ADDITIONAL_COLORS);
	}
	
	public static boolean isShowXorMarkerByDefault() {
		return VsdtDiagramEditorPlugin.getInstance().getPreferenceStore().getBoolean(PREF_SHOW_XORMARKER_BY_DEFAULT);
	}
	
	public static boolean isMetaDiagramStyleUsecase() {
		return VsdtDiagramEditorPlugin.getInstance().getPreferenceStore().getString(PREF_META_DIAGRAM_STYLE) == PREF_META_DIAGRAM_STYLE_USECASE;
	}
	
}
