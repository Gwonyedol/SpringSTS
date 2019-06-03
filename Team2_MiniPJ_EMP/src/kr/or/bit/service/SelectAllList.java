package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Dao;
import kr.or.bit.dto.Emp;

public class SelectAllList implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
        ActionForward forward = new ActionForward();
        try {
            Dao dao = new Dao();
            List<Emp> EmpList = dao.SelectAllList();
            
            request.setAttribute("emplist", EmpList);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        forward.setPath("/WEB-INF/Ajax/List.jsp");
        System.out.println(forward);
        return forward;
    }
}