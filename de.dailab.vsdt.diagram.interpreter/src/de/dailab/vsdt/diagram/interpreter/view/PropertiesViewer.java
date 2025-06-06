package de.dailab.vsdt.diagram.interpreter.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.widgets.Composite;

import de.dailab.common.swt.views.AbstractContentProvider;
import de.dailab.common.swt.views.AbstractLabelProvider;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.diagram.interpreter.VsdtInterpreterPlugin;
import de.dailab.vsdt.diagram.interpreter.simulation.EclipseInterpretingSimulation;
import de.dailab.vsdt.util.VsdtHelper;

/**
 * This class could be extended to another viewer in the view, dedicated to the
 * properties. Decision whether to use or nor still pending...
 * 
 * Pros and Cons compared to integration in exiting Viewer:
 * + more clarity
 * - less flexibility
 * - more effort in implementation
 * - synchronization of views still posing some problems
 * 
 * @deprecated Currently not used
 * 
 * @author kuester
 */
@Deprecated
public class PropertiesViewer extends ListViewer {
	
	private InterpreterView view;
	
	public PropertiesViewer(InterpreterView view, Composite parent) {
		super(parent);
		this.view= view;
		setContentProvider(new PropertiesViewerContentProvider());
		setLabelProvider(new PropertiesViewerLabelProvider());
	}

	/**
	 * This class provides the content for the Interpreter view (D'oh!)
	 * 
	 * @author kuester
	 */
	public class PropertiesViewerContentProvider extends AbstractContentProvider {

		public Object[] getElements(Object parent) {
			List<Object> elements= new ArrayList<Object>();
			if (parent instanceof EObject) {
				elements.addAll(VsdtHelper.getVisibleProperties((EObject) parent));
			}
			return elements.toArray();
		}
	}

	/**
	 * This class is used to provide the Labels used in the Interpreter View's
	 * Properties Viewer
	 * 
	 * @author kuester
	 */
	public class PropertiesViewerLabelProvider extends AbstractLabelProvider {
		
		protected ImageDescriptor getImageDescriptor(Object element) {
			if (element instanceof Property) {
				return VsdtInterpreterPlugin.getImageDescriptor(VsdtInterpreterPlugin.IMAGE_PROPERTY);
			}
			return null;
		}
		
		@Override
		public String getText(Object element) {
			if (element instanceof Property) {
				Property property= (Property) element;
				if (view.getSimulation() instanceof EclipseInterpretingSimulation) {
					EclipseInterpretingSimulation simulation = (EclipseInterpretingSimulation) view.getSimulation();
					Object value = simulation.getProperties().contains(property) ? simulation.getPropertyValue(property) : "";
					return property.getName() + " (" + property.getType() + ") = " + value;
				}
			}
			return null;
		}
		
	}
	
}
