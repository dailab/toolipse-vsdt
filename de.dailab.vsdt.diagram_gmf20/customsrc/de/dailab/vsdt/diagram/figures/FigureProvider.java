package de.dailab.vsdt.diagram.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Polygon;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Color;

import de.dailab.vsdt.diagram.preferences.DiagramPreferenceInitializer;

/**
 * this class provides the inner figures for e.g. events and gateways
 * 
 * @author tkuester
 */
public class FigureProvider {
	
	private Color foreground= ColorConstants.black;
	
	private Color background= ColorConstants.white;
	
	/**
	 * offset in x direction
	 */
	private int offsetX;
	
	/**
	 * offset in y direction
	 */
	private int offsetY;
	
	/**
	 * create new figure provider
	 * @param offsetX	the offset in x direction
	 * @param offsetY	the offset in y direction
	 */
	public FigureProvider(Color foreground, Color background, int offsetX, int offsetY) {
		this.foreground= foreground;
		this.background= background;
		this.offsetX= offsetX;
		this.offsetY= offsetY;
	}

	public static Color getColor(String key) {
		return new Color(null, PreferenceConverter.getColor(
				DiagramPreferenceInitializer.getStore(), 
				key));
	}
	
	
	/**
	 * set the drawing offset
	 * @param x	new value for offsetX
	 * @param y	new value for offsetY
	 */
	public void setOffsets(int x, int y) {
		this.offsetX=x;
		this.offsetY=y;
	}
	
	/**
	 * @param x	x coordinate
	 * @param y	y coordinate
	 * @return	new point
	 */
	private Point p(int x, int y) {
		return new Point(x+offsetX,y+offsetY);
	}

	//EVENT TRIGGEr FIGURES
	
	/**
	 * @return a cancel event figure
	 */
	public IFigure createCancelEventFigure() {
		Polygon figure= new Polygon();
		figure.setBackgroundColor(foreground);
		figure.setFill(true);
		figure.addPoint(p(2,0));
		figure.addPoint(p(10,8));
		figure.addPoint(p(18,0));
		figure.addPoint(p(20,2));
		figure.addPoint(p(12,10));
		figure.addPoint(p(20,18));
		figure.addPoint(p(18,20));
		figure.addPoint(p(10,12));
		figure.addPoint(p(2,20));
		figure.addPoint(p(0,18));
		figure.addPoint(p(8,10));
		figure.addPoint(p(0,2));
		
		return figure;
	}
	
	/**
	 * @return a compensation event figure
	 */
	public IFigure createCompensationEventFigure() {
		Polygon figure= new Polygon();
		figure.setBackgroundColor(foreground);
		figure.setFill(true);
		figure.addPoint(p(-2,10));
		figure.addPoint(p(8,0));
		figure.addPoint(p(8,10));
		figure.addPoint(p(18,0));
		figure.addPoint(p(18,20));
		figure.addPoint(p(8,10));
		figure.addPoint(p(8,20));
		
		return figure;
	}
	
	/**
	 * @return an error event figure
	 */
	public IFigure createErrorEventFigure() {
		Polygon figure= new Polygon();
		figure.setBackgroundColor(foreground);
		figure.setFill(true);
		figure.addPoint(p(4,3));
		figure.addPoint(p(13,12));
		figure.addPoint(p(20,0));
		figure.addPoint(p(16,17));
		figure.addPoint(p(7,8));
		figure.addPoint(p(0,20));
		
		return figure;
	}
	
	/**
	 * @return a link event figure
	 */
	public IFigure createLinkEventFigure() {
		Polygon figure= new Polygon();
		figure.setBackgroundColor(foreground);
		figure.setFill(true);
		figure.addPoint(p(0,5));
		figure.addPoint(p(12,5));
		figure.addPoint(p(12,0));
		figure.addPoint(p(20,10));
		figure.addPoint(p(12,20));
		figure.addPoint(p(12,15));
		figure.addPoint(p(0,15));
		
		return figure;
	}
	
