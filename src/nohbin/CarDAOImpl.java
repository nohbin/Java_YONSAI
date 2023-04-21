package nohbin;


import javax.sql.*;
import java.sql.*;
import javax.naming.*;
import java.util.*;

public class CarDAOImpl implements CarDAO{
	private static final String driver="oracle.jdbc.driver.OracleDriver";  //상수에 DB연결 관련 데이터를 세팅한다.
	private static final String url ="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd="tiger";
	
	private Connection con;  //DB연결에 사용되는 객체를  선언한다.
    private	Statement stmt;
    private ResultSet rs;	

	public ArrayList<CarVo> listMember(){   
		 ArrayList<CarVo> list =  new ArrayList<CarVo>();
		  try{			
				connDB();  //DB와 연결하는 메서드 
				String query="select * from Member order by id";
					 CarVo data = new CarVo();     
					list.add( data);					
				 
				rs.close();
				stmt.close();
				con.close();
		  }catch(Exception e){
			e.printStackTrace();	
		  }

		  return list;
	} //end list()
	
	public void insertMember(CarVo car){
		
		try{
		
		connDB();
		stmt = con.createStatement();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//회원 정보 수정하는 메소드
	public void updateMember(CarVo car){
		
		try {
			connDB();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//회원 정보 삭제하는 메소드
	public void deleteMember(CarVo car){
	
		try {
			connDB();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void connDB(){
		try{
			Class.forName(driver);  
			System.out.println("Oracle 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
//			stmt = con.createStatement();
//			System.out.println("Statement 생성 성공");		
		}catch(Exception e){
		e.printStackTrace();	
		}
	}
}//end class MemberDAO

