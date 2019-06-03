package kr.or.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.service.ChartEmp;
import kr.or.bit.service.DeleteEmp;
import kr.or.bit.service.InsertEmp;
import kr.or.bit.service.LogOut;
import kr.or.bit.service.LoginOk;
import kr.or.bit.service.SearchEmpByDeptno;
import kr.or.bit.service.SearchEmpByEmpno;
import kr.or.bit.service.SelectAllList;
import kr.or.bit.service.UpdateEmp;
import kr.or.bit.service.UpdateEmpOk;

@MultipartConfig(
		location = "C:\\Users\\os\\Desktop\\Team2_MiniPJ_EMP\\WebContent\\img",
		maxFileSize = -1,
		maxRequestSize = -1,
		fileSizeThreshold = -1
		
		)



@WebServlet("*.do")
public class EmpFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EmpFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }


    
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
    	
    	System.out.println(requestURI);
    	System.out.println(contextPath);
    	System.out.println(url_Command);
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	if(url_Command.equals("/DeleteEmp.do")) { //삭제
    		try {
        		action = new DeleteEmp();
        		forward = action.execute(request, response);
    
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    		
    	}else if(url_Command.equals("/InsertEmp.do")) { //삽입
    		try {
        		action = new InsertEmp();
        		forward = action.execute(request, response);
        		
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    		
    	}else if(url_Command.equals("/SearchEmpByDeptno.do")) { //부서번호로검색
    		try {
        		action = new SearchEmpByDeptno();
        		forward = action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(url_Command.equals("/SearchEmpByEmpno.do")) { //사원번호로검색
    		try {
        		action = new SearchEmpByEmpno();
        		forward = action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(url_Command.equals("/UpdateEmp.do")) { //수정하기
    		try {
        		action = new UpdateEmp();
        		forward = action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(url_Command.equals("/UpdateEmpOK.do")) {
        		action = new UpdateEmpOk();
        		forward = action.execute(request, response);
    	}else if(url_Command.equals("/SelectAllList.do")) {//전체 목록보기
    		try {
				action = new SelectAllList();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(url_Command.equals("/add.do")) {
    		forward = new ActionForward();
    		forward.setPath("/WEB-INF/Ajax/Insert.jsp");
    	}else if(url_Command.equals("/search.do")) {
    		forward = new ActionForward();
    		forward.setPath("/WEB-INF/Ajax/Select.jsp");
    	}else if(url_Command.equals("/LoginOk.do")) {
    		action = new LoginOk();
    		forward = action.execute(request, response);
    	
    	}else if(url_Command.equals("/logout.do")){
    		action = new LogOut();
    		forward = action.execute(request, response);
    	}else if(url_Command.equals("/ChartEmp.do")) {//전체 목록보기
    		try {
				action = new ChartEmp();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(url_Command.equals("/main.do")) {
    		forward = new ActionForward();
    		forward.setPath("/WEB-INF/Ajax/home.jsp");
    	}
    	
    	if(forward != null) {
            RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
                rd.forward(request, response);
            }
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}