	/**
	 * @return a message event figure
	 */
	public IFigure createMessageEventFigure() {
		Polyline figure= new Polyline();
		figure.addPoint(p(0,2));
		figure.addPoint(p(0,17));
		figure.addPoint(p(20,17));
		figure.addPoint(p(20,2));
		figure.addPoint(p(10,9));
		figure.addPoint(p(0,2));
		figure.addPoint(p(20,2));
		
		return figure;
	}

	/**
	 * @return a multiple event figure
	 */
	public IFigure createMultipleEventFigure() {
		RectangleFigure figure= new RectangleFigure();
		figure.setBounds(new Rectangle(10,10,20,20));
		figure.setFill(false);
		figure.setOutline(false);
		
		Polygon figure1= new Polygon();
		figure.setBackgroundColor(foreground);
		figure1.setFill(true);
		figure1.addPoint(p(10,0));
		figure1.addPoint(p(20,15));
		figure1.addPoint(p(0,15));
		
		Polygon figure2= new Polygon();
		figure.setBackgroundColor(foreground);
		figure2.setFill(true);
		figure2.addPoint(p(0,5));
		figure2.addPoint(p(20,5));
		figure2.addPoint(p(10,20));
		
		figure.add(figure1,null);
		figure.add(figure2,null);
		return figure;
	}
	
	/**
	 * @return a rule event figure
	 */
	public IFigure createRuleEventFigure() {
		RectangleFigure figure= new RectangleFigure();
		figure.setBounds(new Rectangle(12,10,16,20));
		
		Polyline figure1= new Polyline();
		figure1.addPoint(p(5,4));
		figure1.addPoint(p(15,4));
		
		Polyline figure2= new Polyline();
		figure2.addPoint(p(5,8));
		figure2.addPoint(p(15,8));
		
		Polyline figure3= new Polyline();
		figure3.addPoint(p(5,12));
		figure3.addPoint(p(15,12));
		
		Polyline figure4= new Polyline();
		figure4.addPoint(p(5,16));
		figure4.addPoint(p(15,16));		
		
		figure.add(figure1,null);
		figure.add(figure2,null);
		figure.add(figure3,null);
		figure.add(figure4,null);
		return figure;
	}
	
	/**
	 * @return a terminate event figure
	 */
	public IFigure createTerminateEventFigure() {
		Ellipse figure= new Ellipse();
		figure.setBounds(new Rectangle(12,12,16,16));
		
		return figure;
	}
	
	/**
	 * @return a timer event figure
	 */
	public IFigure createTimerEventFigure() {
		Ellipse figure= new Ellipse();
		figure.setFill(false);
		figure.setBounds(new Rectangle(10,10,21,21));
		figure.setBackgroundColor(background);
		
		Polyline figureZ1= new Polyline();
		figureZ1.addPoint(p(10,10));
		figureZ1.addPoint(p(12,2));
		
		Polyline figureZ2= new Polyline();
		figureZ2.addPoint(p(10,10));
		figureZ2.addPoint(p(15,10));
		
		Polyline figure1= new Polyline();
		figure1.addPoint(p(15,1));
		figure1.addPoint(p(14,3));
		
		Polyline figure2= new Polyline();
		figure2.addPoint(p(19,5));
		figure2.addPoint(p(17,6));
		
		Polyline figure3= new Polyline();
		figure3.addPoint(p(20,10));
		figure3.addPoint(p(18,10));
		
		Polyline figure4= new Polyline();
		figure4.addPoint(p(19,15));
		figure4.addPoint(p(17,14));
		
		Polyline figure5= new Polyline();
		figure5.addPoint(p(15,19));
		figure5.addPoint(p(14,17));
		
		Polyline figure6= new Polyline();
		figure6.addPoint(p(10,20));
		figure6.addPoint(p(10,18));
		
		Polyline figure7= new Polyline();
		figure7.addPoint(p(5,19));
		figure7.addPoint(p(6,17));
		
		Polyline figure8= new Polyline();
		figure8.addPoint(p(1,15));
		figure8.addPoint(p(3,14));
		
		Polyline figure9= new Polyline();
		figure9.addPoint(p(0,10));
		figure9.addPoint(p(2,10));
		
		Polyline figure10= new Polyline();
		figure10.addPoint(p(1,5));
		figure10.addPoint(p(3,6));
		
		Polyline figure11= new Polyline();
		figure11.addPoint(p(5,1));
		figure11.addPoint(p(6,3));

		Polyline figure12= new Polyline();
		figure12.addPoint(p(10,0));
		figure12.addPoint(p(10,2));
		
		
		figure.add(figureZ1,null);
		figure.add(figureZ2,null);
		figure.add(figure1,null);
		figure.add(figure2,null);
		figure.add(figure3,null);
		figure.add(figure4,null);
		figure.add(figure5,null);
		figure.add(figure6,null);
		figure.add(figure7,null);
		figure.add(figure8,null);
		figure.add(figure9,null);
		figure.add(figure10,null);
		figure.add(figure11,null);
		figure.add(figure12,null);
		
		return figure;
	}
	
