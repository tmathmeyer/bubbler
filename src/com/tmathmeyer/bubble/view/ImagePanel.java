package com.tmathmeyer.bubble.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.tmathmeyer.bubble.data.Shape;
import com.tmathmeyer.bubble.listeners.DrawingPanelClickListener;
import com.tmathmeyer.bubble.model.CircleHolder;
import com.tmathmeyer.bubble.model.ShapeHolder;
import com.tmathmeyer.geom.shape.Circle;

public class ImagePanel extends JPanel
{
	private static final long serialVersionUID = 3298830684199407878L;
	private final View view;
	
	
	public static class TextButtonListener {
		private final JButton button;
		
		public TextButtonListener(String t, ActionListener l)
		{
			button = new JButton(t);
			button.addActionListener(l);
		}
		
		public JButton getListenedButton()
		{
			return button;
		}
	}
	
	private final List<TextButtonListener> buttons;
	private final BufferedImage image;
	
	public void addButton(String title, ActionListener l)
	{
		buttons.add(new TextButtonListener(title, l));
	}
	
	public final List<TextButtonListener> getAllButtons()
	{
		return buttons;
	}
	
	private void addButtonsToView(int gap)
	{
		this.setLayout(null);
		int left = 0;
		Insets insets = this.getInsets();
		for(TextButtonListener tbl : buttons)
		{
			JButton button = tbl.getListenedButton();
			Dimension size = button.getPreferredSize();
			
			button.setBounds(gap + left + insets.left, gap + insets.top, size.width, size.height);
			left += size.width;
			this.add(button);
		}
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		g.drawImage(image, 0, 0, null);
		List<Circle> cc = CircleHolder.INSTANCE.getAll();
		if (cc.size() != 0)
		{
			Graphics2D g2d = (Graphics2D) g;
			Area a = new Area(new Rectangle(0, 0, getWidth(), getHeight()));
			
			g.setColor(Color.RED);
			for(Circle d : cc)
			{
				a.subtract(new Area(new Ellipse2D.Double(d.getCenter().getX()-d.getRadius(), d.getCenter().getY()-d.getRadius(), d.getRadius()*2, d.getRadius()*2)));
			}
			g2d.fill(a);
		}
		else
		{
			for(Shape s : ShapeHolder.INSTANCE.getAllShapes())
			{
				if (s != null)
				{
					s.draw(g);
				}
			}
		}
	}
	
	
	public ImagePanel(BufferedImage image, View containingWindow, List<TextButtonListener> buttons)
	{
		this.buttons = buttons;
		this.image = image;
		this.view = containingWindow;
		
		DrawingPanelClickListener dpcl = new DrawingPanelClickListener(this);
		this.addMouseListener(dpcl);
	}
	
	public void addAndPaint()
	{
		addButtonsToView(10);
		view.setSize(image.getWidth(), image.getHeight());
		view.setLayout(new GridLayout(1,1));
		view.remove(view.getComponent(0).getComponentAt(1, 1));
		view.swapPanel(this);
		repaint();
	}
}
