package kr.or.bit.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Dao;
import kr.or.bit.dto.Emp;

public class SearchEmpByEmpno implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		int num = Integer.parseInt(request.getParameter("empno")); 
		System.out.println(num);
		ActionForward forward = null;

		try {
			Dao dao = new Dao();
			Emp EmpListByEmpno = dao.SelectByEmpno(num);
			System.out.println(EmpListByEmpno.toString());
			
			forward = new ActionForward();
			forward.setPath("/WEB-INF/Ajax/Select.jsp");
			
			request.setAttribute("EmpListByEmpno",EmpListByEmpno);
			

	  		System.out.println(forward);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return forward;
	}

}