	//GATEWAY TYPE FIGURES
	
	/**
	 * @return an and gateway figure
	 */
	public IFigure createAndGatewayFigure() {
		Polygon figure= new Polygon();
		figure.setForegroundColor(foreground);
		figure.setBackgroundColor(foreground);
		figure.setFill(true);
		figure.addPoint(p(8,0));
		figure.addPoint(p(12,0));
		figure.addPoint(p(12,8));
		figure.addPoint(p(20,8));
		figure.addPoint(p(20,12));
		figure.addPoint(p(12,12));
		figure.addPoint(p(12,20));
		figure.addPoint(p(8,20));
		figure.addPoint(p(8,12));
		figure.addPoint(p(0,12));
		figure.addPoint(p(0,8));
		figure.addPoint(p(8,8));
		
		return figure;
	}
	
	/**
	 * @return a complex gateway figure
	 */
	public IFigure createComplexGatewayFigure() {
		Polygon figure= new Polygon();
		figure.setForegroundColor(foreground);
		figure.setBackgroundColor(foreground);
		figure.setFill(true);
		figure.addPoint(p(8,0));
		figure.addPoint(p(12,0));
		figure.addPoint(p(12,8));
		figure.addPoint(p(20,8));
		figure.addPoint(p(20,12));
		figure.addPoint(p(12,12));
		figure.addPoint(p(12,20));
		figure.addPoint(p(8,20));
		figure.addPoint(p(8,12));
		figure.addPoint(p(0,12));
		figure.addPoint(p(0,8));
		figure.addPoint(p(8,8));
		
		Polygon figure1= new Polygon();
		figure.setBackgroundColor(foreground);
		figure1.setFill(true);
		figure1.addPoint(p(3,1));
		figure1.addPoint(p(10,8));
		figure1.addPoint(p(17,1));
		figure1.addPoint(p(19,3));
		figure1.addPoint(p(12,10));
		figure1.addPoint(p(19,17));
		figure1.addPoint(p(17,19));
		figure1.addPoint(p(10,12));
		figure1.addPoint(p(3,19));
		figure1.addPoint(p(1,17));
		figure1.addPoint(p(8,10));
		figure1.addPoint(p(1,3));
		
		figure.add(figure1,null);
		return figure;
	}
	
	/**
	 * @return an or gateway figure
	 */
	public IFigure createOrGatewayFigure() {
		Ellipse figure= new Ellipse();
		figure.setForegroundColor(foreground);
		figure.setBackgroundColor(foreground);
		figure.setBounds(new Rectangle(10,10,20,20));
		
		Ellipse figure1= new Ellipse();
		figure1.setBounds(new Rectangle(13,13,14,14));
		figure1.setForegroundColor(background);
		figure1.setBackgroundColor(background);
		
		figure.add(figure1,null);
		
		return figure;
	}
	
