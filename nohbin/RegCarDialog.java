package nohbin;

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
		init();
		setTitle(id);
		setLayout(new GridLayout(6, 1));
		Container c = getContentPane();
		c.add(jPanel, "South");
		c.add(numPanel);
		c.add(namePanel);
		c.add(sizePanel);
		c.add(colorPanel);
		c.add(makerPanel);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(200, 100);
		pack();
		setVisible(true);
		System.out.println("카 다이알로그");
	}

	private void init() {
		//label
		lCarNum = new JLabel("차량번호");
		lCarName = new JLabel("차량명");
		lSize = new JLabel("배기량");
		lColor = new JLabel("차색상");
		lMaker = new JLabel("차제조사");
		//table
		tfCarNum = new JTextField(20);
		tfCarName = new JTextField(20);
		tfSize = new JTextField(20);
		tfColor = new JTextField(20);
		tfMaker = new JTextField(20);
		//event
		btnReg = new JButton("등록하기");

		jPanel = new JPanel();
		namePanel = new JPanel();
		numPanel = new JPanel();
		makerPanel = new JPanel();
		sizePanel = new JPanel();
		colorPanel = new JPanel();

		numPanel.add(lCarNum);
		numPanel.add(tfCarNum);
		namePanel.add(lCarName);
		namePanel.add(tfCarName);
		sizePanel.add(lSize);
		sizePanel.add(tfSize);
		colorPanel.add(lColor);
		colorPanel.add(tfColor);
		makerPanel.add(lMaker);
		makerPanel.add(tfMaker);
		
		
		jPanel.add(btnReg);

		btnReg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int carNum = Integer.parseInt(tfCarNum.getText());
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

	}
}