package de.dailab.vsdt.diagram.properties;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.ui.IWorkbenchPart;

import de.dailab.vsdt.Lane;
import de.dailab.vsdt.VsdtPackage;


public class LaneSection extends AbstractVsdtPropertySection {

	public static final String DISPLAY_MOVE_UP=   "Move Down",
							   DISPLAY_MOVE_DOWN= "Move Up";

	protected Lane lane;
    
    private Button moveUpButton;
    private Button moveDownButton;

    @Override
    protected EClass getObjectClass() {
    	return VsdtPackage.eINSTANCE.getLane();
    }

    @Override
    public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);
        if (eObject instanceof Lane) {
        	this.lane= (Lane) eObject;
        }
    }

    @Override
 	protected void internalRefresh() {
    }
 
    public void focusLost(FocusEvent e) {
    }
    
    public void widgetSelected(SelectionEvent e) {
    }
}