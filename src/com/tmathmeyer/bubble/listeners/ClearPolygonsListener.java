package com.tmathmeyer.bubble.listeners;

import java.awt.event.ActionEvent;

import com.tmathmeyer.bubble.model.ShapeHolder;

public class ClearPolygonsListener extends BubbleButtonListener {

	public ClearPolygonsListener(ShapeHolder sh) {
		super(sh);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		getSh().clear();
	}

}
