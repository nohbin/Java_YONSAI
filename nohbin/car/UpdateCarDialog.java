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

public class UpdateCarDialog extends JDialog {
	JPanel jPanel,panelBtn;
	JLabel lCarNum, lCarName, lSize, lColor, lMaker;
	JTextField tfCarNum, tfCarName, tfSize, tfColor, tfMaker;
    JButton updateBtn ;
    CarController carCtrl;
	
	public UpdateCarDialog(String id) {
		setTitle(id);
		init();
	}
	private void init() {
		//label
		lCarNum = new JLabel("번호");
		lCarName = new JLabel("이름");
		lSize = new JLabel("배기량");
		lColor = new JLabel("색상");
		lMaker = new JLabel("제조사");
		//table
		tfCarNum = new JTextField(20);
		tfCarName = new JTextField(20);
		tfSize = new JTextField(20);
		tfColor = new JTextField(20);
		tfMaker = new JTextField(20);
		updateBtn = new JButton("수정하기");
		
		
        
        updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String carNum=tfCarNum.getText();
				String carName=tfCarName.getText();
				int carSize=Integer.parseInt(tfSize.getText());
				String carColor=tfColor.getText();
				String carMaker=tfMaker.getText();
				
				CarVo car = new CarVo();
				car.setCarNum(carNum);
				car.setCarName(carName);
				car.setCarSize(carSize);
				car.setCarColor(carColor);
				car.setCarMaker(carMaker);
				
				carCtrl = new CarControllerImpl();
				carCtrl.updateCar(car);
				System.out.println("업데이트 완료");
				
				tfCarNum.setText("");
				tfCarName.setText("");
				tfSize.setText("");
				tfColor.setText("");
				tfMaker.setText("");
				
			}
		});
        
        jPanel = new JPanel(new GridLayout(0,2));
        jPanel.add(lCarNum);
		jPanel.add(tfCarNum);
		jPanel.add(lCarName);
		jPanel.add(tfCarName);
		jPanel.add(lSize);
		jPanel.add(tfSize);
		jPanel.add(lColor);
		jPanel.add(tfColor);
		jPanel.add(lMaker);
		jPanel.add(tfMaker);
		
		add(updateBtn,BorderLayout.NORTH);
		add(jPanel,BorderLayout.SOUTH);
		setLocation(400, 200);
        setSize(400,200);
        setModal(true); //항상 부모창 위에 보이게 한다.
        setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new UpdateCarDialog("차량 수정");
	}
}
