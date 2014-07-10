package com.tmathmeyer.bubble.data;

public class ColorPolygonVertex
{
	private final int X, Y;
	
	public ColorPolygonVertex(int x, int y)
	{
		X = x;
		Y = y;
	}

	/**
	 * @return the x
	 */
	public int getX()
	{
		return X;
	}

	/**
	 * @return the y
	 */
	public int getY()
	{
		return Y;
	}
	
	public ColorPolygonVertex transform(PlanarDistance pd)
	{
		return new ColorPolygonVertex(pd.getX()+getX(), pd.getY()+getY());
	}
}
