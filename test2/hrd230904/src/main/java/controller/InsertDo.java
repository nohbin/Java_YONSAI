package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TutorDao;
import dto.ClassVO;

public class InsertDo implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ClassVO vo = new ClassVO();
		
		vo.setRegist_month(request.getParameter("regist_month"));
		vo.setC_no(request.getParameter("c_no"));
		vo.setClass_area(request.getParameter("class_area"));
		vo.setTuition(request.getParameter("tuition"));
		vo.setTeacher_code(request.getParameter("teacher_code"));
		
		TutorDao dao = new TutorDao();
		dao.insertClass(vo);
		
		request.getRequestDispatcher("good.jsp").forward(request, response);
	}
}
