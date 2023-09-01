package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DBPKG.DBConnection;
import dto.VoteVO;
import dto.listVO;

public class TestDao {

	private static TestDao instance;
	private TestDao() {}
	
	public static TestDao getInstance() {
		if(instance == null) {
			instance= new TestDao();
		}
		System.out.println("dao instance");
		return instance;
	}

	public List<listVO> getList() {
		// TODO Auto-generated method stub
		List<listVO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select M.m_no, M.m_name, P.p_name, decode(M.p_school,'1','고졸','2','학사','3','석사','4','박사') p_school,substr(M.m_jumin,1,6)||'-'||substr(M.m_jumin,7) m_jumin, M.m_city, substr(P.p_tel1,1,2) ||'-'|| P.p_tel2 ||'-' || P.p_tel3 p_tel from tbl_member_202005 M , tbl_party_202005 P where M.p_code = P.p_code";
		try {
			Connection conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				listVO vo = new listVO();
				vo.setM_no(rs.getString("m_no"));
				vo.setM_name(rs.getString("m_name"));
				vo.setP_name(rs.getString("p_name"));
				vo.setP_school(rs.getString("p_school"));
				vo.setM_jumin(rs.getString("m_jumin"));
				vo.setM_city(rs.getString("m_city"));
				vo.setTel(rs.getString("p_tel"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public void insertVote(VoteVO vo) {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt = null;
		String sql = "insert into tbl_vote_202005 values(?,?,?,?,?,?)";
		
		try {
			Connection conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getV_jumin());
			pstmt.setString(2, vo.getV_name());
			pstmt.setString(3, vo.getM_no());
			pstmt.setString(4, vo.getV_time());
			pstmt.setString(5, vo.getV_area());
			pstmt.setString(6, vo.getV_confirm());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		
		}
		
	}
	

	
	
	
}
