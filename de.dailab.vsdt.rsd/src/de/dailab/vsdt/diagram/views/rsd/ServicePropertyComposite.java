package de.dailab.vsdt.diagram.views.rsd;

import java.util.Arrays;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

import de.dailab.vsdt.diagram.rsd.IRsdWS;

/**
 * This class is a component to be embedded in the RSD view, showing the properties
 * of the selected web service. In contrast to a (modal) dialog, the properties can
 * be marked, copied and pasted somewhere in an open editor without having to close
 * and to reopen the dialog again and again.
 * 
 * @author kuester
 */
public class ServicePropertyComposite extends Composite {
	
	public static final int LABEL_WIDTH= 100;
	
	public static final String NAME= "Name",
							   PROVIDER= "Provider Address",
							   ID= "Id",
							   KEYWORDS= "Keywords",
							   QOSRATING= "QoS Rating",
							   EXPIRE= "Expire Date",
							   PRECONDITION= "Pre-Condition",
							   POSTCONDITION= "Post-Condition",
							   INPUT= "Input Params",
							   OUTPUT= "Output Param",
							   WSDL_URL= "WSDL URL";

	private Text nameText;
	private Text providerAddressText;
	private Text idText;
	private Text keywordsText;
	private Text qosRatingText;
	private Text expireDateText;
	private Text preConditionText;
	private Text postConditionText;
	private Text inputParamsText;
	private Text outputParamText;
	private Text wsdlUrlText;
	
	private Control insertedLast= null;
	
	/**
	 * Call super, create contents
	 * 
	 * @param parent	the parent composite
	 * @param style		the style
	 */
	public ServicePropertyComposite(Composite parent, int style) {
		super(parent,style);
		createContents();
	}
	
	private void createContents() {
		this.setLayout(new FormLayout());
		nameText= addLabeledText(NAME, 0);
		providerAddressText= addLabeledText(PROVIDER, 0);
		idText= addLabeledText(ID, 0);
		keywordsText= addLabeledText(KEYWORDS, 0);
		qosRatingText= addLabeledText(QOSRATING, 0);
		expireDateText= addLabeledText(EXPIRE, 0);
		preConditionText= addLabeledText(PRECONDITION, 0);
		postConditionText= addLabeledText(POSTCONDITION, 0);
		inputParamsText= addLabeledText(INPUT, 0);
		outputParamText= addLabeledText(OUTPUT, 0);
		wsdlUrlText= addLabeledText(WSDL_URL, 0);
	}
	
	public void displayProperties(IRsdWS ws) {
		if (ws != null) {
			nameText.setText(nonNull(ws.getName()));
			providerAddressText.setText(nonNull(ws.getProviderAdress()));
			idText.setText(nonNull(ws.getId()));
			keywordsText.setText(arrayString(ws.getKeywords()));
			qosRatingText.setText(nonNull(ws.getQoSRating()));
			expireDateText.setText(ws.getExpireDate() != null ? ws.getExpireDate().getTime().toString() : "");
			preConditionText.setText(nonNull(ws.getPrecondition()));
			postConditionText.setText(nonNull(ws.getPostcondition()));
			wsdlUrlText.setText(nonNull(ws.getWsdlUrl()));
			inputParamsText.setText(arrayString(ws.getInputParams()));
			outputParamText.setText(arrayString(ws.getOutputParams()));
		}
	}
	
	
    private Text addLabeledText(String caption, int style) {
    	CLabel label = new CLabel(this, SWT.NONE);
    	label.setText(caption);
        FormData data = new FormData();
        data.left = new FormAttachment(0);
    	data.right = new FormAttachment(0,LABEL_WIDTH);
        data.top = new FormAttachment(insertedLast);
        label.setLayoutData(data);
    	
        Text text = new Text(this, style | SWT.BORDER);
    	text.setText("");//$NON-NLS-1$
    	data= new FormData();
    	data.top= new FormAttachment(insertedLast);
    	data.left= new FormAttachment(label,0);
    	data.right= new FormAttachment(100,0);
    	text.setLayoutData(data);
    	text.setEditable(false);
    	text.setBackground(ColorConstants.white);
    	insertedLast= text;
    	return text;
    }
    
    protected String nonNull(String s) {
    	return s == null ? "" : s;//$NON-NLS-1$
    }
    
    protected String arrayString(Object[] arr) {
    	if (arr != null) {
			return Arrays.asList(arr).toString();
		}
		return "";
    }

}
