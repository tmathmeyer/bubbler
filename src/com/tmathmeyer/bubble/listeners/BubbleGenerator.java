package com.tmathmeyer.bubble.listeners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tmathmeyer.bubble.model.CircleHolder;
import com.tmathmeyer.bubble.model.IntersectionHolder;
import com.tmathmeyer.bubble.model.ShapeHolder;
import com.tmathmeyer.geom.Point;
import com.tmathmeyer.geom.shape.Circle;

public class BubbleGenerator implements ActionListener
{
	private final IntersectionHolder circles = CircleHolder.INSTANCE, shapes = ShapeHolder.INSTANCE;
	private final Component panel;
	
	public BubbleGenerator(Component p)
	{
		panel = p;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		circles.clear();
		for(int j = 0; j < 1000; j++)
		{
			int x = (int) (Math.random() * panel.getWidth());
			int y = (int) (Math.random() * panel.getHeight());
			Point p = new Point(x, y);
			Circle c = new Circle(p, 0);
			int i = 0;
			for(; !(shapes.intersectsAny(c) || circles.intersectsAny(c)); i+=5)
			{
				c = new Circle(p, i);
			}
			if (i > 5)
			{
				((CircleHolder)circles).add(new Circle(p, i-5));
			}
			panel.repaint();
		}
	}
	
	
}
