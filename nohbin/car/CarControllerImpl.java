package nohbin.car;

import java.util.ArrayList;
import java.util.List;

public class CarControllerImpl  implements CarController{
	public CarDAO dao;
	
	@Override
	public List<CarVo> listMember() {
	List<CarVo> lst = new ArrayList<CarVo>();
		dao = new CarDAOImpl();
		lst = dao.listMember();
		return lst;
	}

	@Override
	public List<CarVo> listMember(String index, String search) {
		List<CarVo> lst = new ArrayList<CarVo>();
	    dao = new CarDAOImpl();
	    lst = dao.listMember(index, search); // 새로운 인자 추가
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