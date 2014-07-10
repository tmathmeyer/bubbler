package com.tmathmeyer.geom.shape;

import com.tmathmeyer.geom.Point;
import com.tmathmeyer.geom.Vector;

public class Circle
{
	private final Point center;
	private final int radius;
	
	public Circle(Point p, int r)
	{
		center = p;
		radius = r;
	}

	/**
	 * @return the center
	 */
	public Point getCenter() {
		return center;
	}

	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}
	
	public boolean intersects(Vector v)
	{
		Vector a = new Vector(center, v.getStart());
		Vector b = new Vector(center, v.getEnd());
		
		if (a.distance() < radius || b.distance() < radius)
		{
			return true;
		}
		
		return v.intersects(getAngleVector(v));
	}
	
	public Vector getAngleVector(Vector v)
	{
		Vector a = new Vector(center, v.getStart());
		Vector b = new Vector(center, v.getEnd());
		double aa = a.angle();
		double ba = b.angle();
		double na = (aa/2.0) + (ba/2.0);
		
		Vector x = new Vector(center, radius, na);
		Vector y = new Vector(center, -radius, na);
		
		return new Vector(x.getEnd(), y.getEnd());
	}
}
