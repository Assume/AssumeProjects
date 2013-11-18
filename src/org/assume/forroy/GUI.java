package org.assume.forroy;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					GUI frame = new GUI();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public void addRectangle()
	{
		if (x < 500)
		{
			Rectangle r = new Rectangle(x, y, 50, 50);
			list.add(r);
			x = y == 500 ? x + 50 : x;
			y = y == 500 ? 0 : y + 50;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Maximum rectangles added");
		}
	}

	private List<Rectangle> list;
	private int x = 0;
	private int y = 0;
	boolean done;

	public GUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		list = new ArrayList<Rectangle>();
		contentPane = new DrawCanvas(list, x, y);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnAddRectangle = new JButton("Add Rectangle");
		btnAddRectangle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				addRectangle();
			}
		});
		btnAddRectangle.setBounds(357, 427, 117, 23);
		contentPane.add(btnAddRectangle);

		done = true;
	}
}

class DrawCanvas extends JPanel
{

	private List<Rectangle> list;
	private int x;
	private int y;

	public DrawCanvas(List<Rectangle> list, int x, int y)
	{
		this.list = list;
		this.x = x;
		this.y = y;
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		repaint();
		try
		{
			for (Rectangle r : list)
			{
				((Graphics2D) g).draw(r);
				int x = new Random().nextInt(2) == 0 ? ((int) r.getCenterX() - new Random()
						.nextInt(20)) : (int) r.getCenterX()
						+ new Random().nextInt(20);
				int y = new Random().nextInt(2) == 0 ? ((int) r.getCenterY() - new Random()
						.nextInt(20)) * -1
						: (int) r.getCenterY() + new Random().nextInt(20);
				((Graphics2D) g).drawOval(x, y, 15, 15);
			}
			Thread.sleep(75);
		}
		catch (Exception e)
		{

		}

	}
}
