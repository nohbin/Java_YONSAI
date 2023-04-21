package prj.movie;


import javax.sql.*;
import java.sql.*;
import javax.naming.*;
import java.util.*;

public class MovieDAOImpl implements MovieDao{
	private static final String driver="oracle.jdbc.driver.OracleDriver";  //상수에 DB연결 관련 데이터를 세팅한다.
	private static final String url ="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd="tiger";

	
	private Connection con;  //DB연결에 사용되는 객체를  선언한다.
    private	Statement stmt;
    private ResultSet rs;	

	public ArrayList<MovieVo> listMember(){   
		 ArrayList<MovieVo> list =  new ArrayList<MovieVo>();
		  try{			
				connDB();  //DB와 연결하는 메서드 
				String query="select * from movie order by id";
				System.out.println(query);
				ResultSet rs = stmt.executeQuery( query);	 

				 while( rs.next() ){				       
					 String id=rs.getString("id");						 
					 String name = rs.getString("name");
					 String genre = rs.getString("genre");
					 int runtime = rs.getInt("runtime");
					 int age = rs.getInt("age");

					 MovieVo data = new MovieVo();     
					data.setId(id);
					data.setName( name);                
					data.setGenre(genre);
					data.setRuntime(runtime);
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
	
	public void insertMember(MovieVo mem){
		String id=mem.getId();
		String name=mem.getName();
		String genre= mem.getGenre();
		int runtime = mem.getRuntime();
		int age = mem.getAge();
		try{
		
		connDB();
		
		String query = "insert into movie(id,name,genre,runtime,age) ";
		      query=query +"values("+"'"+id+"','"+name+"','"+genre+"',"+runtime+","+age +")" ;
		System.out.println(query);
		stmt.executeUpdate(query);		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//회원 정보 수정하는 메소드
	public void updateMember(MovieVo mem){
		String id=mem.getId();
		String name=mem.getName();
		String genre= mem.getGenre();
		int runtime = mem.getRuntime();
		int age = mem.getAge();
		String sql = "update movie set name = ? , genre = ? , runtime = ? , age = ? "
				+ "where id = ?";
		
		try {
			connDB();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, genre);
			pstmt.setInt(3, runtime);
			pstmt.setInt(4, age);
			pstmt.setString(5, id);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//회원 정보 삭제하는 메소드
	public void deleteMember(MovieVo mem){
		String id = mem.getId();
		try {
			connDB();
			String sql = "delete from movie where id = ?";
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

			stmt = con.createStatement();
			System.out.println("Statement 생성 성공");		
		}catch(Exception e){
		e.printStackTrace();	
		}
	}
}//end class MemberDAO