	/**
	 * @return an xor event-based gateway figure
	 */
	public IFigure createXorEventGatewayFigure() {
		Ellipse figure= new Ellipse();
		figure.setForegroundColor(foreground);
		figure.setBackgroundColor(background);
		figure.setBounds(new Rectangle(7,7,26,26));
		
		Ellipse figure0= new Ellipse();
		figure0.setBounds(new Rectangle(9,9,22,22));
		
		
		Polygon figure1= new Polygon();
		figure1.setBackgroundColor(foreground);
		figure1.setFill(true);
		figure1.addPoint(p(10,0));
		figure1.addPoint(p(20,15));
		figure1.addPoint(p(0,15));
		
		Polygon figure2= new Polygon();
		figure2.setBackgroundColor(foreground);
		figure2.setFill(true);
		figure2.addPoint(p(0,5));
		figure2.addPoint(p(20,5));
		figure2.addPoint(p(10,20));
		
		figure.add(figure0,null);
		figure.add(figure1,null);
		figure.add(figure2,null);
		return figure;
	}
	
	/**
	 * @return an xor data-based gateway figure
	 */
	public IFigure createXorDataGatewayFigure() {
		Polygon figure= new Polygon();
		figure.setFill(true);
		figure.setForegroundColor(foreground);
		figure.setBackgroundColor(foreground);
		figure.addPoint(p(2,0));
		figure.addPoint(p(6,0));
		figure.addPoint(p(18,20));
		figure.addPoint(p(14,20));
		
		Polygon figure1= new Polygon();
		figure1.setFill(true);
		figure1.addPoint(p(2,20));
		figure1.addPoint(p(6,20));
		figure1.addPoint(p(18,0));
		figure1.addPoint(p(14,0));
		
		figure.add(figure1,null);
		return figure;
	}
	
