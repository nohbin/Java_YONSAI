package day0414;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ComboActionEx extends JFrame {
	private String[] fruits = { "apple", "banana", "kiwi", "mango" ,"pear" ,"cherry"};
	private ImageIcon[] images = { new ImageIcon("apple.jpg"), 
									new ImageIcon("banana.jpg"),
									new ImageIcon("kiwi.jpg"), 
									new ImageIcon("mango.jpg"), 
									new ImageIcon("pear.jpg"), 
									new ImageIcon("cherry.jpg")};
	private JLabel imgLabel = new JLabel(images[0]);
	private JComboBox<String> strCombo = new JComboBox<String>(fruits);

	public ComboActionEx() {
		setTitle("콤보박스 활용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(strCombo);
		c.add(imgLabel);

		strCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
				int index = cb.getSelectedIndex();
				imgLabel.setIcon(images[index]);
			}
		});
		setSize(300, 250);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ComboActionEx();
	}
}
