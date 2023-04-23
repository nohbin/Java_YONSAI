package nohbin;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SearchCarDialog extends JDialog {
	JTable table, carTable;
	JPanel jPanel, search, btn;
	JLabel lCarNum, lCarName, lSize, lColor, lMaker;
	JTextField tfCarNum, tfCarName, tfSize, tfColor, tfMaker, tCondition;
	JButton btnReg, searchBtn;
	DefaultTableModel model;
	CarController carCtrl;

	public SearchCarDialog(String id) {
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
		Object[][] rows = new Object[100][5];
		model = new DefaultTableModel(rows,columnNames);
		table = new JTable(model);
		
		
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

		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				carCtrl = new CarControllerImpl();
				List<CarVo> lists = carCtrl.listMember();
				
				for (int i = 0; i < lists.size(); i++) {
					CarVo car = new CarVo();
					car = (CarVo)lists.get(i);
					
					int num = car.getCarNum();
					String name = car.getCarName();
					int size = car.getCarSize();
					String color = car.getCarColor();
					String maker = car.getCarMaker();
					
					Object[]data = {num,name,size,color,maker};
					model.addRow(data);
							
				}

			}
		});

	}

	public static void main(String[] args) {
		new SearchCarDialog("차량관리");
	}
}