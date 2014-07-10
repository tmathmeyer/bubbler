package com.tmathmeyer.bubble.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import com.tmathmeyer.bubble.view.ImagePanel;
import com.tmathmeyer.bubble.view.View;

public class SelectImage implements ActionListener
{
	private final View view;
	private ImagePanel panel;
	
	public SelectImage(View v, ImagePanel p)
	{
		view = v;
		panel = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(null);

	    if (returnVal == JFileChooser.APPROVE_OPTION) {
	        File file = fc.getSelectedFile();
	        
	        BufferedImage image;
			try {
				image = ImageIO.read(file);
				this.panel = new ImagePanel(image, view, panel.getAllButtons());
				this.panel.addAndPaint();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	    }
	}
}
