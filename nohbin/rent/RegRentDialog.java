package nohbin.rent;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegRentDialog extends JDialog {
	JTable table, rentTable;
	JPanel jPanel;
	JLabel lrent_no, lstart_date, lend_date, lprice, lcarNum, lid;
	JTextField tfrent_no, tfstart_date, tfend_date, tfprice, tfcarNum, tfid;
	JButton btnReg;
	RentController rentCtrl;

	public RegRentDialog(String id) {
		// TODO Auto-generated constructor stub
		setTitle(id);
		init();
	}
	private void init() {
		// label
		lrent_no = new JLabel("예약번호");
		lstart_date = new JLabel("차량대여일");
		lend_date = new JLabel("차량반납일");
		lprice = new JLabel("렌트가격");
		lcarNum = new JLabel("차량번호");
		lid = new JLabel("아이디");

		// table
		tfrent_no = new JTextField(20);
		tfstart_date = new JTextField(20);
		tfend_date = new JTextField(20);
		tfprice = new JTextField(20);
		tfcarNum = new JTextField(20);
		tfid = new JTextField(20);

		// event
		btnReg = new JButton("등록하기");
		jPanel = new JPanel(new GridLayout(0, 2));

		jPanel.add(lstart_date);
		jPanel.add(tfstart_date);
		jPanel.add(lend_date);
		jPanel.add(tfend_date);
		jPanel.add(lcarNum);
		jPanel.add(tfcarNum);
		jPanel.add(lid);
		jPanel.add(tfid);

		btnReg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int start_date = Integer.parseInt(tfstart_date.getText());
				int end_date = Integer.parseInt(tfend_date.getText());
				String carNum = tfcarNum.getText();
				String id = tfid.getText();

				RentVo rent = new RentVo();
				rent.setStart_date(start_date);
				rent.setEnd_date(end_date);
				rent.setPrice();
				rent.setCarNum(carNum);
				rent.setId(id);

				rentCtrl = new RentControllerImpl();
				rentCtrl.insertRent(rent);

				System.out.println("등록 완료");
				// 차량 등록 후 텍스트칸 초기화
				tfstart_date.setText("");
				tfend_date.setText("");
				tfcarNum.setText("");
				tfid.setText("");
			}
		});
		add(btnReg, BorderLayout.NORTH);
		add(jPanel, BorderLayout.SOUTH);
		setLocation(400, 200);
		setSize(400, 200);
		setModal(true); // 항상 부모창 위에 보이게 한다.
		setVisible(true);
	}
}
