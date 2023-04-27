package nohbin;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import javax.swing.*;

import nohbin.car.*;
import nohbin.member.*;
import nohbin.rent.*;

public class MainWindow {
	JFrame f;
	JMenuBar menuBar;
	JMenu carMenu, memberMenu, rentMenu, helpMenu, dieMenu;
	JMenuItem carMenu11, carMenu12, carMenu13, carMenu14;
	JMenuItem memMenu21, memMenu22, memMenu23, memMenu24;
	JMenuItem rentMenu31, rentMenu32, rentMenu33, rentMenu34, rentMenu35;
	JMenuItem helpMenu41;
	JPanel jPanel, jPanel2;
	JLabel lCarName, lRentName;
	JTextField tf, rentTf;
	JButton carSearchBtn, rentSearchBtn;
	CarController carCtrl;
	RentController rentCtrl;
	String[][] carItems;

	// table 차량 조회 시 column
	String[] carColumnNames = { "차번호", "이름", "배기량", "색상", "제조사", "렌트현황" };
	// table 렌트 조회 시 column
	String[] rentColumnNames = { "예약번호", "시작일", "종료일", "가격", "차량번호", "회원번호" };
	// 조회 시 사용할 combobox
	private String[] carSearchByCol = { "carNum", "carName", "carSize", "carColor", "carMaker", "rentGood" };
	private JComboBox<String> carSearchCombo = new JComboBox<>(carSearchByCol);
	private String[] rentSearchByCol = { "rent_no", "start_date", "end_date", "price", "carNum", "id" };
	private JComboBox<String> rentSearchCombo = new JComboBox<>(rentSearchByCol);

	JTable carTable, rentTable;
	RentTableModel model;
	Date nowDate = new Date();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
	int intNowDate = Integer.parseInt(simpleDateFormat.format(nowDate));

	public MainWindow() {
		// TODO Auto-generated constructor stub
		f = new JFrame("렌터카 예약 시스템");
		menuBar = new JMenuBar();
		carMenu = new JMenu("차량 관리");
		memberMenu = new JMenu("회원 관리");
		rentMenu = new JMenu("예약 관리");
		helpMenu = new JMenu("도움말");
		startFrame();
	}

