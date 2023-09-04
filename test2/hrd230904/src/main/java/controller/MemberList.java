package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TutorDao;
import dto.MemberVO;

public class MemberList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		TutorDao d = new TutorDao();
		
		List<MemberVO> list = d.getMemberList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("memberlist.jsp").forward(request, response);
	}

}
