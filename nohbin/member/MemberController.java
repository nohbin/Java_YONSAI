package nohbin.member;

import java.util.List;

public interface MemberController {
	public List<MemberVo> listMember();
	public List<MemberVo> listMember(String index , String search);
	
	public void insertMember(MemberVo mem);
	
	public void updateMember(MemberVo mem);
	
	public void deleteMemeber(MemberVo mem);

}
