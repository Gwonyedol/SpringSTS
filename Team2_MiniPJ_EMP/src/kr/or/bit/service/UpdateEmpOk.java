package kr.or.bit.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Dao;
import kr.or.bit.dto.Emp;

public class UpdateEmpOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        ActionForward forward= null;
        int empno=Integer.parseInt(request.getParameter("empno"));
        
        System.out.println("경로" + request.getContextPath());
        String filename = "";
        try {
            String uploadpath = "C:\\FrontAndBackAnd\\Wep\\WepClientLabs\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Team2_MiniPJ_EMP";
            String root = uploadpath + "/img/";
			Part part = request.getPart("image");
	        System.out.println("파일 업로드 접근전");
	        if(part.getHeader("Content-Disposition").contains("filename=")) {
	        	System.out.println("disposition 접근");
	        	filename = part.getSubmittedFileName();
	        	System.out.println("filename 받아왔다. q" + filename);
	        	if(part.getSize() > 0) {
	        		System.out.println("파일 가져와서 사이즈 측정");
	        		part.write(root +"/"+ filename);
	        		part.delete();
	        	}
	        }
        } catch (IOException | ServletException e1) {
			System.out.println("e1에러" +  e1.getMessage());
		}
        
        System.out.println("asdasdsd"+empno);
        int row = 0;
        PrintWriter out = null;
        try {
            Dao dao = new Dao();
            Emp emp = new Emp();
            out = response.getWriter();
            
            emp.setEmpno(empno);
            
            emp.setEname(request.getParameter("ename"));
            emp.setJob(request.getParameter("job"));
            emp.setHiredate(request.getParameter("hiredate"));
            emp.setMgr(Integer.parseInt(request.getParameter("mgr")));
            emp.setSal(Integer.parseInt(request.getParameter("sal")));
            emp.setComm(Integer.parseInt(request.getParameter("comm")));
            emp.setDeptno(Integer.parseInt(request.getParameter("deptno")));
            emp.setFilepath(("img/"+filename).trim());
            row = dao.UpdateEmp(emp);
            
			if(row>0) {
				out.print("<script>alert('수정 성공');</script>");
			}else {
				out.print("<script>alert('수정 실패');</script>");
			}
			            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        forward = new ActionForward();
        forward.setPath("/SelectAllList.do");
        
        return forward;
    }

}
