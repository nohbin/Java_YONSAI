package day0414;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShapeDrawer extends JFrame {
	private JPanel shapePanel;
	private JButton squareButton, circleButton, triangleButton, freehandButton;
	private Point prevPoint, curPoint;

	public ShapeDrawer() {
		setTitle("Shape Drawer");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// JPanel to draw shapes
		shapePanel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				// draw shape based on button selection
				if (squareButton.getModel().isSelected()) {
					g.setColor(Color.RED);
					g.fillRect(100, 100, 50, 50);
				} else if (circleButton.getModel().isSelected()) {
					g.setColor(Color.GREEN);
					g.fillOval(150, 150, 50, 50);
				} else if (triangleButton.getModel().isSelected()) {
					g.setColor(Color.BLUE);
					int[] xPoints = { 200, 250, 225 };
					int[] yPoints = { 100, 100, 50 };
					g.fillPolygon(xPoints, yPoints, 3);
				}
			}
		};

		// Buttons to select shapes
		freehandButton = new JButton("그리기");
		squareButton = new JButton("Square");
		circleButton = new JButton("Circle");
		triangleButton = new JButton("Triangle");

		squareButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				squareButton.getModel().setSelected(true);
				circleButton.getModel().setSelected(false);
				triangleButton.getModel().setSelected(false);
				freehandButton.getModel().setSelected(false);
				shapePanel.repaint();
			}
		});

		circleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				squareButton.getModel().setSelected(false);
				circleButton.getModel().setSelected(true);
				triangleButton.getModel().setSelected(false);
				freehandButton.getModel().setSelected(false);
				shapePanel.repaint();
			}
		});

		triangleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				squareButton.getModel().setSelected(false);
				circleButton.getModel().setSelected(false);
				triangleButton.getModel().setSelected(true);
				freehandButton.getModel().setSelected(false);
				shapePanel.repaint();
			}
		});

		freehandButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				squareButton.getModel().setSelected(false);
				circleButton.getModel().setSelected(false);
				triangleButton.getModel().setSelected(false);
				freehandButton.getModel().setSelected(true);
			}
		});

		// add buttons and panel to JFrame
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(freehandButton);
		buttonPanel.add(squareButton);
		buttonPanel.add(circleButton);
		buttonPanel.add(triangleButton);

		add(shapePanel);
		add(buttonPanel, "South");

		// Mouse listener for freehand drawing
		shapePanel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (freehandButton.getModel().isSelected()) {
					prevPoint = e.getPoint();
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (freehandButton.getModel().isSelected()) {
					prevPoint = null;
				}
			}
		});

		shapePanel.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				if (freehandButton.getModel().isSelected()) {
					curPoint = e.getPoint();
					Graphics g = shapePanel.getGraphics();
					g.drawLine(prevPoint.x, prevPoint.y, curPoint.x, curPoint.y);
					prevPoint = curPoint;
				}
			}
		});
	}

	public static void main(String[] args) {
	    ShapeDrawer drawer = new ShapeDrawer();
	    drawer.setVisible(true);
	  }
}
