package nohbin.rent;


import javax.sql.*;


import java.sql.*;
import javax.naming.*;
import java.util.*;

public class RentDAOImpl implements RentDAO{
	private static final String driver="oracle.jdbc.driver.OracleDriver";  //상수에 DB연결 관련 데이터를 세팅한다.
	private static final String url ="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd="tiger";
	
	private Connection con;  //DB연결에 사용되는 객체를  선언한다.
    private PreparedStatement pstmt;
    private ResultSet rs;
    

	public List<RentVo> listRent(){   
		 List<RentVo> list =  new ArrayList<RentVo>();
		 try{			
				connDB();  //DB와 연결하는 메서드 
				String sql = "select * from renttable";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				System.out.println(rs.getRow());
				while (rs.next()) {
					String rent_no=rs.getString("rent_no");						 
					String start_date = rs.getString("start_date");
					String end_date = rs.getString("end_date");
					int price = rs.getInt("price");
					String carnum = rs.getString("carnum");
					String id = rs.getString("id");
					
					RentVo data = new RentVo();
					data.setRent_no(rent_no);
					data.setStart_date(start_date);
					data.setEnd_date(end_date);
					data.setPrice(price);
					data.setCarNum(carnum);
					data.setId(id);
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
	public List<RentVo> listRent(String index, String search) {
		 List<RentVo> list =  new ArrayList<RentVo>();
		 try {
		        connDB(); 
		        String sql = "select * from rentTable";
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
		        	String rent_no=rs.getString("rent_no");						 
					String start_date = rs.getString("start_date");
					String end_date = rs.getString("end_date");
					int price = rs.getInt("price");
					String carnum = rs.getString("carnum");
					String id = rs.getString("id");
					
					  RentVo data = new RentVo();
					 
						data.setRent_no(rent_no);
						data.setStart_date(start_date);
						data.setEnd_date(end_date);
						data.setPrice(price);
						data.setCarNum(carnum);
						data.setId(id);
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
	

	public void insertRent(RentVo mem){
		
	}
			
	//회원 정보 수정하는 메소드
	public void updateRent(RentVo mem){
		
	}
	
	//회원 정보 삭제하는 메소드
	public void deleteRent(RentVo rent){
		
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