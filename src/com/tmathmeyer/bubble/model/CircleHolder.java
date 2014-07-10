package com.tmathmeyer.bubble.model;

import java.util.LinkedList;
import java.util.List;

import com.tmathmeyer.geom.shape.Circle;

public class CircleHolder implements IntersectionHolder
{

	private List<Circle> circles = new LinkedList<>();
	
	@Override
	public boolean intersectsAny(Circle c)
	{
		for(Circle b : circles)
		{
			if (b.intersects(c))
			{
				return true;
			}
		}
		return false;
	}
	
	public List<Circle> getAll()
	{
		return new LinkedList<>(circles);
	}

	@Override
	public void clear()
	{
		circles = new LinkedList<>();
	}
	
	public void add(Circle c)
	{
		circles.add(c);
	}
	
	public static final CircleHolder INSTANCE = new CircleHolder();
	
	private CircleHolder() {}
}
