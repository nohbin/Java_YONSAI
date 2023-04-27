package nohbin.rent;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import nohbin.MainWindow;
import nohbin.RentTableModel;


public class SearchRentDialog extends JDialog {
	JPanel panelSearch,btnPanel;
	JLabel lCarName;
	JTextField tf ;
    JButton searchAllBtn , searchBtn , searchOldBtn ;
    String[][] rentItems;
    JTable rentTable;
    RentTableModel model;
    RentController rentCtrl;
    String[] columnNames={"예약번호","시작일","종료일","가격","차량번호","회원번호"};
    private String[] searchByCol = {"rent_no","start_date","end_date","price","carNum","id"};
    private JComboBox<String> searchCombo = new JComboBox<>(searchByCol);
    Date nowDate = new Date();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
	int intNowDate = Integer.parseInt(simpleDateFormat.format(nowDate));
	
	public SearchRentDialog() {}
	public SearchRentDialog(String id) {
		setTitle(id);
    	init();
	}

	public void init() {
		rentCtrl = new RentControllerImpl();
    	rentTable=new JTable();
    	panelSearch=new JPanel();
    	btnPanel=new JPanel();
    	lCarName = new JLabel("렌트번호");
    	tf=new JTextField(20);
    	searchBtn = new JButton("렌트 조회");
//    	searchAllBtn=new JButton("전체 조회");
    	searchOldBtn = new JButton("내역 조회");

		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("조회 버튼 클릭");
				String index = searchCombo.getSelectedItem().toString();
				String search = tf.getText();
				List<RentVo> lists = new ArrayList<>();
		        lists = rentCtrl.listRent(index, search);
		        loadTable(lists);
			}
		});
	

//		searchAllBtn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("전체조회 버튼 클릭");
//				List<RentVo> lists = new ArrayList<>();
//				lists = rentCtrl.listRent();
//				loadTable(lists);
//			}
//    	}); 
		
		searchOldBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				List<RentVo> lists = new ArrayList<>();
				lists = rentCtrl.listRent();
				dieRentTable(lists);
			}
		});
		
		panelSearch.add(searchCombo);
    	panelSearch.add(tf);
    	panelSearch.add(searchBtn);
//    	panelSearch.add(searchAllBtn);
    	panelSearch.add(searchOldBtn);
      	add(panelSearch,BorderLayout.NORTH);
    	add(btnPanel,BorderLayout.SOUTH);
      	rentItems = new String[0][6];
        model=new RentTableModel(rentItems,columnNames);
    	rentTable.setModel(model);
        add(new JScrollPane(rentTable),BorderLayout.CENTER);
        setLocation(300,100);
        setSize(900,600);
        setModal(true);
        setVisible(true);   
	}
	
	private void loadTable(List<RentVo> lists) {
		String[][] datas = new String[lists.size()][6];
		for (int i = 0; i < lists.size(); i++) {
			RentVo rent = lists.get(i);
			datas[i][0] = rent.getRent_no();
			datas[i][1] = Integer.toString(rent.getStart_date());
			datas[i][2] = Integer.toString(rent.getEnd_date());
			datas[i][3] = Integer.toString(rent.getPrice());
			datas[i][4] = rent.getCarNum();
			datas[i][5] = rent.getId();
		}
		model=new RentTableModel(datas,columnNames);
    	rentTable.setModel(model);
	}
	
	private void dieRentTable(List<RentVo> lists) {
		List<RentVo> list = lists.stream()
								 .filter(x->x.getEnd_date()<intNowDate)
							 	 .collect(Collectors.toList());
		
		String[][] datas = new String[list.size()][6];
		
		for (int i = 0; i < list.size(); i++) {
			RentVo rent = list.get(i);
				datas[i][0] = rent.getRent_no();
				datas[i][1] = Integer.toString(rent.getStart_date());
				datas[i][2] = Integer.toString(rent.getEnd_date());
				datas[i][3] = Integer.toString(rent.getPrice());
				datas[i][4] = rent.getCarNum();
				datas[i][5] = rent.getId();
		}
		
		model = new RentTableModel(datas, columnNames);
		rentTable.setModel(model);
	}
}