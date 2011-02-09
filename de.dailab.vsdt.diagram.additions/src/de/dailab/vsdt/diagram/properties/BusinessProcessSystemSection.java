package de.dailab.vsdt.diagram.properties;

import java.util.Calendar;
import java.util.Date;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.dailab.common.swt.FormLayoutUtil;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.actions.OrganizeDataTypesAction;
import de.dailab.vsdt.diagram.actions.OrganizeImplementationsAction;
import de.dailab.vsdt.diagram.actions.OrganizeMessagesAction;


public class BusinessProcessSystemSection extends AbstractVsdtPropertySection {

	public static final String DISPLAY_VERSION= "Version",
							   DISPLAY_AUTHOR= "Author",
							   DISPLAY_LANGUAGE= "Language",
							   DISPLAY_EXP_LANG= "Expr. Language",
							   DISPLAY_QUERY_LANG= "Query Language",
							   DISPLAY_EXECUTABLE= "Executable",
							   DISPLAY_CREATE_DATE= "Creation Date",
							   DISPLAY_MOD_DATE= "Modification Date",
							   DISPLAY_MODIFIED_NOW= "Now",
							   DISPLAY_ORG_IMPL= "Services...",
							   DISPLAY_ORG_MSG= "Message Channels...",
							   DISPLAY_ORG_DATA= "Data Types...";
	
    protected BusinessProcessSystem bps;

    private Text versionText;
    private Text authorText;
    private Text languageText;
    private Text expLangText;
    private Text queryLangText;
    private Button setModifiedTimeButton;
    private Button orgImplButton;
    private Button orgMsgButton;
    private Button orgDataButton;
    
    private Button executableButton;
    
    private DateTime creationDate;
    private DateTime creationTime;
    private DateTime modificationDate;
    private DateTime modificationTime;

    @Override
    protected EClass getObjectClass() {
    	return VsdtPackage.eINSTANCE.getBusinessProcessSystem();
    }

