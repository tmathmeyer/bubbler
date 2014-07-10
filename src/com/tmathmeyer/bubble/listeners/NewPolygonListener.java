package com.tmathmeyer.bubble.listeners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tmathmeyer.bubble.model.CircleHolder;
import com.tmathmeyer.bubble.model.ShapeHolder;

public class NewPolygonListener implements ActionListener{

	private final Component panel;
	
	public NewPolygonListener(Component p)
	{
		panel = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		ShapeHolder.INSTANCE.finish();
		CircleHolder.INSTANCE.clear();
		panel.repaint();
	}

}


