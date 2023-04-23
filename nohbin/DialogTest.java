package nohbin;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class MyDialog extends JDialog{
	
	JLabel lCarNum,lCarName,lSize,lColor,lMaker;
	JTextField tf = new JTextField(10);
	JTextField tf1 = new JTextField(10);
	JTextField tf2 = new JTextField(10);
	JTextField tf3 = new JTextField(10);
	JButton okButton = new JButton("OK");
	
	
	public MyDialog(JFrame frame, String title) {
		super(frame, title);
		lCarNum = new JLabel("차량번호");
		lCarName = new JLabel("차량명");
		lSize = new JLabel("배기량");
		lColor = new JLabel("차색상");
		lMaker = new JLabel("차제조사");
		setLayout(new FlowLayout());
		add(lCarNum);
		add(lCarName);
		add(lSize);
		add(lColor);
		add(lMaker);
		
		
		add(tf);
		add(tf1);
		add(tf2);
		add(tf3);
		add(okButton);
		setSize(900,900);
		
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		
	}
}

class DialogTest extends JFrame  {
	MyDialog d;
	
	public DialogTest() {
		super("Dialog 예제 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton("show Dialog");
		
		d = new MyDialog(this, "Test");
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				d.setVisible(true);
			}
		});
		getContentPane().add(btn);
		setSize(250,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new DialogTest();
	}
	
}