package com.tmathmeyer.bubble.listeners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tmathmeyer.bubble.model.CircleHolder;
import com.tmathmeyer.bubble.model.ShapeHolder;

public class ClearPolygonsListener implements ActionListener{

	private final Component panel;
	
	public ClearPolygonsListener(Component p)
	{
		panel = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		ShapeHolder.INSTANCE.clear();
		CircleHolder.INSTANCE.clear();
		panel.repaint();
	}

}
