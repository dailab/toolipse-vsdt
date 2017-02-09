package de.dailab.vsdt.diagram.figures;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

import de.dailab.vsdt.AbstractProcess;
import de.dailab.vsdt.Activity;
import de.dailab.vsdt.AssignTimeType;
import de.dailab.vsdt.Assignment;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.IdObject;
import de.dailab.vsdt.Implementation;
import de.dailab.vsdt.MessageChannel;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;
import de.dailab.vsdt.diagram.preferences.DiagramAppearancePreferencePage;
import de.dailab.vsdt.util.VsdtToStringHelper;

/**
 * Helper class providing some graphical helper stuff as well as constants
 * for colors etc.
 * 
 * @author kuester
 */
public class FigureHelper {
	
	public static final Color DEFAULT_FOREGROUND= ColorConstants.black; 
	public static final Color DEFAULT_BACKGROUND= ColorConstants.white;
	
	// tango colors (twice as bright values)
	public static final Color DEFAULT_COLOR_ACTIVITY=     new Color(null, 250, 250, 248);
	public static final Color DEFAULT_COLOR_ACTIVITY_ALT= new Color(null, 238, 238, 236);
	public static final Color DEFAULT_COLOR_START=        new Color(null, 196, 240, 153);
	public static final Color DEFAULT_COLOR_INTERMEDIATE= new Color(null, 253, 244, 167);
	public static final Color DEFAULT_COLOR_END=          new Color(null, 247, 148, 148);
	public static final Color DEFAULT_COLOR_GATEWAY=      new Color(null, 253, 215, 158);
	public static final Color DEFAULT_COLOR_POOL=         new Color(null, 219, 231, 243);
	public static final Color DEFAULT_COLOR_LANE=         new Color(null, 219, 231, 243);
	public static final Color DEFAULT_COLOR_SEQUENCE=     ColorConstants.black;
	public static final Color DEFAULT_COLOR_MESSAGE=      ColorConstants.gray;
	public static final Color DEFAULT_COLOR_ASSOCIATION=  ColorConstants.lightBlue;
	public static final Color DEFAULT_COLOR_DATA=         new Color(null, 253, 244, 167);
	public static final Color DEFAULT_COLOR_GROUP=        ColorConstants.gray;
	public static final Color DEFAULT_COLOR_TEXT=         ColorConstants.black;
	
	public static Color colorActivity= DEFAULT_COLOR_ACTIVITY;
	public static Color colorActivityAlt= DEFAULT_COLOR_ACTIVITY_ALT;
	public static Color colorStart= DEFAULT_COLOR_START;
	public static Color colorIntermediate= DEFAULT_COLOR_INTERMEDIATE;
	public static Color colorEnd= DEFAULT_COLOR_END;
	public static Color colorGateway= DEFAULT_COLOR_GATEWAY;
	public static Color colorPool= DEFAULT_COLOR_POOL;
	public static Color colorLane= DEFAULT_COLOR_LANE;
	public static Color colorGroup= DEFAULT_COLOR_GROUP;
	public static Color colorData= DEFAULT_COLOR_DATA;
	public static Color colorText= DEFAULT_COLOR_TEXT;
	public static Color colorSequence= DEFAULT_COLOR_SEQUENCE;
	public static Color colorMessage= DEFAULT_COLOR_MESSAGE;
	public static Color colorAssociation= DEFAULT_COLOR_ASSOCIATION;

	public static int useColor= -1;
	
	public static void setUseColor(boolean useColor) {
		FigureHelper.useColor= useColor ? 1 : 0;
	}
	
	public static boolean isUseColor() {
		if (useColor == -1) {
			useColor= VsdtDiagramEditorPlugin.getInstance().getPreferenceStore().getBoolean(DiagramAppearancePreferencePage.PREF_USE_ADDITIONAL_COLORS)
			? 1 : 0;
		}
		return useColor == 1;
	}
	
	public static Color getForeground(Figure figure, Object hint) {
		if (isUseColor()) {
			if (figure instanceof MessageFlowFigure) {
				return colorMessage;
			}
			if (figure instanceof GroupFigure) {
				return colorGroup;
			}
			if (figure instanceof AssociationFigure) {
				return colorAssociation;
			}
			if (figure instanceof TextAnnotationFigure) {
				return colorText;
			}
		}
		return DEFAULT_FOREGROUND;
	}
	
	public static Color getForeground(Figure figure) {
		return getForeground(figure, null);
	}

	public static Color getBackground(Figure figure, Object hint) {
		if (isUseColor()) {
			if (figure instanceof ActivityFigure) {
				return (Integer) hint % 2 == 0 ? colorActivity  : colorActivityAlt;
			}
			if (figure instanceof EventFigure) {
				switch ((Integer) hint) {
				case EventFigure.START:        return colorStart ;
				case EventFigure.INTERMEDIATE: return colorIntermediate;
				case EventFigure.END:          return colorEnd;
				}
			}
			if (figure instanceof GatewayFigure) {
				return colorGateway;
			}
			if (figure instanceof DataObjectFigure) {
				return colorData;
			}
			if (figure instanceof SwimlaneFigure) {
				return (Boolean) hint ? colorPool : colorLane;
			}
		}
		return DEFAULT_BACKGROUND;
	}
	
