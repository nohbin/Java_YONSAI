package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TutorDao;
import dto.ResultVO;

public class TutorResult implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		TutorDao d = new TutorDao();
		
		List<ResultVO> list = d.getResultList();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}
}
