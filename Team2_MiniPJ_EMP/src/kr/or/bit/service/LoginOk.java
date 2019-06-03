package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;

public class LoginOk implements Action {
	ActionForward forward = new ActionForward();
	@SuppressWarnings("deprecation")
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id  = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		System.out.println(id);
		System.out.println(pwd);
		
		if(id.equals("admin")&&pwd.equals("1004")) {
			HttpSession session = request.getSession();
			session.setAttribute("id", "admin");
			System.out.println(session.getId());
			System.out.println(session.getValue("id"));
			forward = new ActionForward();
			forward.setPath("/SelectAllList.do");
		} else {
			forward = new ActionForward();
			forward.setPath("/login.jsp");
		}

		return forward;
	}

}
