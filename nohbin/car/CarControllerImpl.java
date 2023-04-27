package nohbin.car;

import java.util.ArrayList;
import java.util.List;

public class CarControllerImpl  implements CarController{
	public CarDAO dao;
	
	@Override
	public List<CarVo> listCar() {
	List<CarVo> lst = new ArrayList<CarVo>();
		dao = new CarDAOImpl();
		lst = dao.listCar();
		return lst;
	}

	
	@Override
	public List<CarVo> listCar(String index, String search) {
		List<CarVo> lst = new ArrayList<CarVo>();
	    dao = new CarDAOImpl();
	    lst = dao.listCar(index, search); // 새로운 인자 추가
	    return lst;
	}

	@Override
	public void insertCar(CarVo carVo) {
		dao = new CarDAOImpl();
		dao.insertCar(carVo);
		
	}

	@Override
	public void updateCar(CarVo carVo) {
		dao = new CarDAOImpl();
		dao.updateCar(carVo);
	}
	
	@Override
	public CarVo updateCardata(CarVo car) {
		dao = new CarDAOImpl();
		dao.updateCardata(car);
		return car;  
	}


	@Override
	public void deleteCar(CarVo carVo) {
		dao = new CarDAOImpl();
		dao.deleteCar(carVo);
		
	}

}