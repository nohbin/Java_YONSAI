package nohbin.member;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class RegMemberDialog extends JDialog {
	JTable table;
	JPanel jPanel , btnPanel;
	JLabel lMemberNum, lMemberName, lMemberHeight, lMemberWeight, lMemberAge;
	JTextField tfMemberNum, tfMemberName, tfMemberHeight, tfMemberWeight, tfMemberAge;
	JButton btnReg;
	MemberController memCtrl;

	public RegMemberDialog(String id) {
		// TODO Auto-generated constructor stub
		setTitle(id);
		init();
	}

	private void init() {
		// label
		lMemberNum = new JLabel("번호");
		lMemberName = new JLabel("이름");
		lMemberHeight = new JLabel("키");
		lMemberWeight = new JLabel("몸무게");
		lMemberAge = new JLabel("나이");
		// table
		tfMemberNum = new JTextField(20);
		tfMemberName = new JTextField(20);
		tfMemberHeight = new JTextField(20);
		tfMemberWeight = new JTextField(20);
		tfMemberAge = new JTextField(20);
		// event
		btnReg = new JButton("등록하기");

		
		

		btnReg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String memberNum = tfMemberNum.getText();
				String memberName = tfMemberName.getText();
				int memberHeight = Integer.parseInt(tfMemberHeight.getText());
				int memberWeight = Integer.parseInt(tfMemberWeight.getText());
				int memberAge = Integer.parseInt(tfMemberAge.getText());

				MemberVo mem = new MemberVo();
				mem.setMemberNum(memberNum);
				mem.setMemberName(memberName);
				mem.setMemberHeight(memberHeight);
				mem.setMemberWeight(memberWeight);
				mem.setMemberAge(memberAge);

				memCtrl = new MemberControllerImpl();
				memCtrl.insertMember(mem);

				System.out.println("등록 완료");
				// 차량 등록 후 텍스트칸 초기화
				tfMemberNum.setText("");
				tfMemberName.setText("");
				tfMemberHeight.setText("");
				tfMemberWeight.setText("");
				tfMemberAge.setText("");

			}
		});
		
		jPanel = new JPanel(new GridLayout(0, 2));
		btnPanel = new JPanel();
		jPanel.add(lMemberNum);
		jPanel.add(tfMemberNum);
		jPanel.add(lMemberName);
		jPanel.add(tfMemberName);
		jPanel.add(lMemberHeight);
		jPanel.add(tfMemberHeight);
		jPanel.add(lMemberWeight);
		jPanel.add(tfMemberWeight);
		jPanel.add(lMemberAge);
		jPanel.add(tfMemberAge);
		btnPanel.add(btnReg);
		add(btnPanel, BorderLayout.SOUTH);
		add(jPanel, BorderLayout.NORTH);
		setLocation(400, 200);
		setSize(400, 200);
		setModal(true); // 항상 부모창 위에 보이게 한다.
		setVisible(true);
	}

}