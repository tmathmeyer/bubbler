package com.tmathmeyer.geom;

public class Vector
{
	private final Point start, end;
	
	public Vector(Point s, Point e)
	{
		start = s;
		end = e;
	}
	
	public Vector(Point s, int distance, double angle)
	{
		angle *= Math.PI;
		angle /= 360.0;
		int x = (int) (distance * Math.sin(angle));
		int y = (int) (-distance * Math.cos(angle));
		
		start = s;
		end = new Point(s.getX() + x, s.getY() + y);
	}

	/**
	 * @return the start
	 */
	public Point getStart() {
		return start;
	}

	/**
	 * @return the end
	 */
	public Point getEnd() {
		return end;
	}
	
	public double distance()
	{
		double vd = end.getY() - start.getY();
		double hd = end.getX() - start.getX();
		vd *= vd;
		hd *= hd;
		return Math.sqrt(vd + hd);
	}
	
	// computes the angle where vertical is 0/360
	public double angle()
	{
		
		double vd = start.getY() - end.getY();
		double hd = end.getX() - start.getX();
		

		double atan = 0;
		if (vd > 0 && hd > 0)
		{ // first quadrent
			atan = Math.atan(hd/vd);
		}
		else if (vd == 0 && hd > 0)
		{
			atan = Math.PI / 2.0;
		}
		else if (vd < 0 && hd > 0)
		{
			atan = Math.atan(-vd / hd) + Math.PI/2.0;
		}
		else if (vd < 0 && hd == 0)
		{
			atan = Math.PI;
		}
		else if (vd < 0 && hd < 0)
		{
			atan = Math.atan(hd/vd) + Math.PI;
		}
		else if (vd == 0  && hd < 0)
		{
			atan = 3.0 * Math.PI / 2.0;
		}
		else if (vd > 0 && hd < 0)
		{
			atan = Math.atan(-vd / hd) + (3.0 * Math.PI / 2.0);
		}
		else if (vd > 0 && hd == 0)
		{
			return 0;
		}
		else
		{
			return -1;
		}
		return atan * 360.0 / Math.PI;
		
	}
	
	public boolean intersects(Vector other)
	{
		int a = getStart().getX();
		int b = getStart().getY();
		int c = getEnd().getX();
		int d = getEnd().getY();
		
		int p = other.getStart().getX();
		int q = other.getStart().getY();
		int r = other.getEnd().getX();
		int s = other.getEnd().getY();
		
		double det = ((c - a) * (s - q)) - ((r - p) * (d - b));
		if (det == 0)
		{
			return false;
		}
		double lambda = ((s - q) * (r - a) + (p - r) * (s - b)) / det;
		double gamma = ((b - d) * (r - a) + (c - a) * (s - b)) / det;
		return (0 < lambda && lambda < 1) && (0 < gamma && gamma < 1);
		
	}
	
	/*
	 * // returns true iff the line from (a,b)->(c,d) intersects with (p,q)->(r,s)
function intersects(a,b,c,d,p,q,r,s) {
  var det, gamma, lambda;
  det = (c - a) * (s - q) - (r - p) * (d - b);
  if (det === 0) {
    return false;
  } else {
    lambda = ((s - q) * (r - a) + (p - r) * (s - b)) / det;
    gamma = ((b - d) * (r - a) + (c - a) * (s - b)) / det;
    return (0 < lambda && lambda < 1) && (0 < gamma && gamma < 1);
  }
};
	 */
}
