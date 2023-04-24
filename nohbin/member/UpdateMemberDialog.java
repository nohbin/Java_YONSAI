package nohbin.member;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateMemberDialog extends JDialog {
	JPanel jPanel,panelBtn;
	JLabel lMemberNum, lMemberName, lMemberHeight, lMemberWeight, lMemberAge;
	JTextField tfMemberNum, tfMemberName, tfMemberHeight, tfMemberWeight, tfMemberAge;
    JButton updateBtn ;
    MemberController carCtrl;
	
	public UpdateMemberDialog(String id) {
		setTitle(id);
		init();
	}
	
	private void init() {
		//label
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
		updateBtn = new JButton("수정하기");
		
		jPanel = new JPanel(new GridLayout(0,2));

		
        
        updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String memberNum = tfMemberNum.getText();
				String memberName = tfMemberName.getText();
				int memberHeight = Integer.parseInt(tfMemberHeight.getText());
				int memberWeight = Integer.parseInt(tfMemberWeight.getText());
				int memberAge = Integer.parseInt(tfMemberAge.getText());
				
				RentVo mem = new RentVo();
				mem.setMemberNum(memberNum);
				mem.setMemberName(memberName);
				mem.setMemberHeight(memberHeight);
				mem.setMemberWeight(memberWeight);
				mem.setMemberAge(memberAge);
				
				carCtrl = new MemberControllerImpl();
				carCtrl.updateMember(mem);
				System.out.println("업데이트 완료");
				
				tfMemberNum.setText("");
				tfMemberName.setText("");
				tfMemberHeight.setText("");
				tfMemberWeight.setText("");
				tfMemberAge.setText("");
				
			}
		});
        
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
		
		add(updateBtn,BorderLayout.NORTH);
		add(jPanel,BorderLayout.SOUTH);
		setLocation(400, 200);
        setSize(400,200);
        setModal(true); //항상 부모창 위에 보이게 한다.
        setVisible(true);
		
	}
	

}
