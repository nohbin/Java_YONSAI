package day0414;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelEx extends JFrame{
	public LabelEx() {
		// TODO Auto-generated constructor stub
		setTitle("Label ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel textLabel = new JLabel("사랑합니다");
		ImageIcon beauty = new ImageIcon("heart.jpg");
		JLabel imageLabel = new JLabel(beauty);
		
		ImageIcon normalicon = new ImageIcon("tell.jpg.gif");
		ImageIcon rolloverIcon = new ImageIcon("tell.press.gif");
		JLabel label = new JLabel("Call me baby",normalicon,SwingConstants.CENTER);
		JButton btn = new JButton("call me",normalicon);
		btn.setRolloverIcon(rolloverIcon);
		c.add(textLabel);
		c.add(imageLabel);
		c.add(label);
		c.add(btn);
		
		setSize(400,600);
		setVisible(true);
	}
	public static void main(String[] args) {
		new LabelEx();
	}
}
