package prj.movie;

import java.util.ArrayList;

public interface MovieDao {
	//회원 정보 조회하는 메소드
	public ArrayList<MovieVo> listMember();
	
	//회원 정보 추가하는 메소드
	public void insertMember(MovieVo mov);
	
	//회원 정보 수정하는 메소드
	public void updateMember(MovieVo mov);
	
	//회원 정보 삭제하는 메소드
	public void deleteMember(MovieVo mov);
}


