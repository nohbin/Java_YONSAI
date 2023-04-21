package prj.member;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import prj.movie.MovieController;
import prj.movie.MovieControllerImpl;
import prj.movie.MovieVo;

public class BaseWindow {
	public  JFrame frame;
	public  List guiList;
	public  JPanel p1, p2;
	public  JPanel part1,part2,part3,part4,part5;
	
	public JTextField tId,tName,tHeight,tWeight,tAge,tGenre,tRuntime;
	public  JButton btnSearch, btnInsert,btnUpdate,btnDelete;
	
	public  JLabel lId,lName,lHeight,lWeight,lAge,lGenre,lRuntime;
	
	
	protected MemberController memberController;
	protected MovieController movieController;
	public BaseWindow(){
		memberController =new MemberControllerImpl();
		movieController = new MovieControllerImpl();
	}
	//최초 화면 생성 시 회원 조회 기능 메소드
	public void init(){
		ArrayList<MemberVo> lst = new  ArrayList<MemberVo>();
		lst = memberController.listMember();
		guiList.removeAll();
		//조회된 회원 정보를 화면에 보여 준다.
		for(int i=0; i < lst.size();i++){
			MemberVo mem = new MemberVo();
			mem= (MemberVo)lst.get(i);
			
			String id=(String)mem.getId();
			String name= (String)mem.getName();
			int height = mem.getHeight();
			int weight = mem.getWeight();
			int age = (int)mem.getAge();
			guiList.add(id+"                         "+
					  name+"                         "+
					  height+"                         "+
					  weight+"                         "+
					  age);
		}
	}
	public void init2(){
		ArrayList<MovieVo> lst = new  ArrayList<MovieVo>();
		lst = movieController.listMember();
		guiList.removeAll();
		//조회된 회원 정보를 화면에 보여 준다.
		for(int i=0; i < lst.size();i++){
			MovieVo mem = new MovieVo();
			mem= (MovieVo)lst.get(i);
			
			String id=(String)mem.getId();
			String name= (String)mem.getName();
			String genre = mem.getGenre();
			int runtime = mem.getRuntime();
			int age = mem.getAge();
			guiList.add(id+"                         "+
					  name+"                         "+
					  genre+"                         "+
					  runtime+"                         "+
					  age);
		}
	}
}
