package prj.member;

import java.util.ArrayList;

public interface MemberDAO {
	//회원 정보 조회하는 메소드
	public ArrayList<MemberVo> listMember();
	
	//회원 정보 추가하는 메소드
	public void insertMember(MemberVo mem);
	
	//회원 정보 수정하는 메소드
	public void updateMember(MemberVo mem);
	
	//회원 정보 삭제하는 메소드
	public void deleteMember(MemberVo mem);
}


