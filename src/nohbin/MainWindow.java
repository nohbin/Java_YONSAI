package nohbin;

import javax.swing.*;
import javax.swing.JPopupMenu.Separator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
	JFrame f;
	JMenuBar menuBar;
	JMenu carMenu, memberMenu, rentMenu, helpMenu;
	JMenuItem carMenu11, carMenu12, carMenu13, carMenu14;
	JMenuItem memMenu21, memMenu22, memMenu23, memMenu24;
	JMenuItem helpMenu41;
	JPanel jPanel;
	JLabel lCarName;
	JTextField tf;
	JButton searchBtn;
	RegCarDialog regCarDialog;

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
		
		//차량 관리 하위 메뉴 설정 코드
		carMenu11.addActionListener(new CarHandler());
		carMenu12.addActionListener(new CarHandler());
		carMenu13.addActionListener(new CarHandler());
		carMenu14.addActionListener(new CarHandler());
		
		
		
		// 회원 관리 하위 메뉴 설정 코드
		menuBar.add(memberMenu);
		memberMenu.add(memMenu21 = new JMenuItem("회원 등록"));
		memberMenu.add(memMenu22 = new JMenuItem("회원 조회"));
		memberMenu.addSeparator();
		memberMenu.add(memMenu23 = new JMenuItem("회원 수정"));
		memberMenu.add(memMenu24 = new JMenuItem("회원 삭제"));
		// 버전 관리 메뉴 설정
		menuBar.add(helpMenu);
		helpMenu.add(helpMenu41 = new JMenuItem("버전"));
		
		// 패널 중앙 차량 조회 코드
		jPanel = new JPanel();
		lCarName=new JLabel("차량명"); 
		tf = new JTextField(10);
		searchBtn = new JButton("차량 조회 하기");
		jPanel.add(lCarName);
		jPanel.add(tf);
		jPanel.add(searchBtn);
		
		Container con = f.getContentPane();
		con.add(jPanel,"North");
		f.setLocation(200,100);
		f.setSize(800,600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private class CarHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			 if(e.getSource()==carMenu11){ 
				 regCarDialog = new RegCarDialog("차량등록 창");
			}else if (e.getSource() == carMenu12) {
//				new SearchCarDialog("차량조회 창");
			}else if(e.getSource()==carMenu13) {
				
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		new MainWindow();
	}

}
