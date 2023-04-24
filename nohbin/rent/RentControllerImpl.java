package nohbin.rent;

import java.util.ArrayList;
import java.util.List;

public class RentControllerImpl  implements RentController{
	public RentDAO dao;
	
	@Override
	public List<RentVo> listRent() {
	List<RentVo> lst = new ArrayList<RentVo>();
		dao = new RentDAOImpl();
		lst = dao.listRent();
		return lst;
	}

	@Override
	public List<RentVo> listRent(String index, String search) {
		List<RentVo> lst = new ArrayList<RentVo>();
	    dao = new RentDAOImpl();
	    lst = dao.listRent(index, search); // 새로운 인자 추가
	    return lst;
	}

	@Override
	public void insertRent(RentVo rentVo) {
		dao = new RentDAOImpl();
		dao.insertRent(rentVo);
		
	}

	@Override
	public void updateRent(RentVo rentVo) {
		dao = new RentDAOImpl();
		dao.updateRent(rentVo);
	}

	@Override
	public void deleteRent(RentVo rentVo) {
		dao = new RentDAOImpl();
		dao.deleteRent(rentVo);
		
	}

}