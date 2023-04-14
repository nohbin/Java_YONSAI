package day0413;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.SwingConstants;

public class Mywindow {

	private JFrame frame;
	private JTextField putMethod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mywindow window = new Mywindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mywindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(194, 72, 98, 41);
		frame.getContentPane().add(btnNewButton);
		
		putMethod = new JTextField();
		putMethod.setHorizontalAlignment(SwingConstants.CENTER);
		putMethod.addInputMethodListener(new InputMethodListener() {
			
			public void inputMethodTextChanged(InputMethodEvent event) {
				
			}

			@Override
			public void caretPositionChanged(InputMethodEvent event) {
				
				
			}
		});
		putMethod.setBounds(12, 72, 170, 41);
		frame.getContentPane().add(putMethod);
		putMethod.setColumns(10);
		
		JLabel titleName = new JLabel("JAVA STUDY");
		titleName.setHorizontalAlignment(SwingConstants.CENTER);
		titleName.setFont(new Font("Arial", Font.PLAIN, 30));
		titleName.setBounds(12, 10, 560, 52);
		frame.getContentPane().add(titleName);
	}
}
