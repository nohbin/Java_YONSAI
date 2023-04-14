package day0413;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutEx1 extends JFrame {
	public BorderLayoutEx1() {
		setTitle("ContentPane 과 JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout(30 ,20));
		c.add(new JButton("add"),BorderLayout.WEST);
		c.add(new JButton("sub"),BorderLayout.NORTH);
		c.add(new JButton("mul"),BorderLayout.SOUTH);
		c.add(new JButton("div"),BorderLayout.EAST);
		c.add(new JButton("Calcultae"),BorderLayout.CENTER);
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BorderLayoutEx1();
	}
}
