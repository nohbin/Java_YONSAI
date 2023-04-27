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

public class DeleteMemberDialog extends JDialog{
	
	JPanel jPanel,btnPanel;
	JLabel lMemberNum;
	JTextField tfMemberNum;
    JButton updateBtn ;
    MemberController carCtrl;

	public DeleteMemberDialog(String id) {
		// TODO Auto-generated constructor stub
		setTitle(id);
		init();
	}
	
	private void init() {
		lMemberNum = new JLabel("번호");
		tfMemberNum = new JTextField(20);
		updateBtn = new JButton("삭제하기");
        
        updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String memberNum=tfMemberNum.getText();			
				MemberVo mem = new MemberVo();
				mem.setMemberNum(memberNum);			
				carCtrl = new MemberControllerImpl();
				carCtrl.deleteMemeber(mem);
				System.out.println("삭제 완료");			
				tfMemberNum.setText("");
				
			}
		});
        
        jPanel = new JPanel(new GridLayout(0,2));
        btnPanel = new JPanel();
        jPanel.add(lMemberNum);
		jPanel.add(tfMemberNum);
		btnPanel.add(updateBtn);
		add(btnPanel,BorderLayout.SOUTH);
		add(jPanel,BorderLayout.NORTH);
		setLocation(400, 200);
        setSize(400,200);
        setModal(true); //항상 부모창 위에 보이게 한다.
        setVisible(true);
	}
}
