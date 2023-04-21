package prj.movie;

import java.util.ArrayList;
import java.awt.List;

public interface MovieController {
	public ArrayList<MovieVo> listMember();
	
	public void insertMember(MovieVo movieVo);
	
	public void updateMember(MovieVo movieVo);
	
	public void deleteMember(MovieVo movieVo);

}


