package day0414;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CheckBoxItemEventEx extends JFrame {
	private JCheckBox[] fruits = new JCheckBox[3];
	private String[] names = {"사과","배","체리"};
	private JLabel sumLabel;
	private int sum = 0;
	
	public CheckBoxItemEventEx() {
		// TODO Auto-generated constructor stub
		setTitle("과일가게");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c= getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("사과 100원,배 500원, 체리 2000원"));
		for (int i = 0; i < fruits.length; i++) {
			fruits[i] = new JCheckBox(names[i]);
			fruits[i].setBorderPainted(true);
			c.add(fruits[i]);
			fruits[i].addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					if(e.getStateChange() == ItemEvent.SELECTED) {
						if(e.getItem() == fruits[0]) {
							sum += 100;
						}else if(e.getItem() == fruits[1]) {
							sum += 500;
						}else if(e.getItem() == fruits[2]) {
							sum += 2000;
						}
					}else {
						if(e.getItem() == fruits[0]) {
							sum -=100;
						}else if(e.getItem() == fruits[1]) {
							sum -= 500;
						}else if(e.getItem() == fruits[2]) {
							sum -= 2000;
						}
					}
					sumLabel.setText("현재 " + sum + " 원 입니다.");
				}
			});
		}
		sumLabel = new JLabel("현재 0원 입니다.");
		c.add(sumLabel);
		setSize(250,200);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new CheckBoxItemEventEx();
	}
}
