package nohbin.car;

import java.util.List;

public interface CarDAO {
	//회원 정보 조회하는 메소드
	public List<CarVo> listCar();
	public List<CarVo> listCar(String index , String search);
	
	//회원 정보 추가하는 메소드
	public void insertCar(CarVo car);
	
	//회원 정보 수정하는 메소드
	public void updateCar(CarVo car);
	public void updateCar(CarVo car , int date);
	public CarVo updateCardata(CarVo car);
	//회원 정보 삭제하는 메소드
	public void deleteCar(CarVo car);
}