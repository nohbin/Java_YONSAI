package nohbin.car;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class RegCarDialog extends JDialog {
	JTable table, carTable;
	JPanel jPanel,namePanel,numPanel,colorPanel,sizePanel,makerPanel;
	JLabel lCarNum, lCarName, lSize, lColor, lMaker;
	JTextField tfCarNum, tfCarName, tfSize, tfColor, tfMaker;
	JButton btnReg;
	CarController carCtrl;
	
	public RegCarDialog(String id) {
		// TODO Auto-generated constructor stub
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
		//event
		btnReg = new JButton("등록하기");

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
		
		

		btnReg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String carNum = tfCarNum.getText();
				String carName = tfCarName.getText();
				int carSize = Integer.parseInt(tfSize.getText());
				String carColor = tfColor.getText();
				String carMaker = tfMaker.getText();
				
				CarVo car = new CarVo();
				car.setCarNum(carNum);
				car.setCarName(carName);
				car.setCarSize(carSize);
				car.setCarColor(carColor);
				car.setCarMaker(carMaker);
				
				carCtrl = new CarControllerImpl();
				carCtrl.insertCar(car);
			

				System.out.println("등록 완료");
				// 차량 등록 후 텍스트칸 초기화
				tfCarNum.setText("");
				tfCarName.setText("");
				tfSize.setText("");
				tfColor.setText("");
				tfMaker.setText("");
		
			}
		});
		
		add(btnReg,BorderLayout.NORTH);
		add(jPanel,BorderLayout.SOUTH);
		setLocation(400, 200);
        setSize(400,200);
        setModal(true); //항상 부모창 위에 보이게 한다.
        setVisible(true);
	}
	
}