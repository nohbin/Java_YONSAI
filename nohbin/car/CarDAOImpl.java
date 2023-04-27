package nohbin.car;


import java.sql.*;
import java.util.*;

public class CarDAOImpl implements CarDAO{
	private static final String driver="oracle.jdbc.driver.OracleDriver";  //상수에 DB연결 관련 데이터를 세팅한다.
	private static final String url ="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd="tiger";
	
	private Connection con;  //DB연결에 사용되는 객체를  선언한다.
    private PreparedStatement pstmt;
    private ResultSet rs;
    SearchCarDialog search;

	

	public List<CarVo> listCar(){   
		 List<CarVo> list =  new ArrayList<CarVo>();
		  try{			
				connDB();  //DB와 연결하는 메서드 
				String sql = "select * from Car order by carNum";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String carNum = rs.getString("carNum");
					String carName = rs.getString("carName");
					int carSize = rs.getInt("carSize");
					String carColor = rs.getString("carColor");
					String carMaker = rs.getString("carMaker");
					String rentGood = rs.getString("rentgood");
					
					  CarVo data = new CarVo();
					  data.setCarNum(carNum);
					  data.setCarName(carName);
					  data.setCarSize(carSize);
					  data.setCarColor(carColor);
					  data.setCarMaker(carMaker);
					  data.setRentGood(rentGood);
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
	public List<CarVo> listCar(String index, String search) {
		 List<CarVo> list =  new ArrayList<CarVo>();
		 try {
		        connDB(); 
		        String sql = "select * from Car";
		        if (index != null && !index.isEmpty() && search != null && !search.isEmpty()) {
		            // index와 search가 입력되었을 경우, 조건절 추가
		            sql += " WHERE lower(" + index + ") LIKE lower('%' || ? || '%')";
		            sql += " order by carNum";
		            pstmt = con.prepareStatement(sql);
		            pstmt.setString(1, search);
		        } else {
		        	sql += " order by carNum";
		            pstmt = con.prepareStatement(sql);
		        }
		        rs = pstmt.executeQuery();
		        while (rs.next()) {
		            String carNum = rs.getString("carNum");
		            String carName = rs.getString("carName");
		            int carSize = rs.getInt("carSize");
		            String carColor = rs.getString("carColor");
		            String carMaker = rs.getString("carMaker");
		            String rentGood = rs.getString("rentgood");

		            CarVo data = new CarVo();
		            data.setCarNum(carNum);
		            data.setCarName(carName);
		            data.setCarSize(carSize);
		            data.setCarColor(carColor);
		            data.setCarMaker(carMaker);
		            data.setRentGood(rentGood);
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
	

	public void insertCar(CarVo car){
		String num = car.getCarNum();
		String name = car.getCarName();
		int size = car.getCarSize();
		String color = car.getCarColor();
		String maker = car.getCarMaker();
		try{
		
		connDB();
		String sql = "insert into car(carNum,carName,carSize,carColor,carMaker)";
		sql += " values(?,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, num);
		pstmt.setString(2, name);
		pstmt.setInt(3, size);
		pstmt.setString(4, color);
		pstmt.setString(5, maker);
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
			
	//회원 정보 수정하는 메소드
	public void updateCar(CarVo car){
		String num = car.getCarNum();
		String name = car.getCarName();
		int size = car.getCarSize();
		String color = car.getCarColor();
		String maker = car.getCarMaker();
		String sql = "update car set carName = ? , carSize = ? , carColor = ? , carMaker = ? ";
		sql += "where carNum = ?";
		
		try {
			connDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, size);
			pstmt.setString(3, color);
			pstmt.setString(4, maker);
			pstmt.setString(5, num);
			pstmt.execute();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateCar(CarVo car, int date) {
		String sql;
		sql = "UPDATE car SET rentgood = CASE"; 
		sql += " WHEN carnum IN (SELECT carnum FROM renttable)"; 
		sql += " AND " + date + " <=any (SELECT end_date FROM renttable WHERE renttable.carnum = car.carnum)"; 
		sql += " AND " + date + " >any (SELECT start_date FROM renttable WHERE renttable.carnum = car.carnum)"; 
		sql += " THEN to_char((SELECT MAX(end_date) FROM renttable WHERE renttable.carnum = car.carnum))";
		sql += " ELSE '렌트 가능'";
		sql += " END";
		try {
			connDB();
			pstmt = con.prepareStatement(sql);
			pstmt.execute();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public CarVo updateCardata(CarVo car) {
		String num = car.getCarNum();
		String sql = "select * from car where carnum = ?";
		try {
			connDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 String carNum = rs.getString("carnum");
		         String carName = rs.getString("carName");
		         int carSize = rs.getInt("carSize");
		         String carColor = rs.getString("carColor");
		         String carMaker = rs.getString("carMaker");
		         String rentGood = rs.getString("rentgood");
		         car.setCarNum(carNum);
		         car.setCarName(carName);
		         car.setCarSize(carSize);
		         car.setCarColor(carColor);
		         car.setCarMaker(carMaker);
		         car.setRentGood(rentGood);
		         System.out.println(car.getCarName());
		         
			}
			pstmt.close();
			rs.close();
			con.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return car;
	}
	
	//회원 정보 삭제하는 메소드
	public void deleteCar(CarVo car){
		String num = car.getCarNum();
		String sql = "delete from car where carNum = ?";
		try {
			connDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
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