	public static Color getBackground(Figure figure) {
		return getBackground(figure, null);
	}
	
	
	/*
	 * Activity Icons
	 */

	public static Map<String, Image> activityIcons= new HashMap<String, Image>();
	
	private static int useActivityIcons= -1;
	
	public static void setUseActivityIcons(boolean useActivityIcons) {
		FigureHelper.useActivityIcons = useActivityIcons ? 1 : 0;
	}
	
	public static boolean isUseActivityIcons() {
		if (useActivityIcons == -1) {
			useActivityIcons= VsdtDiagramEditorPlugin.getInstance().getPreferenceStore().getBoolean(DiagramAppearancePreferencePage.PREF_USE_ACTIVITY_ICONS)
					? 1 : 0;
		}
		return useActivityIcons == 1;
	}

	/**
	 * Sets the activityIcon field to the image appropriate for the current activity type.
	 * The images are stored in a static map, so they do not have to be reloaded on each 
	 * change of the activity type and for each individual activity.
	 */
	public static Image getIcon(String key) {
		Image icon= activityIcons.get(key);
		if (icon == null) {
			String path= "icons/activityIcons/" + key + ".gif";
			ImageDescriptor descriptor= VsdtDiagramEditorPlugin.imageDescriptorFromPlugin(VsdtDiagramEditorPlugin.ID, path);
			if (descriptor != null) {
				icon= descriptor.createImage();
				activityIcons.put(key, icon);
		    } else {
		        System.err.println("Could not find file: " + path);
			}			
		}
		return icon;
	}
	
	public static void drawGradient(Graphics g, Rectangle bounds, Color color1, Color color2, boolean vertical) {
		Color oldForeground= g.getForegroundColor();
		Color oldBackground= g.getBackgroundColor();
		
		g.setForegroundColor(color1);
		g.setBackgroundColor(color2);
		g.fillGradient(bounds, vertical);
		g.setForegroundColor(oldForeground);
		g.setBackgroundColor(oldBackground);	
	}
	
	/*
	 * Tooltips
	 */

	private static final String NL = System.getProperty("line.separator");
	
	public static String getToolTipText(IdObject object) {
		StringBuffer buffer = new StringBuffer();
		
		if (object instanceof AbstractProcess) {
			AbstractProcess process = (AbstractProcess) object;
			if (! process.getProperties().isEmpty()) {
				buffer.append("Properties:");
				for (Property property : process.getProperties()) {
					buffer.append(NL + "- " + VsdtToStringHelper.getString(property));
				}
			}
		}
		if (object instanceof FlowObject) {
			FlowObject flowObject = (FlowObject) object;
			if (! flowObject.getAssignments().isEmpty()) {
				if (! buffer.toString().isEmpty()) {
					buffer.append(NL + "- - -" + NL);
				}
				buffer.append("Assignments:");
				for (Assignment assignment : flowObject.getAssignments()) {
					if (assignment.getAssignTime() == AssignTimeType.START) {
						buffer.append(NL + "< " + VsdtToStringHelper.getString(assignment));
					}
				}
				for (Assignment assignment : flowObject.getAssignments()) {
					if (assignment.getAssignTime() == AssignTimeType.END) {
						buffer.append(NL + "> " + VsdtToStringHelper.getString(assignment));
					}
				}
				if (flowObject instanceof Event) {
					Event event = (Event) flowObject;
					buffer.append(NL + "- - -");
					if (event.getImplementation() != null) {
						buffer.append(NL + "Implementation: " + getTextForImplementation(event.getImplementation()));
					}
					if (event.getRuleExpression() != null) {
						buffer.append(NL + "Rule: " + event.getRuleExpression().getExpression());
					}
					if (event.getSignal() != null) {
						buffer.append(NL + "Signal: " + event.getSignal());
					}
					if (event.getTimeExpression() != null) {
						buffer.append(NL + "Time: " + event.getTimeExpression().getExpression());
					}
				}
				if (flowObject instanceof Activity) {
					Activity activity = (Activity) flowObject;
					buffer.append(NL + "- - -");
					if (activity.getImplementation() != null) {
						buffer.append(NL + "Implementation: " + getTextForImplementation(activity.getImplementation()));
					}
					if (activity.getScript() != null) {
						buffer.append(NL + "Script:" + NL + activity.getScript());
					}
				}
			}
		}
		return buffer.toString().isEmpty() ? null : buffer.toString();
	}
	
	private static String getTextForImplementation(Implementation impl) {
		StringBuffer buffer = new StringBuffer();
		if (impl instanceof Service) {
			Service service = (Service) impl;
			buffer.append(VsdtToStringHelper.getString(service));
			if (! service.getPreconditions().isEmpty()) {
				buffer.append(NL + "- Preconditions: ");
				for (Expression exp : service.getPreconditions()) {
					buffer.append(NL + "  - " + exp.getExpression());
				}
			}
			if (! service.getEffects().isEmpty()) {
				buffer.append(NL + "- Effects: ");
				for (Expression exp : service.getEffects()) {
					buffer.append(NL + "  - " + exp.getExpression());
				}
			}
		}
		if (impl instanceof MessageChannel) {
			MessageChannel channel = (MessageChannel) impl;
			buffer.append(VsdtToStringHelper.getString(channel));
		}
		return buffer.toString();
	}
}
