package com.tmathmeyer.bubble.data;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.LinkedList;
import java.util.List;

import com.tmathmeyer.geom.Point;
import com.tmathmeyer.geom.Vector;
import com.tmathmeyer.geom.shape.Circle;

public class Shape
{
	private final List<Point> perimeter;
	
	public Shape(Point seed, List<Point> ol)
	{
		perimeter = new LinkedList<>(ol);
		perimeter.add(seed);
	}
	
	public Shape(Point cpv)
	{
		this(cpv, new LinkedList<Point>());
	}
	
	public Shape add(Point cpv)
	{
		return new Shape(cpv, perimeter);
	}
	
	public void draw(Graphics g)
	{
		Polygon p = toPoly();
		g.setColor(Color.black);
		g.drawPolygon(p);
		g.setColor(new Color(0, 140, 140, 128));
		g.fillPolygon(p);
	}
	
	public Polygon toPoly()
	{
		Polygon p = new Polygon();
		for(Point cpv : perimeter)
		{
			p.addPoint(cpv.getX(), cpv.getY());
		}
		return p;
	}
	
	public boolean intersects(Circle c)
	{
		Point a = null;
		Point b = null;
		
		if (toPoly().contains(new java.awt.Point(c.getCenter().getX(), c.getCenter().getY())))
		{
			return true;
		}
		
		for(Point p : perimeter)
		{
			a = b;
			b = p;
			
			if (a != null && b != null)
			{
				Vector v = new Vector(a, b);
				if (c.intersects(v))
				{
					return true;
				}
			}
		}
		
		return false;
	}
}
