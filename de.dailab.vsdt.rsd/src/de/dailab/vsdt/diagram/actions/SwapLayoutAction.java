package de.dailab.vsdt.diagram.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Composite;

import de.dailab.vsdt.diagram.rsd.VsdtRsdPlugin;
import de.dailab.vsdt.diagram.views.rsd.RsdView;

/**
 * When executed, this action swaps the layout of the RSD view to fit in the bottom or the
 * left/right view compartment, meaning that the two sections, RSD content and selected service
 * details, are either side by side or on top of each other.
 * 
 * @author kuester
 */
public class SwapLayoutAction extends Action {
	
	public static final String TEXT= "Swap Layout";
	public static final String TOOLTIP= "Swaps the layout from horizontally aligned " +
			"to vertically aligned and back.";

	private RsdView view;
	
	public SwapLayoutAction(RsdView view) {
		this.view= view;
		this.setText(TEXT);
		this.setToolTipText(TOOLTIP);
		this.setImageDescriptor(VsdtRsdPlugin.getImageDescriptor(VsdtRsdPlugin.IMAGE_PERSPECTIVE));
	}
	
	@Override
	public void run() {
		Composite composite= view.getTheComposite();
		if (composite.getLayout() == RsdView.layoutWide) {
			composite.setLayout(RsdView.layoutHigh);
		} else {
			composite.setLayout(RsdView.layoutWide);
		}
		composite.layout(true, true);
	}
	
}
