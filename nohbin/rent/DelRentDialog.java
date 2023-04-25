package nohbin.rent;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DelRentDialog extends JDialog {
	JPanel jPanel, panelBtn;
	JLabel lMemberNum;
	JTextField tfMemberNum;
	JButton deleteBtn;
	RentControllerImpl carCtrl;
	
	public DelRentDialog(String id) {
		setTitle(id);
		init();
	}
	
	private void init() {
		lMemberNum = new JLabel("번호");
		tfMemberNum = new JTextField(20);
		deleteBtn = new JButton("삭제하기");
		
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String rentNum = tfMemberNum.getText();
				RentVo ren = new RentVo();
				ren.setRent_no(rentNum);
				carCtrl = new RentControllerImpl();
				carCtrl.deleteRent(ren);
				System.out.println("삭제 완료");
				tfMemberNum.setText("");
			}
		});
		
		jPanel = new JPanel(new GridLayout(0, 2));
		jPanel.add(lMemberNum);
		jPanel.add(tfMemberNum);
		add(deleteBtn, BorderLayout.NORTH);
		add(jPanel, BorderLayout.SOUTH);
		setLocation(400, 200);
		setSize(400, 200);
		setModal(true); // 항상 부모창 위에 보이게 한다.
		setVisible(true);
	}
}
