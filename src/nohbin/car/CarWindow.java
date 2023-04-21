package nohbin.car;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class CarWindow {
	
	JMenu carMenu;
	JMenuItem carMenu11, carMenu12, carMenu13, carMenu14;
	JMenuBar menuBar;
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
}
	private class CarHandler implements ActionListener{
//      System.out.println(e.getActionCommand( )); 
//      if(e.getSource( )==carMenu11){ 
//         new RegCarDialog("차량등록 창"); 

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			if(e.getSource()==carMenu11) {
				
			}
		}
		
	}
}
