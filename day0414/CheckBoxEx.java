package day0414;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class CheckBoxEx extends JFrame {
	public CheckBoxEx() {
		// TODO Auto-generated constructor stub
		super("Check box ex");
		Container c= getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(new FlowLayout());
		
		ImageIcon cherryic = new ImageIcon("cherry.jpg");
		ImageIcon cherryCheck = new ImageIcon("cherryCheck.jpg");
		
		JCheckBox apple = new JCheckBox("사과");
		JCheckBox pear = new JCheckBox("배",true);
		JCheckBox cherry = new JCheckBox("체리",cherryic);
		cherry.setBorderPainted(true);
		cherry.setSelectedIcon(cherryCheck);
		
		c.add(apple);
		c.add(pear);
		c.add(cherry);
		setSize(250,150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new CheckBoxEx();
	}
}
