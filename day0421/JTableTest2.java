package day0421;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JTableTest2 extends JFrame{ 
	   JTable table; 
	   Object[][] rows={ 
	                 {"150000","박길동","총무부"}, 
	                 {"150001","홍길동","관리부"}, 
	                 {"150002","이순신","회계부"}, 
	                 {"150003","임꺽정","개발부"}, 
	                 {"150004","박지성","관리부"}, 
	                 {"150005","제임스","총무부"}, 
	                 {"150006","이길동","총무부"}, 
	                 {"150007","차범근","개발부"}, 
	                 {"150008","박세리","회계부"}, 
	                 {"150009","차두리","영업부"}, 
	                 {"150010","홍명보","영업부"}, 
	                 {"150011","존슨","개발부"}, 
	                 {"150012","김유신","영업부"}}; 

	   Object [] columnNames={"사번","이름","근무부서" }; 
	   int rowIdx=1,colIdx=1;
	   
	   public JTableTest2(){ 
		      table=new JTable(rows,columnNames); 
		      ListSelectionModel rowSel = table.getSelectionModel(); 
//		     rowSel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 
//		     rowSel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); 
		      rowSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		      rowSel.addListSelectionListener(new ListSelectionListener(){ 
		         public void valueChanged(ListSelectionEvent e) { 
		            if(!e.getValueIsAdjusting()){ 
		               ListSelectionModel lsm=(ListSelectionModel)e.getSource(); 
		               rowIdx=lsm.getMinSelectionIndex(); 
		               System.out.println(lsm.getMinSelectionIndex()+ " 번째 행이선택됨..."); 
		               System.out.println(rows[rowIdx][colIdx]); 
		            } 
		         }}); 
		         ListSelectionModel colSel = table.getColumnModel().getSelectionModel(); 
		         colSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		         colSel.addListSelectionListener(new ListSelectionListener(){ 
		            public void valueChanged(ListSelectionEvent e) { 
		                ListSelectionModel lsm = (ListSelectionModel)e.getSource(); 
		               colIdx=lsm.getMinSelectionIndex(); 
		               if(!e.getValueIsAdjusting()){ 
		                   System.out.println(lsm.getMinSelectionIndex()+" 번째 열이  선택됨..."); 
		                   System.out.println(rows[rowIdx][colIdx]); 
		                } 
		           } 
		         }); 
		   } 
	   public void startFrame(){ 
		      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		      this.setTitle("테이블 테스트"); 
		      add(new JScrollPane(table)); 
		      pack(); 
		      setVisible(true); 
		   } 

		   public static void main(String[] args){ 
		      JTableTest2 t=new JTableTest2(); 
		      t.startFrame(); 
		   } 
		} 

