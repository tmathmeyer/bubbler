package com.tmathmeyer.bubble.listeners;

import java.awt.event.ActionEvent;

import com.tmathmeyer.bubble.model.ShapeHolder;

public class NewPolygonListener extends BubbleButtonListener {

	public NewPolygonListener(ShapeHolder sh) {
		super(sh);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		getSh().finish();
	}

}
