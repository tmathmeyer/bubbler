package com.tmathmeyer.bubble;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.tmathmeyer.bubble.data.Shape;
import com.tmathmeyer.bubble.listeners.Bubbler;
import com.tmathmeyer.bubble.listeners.ClearPolygonsListener;
import com.tmathmeyer.bubble.listeners.DrawingPanelClickListener;
import com.tmathmeyer.bubble.listeners.NewPolygonListener;
import com.tmathmeyer.bubble.model.ShapeHolder;
import com.tmathmeyer.geom.shape.Circle;

public class Main extends JPanel
{
	private static final long serialVersionUID = 1L;
	private final ShapeHolder sh;
	public List<Circle> c = new LinkedList<>();
	public boolean bubble = false;
	
	public Main(ShapeHolder s)
	{
		sh = s;
		this.setLayout(null);
		
		JButton b1 = new JButton("New Polygon");
		JButton b2 = new JButton("Bubble");
		JButton b3 = new JButton("Clear");
		
		b1.addActionListener(new NewPolygonListener(s));
		b3.addActionListener(new ClearPolygonsListener(s));
		b2.addActionListener(new Bubbler(s, this));

		this.add(b1);
		this.add(b2);
		this.add(b3);
		
		Insets insets = this.getInsets();
		int left = 0;
		Dimension size = b1.getPreferredSize();
		b1.setBounds(25 + left + insets.left, 25 + insets.top,
	             size.width, size.height);
		left += size.width;
		
		size = b2.getPreferredSize();
		b2.setBounds(50 + left + insets.left, 25 + insets.top,
		             size.width, size.height);
		left += size.width;
		
		size = b3.getPreferredSize();
		b3.setBounds(75 + left + insets.left, 25 + insets.top,
		             size.width, size.height);
	}
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void paintComponent(Graphics g)
	{
		try {
			BufferedImage image = ImageIO.read(new File("/home/ted/bik.jpg"));
			g.drawImage(image, 0, 0, null);
			if (!bubble)
			{
				for(Shape s : sh.getAllShapes())
				{
					if (s != null)
					{
						s.draw(g);
					}
				}
			}
			
			if (bubble)
			{
				Graphics2D g2d = (Graphics2D) g;
				Area a = new Area(new Rectangle(0, 0, getWidth(), getHeight()));
				
				
				g.setColor(Color.RED);
				for(Circle d : c)
				{
					a.subtract(new Area(new Ellipse2D.Double(d.getCenter().getX()-d.getRadius(), d.getCenter().getY()-d.getRadius(), d.getRadius()*2, d.getRadius()*2)));
					//g.drawOval(d.getCenter().getX()-d.getRadius(), d.getCenter().getY()-d.getRadius(), d.getRadius()*2, d.getRadius()*2);
				}
				g2d.fill(a);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	public static void main(String... args) {
		JFrame f = new JFrame();
		f.setLayout(new GridLayout(1,1));
		
		ShapeHolder sh = new ShapeHolder();
		Main m = new Main(sh);
		
		DrawingPanelClickListener dpcl = new DrawingPanelClickListener(sh, m);
		
		
		m.addMouseListener(dpcl);
		f.add(m);
		f.setPreferredSize(new Dimension(500, 500));
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
