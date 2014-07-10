package com.tmathmeyer.bubble.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonCloseListener implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
