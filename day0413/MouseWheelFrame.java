package day0413;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseWheelFrame extends JFrame {
	public MouseWheelFrame() {
		// TODO Auto-generated constructor stub
		super("마우스 휠을 굴려 폰트 크기 조절");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JLabel l = new JLabel("Love Java");
		c.add(l);
		l.setFont(new Font("Arial", Font.PLAIN, 15));
		l.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				// TODO Auto-generated method stub
				int n = e.getWheelRotation();
				if (n < 0) {
					JLabel la = (JLabel) e.getSource();
					Font f = la.getFont();
					int size = f.getSize();
					if (size <= 5) {
						return;
					}
					la.setFont(new Font("Arial", Font.PLAIN, size-5));
				} else {
					JLabel la = (JLabel) e.getSource();
					Font f = la.getFont();
					int size = f.getSize();
					la.setFont(new Font("TimesRoman", Font.PLAIN, size + 5));
				}
			}
		});
		setSize(300, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MouseWheelFrame();
	}
}
