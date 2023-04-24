package nohbin;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import nohbin.car.CarController;
import nohbin.car.CarControllerImpl;
import nohbin.car.CarVo;
import nohbin.car.DeleteCarDialog;
import nohbin.car.RegCarDialog;
import nohbin.car.SearchCarDialog;
import nohbin.car.UpdateCarDialog;
import nohbin.member.DeleteMemberDialog;
import nohbin.member.RegMemberDialog;
import nohbin.member.SearchMemberDialog;
import nohbin.member.UpdateMemberDialog;
import nohbin.rent.RentController;
import nohbin.rent.RentControllerImpl;
import nohbin.rent.RentVo;
import nohbin.rent.SearchRentDialog;

public class MainWindow {
	JFrame f;
	JMenuBar menuBar;
	JMenu carMenu, memberMenu, rentMenu, helpMenu;
	JMenuItem carMenu11, carMenu12, carMenu13, carMenu14;
	JMenuItem memMenu21, memMenu22, memMenu23, memMenu24;
	JMenuItem rentMenu31, rentMenu32, rentMenu33, rentMenu34;
	JMenuItem helpMenu41;
	JPanel jPanel , jPanel2;
	JLabel lCarName , lRentName;
	JTextField tf , rentTf;
	JButton carSearchBtn , rentSearchBtn;
	CarController carCtrl;
	RentController rentCtrl;
	String[][] carItems;
	String[] columnNames = { "차번호", "이름", "배기량", "색상", "제조사" };
	String[] rentColumnNames={"예약번호","시작일","종료일","가격","차량번호","회원번호"};
	
	JTable rentTable;
	RentTableModel model;
	

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
		f.setJMenuBar(menuBar);
		menuBar.add(carMenu);
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

		menuBar.add(memberMenu);
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
		menuBar.add(rentMenu);
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
		menuBar.add(helpMenu);
		helpMenu.add(helpMenu41 = new JMenuItem("버전"));

		// 패널 중앙 차량 조회 코드
		jPanel = new JPanel();
		lCarName = new JLabel("차량명");
		tf = new JTextField(10);
		carSearchBtn = new JButton("차량 조회");
		rentSearchBtn = new JButton("렌트현황 조회");
		carCtrl = new CarControllerImpl();
		rentCtrl = new RentControllerImpl();
		rentTable=new JTable();
		
		carSearchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				List<CarVo> lists = new ArrayList<>();
				CarVo car = new CarVo();
				lists.add(car);
				
				lists = carCtrl.listMember();
				loadCarTable(lists);
			}
		});
		
		rentSearchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				List<RentVo> lists = new ArrayList<>();
				RentVo rent = new RentVo();
				lists.add(rent);
				
				lists = rentCtrl.listRent();
				loadRentTable(lists);
			}
		});


		jPanel.add(lCarName);
		jPanel.add(tf);
		jPanel.add(carSearchBtn);
		jPanel.add(rentSearchBtn);

		Container con = f.getContentPane();
		con.add(new JScrollPane(rentTable), BorderLayout.CENTER);
		con.add(jPanel, "North");
		
		f.setLocation(200, 100);
		f.setSize(800, 600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class CarHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
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
			} else if (e.getSource() == memMenu21) {
				// 멤버 등록
				new RegMemberDialog("회원등록 창");
			} else if (e.getSource() == memMenu22) {
				// 맴버 조회
				new SearchMemberDialog("회원조회 창");
			} else if (e.getSource() == memMenu23) {
				// 맴버 수정
				new UpdateMemberDialog("회원수정 창");
			} else if (e.getSource() == memMenu24) {
				new DeleteMemberDialog("회원삭제 창");
				// 맴버 삭제
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
				new DeleteMemberDialog("회원삭제 창");
				// 맴버 삭제
			}
		}

	}

	private class RentHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			if (e.getSource() == rentMenu31) {

			} else if (e.getSource() == rentMenu32) {
				new SearchRentDialog("렌트 관리");
			} else if (e.getSource() == rentMenu33) {

			} else if (e.getSource() == rentMenu34) {

			}
		}
	}

	private void loadCarTable(List<CarVo> lists) {
		String[][] datas = new String[lists.size()][5];
		for (int i = 0; i < lists.size(); i++) {
			CarVo car = lists.get(i);
			datas[i][0] = car.getCarNum();
			datas[i][1] = car.getCarName();
			datas[i][2] = Integer.toString(car.getCarSize());
			datas[i][3] = car.getCarColor();
			datas[i][4] = car.getCarMaker();
		}
		model = new RentTableModel(datas, columnNames);
		rentTable.setModel(model);
	}
	private void loadRentTable(List<RentVo> lists) {
		String[][] datas = new String[lists.size()][6];
		for (int i = 0; i < lists.size(); i++) {
			RentVo rent = lists.get(i);
			datas[i][0] = rent.getRent_no();
			datas[i][1] = rent.getStart_date();
			datas[i][2] = rent.getEnd_date();
			datas[i][3] = Integer.toString(rent.getPrice());
			datas[i][4] = rent.getCarNum();
			datas[i][5] = rent.getId();
		}
		model=new RentTableModel(datas,rentColumnNames);
    	rentTable.setModel(model);
	}
	public static void main(String[] args) {
		new MainWindow();
	}

}