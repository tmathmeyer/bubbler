package com.tmathmeyer.bubble.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.tmathmeyer.bubble.listeners.BubbleGenerator;
import com.tmathmeyer.bubble.listeners.ButtonCloseListener;
import com.tmathmeyer.bubble.listeners.ClearPolygonsListener;
import com.tmathmeyer.bubble.listeners.NewPolygonListener;
import com.tmathmeyer.bubble.listeners.SelectImage;
import com.tmathmeyer.bubble.view.ImagePanel.TextButtonListener;

public class View extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel old = null;

	public void updateSize(int w, int h)
	{
		w = w<100?100:w;
		h = h<100?100:h;
		Dimension d = new Dimension(w, h);
		this.setSize(d);
		this.setPreferredSize(d);
		this.pack();
		this.setVisible(true);
	}
	
	public void swapPanel(JPanel p)
	{
		if (old != null)
		{
			remove(old);
		}
		old = p;
		add(p, BorderLayout.CENTER);
	}
	
	
	public View()
	{
		this.setResizable(false);
		this.updateSize(600, 400);
	}
	
	
	public static void main(String... args) throws IOException
	{
		BufferedImage image = ImageIO.read(new File("/home/ted/ss.png"));
		View v = new View();
		ImagePanel ip = new ImagePanel(image, v, new LinkedList<TextButtonListener>());
		
		ip.addButton("Close", new ButtonCloseListener());
		ip.addButton("New Image", new SelectImage(v, ip));
		ip.addButton("Bubble", new BubbleGenerator(v));
		ip.addButton("New Polygon", new NewPolygonListener(v));
		ip.addButton("Clear", new ClearPolygonsListener(v));
		
		ip.addAndPaint();
		
		System.out.println(v.old.getClass().getCanonicalName());
		v.repaint();
	}
}
