package nohbin.rent;


import java.sql.*;
import java.sql.Date;
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
				String sql = "select * from renttable order by rent_no";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String rent_no=rs.getString("rent_no");						 
					int start_date = rs.getInt("start_date");
					int end_date = rs.getInt("end_date");
					String carnum = rs.getString("carnum");
					String id = rs.getString("id");
					RentVo data = new RentVo();
					data.setRent_no(rent_no);
					data.setStart_date(start_date);
					data.setEnd_date(end_date);
					data.setPrice();
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
		            sql += " order by rent_no";
		            pstmt = con.prepareStatement(sql);
		            pstmt.setString(1, search);
		        } else {
		        	sql += " order by rent_no";
		            pstmt = con.prepareStatement(sql);
		        }
		        rs = pstmt.executeQuery();
		        while (rs.next()) {
		        	String rent_no=rs.getString("rent_no");						 
					int start_date = rs.getInt("start_date");
					int end_date = rs.getInt("end_date");
					String carnum = rs.getString("carnum");
					String id = rs.getString("id");
					RentVo data = new RentVo();
					data.setRent_no(rent_no);
					data.setStart_date(start_date);
					data.setEnd_date(end_date);
					data.setPrice();
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
	
	public void insertRent(RentVo rent){
		int start_date = rent.getStart_date();
		int end_date = rent.getEnd_date();
		String carNum = rent.getCarNum();
		String id = rent.getId();
		try {
			connDB();
			String sql = "insert into rentTable(rent_no,start_date,end_date,carNum,id)";
			sql += "values(rent_no_seq.NEXTVAL,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start_date);
			pstmt.setInt(2, end_date);
			pstmt.setString(3, carNum);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
			
	//회원 정보 수정하는 메소드
	public void updateRent(RentVo mem){
		
	}
	
	//회원 정보 삭제하는 메소드
	public void deleteRent(RentVo rent){
		String idNum = rent.getRent_no();
		String sql = "delete from rentTable where rent_no = ?";
		try {
			connDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, idNum);
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