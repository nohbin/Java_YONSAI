package nohbin.car;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteCarDialog extends JDialog{
	
	JPanel jPanel,btnPanel;
	JLabel lCarNum;
	JTextField tfCarNum;
    JButton updateBtn ;
    CarController carCtrl;
	public DeleteCarDialog(String id) {
		// TODO Auto-generated constructor stub
		setTitle(id);
		init();
	}
	private void init() {
		lCarNum = new JLabel("번호");
		tfCarNum = new JTextField(20);
		updateBtn = new JButton("삭제하기");
		jPanel = new JPanel(new GridLayout(0,2));
		btnPanel = new JPanel();
        updateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String carNum=tfCarNum.getText();			
				CarVo car = new CarVo();
				car.setCarNum(carNum);			
				carCtrl = new CarControllerImpl();
				carCtrl.deleteCar(car);
				System.out.println("삭제 완료");			
				tfCarNum.setText("");
			}
		});
        
        jPanel.add(lCarNum);
		jPanel.add(tfCarNum);
		btnPanel.add(updateBtn);
		
		add(btnPanel,BorderLayout.SOUTH);
		add(jPanel,BorderLayout.NORTH);
		setLocation(400, 200);
        setSize(400,200);
        setModal(true); //항상 부모창 위에 보이게 한다.
        setVisible(true);
		
		
	}
}
