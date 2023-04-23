package nohbin;

import java.util.ArrayList;

public interface CarDAO {
	//회원 정보 조회하는 메소드
	public ArrayList<CarVo> listMember();
	
	//회원 정보 추가하는 메소드
	public void insertMember(CarVo car);
	
	//회원 정보 수정하는 메소드
	public void updateMember(CarVo car);
	
	//회원 정보 삭제하는 메소드
	public void deleteMember(CarVo car);
}

