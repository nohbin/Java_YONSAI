package day0330;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InnerEx6 extends JFrame {
	public InnerEx6() {
		setTitle("Action Button");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Start");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				if(b.getText().equals("Start")) {
					b.setText("End");
				}else b.setText("Start");
			}
		});
		JButton btn2 = new JButton("stop");
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("stop");
			}
		});
		c.add(btn);
		c.add(btn2);
		setSize(200,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new InnerEx6();
		
		
		
	}
}

//class EventHandler implements ActionListener {
//	@Override
//	public void actionPerformed(ActionEvent e) {
//	
//		
//		System.out.println();
//		
//	}
//
//}
