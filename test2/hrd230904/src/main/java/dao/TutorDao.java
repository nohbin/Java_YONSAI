package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbpkg.DbMgr;
import dto.ClassVO;
import dto.MemberVO;
import dto.ResultVO;
import dto.TutorVO;

public class TutorDao {

	public List<TutorVO> getTutorList() {
		// TODO Auto-generated method stub
		List<TutorVO> t = new ArrayList<TutorVO>();
		
		try {
			Connection con = DbMgr.dbConnect();
			String sql = "select teacher_code,teacher_name,class_name,'￦' || to_char(class_price,'fm999,999,999') class_price , substr(teacher_regist_date,0,4) || '년' || substr(teacher_regist_date,5,2)||'월' || substr(teacher_regist_date,7,2)||'일' teacher_regist_date from tbl_teacher_202201";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				TutorVO v = new TutorVO();
				v.setTeacher_code(rs.getString("teacher_code"));
				v.setTeacher_name(rs.getString("teacher_name"));
				v.setClass_name(rs.getString("class_name"));
				v.setClass_price(rs.getString("class_price"));
				v.setTeacher_regist(rs.getString("teacher_regist_date"));
				t.add(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return t;
	}

	public void insertClass(ClassVO vo) {
		// TODO Auto-generated method stub
		
		try {
			Connection con = DbMgr.dbConnect();
			PreparedStatement pstmt = con.prepareStatement("insert into tbl_class_202201 values(?,?,?,?,?)");
			pstmt.setString(1, vo.getRegist_month());
			pstmt.setString(2, vo.getC_no());
			pstmt.setString(3, vo.getClass_area());
			pstmt.setInt(4, Integer.parseInt(vo.getTuition()));
			pstmt.setString(5, vo.getTeacher_code());
			
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public List<MemberVO> getMemberList() {
		List<MemberVO> t = new ArrayList<MemberVO>();
		try {
			Connection con = DbMgr.dbConnect();
			String sql = "select substr(c.regist_month,0,4)||'년'||substr(c.regist_month,5,2)||'월' regist_month , c.c_no, m.c_name, t.class_name,c.class_area, '￦'||to_char(c.tuition, 'fm999,999,999') tuition , m.grade from tbl_teacher_202201 t, tbl_member_202201 m, tbl_class_202201 c where c.c_no = m.c_no and c.teacher_code = t.teacher_code";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO v = new MemberVO();
				v.setRegist_month(rs.getString("regist_month"));
				v.setC_no(rs.getString("c_no"));
				v.setC_name(rs.getString("c_name"));
				v.setClass_name(rs.getString("class_name"));
				v.setClass_area(rs.getString("class_area"));
				v.setTuition(rs.getString("tuition"));
				v.setGrade(rs.getString("grade"));
				t.add(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return t;
	}

	public List<ResultVO> getResultList() {
		// TODO Auto-generated method stub
		List<ResultVO> t = new ArrayList<ResultVO>();
		String sql = "select c.teacher_code , t.class_name, t.teacher_name, '￦'||to_char(sum(c.tuition)) total from tbl_class_202201 c, tbl_teacher_202201 t where c.teacher_code = t.teacher_code group by (c.teacher_code, t.class_name, t.teacher_name) order by c.teacher_code";
		try {
			Connection con = DbMgr.dbConnect();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ResultVO v = new ResultVO();
				v.setTeacher_code(rs.getString("teacher_code"));
				v.setClass_name(rs.getString("class_name"));
				v.setTeacher_name(rs.getString("teacher_name"));
				v.setTotal(rs.getString("total"));
				t.add(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return t;
	}

	
	
}
