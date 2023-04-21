package nohbin;

import java.awt.List;
import java.util.ArrayList;


public class CarControllerImpl  implements CarController{
	public CarDAO dao;
	
	@Override
	public ArrayList<CarVo> listMember() {
		ArrayList<CarVo> lst = new ArrayList<CarVo>();
		dao = new CarDAOImpl();
		lst = dao.listMember();
		return lst;
	}

	@Override
	public void insertCar(CarVo carVo) {
		dao = new CarDAOImpl();
		dao.insertMember(carVo);
		
	}

	@Override
	public void updateCar(CarVo carVo) {
		dao = new CarDAOImpl();
		dao.updateMember(carVo);
	}

	@Override
	public void deleteCar(CarVo carVo) {
		dao = new CarDAOImpl();
		dao.deleteMember(carVo);
		
	}

}
