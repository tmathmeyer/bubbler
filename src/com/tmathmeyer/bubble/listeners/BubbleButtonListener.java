package com.tmathmeyer.bubble.listeners;

import java.awt.event.ActionListener;

import com.tmathmeyer.bubble.model.ShapeHolder;

public abstract class BubbleButtonListener implements ActionListener
{
	private final ShapeHolder sh;
	
	public BubbleButtonListener( ShapeHolder sh )
	{
		this.sh = sh;
	}

	/**
	 * @return the sh
	 */
	public ShapeHolder getSh() {
		return sh;
	}
}
