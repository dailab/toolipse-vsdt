package de.dailab.common.gmf.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.OrthogonalRouter;

public class RoundedPolylineConnection extends PolylineConnectionEx {

	public static final int RADIUS= 15;
	
	/**
	 * rounded corners
	 * @see http://www.wsmostudio.org/multiproject/org.wsmostudio.bpmo/xref/org/wsmostudio/bpmo/figures/RoundedPolyline.html
	 */
	protected void outlineShape(Graphics g) {
		// no rectilinear routing -> normal style
		if (! (this.getConnectionRouter() instanceof OrthogonalRouter)) {
			super.outlineShape(g);
			return;
		}
  		PointList originalPoints = getPoints();
  		PointList newPoints = new PointList();
  		newPoints.addPoint(originalPoints.getFirstPoint());
  		for(int i = 1; i < originalPoints.size() - 1; i++) {
  			Point refPoint = originalPoints.getPoint(i);
  			Point prevPoint = originalPoints.getPoint(i-1);
  			Point nextPoint = originalPoints.getPoint(i+1);
  			
  			int lengPrevious = Math.max(Math.abs(refPoint.x - prevPoint.x), 
  					Math.abs(refPoint.y - prevPoint.y));
  			int lengNext = Math.max(Math.abs(refPoint.x - nextPoint.x), 
  					Math.abs(refPoint.y - nextPoint.y));
  			int r = Math.min(Math.min(lengPrevious / 2, lengNext / 2), RADIUS);
  			
  			int dxPrev = r * sign(prevPoint.x - refPoint.x); 
  			int dyPrev = r * sign(prevPoint.y - refPoint.y); 
  			int dxNext = r * sign(nextPoint.x - refPoint.x); 
  			int dyNext = r * sign(nextPoint.y - refPoint.y); 
  			
  			Point prevLineEnd = new Point(refPoint.x + dxPrev, refPoint.y + dyPrev);
  			newPoints.addPoint(prevLineEnd);
  			Point nextLineStart = new Point(refPoint.x + dxNext, refPoint.y + dyNext);

  			if (r < 3) { // too small radius
  				g.drawLine(prevLineEnd, nextLineStart);
  			}
  			else {
  				int arcCenterX = refPoint.x + dxNext + dxPrev;
  				int arcCenterY = refPoint.y + dyNext + dyPrev;
  
  				double step = Math.min(Math.max(Math.PI / r, 0.08), 0.2);
  				Point arcPoint = null;
  				for(double rad = 0.0; rad <= Math.PI / 2 ; rad += step) {
  					Point newArcPoint = new Point(arcCenterX - (int)Math.round(r * Math.cos(rad)) * sign(dxNext + dxPrev), 
  							arcCenterY - (int)Math.round(r * Math.sin(rad)) * sign(dyNext + dyPrev));
  					if (arcPoint != null) {
  						g.drawLine(arcPoint, newArcPoint);
  					}
  					else {
  						g.drawLine(newArcPoint, 
  								(newArcPoint.getDistance(prevLineEnd) < newArcPoint.getDistance(nextLineStart)) ?
  										prevLineEnd
  										: nextLineStart);
  					}
  					arcPoint = newArcPoint;
  				}
  				g.drawLine(arcPoint, 
  						(arcPoint.getDistance(prevLineEnd) < arcPoint.getDistance(nextLineStart)) ?
  								prevLineEnd
  								: nextLineStart);
  			}
  			newPoints.addPoint(nextLineStart);
  		}
  		newPoints.addPoint(originalPoints.getLastPoint());
  		for (int i = 0; i < newPoints.size(); i += 2) {
  			g.drawLine(newPoints.getPoint(i), newPoints.getPoint(i+1));
  		}
  	}
  	
  	private int sign(int test) {
  		if (test > 0) {
  			return 1;
  		}
  		if (test < 0) {
  			return -1;
 		}
  		return 0;
 	}

}
