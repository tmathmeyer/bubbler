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
		int rad = (int) (radius*1.2);
		
		Vector x = new Vector(center, rad, na);
		Vector y = new Vector(center, -rad, na);
		
		return new Vector(x.getEnd(), y.getEnd());
	}
	
	public boolean intersects(Circle c)
	{
		Vector v = new Vector(c.getCenter(), this.getCenter());
		return v.distance() < c.getRadius() + this.getRadius()+10;
	}
}