    @Override
    public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);
        if (eObject instanceof BusinessProcessSystem) {
        	this.bps= (BusinessProcessSystem) eObject;
        }
    }

    @Override
 	protected void internalRefresh() {
    	super.internalRefresh();
        executableButton.setSelection(bps.isExecutable());
        
    	versionText.setText(nonNull(bps.getVersion()));
    	authorText.setText(nonNull(bps.getAuthor()));
    	languageText.setText(nonNull(bps.getLanguage()));
    	expLangText.setText(nonNull(bps.getExpressionLanguage()));
    	queryLangText.setText(nonNull(bps.getQueryLanguage()));
    	
    	Calendar cal= Calendar.getInstance();
    	cal.setTime(bps.getCreationDate() == null ? new Date() : bps.getCreationDate());
    	creationDate.setYear(cal.get(Calendar.YEAR));
    	creationDate.setMonth(cal.get(Calendar.MONTH));
    	creationDate.setDay(cal.get(Calendar.DAY_OF_MONTH));
    	creationTime.setHours(cal.get(Calendar.HOUR_OF_DAY));
    	creationTime.setMinutes(cal.get(Calendar.MINUTE));
    	creationTime.setSeconds(cal.get(Calendar.SECOND));
    	
    	cal.setTime(bps.getModificationDate() == null ? new Date() : bps.getModificationDate());
    	modificationDate.setYear(cal.get(Calendar.YEAR));
    	modificationDate.setMonth(cal.get(Calendar.MONTH));
    	modificationDate.setDay(cal.get(Calendar.DAY_OF_MONTH));
    	modificationTime.setHours(cal.get(Calendar.HOUR_OF_DAY));
    	modificationTime.setMinutes(cal.get(Calendar.MINUTE));
    	modificationTime.setSeconds(cal.get(Calendar.SECOND));
    }
 
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);
        CLabel label;

        // executable
        executableButton= FormLayoutUtil.addButton(composite, DISPLAY_EXECUTABLE, SWT.CHECK, lastControl, 0, null);
        executableButton.addSelectionListener(this);
        
        lastControl = executableButton;

        // organize buttons
        orgImplButton = addButton(DISPLAY_ORG_IMPL);
        orgMsgButton = addButton(DISPLAY_ORG_MSG);
        orgDataButton = addButton(DISPLAY_ORG_DATA);
        
        // author
        label = FormLayoutUtil.addLabel(composite, DISPLAY_AUTHOR, lastControl, 0);
        authorText = FormLayoutUtil.addText(composite, lastControl, label, 50, 0);
        authorText.addFocusListener(this);
        
        // version
        label = FormLayoutUtil.addLabel(composite, DISPLAY_VERSION, label, 0);
        versionText = FormLayoutUtil.addText(composite, authorText, label, 50, 0);
        versionText.addFocusListener(this);
       
        // language
        label = FormLayoutUtil.addLabel(composite, DISPLAY_LANGUAGE, lastControl, 50);
        languageText = FormLayoutUtil.addText(composite, lastControl, label, 100, 0);
        languageText.addFocusListener(this);
        
        // expression language
        label= FormLayoutUtil.addLabel(composite, DISPLAY_EXP_LANG, label, 50);
        expLangText= FormLayoutUtil.addText(composite, languageText, label, 100, 0);
        expLangText.addFocusListener(this);
        
        // query language
        label = FormLayoutUtil.addLabel(composite, DISPLAY_QUERY_LANG, label, 50);
        queryLangText = FormLayoutUtil.addText(composite, expLangText, label, 100, 0);
        queryLangText.addFocusListener(this); 

        // creation date and time
        label= FormLayoutUtil.addLabel(composite, DISPLAY_CREATE_DATE, versionText, 0);
        creationDate= FormLayoutUtil.addDateTime(composite, versionText, label, null, SWT.DATE);
        creationTime= FormLayoutUtil.addDateTime(composite, versionText, creationDate, null, SWT.TIME);
        creationDate.addFocusListener(this);
        creationTime.addFocusListener(this);
        
        // modification date and time
        label= FormLayoutUtil.addLabel(composite, DISPLAY_MOD_DATE, label, 0);
        modificationDate= FormLayoutUtil.addDateTime(composite, creationDate, label, null, SWT.DATE);
        modificationTime= FormLayoutUtil.addDateTime(composite, creationTime, modificationDate, null, SWT.TIME);
        modificationDate.addFocusListener(this);
        modificationTime.addFocusListener(this);
        
        // now-button
        setModifiedTimeButton= FormLayoutUtil.addButton(composite, DISPLAY_MODIFIED_NOW, 0, creationDate, modificationTime, null);
        setModifiedTimeButton.addSelectionListener(this);
        
    }
    
    public void focusLost(FocusEvent e) {
    	super.focusLost(e);
    	if (e.getSource().equals(authorText)) {
    		setPropertyValue(bps, pack.getBusinessProcessSystem_Author(), nullIfEmpty(authorText.getText()));
    	}
    	if (e.getSource().equals(versionText)) {
    		setPropertyValue(bps, pack.getBusinessProcessSystem_Version(), nullIfEmpty(versionText.getText()));
    	}
    	if (e.getSource().equals(languageText)) {
    		setPropertyValue(bps, pack.getBusinessProcessSystem_Language(), nullIfEmpty(languageText.getText()));
    	}
    	if (e.getSource().equals(queryLangText)) {
    		setPropertyValue(bps, pack.getBusinessProcessSystem_QueryLanguage(), nullIfEmpty(queryLangText.getText()));
    	}
    	if (e.getSource().equals(expLangText)) {
    		setPropertyValue(bps, pack.getBusinessProcessSystem_ExpressionLanguage(), nullIfEmpty(expLangText.getText()));
    	}
    	if (e.getSource().equals(modificationDate) || e.getSource().equals(modificationTime)) {
    		Calendar cal= Calendar.getInstance();
    		cal.set(Calendar.YEAR, modificationDate.getYear());
    		cal.set(Calendar.MONTH, modificationDate.getMonth());
    		cal.set(Calendar.DAY_OF_MONTH, modificationDate.getDay());
    		cal.set(Calendar.HOUR_OF_DAY, modificationTime.getHours());
    		cal.set(Calendar.MINUTE, modificationTime.getMinutes());
    		cal.set(Calendar.SECOND, modificationTime.getSeconds());
    		Date date= cal.getTime();
    		setPropertyValue(bps, pack.getBusinessProcessSystem_ModificationDate(), date);
    	}
    	if (e.getSource().equals(creationDate) || e.getSource().equals(creationTime)) {
    		Calendar cal= Calendar.getInstance();
    		cal.set(Calendar.YEAR, creationDate.getYear());
    		cal.set(Calendar.MONTH, creationDate.getMonth());
    		cal.set(Calendar.DAY_OF_MONTH, creationDate.getDay());
    		cal.set(Calendar.HOUR_OF_DAY, creationTime.getHours());
    		cal.set(Calendar.MINUTE, creationTime.getMinutes());
    		cal.set(Calendar.SECOND, creationTime.getSeconds());
    		Date date= cal.getTime();
    		setPropertyValue(bps, pack.getBusinessProcessSystem_CreationDate(), date);
    	}
    }

    public void widgetSelected(SelectionEvent e) {
    	super.widgetSelected(e);
    	Object src= e.getSource();
    	if (src.equals(setModifiedTimeButton)) {
    		Date date= new Date();
    		setPropertyValue(bps, pack.getBusinessProcessSystem_ModificationDate(), date);
    		refresh();
    	}
    	if (src.equals(orgImplButton)) {
    		new OrganizeImplementationsAction().run(bps);
    	}
    	if (src.equals(orgMsgButton)) {
			new OrganizeMessagesAction().run(bps);
    	}
    	if (src.equals(orgDataButton)) {
			new OrganizeDataTypesAction().run(bps);
    	}
    	if (src.equals(executableButton)) {
    		setPropertyValue(bps, pack.getBusinessProcessSystem_Executable(), executableButton.getSelection());
    	}
    }

}