package nohbin.rent;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateRentDialog extends JDialog {
	JTable table, rentTable;
	JPanel jPanel , btnPanel;
	JLabel lrent_no, lstart_date, lend_date, lprice, lcarNum, lid;
	JTextField tfrent_no, tfstart_date, tfend_date, tfprice, tfcarNum, tfid;
	JButton updateBtn, confirmBtn;
	RentController rentCtrl;

	public UpdateRentDialog(String id) {
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
		updateBtn = new JButton("수정하기");
		confirmBtn = new JButton("확인");
		jPanel = new JPanel(new GridLayout(0, 2));
		btnPanel = new JPanel();
		
		jPanel.add(lrent_no);
		jPanel.add(tfrent_no);
		jPanel.add(lstart_date);
		jPanel.add(tfstart_date);
		jPanel.add(lend_date);
		jPanel.add(tfend_date);
		jPanel.add(lcarNum);
		jPanel.add(tfcarNum);
		jPanel.add(lid);
		jPanel.add(tfid);
		btnPanel.add(updateBtn);
		btnPanel.add(confirmBtn);
		updateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String rent_no = tfrent_no.getText();
				int start_date = Integer.parseInt(tfstart_date.getText());
				int end_date = Integer.parseInt(tfend_date.getText());
				String carNum = tfcarNum.getText();
				String id = tfid.getText();

				RentVo rent = new RentVo();
				rent.setRent_no(rent_no);
				rent.setStart_date(start_date);
				rent.setEnd_date(end_date);
				rent.setPrice();
				rent.setCarNum(carNum);
				rent.setId(id);

				rentCtrl = new RentControllerImpl();
				rentCtrl.updateRent(rent);

				System.out.println("수정 완료");
				tfrent_no.setText("");
				tfstart_date.setText("");
				tfend_date.setText("");
				tfcarNum.setText("");
				tfid.setText("");
			}
		});

		confirmBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String rent_no = tfrent_no.getText();
				RentVo rent = new RentVo();
				rent.setRent_no(rent_no);
				rentCtrl = new RentControllerImpl();
				rentCtrl.updateRentData(rent);
				
				tfstart_date.setText(Integer.toString(rent.getStart_date()));
				tfend_date.setText(Integer.toString(rent.getEnd_date()));
				tfcarNum.setText(rent.getCarNum());
				tfid.setText(rent.getId()); 

			}
		});
		add(jPanel, BorderLayout.NORTH);
		add(btnPanel , BorderLayout.SOUTH);
		setLocation(400, 200);
		setSize(400, 200);
		setModal(true); // 항상 부모창 위에 보이게 한다.
		setVisible(true);

	}
}