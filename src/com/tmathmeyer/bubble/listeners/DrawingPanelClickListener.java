package com.tmathmeyer.bubble.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import com.tmathmeyer.bubble.model.ShapeHolder;
import com.tmathmeyer.geom.Point;

public class DrawingPanelClickListener implements MouseListener
{
	private final ShapeHolder sh;
	private final JPanel p;
	
	public DrawingPanelClickListener(ShapeHolder s, JPanel p)
	{
		sh = s;
		this.p = p;
	}

	@Override
	public void mouseClicked(MouseEvent click)
	{
		sh.addPoint(new Point(click.getX(), click.getY()));
		p.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

}
