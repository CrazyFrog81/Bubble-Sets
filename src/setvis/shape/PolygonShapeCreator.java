/**
 * 
 */
package setvis.shape;

import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import setvis.SetOutline;

/**
 * Creates direct shapes for the vertices generated by
 * {@link SetOutline#createOutline(Rectangle2D[], Rectangle2D[])}.
 * 
 * @author Joschi <josua.krause@googlemail.com>
 * 
 */
public class PolygonShapeCreator extends AbstractShapeCreator {

	/**
	 * Creates a new {@link PolygonShapeCreator} with the given set outline
	 * creator.
	 * 
	 * @param outline
	 *            The set outline generator.
	 */
	public PolygonShapeCreator(final SetOutline outline) {
		super(outline);
	}

	@Override
	protected Shape convertToShape(final Point2D[] points) {
		final int size = points.length;
		final int[] x = new int[size];
		final int[] y = new int[size];
		int i = size;
		while (--i >= 0) {
			x[i] = (int) points[i].getX();
			y[i] = (int) points[i].getY();
		}
		return new Polygon(x, y, size);
	}

	@Override
	protected Rectangle2D mapRect(final Rectangle2D r) {
		final double radius = getRadius();
		final double dblRad = radius * 2.0;
		return new Rectangle2D.Double(r.getMinX() - radius, r.getMinY()
				- radius, r.getWidth() + dblRad, r.getHeight() + dblRad);
	}

}