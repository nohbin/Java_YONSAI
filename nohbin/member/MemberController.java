package nohbin.member;

import java.util.List;

public interface MemberController {
	public List<RentVo> listMember();
	public List<RentVo> listMember(String index , String search);
	
	
	public void insertMember(RentVo mem);
	
	public void updateMember(RentVo mem);
	
	public void deleteMemeber(RentVo mem);

}
