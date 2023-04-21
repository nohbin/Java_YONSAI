package nohbin;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RegCarDialog extends JDialog {
	JTable table, carTable;
	JPanel jPanel, search, btn;
	JLabel lCarNum, lCarName, lSize, lColor, lMaker;
	JTextField tfCarNum, tfCarName, tfSize, tfColor, tfMaker, tCondition;
	JButton btnReg, searchBtn;
	CarController carCtrl;

	public RegCarDialog(String id) {
		// TODO Auto-generated constructor stub
		init();
		setTitle(id);
		setLayout(new BorderLayout());
		Container c = getContentPane();
		c.add(new JScrollPane(table));
		c.add(jPanel, "North");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(200, 100);
		pack();
		setVisible(true);
		System.out.println("카 다이알로그");
	}

	private void init() {
		carCtrl = new CarControllerImpl();
		lCarNum = new JLabel("차량번호");
		lCarName = new JLabel("차량명");
		lSize = new JLabel("배기량");
		lColor = new JLabel("차색상");
		lMaker = new JLabel("차제조사");

		Object[] columnNames = { "차량번호", "차량명", "배기량", "차색상", "차 제조사" };
		Object[][] rows = { 
				{"1", "람보르기니", "5200cc", "노랑", "람보르기니"}, 
				{"2", "페라리", "3902cc", "빨강", "페라리"},
				{"3", "포르쉐", "2981cc", "흰색", "포르쉐"} 
		};

		table = new JTable(rows, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane);

		tfCarNum = new JTextField(20);
		tfCarName = new JTextField(20);
		tfSize = new JTextField(20);
		tfColor = new JTextField(20);
		tfMaker = new JTextField(20);
		btnReg = new JButton("등록하기");

		jPanel = new JPanel();
		tCondition = new JTextField(10);
		searchBtn = new JButton("차량 조회 하기");
		jPanel.add(lCarName);
		jPanel.add(tCondition);
		jPanel.add(searchBtn);

		btnReg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String carNum = tfCarNum.getText().trim();
				String carName = tfCarName.getText().trim();
				int carSize = Integer.parseInt(tfSize.getText().trim());
				String carColor = tfColor.getText().trim();
				String carMaker = tfMaker.getText().trim();
				CarVo vo = new CarVo(carMaker, carMaker, carSize, carMaker, carMaker);
				carCtrl.insertCar(vo);
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

	public static void main(String[] args) {
		new RegCarDialog("차량관리");
	}
}
