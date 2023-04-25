package nohbin.car;

import java.util.List;

public interface CarController {
	public List<CarVo> listCar();
	public List<CarVo> listCar(String index , String search);
	
	
	public void insertCar(CarVo carVo);
	
	public void updateCar(CarVo carVo);
	
	public void deleteCar(CarVo carVo);

}