	protected void startFrame() {
		carMenu.add(carMenu11 = new JMenuItem("차량 등록"));
		carMenu.add(carMenu12 = new JMenuItem("차량 조회"));
		carMenu.addSeparator();
		carMenu.add(carMenu13 = new JMenuItem("차량 수정"));
		carMenu.add(carMenu14 = new JMenuItem("차량 삭제"));

		// 차량 관리 하위 메뉴 설정 코드
		carMenu11.addActionListener(new CarHandler());
		carMenu12.addActionListener(new CarHandler());
		carMenu13.addActionListener(new CarHandler());
		carMenu14.addActionListener(new CarHandler());

		memberMenu.add(memMenu21 = new JMenuItem("회원 등록"));
		memberMenu.add(memMenu22 = new JMenuItem("회원 조회"));
		memberMenu.addSeparator();
		memberMenu.add(memMenu23 = new JMenuItem("회원 수정"));
		memberMenu.add(memMenu24 = new JMenuItem("회원 삭제"));

		// 차량 관리 하위 메뉴 설정 코드
		memMenu21.addActionListener(new MemberHandler());
		memMenu22.addActionListener(new MemberHandler());
		memMenu23.addActionListener(new MemberHandler());
		memMenu24.addActionListener(new MemberHandler());

		// 예약 관리 메뉴 관련 서브 메뉴 항목
		rentMenu.add(rentMenu31 = new JMenuItem("예약 등록"));
		rentMenu.add(rentMenu32 = new JMenuItem("예약 조회"));
		rentMenu.addSeparator();
		rentMenu.add(rentMenu33 = new JMenuItem("예약 수정"));
		rentMenu.add(rentMenu34 = new JMenuItem("예약 삭제"));

		rentMenu31.addActionListener(new RentHandler());
		rentMenu32.addActionListener(new RentHandler());
		rentMenu33.addActionListener(new RentHandler());
		rentMenu34.addActionListener(new RentHandler());

		// 버전 관리 메뉴 설정
		f.setJMenuBar(menuBar);
		menuBar.add(carMenu);
		menuBar.add(memberMenu);
		menuBar.add(rentMenu);
		menuBar.add(helpMenu);
		helpMenu.add(helpMenu41 = new JMenuItem("버전"));

		// 패널 중앙 차량 조회 코드
		jPanel = new JPanel();
		lCarName = new JLabel("차번호");
		tf = new JTextField(10);
		carSearchBtn = new JButton("차량 조회");
		rentSearchBtn = new JButton("렌트현황 조회");
		carCtrl = new CarControllerImpl();
		rentCtrl = new RentControllerImpl();
		carTable = new JTable();
		rentTable = new JTable();

		carSearchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshCarInfo();
				List<CarVo> lists = new ArrayList<>();
				String search = tf.getText();
				if (search != null && !search.isEmpty()) {
					lists = carCtrl.listCar("carnum", search);
				} else {

					CarVo car = new CarVo();
					lists.add(car);
					lists = carCtrl.listCar();
				}
				loadCarTable(lists);
			}
		});

		rentSearchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				List<RentVo> lists = new ArrayList<>();
				String search = tf.getText();
				if (search != null && !search.isEmpty()) {
					lists = rentCtrl.listRent("carnum", search);
				} else {
					RentVo rent = new RentVo();
					lists.add(rent);
					lists = rentCtrl.listRent();
				}
				loadRentTable(lists);
			}
		});

		
		jPanel.add(lCarName);
		jPanel.add(tf);
		jPanel.add(carSearchBtn);
		jPanel.add(rentSearchBtn);
		jPanel.add(carSearchCombo);
		jPanel.add(rentSearchCombo);

		Container con = f.getContentPane();
		con.add(new JScrollPane(carTable), BorderLayout.WEST);
		con.add(new JScrollPane(rentTable), BorderLayout.EAST);
		con.add(jPanel, "North");

		f.setLocation(200, 100);
		f.setSize(920, 800);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class CarHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			refreshCarInfo();
			System.out.println(e.getActionCommand());
			if (e.getSource() == carMenu11) {
				// 차량 등록
				new RegCarDialog("차량등록 창");
			} else if (e.getSource() == carMenu12) {
				// 차량 조회
				new SearchCarDialog("차량조회 창");
			} else if (e.getSource() == carMenu13) {
				// 차량 수정
				new UpdateCarDialog("차량수정 창");
			} else if (e.getSource() == carMenu14) {
				// 차량 삭제
				new DeleteCarDialog("차량삭제 창");
			}
		}
	}

	private class MemberHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			if (e.getSource() == memMenu21) {
				// 멤버 등록
				new RegMemberDialog("회원등록 창");
			} else if (e.getSource() == memMenu22) {
				// 맴버 조회
				new SearchMemberDialog("회원조회 창");
			} else if (e.getSource() == memMenu23) {
				// 맴버 수정
				new UpdateMemberDialog("회원수정 창");
			} else if (e.getSource() == memMenu24) {
				// 맴버 삭제
				new DeleteMemberDialog("회원삭제 창");
			}
		}
	}

	private class RentHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			if (e.getSource() == rentMenu31) {
				// 렌트 등록
				new RegRentDialog("렌트 등록");
			} else if (e.getSource() == rentMenu32) {
				// 렌트 조회
				new SearchRentDialog("렌트 관리");
			} else if (e.getSource() == rentMenu33) {
				// 렌트 수정
				new UpdateRentDialog("렌트 수정");
			} else if (e.getSource() == rentMenu34) {
				// 렌트 삭제
				new DelRentDialog("렌트 삭제");
			}
		}
	}

	private void loadCarTable(List<CarVo> lists) {
		String[][] datas = new String[lists.size()][6];
		String index = carSearchCombo.getSelectedItem().toString();
		if (index.equals(carSearchByCol[0])) {
			lists.sort(Comparator.comparing(CarVo::getCarNum));
		} else if (index.equals(carSearchByCol[1])) {
			lists.sort(Comparator.comparing(CarVo::getCarName));
		} else if (index.equals(carSearchByCol[2])) {
			lists.sort(Comparator.comparing(CarVo::getCarSize));
		} else if (index.equals(carSearchByCol[3])) {
			lists.sort(Comparator.comparing(CarVo::getCarColor));
		} else if (index.equals(carSearchByCol[4])) {
			lists.sort(Comparator.comparing(CarVo::getCarMaker));
		} else if (index.equals(carSearchByCol[5])) {
			lists.sort(Comparator.comparing(CarVo::getRentGood));
		}

		for (int i = 0; i < lists.size(); i++) {
			CarVo car = lists.get(i);
			datas[i][0] = car.getCarNum();
			datas[i][1] = car.getCarName();
			datas[i][2] = Integer.toString(car.getCarSize());
			datas[i][3] = car.getCarColor();
			datas[i][4] = car.getCarMaker();
			datas[i][5] = car.getRentGood();
		}
		model = new RentTableModel(datas, carColumnNames);
		carTable.setModel(model);
	}

	private void loadRentTable(List<RentVo> lists) {
		
		List<RentVo> list = lists.stream()
								 .filter(x->x.getEnd_date()>=intNowDate)
								 .collect(Collectors.toList());
		String[][] datas = new String[list.size()][6];
		
		String index = rentSearchCombo.getSelectedItem().toString();
		if (index.equals(rentSearchByCol[1])) {
			list.sort(Comparator.comparing(RentVo::getStart_date));
		} else if (index.equals(rentSearchByCol[2])) {
			list.sort(Comparator.comparing(RentVo::getEnd_date));
		} else if (index.equals(rentSearchByCol[3])) {
			list.sort(Comparator.comparing(RentVo::getPrice));
		} else if (index.equals(rentSearchByCol[4])) {
			list.sort(Comparator.comparing(RentVo::getCarNum));
		} else if (index.equals(rentSearchByCol[5])) {
			list.sort(Comparator.comparing(RentVo::getId));
		}
		
		for (int i = 0; i < list.size(); i++) {
			RentVo rent = list.get(i);
				rent.setPrice();
				datas[i][0] = rent.getRent_no();
				datas[i][1] = Integer.toString(rent.getStart_date());
				datas[i][2] = Integer.toString(rent.getEnd_date());
				datas[i][3] = Integer.toString(rent.getPrice());
				datas[i][4] = rent.getCarNum();
				datas[i][5] = rent.getId();
		}
		model = new RentTableModel(datas, rentColumnNames);
		rentTable.setModel(model);
	}

	private void refreshCarInfo() {
		CarDAO c = new CarDAOImpl();
		c.updateCar(null, intNowDate);
		System.out.println("차량 렌트 정보 업데이트 완료");
	}
}