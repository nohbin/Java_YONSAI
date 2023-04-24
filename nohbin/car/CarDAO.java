package nohbin.car;

import java.util.List;

public interface CarDAO {
	//회원 정보 조회하는 메소드
	public List<CarVo> listMember();
	public List<CarVo> listMember(String index , String search);
	
	//회원 정보 추가하는 메소드
	public void insertMember(CarVo car);
	
	//회원 정보 수정하는 메소드
	public void updateMember(CarVo car);
	
	//회원 정보 삭제하는 메소드
	public void deleteMember(CarVo car);
}