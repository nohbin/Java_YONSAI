package nohbin.rent;

import java.util.List;

public interface RentDAO {
	//회원 정보 조회하는 메소드
	public List<RentVo> listRent();
	public List<RentVo> listRent(String search);
	public List<RentVo> listRent(String index , String search);
	
	//회원 정보 추가하는 메소드
	public void insertRent(RentVo rent);
	
	//회원 정보 수정하는 메소드
	public void updateRent(RentVo rent);
	public RentVo updateDataRent(RentVo rent);
	
	//회원 정보 삭제하는 메소드
	public void deleteRent(RentVo rent);
}