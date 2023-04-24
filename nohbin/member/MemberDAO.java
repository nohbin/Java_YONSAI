package nohbin.member;

import java.util.List;

public interface MemberDAO {
	//회원 정보 조회하는 메소드
	public List<RentVo> listMember();
	public List<RentVo> listMember(String index , String search);
	
	//회원 정보 추가하는 메소드
	public void insertMember(RentVo mem);
	
	//회원 정보 수정하는 메소드
	public void updateMember(RentVo mem);
	
	//회원 정보 삭제하는 메소드
	public void deleteMember(RentVo mem);
}