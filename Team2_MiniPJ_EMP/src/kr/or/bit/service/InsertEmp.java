package kr.or.bit.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Dao;
import kr.or.bit.dto.Emp;

public class InsertEmp implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		String hiredate = request.getParameter("hiredate");
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		int comm = Integer.parseInt(request.getParameter("comm"));
		int sal = Integer.parseInt(request.getParameter("sal"));
		int empno = Integer.parseInt(request.getParameter("empno"));
		int mgr = Integer.parseInt(request.getParameter("mgr"));
		///////////////////////////////////////////////////////////입력사항 받아오기
		Emp emp = new Emp();

		
		emp.setEmpno(empno);
		emp.setEname(ename);
		emp.setJob(job);
		emp.setMgr(mgr);
		emp.setHiredate(hiredate);
		emp.setSal(sal);
		emp.setComm(comm);
		emp.setDeptno(deptno);
		
		////////////////////////////////////////입력사항 emp객체에 넣어주기
		int add = 0;
		try {
			PrintWriter out = response.getWriter();
			Dao dao = new Dao();
			add = dao.InsertEmp(emp);
			////////////////////////////받아온 입력값 DB에 추가해주기
			if(add > 0 ) {
				out.print("<script>");
				out.print("alert('사원 등록 완료');");
				out.print("</script>");
			}else {
				out.print("<script>");
				out.print("alert('사원 등록을 실패하였습니다.');");
				out.print("</script>");
			}
		}catch (Exception e) {
			System.out.println("insert[추가] 오류 : " + e.getMessage());
		}
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("/SelectAllList.do"); //나중에 추가될 list페이지 주소 ex)SelectAllList.do
		return forward;
		
	}

}