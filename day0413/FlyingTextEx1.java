package day0413;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlyingTextEx1 extends JFrame {
	private final int FLYING_UNIT = 10;
	private JLabel la = new JLabel("*");
	

	public FlyingTextEx1() {
		// TODO Auto-generated constructor stub
		la.setFont(new Font(getName(), ABORT, 30));
		setTitle("move your text");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();

		c.setLayout(null);
		c.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_UP: {
					la.setLocation(la.getX(), la.getY() - FLYING_UNIT);
					break;
				}
				case KeyEvent.VK_DOWN: {
					la.setLocation(la.getX(), la.getY() + FLYING_UNIT);
					break;
				}
				case KeyEvent.VK_LEFT: {
					la.setLocation(la.getX() - FLYING_UNIT, la.getY());
					break;
				}
				case KeyEvent.VK_RIGHT: {
					la.setLocation(la.getX() + FLYING_UNIT, la.getY());
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + keyCode);
				}
			}
		});

		la.setLocation(50, 50);
		la.setSize(100, 20);
		c.add(la);
		setSize(300, 300);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
		c.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Component com = (Component) e.getSource();
				com.setFocusable(true);
				com.requestFocus();
			}
		});
	}

	public static void main(String[] args) {
		new FlyingTextEx1();
	}
}
