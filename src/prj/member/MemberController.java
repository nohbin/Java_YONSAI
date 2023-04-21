package prj.member;

import java.util.ArrayList;
import java.awt.List;

public interface MemberController {
	public ArrayList<MemberVo> listMember();
	
	public void insertMember(MemberVo memberVo);
	
	public void updateMember(MemberVo memberVo);
	
	public void deleteMember(MemberVo memberVo);

}


