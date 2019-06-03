package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Dao;
import kr.or.bit.dto.Emp;

public class SearchEmpByDeptno implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("deptno탔다");
		ActionForward forward = null;
		try {
    		int deptno = Integer.parseInt(request.getParameter("deptno"));
    		Dao dao = new Dao();
    		List<Emp> EmplistByDeptno = dao.SelectByDeptno(deptno);
    		System.out.println(EmplistByDeptno.toString());
    		request.setAttribute("EmplistByDeptno", EmplistByDeptno);
    		
    		forward = new ActionForward();
		  	forward.setPath("/WEB-INF/Ajax/Select.jsp");
		  	
		  	
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
		return forward;
	}

}