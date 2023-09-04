package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TutorDao;
import dto.TutorVO;

public class TutorList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		TutorDao dao = new TutorDao();
		
		List<TutorVO> t = dao.getTutorList();
		
		request.setAttribute("list", t);
		request.getRequestDispatcher("tutorlist.jsp").forward(request, response);
		
	}

}
