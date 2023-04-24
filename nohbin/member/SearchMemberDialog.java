package nohbin.member;

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


public class SearchMemberDialog extends JDialog {
	JPanel panelSearch,panelBtn;
	JLabel lMemberName;
	JTextField tf ;
    JButton searchAllBtn , searchBtn ;
    
    String[][] memberItem ;
    JTable rentTable;
    RentTableModel model;
    MemberController memCtrl;
    String[] columnNames={"회원번호","이름","키","몸무게","나이"};
    private String[] searchByCol = {"id","name","height","weight","age"};
    private JComboBox<String> searchCombo = new JComboBox<>(searchByCol);
	
	
	public SearchMemberDialog(String id) {
		setTitle(id);
    	init();
	}

	private void init() {
		memCtrl = new MemberControllerImpl();
    	rentTable=new JTable();
    	panelSearch=new JPanel();
    	panelBtn=new JPanel();
      
    	lMemberName = new JLabel("회원이름");
    	tf=new JTextField(20);
    	searchBtn = new JButton("회원조회");
    	searchAllBtn=new JButton("전체조회");

		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String index = searchCombo.getSelectedItem().toString();
				String search = tf.getText();
				System.out.println(index);
				List<RentVo> lists = new ArrayList<>();
				try {
		           lists = memCtrl.listMember(index, search);
		           loadTable(lists);
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
			}
		});
	

		searchAllBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<RentVo> lists = new ArrayList<>();
				RentVo mem = new RentVo();
				lists.add(mem);
				try {
					lists = memCtrl.listMember();
					loadTable(lists);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
    	});    	

		panelSearch.add(searchCombo);
    	panelSearch.add(tf);
    	panelSearch.add(searchBtn);
    	panelSearch.add(searchAllBtn);

      	add(panelSearch,BorderLayout.NORTH);
    	add(panelBtn,BorderLayout.SOUTH);
      	memberItem = new String[0][5];
        model=new RentTableModel(memberItem,columnNames);
    	rentTable.setModel(model);
        add(new JScrollPane(rentTable),BorderLayout.CENTER);
        setLocation(300,100);
        setSize(600,600);
        setModal(true);
        setVisible(true);   
	}
	
	private void loadTable(List<RentVo> lists) {
		String[][] datas = new String[lists.size()][5];
		for (int i = 0; i < lists.size(); i++) {
			RentVo mem = lists.get(i);
			datas[i][0] = mem.getMemberNum();
			datas[i][1] = mem.getMemberName();
			datas[i][2] = Integer.toString(mem.getMemberHeight());
			datas[i][3] = Integer.toString(mem.getMemberWeight());
			datas[i][4] = Integer.toString(mem.getMemberAge());
		}
		System.out.println(datas[0][1]);
		model=new RentTableModel(datas,columnNames);
    	rentTable.setModel(model);
	}

	
	public static void main(String[] args) {
		new SearchMemberDialog("회원관리");
	}
}