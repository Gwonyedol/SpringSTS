package kr.or.bit.service;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Dao;

public class DeleteEmp implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//return null;
		ActionForward forward=null;
		PrintWriter out = null;
		try {
			out = response.getWriter();
			int empno = Integer.parseInt(request.getParameter("empno"));
			Dao dao = new Dao();
			int result = dao.DeleteEmp(empno);
			
			if(result>0) {
				out.print("<script>alert('삭제 성공');</script>");
			}else {
				out.print("<script>alert('삭제 실패');</script>");
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		forward = new ActionForward();
		forward.setPath("/SelectAllList.do");
		
		return forward;
	}
	
}