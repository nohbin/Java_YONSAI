package day0413;

import java.awt.*;
import javax.swing.*;

public class FlowLayoutEx1 extends JFrame {
	public FlowLayoutEx1() {
		// TODO Auto-generated constructor stub
		setTitle("ContentPane 과 JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER, 30 ,40));
		c.add(new JButton("add"));
		c.add(new JButton("sub"));
		c.add(new JButton("mul"));
		c.add(new JButton("div"));
		c.add(new JButton("Calcultae"));
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new FlowLayoutEx1();
	}
}
