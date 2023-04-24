package nohbin.car;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import nohbin.RentTableModel;


public class SearchCarDialog extends JDialog {
	JPanel panelSearch,panelBtn;
	JLabel lCarName;
	JTextField tf ;
    JButton searchAllBtn , searchBtn ;
    String[][] carItems;
    JTable rentTable;
    RentTableModel model;
    CarController carCtrl;
    String[] columnNames={"차번호","이름","배기량","색상","제조사"};
    private String[] searchByCol = {"carNum","carName","carSize","carColor","carMaker"};
    private JComboBox<String> searchCombo = new JComboBox<>(searchByCol);
	

	public SearchCarDialog() {}
	public SearchCarDialog(String id) {
		setTitle(id);
    	init();
	}

	public void init() {
		carCtrl = new CarControllerImpl();
    	rentTable=new JTable();
    	panelSearch=new JPanel();
    	panelBtn=new JPanel();
    	lCarName = new JLabel("차량명");
    	tf=new JTextField(20);
    	searchBtn = new JButton("차량 조회");
    	searchAllBtn=new JButton("전체조회");

		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String index = searchCombo.getSelectedItem().toString();
				String search = tf.getText();
				System.out.println(index);
				List<CarVo> lists = new ArrayList<>();
		        lists = carCtrl.listMember(index, search);
		        loadTable(lists);

			}
		});
	

		searchAllBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<CarVo> lists = new ArrayList<>();
				CarVo car = new CarVo();
				lists.add(car);
				lists = carCtrl.listMember();
				loadTable(lists);
					// TODO Auto-generated catch block
			}
    	});    	

		panelSearch.add(searchCombo);
    	panelSearch.add(tf);
    	panelSearch.add(searchBtn);
    	panelSearch.add(searchAllBtn);

      	add(panelSearch,BorderLayout.NORTH);
    	add(panelBtn,BorderLayout.SOUTH);
      	carItems = new String[0][5];
        model=new RentTableModel(carItems,columnNames);
    	rentTable.setModel(model);
        add(new JScrollPane(rentTable),BorderLayout.CENTER);
        setLocation(300,100);
        setSize(600,600);
        setModal(true);
        setVisible(true);   
	}
	
	private void loadTable(List<CarVo> lists) {
		String[][] datas = new String[lists.size()][5];
		for (int i = 0; i < lists.size(); i++) {
			CarVo car = lists.get(i);
			datas[i][0] = car.getCarNum();
			datas[i][1] = car.getCarName();
			datas[i][2] = Integer.toString(car.getCarSize());
			datas[i][3] = car.getCarColor();
			datas[i][4] = car.getCarMaker();
		}
		model=new RentTableModel(datas,columnNames);
    	rentTable.setModel(model);
	}

	
	public static void main(String[] args) {
		new SearchCarDialog("차량관리");
	}
}