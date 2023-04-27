package nohbin.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl implements MemberDAO {
	private static final String driver = "oracle.jdbc.driver.OracleDriver"; // 상수에 DB연결 관련 데이터를 세팅한다.
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd = "tiger";

	private Connection con; // DB연결에 사용되는 객체를 선언한다.
	private PreparedStatement pstmt;
	private ResultSet rs;
	SearchMemberDialog search;

	public List<MemberVo> listMember() {
		List<MemberVo> list = new ArrayList<MemberVo>();
		try {
			connDB(); // DB와 연결하는 메서드
			String sql = "select * from member order by id";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int height = rs.getInt("height");
				int weight = rs.getInt("weight");
				int age = rs.getInt("age");

				MemberVo data = new MemberVo();
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
	} // end list()

	@Override
	public List<MemberVo> listMember(String index, String search) {
		List<MemberVo> list = new ArrayList<MemberVo>();
		try {
			connDB();
			String sql = "select * from member";
			if (index != null && !index.isEmpty() && search != null && !search.isEmpty()) {
				// index와 search가 입력되었을 경우, 조건절 추가
				sql += " WHERE lower(" + index + ") LIKE lower('%' || ? || '%')";
				sql += " order by id";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, search);
			} else {
				sql += " order by id";
				pstmt = con.prepareStatement(sql);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int height = rs.getInt("height");
				int weight = rs.getInt("weight");
				int age = rs.getInt("age");

				MemberVo data = new MemberVo();
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

	public void insertMember(MemberVo mem) {
		String memberNum = mem.getMemberNum();
		String memberName = mem.getMemberName();
		int memberHeight = mem.getMemberHeight();
		int memberWeithgt = mem.getMemberWeight();
		int memberAge = mem.getMemberAge();
		try {

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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 회원 정보 수정하는 메소드
	public void updateMember(MemberVo mem) {
		String memberNum = mem.getMemberNum();
		String memberName = mem.getMemberName();
		int memberHeight = mem.getMemberHeight();
		int memberWeithgt = mem.getMemberWeight();
		int memberAge = mem.getMemberAge();
		String sql = "update member set name = ? , height = ? , weight = ? , age = ? ";
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

	// 회원 정보 삭제하는 메소드
	public void deleteMember(MemberVo mem) {
		String memberNum = mem.getMemberNum();
		String sql = "delete from member where id = ?";
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

	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}// end class MemberDAO