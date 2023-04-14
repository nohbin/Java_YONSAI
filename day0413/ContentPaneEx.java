package day0413;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ContentPaneEx extends JFrame {
	public ContentPaneEx() {
		setTitle("ContentPane 과 JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setBackground(Color.RED);
		contentPane.setLayout(new FlowLayout());
		
		contentPane.add(new JButton("확인"));
		contentPane.add(new JButton("취소"));
		contentPane.add(new JButton("무시"));
		
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ContentPaneEx();
	}
}
