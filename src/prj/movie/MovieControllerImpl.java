package prj.movie;

import java.awt.List;
import java.util.ArrayList;


public class MovieControllerImpl  implements MovieController{
	public MovieDao dao;
	
	@Override
	public ArrayList<MovieVo> listMember() {
		ArrayList<MovieVo> lst = new ArrayList<MovieVo>();
		dao = new MovieDAOImpl();
		lst = dao.listMember();
		return lst;
	}

	@Override
	public void insertMember(MovieVo movieVo) {
		// TODO Auto-generated method stub
		dao = new MovieDAOImpl();
		dao.insertMember(movieVo);
	}

	@Override
	public void updateMember(MovieVo movieVo) {
		// TODO Auto-generated method stub
		dao = new MovieDAOImpl();
		dao.updateMember(movieVo);
	}

	@Override
	public void deleteMember(MovieVo movieVo) {
		// TODO Auto-generated method stub
		dao = new MovieDAOImpl();
		dao.deleteMember(movieVo);
	}

}
