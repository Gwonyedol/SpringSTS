package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Dao;
import kr.or.bit.dto.Emp;

public class UpdateEmp implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        ActionForward forward= null;
        Emp EmpListByEmpno =null;
        int empno=Integer.parseInt(request.getParameter("empno"));
   

		try {
			Dao dao = new Dao();
			EmpListByEmpno = dao.SelectByEmpno(empno);
			
			System.out.println("파일패스 " + EmpListByEmpno.getFilepath());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("empno",EmpListByEmpno);
		forward = new ActionForward();
		forward.setPath("/WEB-INF/Ajax/Update.jsp");
		
		
		return forward;
	}

}