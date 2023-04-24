package nohbin.member;


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
    private PreparedStatement pstmt;
    private ResultSet rs;
    SearchMemberDialog search;

	public List<RentVo> listMember(){   
		 List<RentVo> list =  new ArrayList<RentVo>();
		  try{			
				connDB();  //DB와 연결하는 메서드 
				String sql = "select * from member";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String id=rs.getString("id");						 
					String name = rs.getString("name");
					int height = rs.getInt("height");
					int weight = rs.getInt("weight");
					int age = rs.getInt("age");
					
					  RentVo data = new RentVo();
					  data.setMemberNum(id);
					  data.setMemberName(name);
					  data.setMemberHeight(height);
					  data.setMemberWeight(weight);
					  data.setMemberAge(age);
					  list.add(data);
				}			
				pstmt.close();
				rs.close();
				con.close();
		  }catch(Exception e){
			e.printStackTrace();	
		  }
		  return list;
	} //end list()
	
	@Override
	public List<RentVo> listMember(String index, String search) {
		 List<RentVo> list =  new ArrayList<RentVo>();
		 try {
		        connDB(); 
		        String sql = "select * from member";
		        if (index != null && !index.isEmpty() && search != null && !search.isEmpty()) {
		            // index와 search가 입력되었을 경우, 조건절 추가
		            sql += " WHERE " + index + " LIKE ?";
		            pstmt = con.prepareStatement(sql);
		            pstmt.setString(1, search);
		        } else {
		            pstmt = con.prepareStatement(sql);
		        }
		        rs = pstmt.executeQuery();
		        while (rs.next()) {
		        	String id=rs.getString("id");						 
					String name = rs.getString("name");
					int height = rs.getInt("height");
					int weight = rs.getInt("weight");
					int age = rs.getInt("age");
					
					  RentVo data = new RentVo();
					  data.setMemberNum(id);
					  data.setMemberName(name);
					  data.setMemberHeight(height);
					  data.setMemberWeight(weight);
					  data.setMemberAge(age);
					  list.add(data);
		        }
		        pstmt.close();
		        rs.close();
		        con.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return list;
		}
	

	public void insertMember(RentVo mem){
		String memberNum = mem.getMemberNum();
		String memberName = mem.getMemberName();
		int memberHeight = mem.getMemberHeight(); 
		int memberWeithgt = mem.getMemberWeight();
		int memberAge = mem.getMemberAge();
		try{
		
		connDB();
		String sql = "insert into member(id,name,height,weight,age)";
		sql += " values(?,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, memberNum);
		pstmt.setString(2, memberName);
		pstmt.setInt(3, memberHeight);
		pstmt.setInt(4, memberWeithgt);
		pstmt.setInt(5, memberAge);
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
			
	//회원 정보 수정하는 메소드
	public void updateMember(RentVo mem){
		String memberNum = mem.getMemberNum();
		String memberName = mem.getMemberName();
		int memberHeight = mem.getMemberHeight(); 
		int memberWeithgt = mem.getMemberWeight();
		int memberAge = mem.getMemberAge();
		String sql = "update car set name = ? , heigth = ? , weight = ? , age = ? ";
		sql += "where id = ?";
		
		try {
			connDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberName);
			pstmt.setInt(2, memberHeight);
			pstmt.setInt(3, memberWeithgt);
			pstmt.setInt(4, memberAge);
			pstmt.setString(5, memberNum);
			pstmt.execute();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//회원 정보 삭제하는 메소드
	public void deleteMember(RentVo mem){
		String memberNum = mem.getMemberNum();
		String sql = "delete from car where id = ?";
		try {
			connDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			pstmt.execute();
			pstmt.close();
			con.close();
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
		}catch(Exception e){
		e.printStackTrace();	
		}
	}
}//end class MemberDAO