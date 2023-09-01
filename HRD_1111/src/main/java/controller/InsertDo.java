package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TestDao;
import dto.VoteVO;

public class InsertDo implements TestAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VoteVO vo = new VoteVO(request.getParameter("v_jumin"), 
								request.getParameter("v_name"), 
								request.getParameter("m_no"), 
								request.getParameter("v_time"), 
								request.getParameter("v_area"), 
								request.getParameter("v_confirm"));
		
		TestDao dao = TestDao.getInstance();
		dao.insertVote(vo);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