	//ACTIVITY DECORATIONS
	
//	/**
//	 * @return a ad hoc activity decoration
//	 */
//	public IFigure createAdHocFigure() {
//		RectangleFigure figure= new RectangleFigure();
//		figure.setBounds(new Rectangle(-offsetX,-offsetY,10,10));
//		figure.setFill(false);
//		figure.setOutline(false);
//		
//		Ellipse figure1= new Ellipse();
//		figure1.setForegroundColor(BLACK);
//		figure1.setBackgroundColor(BLACK);
//		figure1.setBounds(new Rectangle(0,2,6,6));
//		
//		Ellipse figure2= new Ellipse();
//		figure2.setBounds(new Rectangle(1,3,4,4));
//		figure2.setForegroundColor(WHITE);
//		figure2.setBackgroundColor(WHITE);
//		
//		Ellipse figure3= new Ellipse();
//		figure3.setForegroundColor(BLACK);
//		figure3.setBackgroundColor(BLACK);
//		figure3.setBounds(new Rectangle(4,2,6,6));
//		
//		Ellipse figure4= new Ellipse();
//		figure4.setBounds(new Rectangle(5,3,4,4));
//		figure4.setForegroundColor(WHITE);
//		figure4.setBackgroundColor(WHITE);
//		
//		RectangleFigure figure5= new RectangleFigure();
//		figure5.setBackgroundColor(WHITE);
//		figure5.setForegroundColor(WHITE);
//		figure5.setFill(true);
//		figure5.setBounds(new Rectangle(0,6,5,4));
//		
//		RectangleFigure figure6= new RectangleFigure();
//		figure6.setBackgroundColor(WHITE);
//		figure6.setForegroundColor(WHITE);
//		figure6.setFill(true);
//		figure6.setBounds(new Rectangle(5,0,5,4));
//		
//		figure.add(figure1,null);
//		figure.add(figure2,null);
//		figure.add(figure3,null);
//		figure.add(figure4,null);
//		figure.add(figure5,null);
//		figure.add(figure6,null);
//		return figure;
//	}
//	
//	/**
//	 * @return a standard loop decoration
//	 */
//	public IFigure createStandardLoopFigure() {
//		RectangleFigure figure= new RectangleFigure();
//		figure.setBounds(new Rectangle(-offsetX,-offsetY,10,10));
//		figure.setFill(false);
//		figure.setOutline(false);
//		
//		Ellipse figure1= new Ellipse();
//		figure1.setForegroundColor(BLACK);
//		figure1.setBackgroundColor(BLACK);
//		figure1.setBounds(new Rectangle(0,0,10,10));
//		
//		Ellipse figure2= new Ellipse();
//		figure2.setBounds(new Rectangle(2,2,6,6));
//		figure2.setForegroundColor(WHITE);
//		figure2.setBackgroundColor(WHITE);
//		
//		RectangleFigure figure3= new RectangleFigure();
//		figure3.setBackgroundColor(WHITE);
//		figure3.setOutline(false);
//		figure3.setBounds(new Rectangle(3,5,3,5));
//		
//		RectangleFigure figure4= new RectangleFigure();
//		figure4.setBackgroundColor(BLACK);
//		figure4.setBounds(new Rectangle(0,8,4,2));
//		
//		RectangleFigure figure5= new RectangleFigure();
//		figure5.setBackgroundColor(BLACK);
//		figure5.setBounds(new Rectangle(3,6,2,4));
//		
//		figure.add(figure1,null);
//		figure.add(figure2,null);
//		figure.add(figure3,null);
//		figure.add(figure4,null);
//		figure.add(figure5,null);
//		return figure;
//	}
//
//	/**
//	 * @return a multiInstance decoration
//	 */
//	public IFigure createMultiinstanceLoopFigure() {
//		RectangleFigure figure= new RectangleFigure();
//		figure.setBounds(new Rectangle(-offsetX,-offsetY,10,10));
//		figure.setFill(false);
//		figure.setOutline(false);
//		
//		RectangleFigure figure1= new RectangleFigure();
//		figure1.setBackgroundColor(BLACK);
//		figure1.setBounds(new Rectangle(0,0,3,10));
//		
//		RectangleFigure figure2= new RectangleFigure();
//		figure2.setBackgroundColor(BLACK);
//		figure2.setBounds(new Rectangle(7,0,3,10));
//				
//		figure.add(figure1,null);
//		figure.add(figure2,null);
//		return figure;
//	}
//	
//	/**
//	 * @return a subprocess decoration
//	 */
//	public IFigure createSubprocessFigure() {
//		RectangleFigure figure= new RectangleFigure();
//		figure.setBounds(new Rectangle(-offsetX,-offsetY,10,10));
//		figure.setFill(true);
//		figure.setOutline(true);
//		
//		RectangleFigure figure1= new RectangleFigure();
//		figure1.setBackgroundColor(BLACK);
//		figure1.setBounds(new Rectangle(4,0,2,10));
//		
//		RectangleFigure figure2= new RectangleFigure();
//		figure2.setBackgroundColor(BLACK);
//		figure2.setBounds(new Rectangle(0,4,10,2));
//		
//		figure.add(figure1,null);
//		figure.add(figure2,null);
//		return figure;
//	}
//	
//	/**
//	 * @return a compensation activity decoration
//	 */
//	public IFigure createCompensationActivityFigure() {
//		RectangleFigure figure= new RectangleFigure();
//		figure.setBounds(new Rectangle(-offsetX,-offsetY,10,10));
//		figure.setFill(false);
//		figure.setOutline(false);
//		
//		RectangleFigure figure1= new RectangleFigure();
//		figure1.setBackgroundColor(BLACK);
//		figure1.setBounds(new Rectangle(0,4,10,2));
//		
//		RectangleFigure figure2= new RectangleFigure();
//		figure2.setBackgroundColor(BLACK);
//		figure2.setBounds(new Rectangle(3,0,2,10));
//		
//		RectangleFigure figure3= new RectangleFigure();
//		figure3.setBackgroundColor(BLACK);
//		figure3.setBounds(new Rectangle(8,0,2,10));
//		
//		RectangleFigure figure4= new RectangleFigure();
//		figure4.setBackgroundColor(BLACK);
//		figure4.setBounds(new Rectangle(1,2,3,6));
//		
//		RectangleFigure figure5= new RectangleFigure();
//		figure5.setBackgroundColor(BLACK);
//		figure5.setBounds(new Rectangle(6,2,3,6));
//		
//		figure.add(figure1);
//		figure.add(figure2);
//		figure.add(figure3);
//		figure.add(figure4);
//		figure.add(figure5);
//		return figure;
//	}
}

