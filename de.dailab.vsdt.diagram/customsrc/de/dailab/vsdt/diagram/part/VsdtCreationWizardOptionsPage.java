package de.dailab.vsdt.diagram.part;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

import de.dailab.common.gmf.Util;
import de.dailab.common.gmf.ui.FormLayoutUtil;
import de.dailab.vsdt.diagram.preferences.DiagramGeneralPreferencePage;

/**
 * On this Wizard page the user can initialize some of the global attributes of 
 * the Business Process Diagram, such as the diagram name and documentation, the 
 * author, language, etc.
 * 
 * @author kuester
 */
public class VsdtCreationWizardOptionsPage extends WizardPage {

	private Text diagramNameText;
	private Text documentationText;
	private Text authorText;
	private Text langText;
	private Text expLangText;
	private Text queLangText;
	
	public VsdtCreationWizardOptionsPage() {
		super("Options");
		setTitle("Set Initial Values");
		setMessage("Set some of the initial values " +
				"for the newly created Business Process Diagram.");
	}
	
	public void createControl(Composite parent) {
		Composite composite= FormLayoutUtil.createFlatFormComposite(parent);
		composite.setBackground(null);
		CLabel label;
		Control lastControl;
		
		label= FormLayoutUtil.addLabel(composite, "Diagram Label:", 0, 0);
		diagramNameText= FormLayoutUtil.addText(composite, 0, label, 100, SWT.BORDER);
		lastControl= diagramNameText;
		
		label= FormLayoutUtil.addLabel(composite, "Documentation:", lastControl, 0);
		documentationText= FormLayoutUtil.addText(composite, lastControl, label, 100, SWT.MULTI | SWT.WRAP);
		((FormData) documentationText.getLayoutData()).height= 100;
        ((FormData) documentationText.getLayoutData()).width= composite.getBounds().width;
        lastControl= documentationText;
        
		label= FormLayoutUtil.addLabel(composite, "Author:", lastControl, 0);
		authorText= FormLayoutUtil.addText(composite, lastControl, label, 100, SWT.BORDER);
		lastControl= authorText;
		
		label= FormLayoutUtil.addLabel(composite, "Language", lastControl, 0);
		langText= FormLayoutUtil.addText(composite, lastControl, label, 100, SWT.BORDER);
		lastControl= langText;

		label= FormLayoutUtil.addLabel(composite, "Expr. Language", lastControl, 0);
		expLangText= FormLayoutUtil.addText(composite, lastControl, label, 100, SWT.BORDER);
		lastControl= expLangText;
		
		label= FormLayoutUtil.addLabel(composite, "Query Language", lastControl, 0);
		queLangText= FormLayoutUtil.addText(composite, lastControl, label, 100, SWT.BORDER);
		lastControl= queLangText;
		
		// initial values
		String author = VsdtDiagramEditorPlugin.getInstance().getPreferenceStore()
				.getString(DiagramGeneralPreferencePage.PREF_AUTHOR);
		authorText.setText(author);
		expLangText.setText(de.dailab.vsdt.vxl.util.Util.LANG_NAME);
		// default name is to be set on setVisible
		
		setPageComplete(false);
		setControl(composite);
	}
	
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		// wizard can finish if this page is shown
		setPageComplete(visible);
	}
	
	/**
	 * @param diagramName	New value for the diagram name text field
	 */
	public void setDiagramName(String diagramName) {
		this.diagramNameText.setText(diagramName);
	}
	
	/**
	 * @return	Value for the Name attribute of the Business Process Diagram
	 */
	public String getDiagramName() {
		return Util.nullIfEmpty(diagramNameText.getText());
	}

	/**
	 * @return	Value for the Documentation attribute
	 */
	public String getDocumentation() {
		return Util.nullIfEmpty(documentationText.getText());
	}
	
	/**
	 * @return	Value for the Author attribute
	 */
	public String getAuthor() {
		return Util.nullIfEmpty(authorText.getText());
	}
	
	/**
	 * @return	Value for the Language attribute
	 */
	public String getLanguage() {
		return Util.nullIfEmpty(langText.getText());
	}
	
	/**
	 * @return	Value for the Expression Language attribute
	 */
	public String getExpressionLanguage() {
		return Util.nullIfEmpty(expLangText.getText());
	}
	
	/**
	 * @return	Value for the Query Language attribute
	 */
	public String getQueryLanguage() {
		return Util.nullIfEmpty(queLangText.getText());
	}

}
