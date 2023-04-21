package prj.member;

import java.awt.List;
import java.util.ArrayList;


public class MemberControllerImpl  implements MemberController{
	public MemberDAO dao;
	
	@Override
	public ArrayList<MemberVo> listMember() {
		ArrayList<MemberVo> lst = new ArrayList<MemberVo>();
		dao = new MemberDAOImpl();
		lst = dao.listMember();
		return lst;
	}

	@Override
	public void insertMember(MemberVo memberVo) {
		dao = new MemberDAOImpl();
		dao.insertMember(memberVo);
		
	}

	@Override
	public void updateMember(MemberVo memberVo) {
		dao = new MemberDAOImpl();
		dao.updateMember(memberVo);
	}

	@Override
	public void deleteMember(MemberVo memberVo) {
		dao = new MemberDAOImpl();
		dao.deleteMember(memberVo);
		
	}

}
