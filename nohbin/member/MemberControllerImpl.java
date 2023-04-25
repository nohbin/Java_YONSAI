package nohbin.member;

import java.util.ArrayList;
import java.util.List;

public class MemberControllerImpl  implements MemberController{
	public MemberDAO dao;
	
	@Override
	public List<MemberVo> listMember() {
	List<MemberVo> lst = new ArrayList<MemberVo>();
		dao = new MemberDAOImpl();
		lst = dao.listMember();
		return lst;
	}

	@Override
	public List<MemberVo> listMember(String index, String search) {
		List<MemberVo> lst = new ArrayList<MemberVo>();
	    dao = new MemberDAOImpl();
	    lst = dao.listMember(index, search); // 새로운 인자 추가
	    return lst;
	}

	@Override
	public void insertMember(MemberVo carVo) {
		dao = new MemberDAOImpl();
		dao.insertMember(carVo);
		
	}

	@Override
	public void updateMember(MemberVo carVo) {
		dao = new MemberDAOImpl();
		dao.updateMember(carVo);
	}

	@Override
	public void deleteMemeber(MemberVo carVo) {
		dao = new MemberDAOImpl();
		dao.deleteMember(carVo);
		
	}

}