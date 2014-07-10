package com.tmathmeyer.bubble.listeners;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JPanel;

import com.tmathmeyer.bubble.Main;
import com.tmathmeyer.bubble.model.ShapeHolder;
import com.tmathmeyer.geom.Point;
import com.tmathmeyer.geom.Vector;
import com.tmathmeyer.geom.shape.Circle;

public class Bubbler extends BubbleButtonListener {

	private Main p;
	
	public Bubbler(ShapeHolder sh, Main p) {
		super(sh);
		this.p = p;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		for(int j = 0; j < 1000; j++)
		{
			int x = (int) (Math.random() * p.getWidth());
			int y = (int) (Math.random() * p.getHeight());
			Point p = new Point(x, y);
			Circle c = new Circle(p, 0);
			int i = 0;
			for(; (!getSh().intersectsALl(c)) && (!intersecterChecker(c, this.p.c)); i+=5)
			{
				c = new Circle(p, i);
			}
			if (i != 0)
			{
				this.p.c.add(c);
			}
		}
		this.p.bubble = true;
		this.p.repaint();
		
	}
	
	

	public boolean intersecterChecker(Circle c, List<Circle> l)
	{
		for(Circle k : l)
		{
			Vector v = new Vector(c.getCenter(), k.getCenter());
			if (v.distance() < c.getRadius() + k.getRadius()+10)
			{
				return true;
			}
		}
		return false;
	}
}
