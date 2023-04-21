package nohbin;

import java.util.ArrayList;
import java.awt.List;

public interface CarController {
	public ArrayList<CarVo> listMember();
	
	public void insertCar(CarVo carVo);
	
	public void updateCar(CarVo carVo);
	
	public void deleteCar(CarVo carVo);

}


