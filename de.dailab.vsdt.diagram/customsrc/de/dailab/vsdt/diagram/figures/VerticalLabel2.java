
package de.dailab.vsdt.diagram.figures;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Display;

/**
 * A vertical label, adopted from STP BPMN editor, but heavily adapted.
 * 
 */
public class VerticalLabel2 extends WrappingLabel {
	
	/**
	 * this was the code suggested here: http://www.eclipsezone.com/eclipse/forums/t73282.html
	 * 
	 * customization: label alignment set to center-left
	 */
	public void paintFigure(final Graphics graphics) {
		
		String theText = super.getText();
		if (theText == null || theText.trim().length() == 0) {
			theText = "-";
		}
        
		//this might have issues on mac. ImageUtilities clips the lower parts of
        //the letters
		Image image = createRotatedImageOfString(
				theText, super.getFont(),
				super.getForegroundColor(), super.getBackgroundColor());
		// offset from left center
		Point offset= new Point(2, - image.getBounds().height/2);
		graphics.drawImage(image, super.getBounds().getLeft().getCopy().translate(offset));
		image.dispose();
	}
	
	@Override
	protected void paintClientArea(Graphics graphics) {
		// prevent the original string from being shown
	}
	
    /**
     * Fix the issues in the ImageUtilities where the size of the image
     * is the ascent of the font instead of being its height.
     * 
     * Also uses the GC for the rotation.
     * 
     * The biggest issue is the very idea of using an image.
     * The size of the font should be given by the mapmode, not in absolute
     * device pixel as it does look ugly when zooming in.
     * 
     * @param string the String to be rendered
     * @param font the font
     * @param foreground the text's color
     * @param background the background color
     * @return an Image which must be disposed
     */
    public Image createRotatedImageOfString(String string, Font font, 
                                                   Color foreground, Color background) {
        Display display = Display.getCurrent();
        if (display == null) {
            SWT.error(SWT.ERROR_THREAD_INVALID_ACCESS);
        }
        
        FontMetrics metrics = FigureUtilities.getFontMetrics(font);
        Dimension strSize = FigureUtilities.getStringExtents(string, font);
        Image srcImage = new Image(display, metrics.getHeight(), strSize.width);
        
        Transform transform = new Transform(display);
        transform.rotate(-90);
        
        GC gc = new GC(srcImage);
        gc.setTransform(transform);
        gc.setFont(font);
        gc.setForeground(foreground);
        gc.setBackground(background);
        gc.fillRectangle(gc.getClipping());
        gc.drawString(string, gc.getClipping().x, 
                gc.getClipping().y - metrics.getLeading());
        gc.dispose();
        
        return srcImage;
    }

	@Override
	public Rectangle getTextBounds() {
		Rectangle rect = super.getTextBounds();
		// swap width and height
		return new Rectangle(rect.x, rect.y, rect.height, rect.width);
	}
	
	@Override
    protected Dimension calculateLabelSize(Dimension txtSize) {
    	return new Dimension(txtSize.height + 5, txtSize.width + 5);
    }
	
	@Override
	public Dimension getPreferredSize(int wHint, int hHint) {
		Dimension dim= calculateSize();
		if (dim != null) {
			return dim;
		} else {
			return super.getPreferredSize(wHint, hHint);
		}
	}
	
	@Override
	public Dimension getMinimumSize(int w, int h) {
		Dimension dim= calculateSize();
		if (dim != null) {
			return dim;
		} else {
			return super.getMinimumSize(w, h);
		}
	}
	
	/**
	 * add a small margin to the figure
	 * 
	 * @return		text bounds plus margin
	 */
	private Dimension calculateSize() {
		Rectangle b= getTextBounds();
		if (b != null && b.width > 0 && b.height > 0) {
			return new Dimension(b.width+5, b.height+5);
		}
		return null;
	}

}
