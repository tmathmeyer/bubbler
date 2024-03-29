package com.tmathmeyer.bubble.model;

import java.util.LinkedList;
import java.util.List;

import com.tmathmeyer.bubble.data.Shape;
import com.tmathmeyer.geom.Point;
import com.tmathmeyer.geom.shape.Circle;

public class ShapeHolder implements IntersectionHolder
{
	private List<Shape> shapes = new LinkedList<Shape>();
	private Shape shape;
	
	public void addPoint(Point cpv)
	{
		if (shape == null)
		{
			shape = new Shape(cpv);
		}
		else
		{
			shape = shape.add(cpv);
		}
	}
	
	public void finish()
	{
		shapes.add(shape);
		shape = null;
	}
	
	public List<Shape> getAllShapes()
	{
		List<Shape> shapes = new LinkedList<>(this.shapes);
		shapes.add(shape);
		return shapes;
	}

	public void clear() {
		shapes = new LinkedList<Shape>();
		shape = null;
	}
	
	public boolean intersectsAny(Circle c)
	{
		for(Shape s : getAllShapes())
		{
			if (s != null && s.intersects(c))
			{
				return true;
			}
		}
		return shapes.size() == 0 && shape == null;
	}
	
	public static final ShapeHolder INSTANCE = new ShapeHolder();
	
	private ShapeHolder() {}
}
