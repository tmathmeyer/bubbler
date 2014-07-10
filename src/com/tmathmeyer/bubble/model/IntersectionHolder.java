package com.tmathmeyer.bubble.model;

import com.tmathmeyer.geom.shape.Circle;

public interface IntersectionHolder
{
	public boolean intersectsAny(Circle c);
	
	public void clear();
}
