package prj.member;


import javax.sql.*;
import java.sql.*;
import javax.naming.*;
import java.util.*;

public class MemberDAOImpl implements MemberDAO{
	private static final String driver="oracle.jdbc.driver.OracleDriver";  //상수에 DB연결 관련 데이터를 세팅한다.
	private static final String url ="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd="tiger";
	
	private Connection con;  //DB연결에 사용되는 객체를  선언한다.
    private	Statement stmt;
    private ResultSet rs;	

	public ArrayList<MemberVo> listMember(){   
		 ArrayList<MemberVo> list =  new ArrayList<MemberVo>();
		  try{			
				connDB();  //DB와 연결하는 메서드 
				String query="select * from Member order by id";
				System.out.println(query);
				stmt = con.createStatement();
				rs = stmt.executeQuery( query);	 
				
				 while( rs.next() ){				       
					 String id=rs.getString("id");						 
					 String name = rs.getString("name");
					 int height = rs.getInt("height");
					 int weight = rs.getInt("weight");
					 int age = rs.getInt("age");

					MemberVo data = new MemberVo();     
					data.setId(id);
					data.setName( name);                
					data.setHeight(height);
					data.setWeight(weight);
					data.setAge(age);
					
					list.add( data);					
				} //end while 
				rs.close();
				stmt.close();
				con.close();
		  }catch(Exception e){
			e.printStackTrace();	
		  }

		  return list;
	} //end list()
	
	public void insertMember(MemberVo mem){
		String id=mem.getId();
		String name=mem.getName();
		int height= mem.getHeight();
		int weight = mem.getWeight();
		int age = mem.getAge();
		try{
		
		connDB();
		stmt = con.createStatement();
		String query = "insert into member(id,name,height,weight,age) ";
		      query=query +"values("+"'"+id+"','"+name+"',"+height+","+weight+","+age +")";
		System.out.println(query);
		stmt.executeUpdate(query);		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//회원 정보 수정하는 메소드
	public void updateMember(MemberVo mem){
		String id=mem.getId();
		String name=mem.getName();
		int height= mem.getHeight();
		int weight = mem.getWeight();
		int age = mem.getAge();
		String sql = "update member set name = ? , height = ? , weight = ? , age = ? "
				+ "where id = ?";
		
		try {
			connDB();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, height);
			pstmt.setInt(3, weight);
			pstmt.setInt(4, age);
			pstmt.setString(5, id);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//회원 정보 삭제하는 메소드
	public void deleteMember(MemberVo mem){
		String id = mem.getId();
		try {
			connDB();
			String sql = "delete from member where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.execute();
		} catch (SQLException e) {
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

