package nohbin.member;

import java.util.ArrayList;
import java.util.List;

public class MemberControllerImpl  implements MemberController{
	public MemberDAO dao;
	
	@Override
	public List<RentVo> listMember() {
	List<RentVo> lst = new ArrayList<RentVo>();
		dao = new MemberDAOImpl();
		lst = dao.listMember();
		return lst;
	}

	@Override
	public List<RentVo> listMember(String index, String search) {
		List<RentVo> lst = new ArrayList<RentVo>();
	    dao = new MemberDAOImpl();
	    lst = dao.listMember(index, search); // 새로운 인자 추가
	    return lst;
	}

	@Override
	public void insertMember(RentVo carVo) {
		dao = new MemberDAOImpl();
		dao.insertMember(carVo);
		
	}

	@Override
	public void updateMember(RentVo carVo) {
		dao = new MemberDAOImpl();
		dao.updateMember(carVo);
	}

	@Override
	public void deleteMemeber(RentVo carVo) {
		dao = new MemberDAOImpl();
		dao.deleteMember(carVo);
		
	}

}