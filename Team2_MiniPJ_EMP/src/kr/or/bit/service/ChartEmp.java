package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Dao;
import kr.or.bit.dto.Emp;

public class ChartEmp implements Action {

	@Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
        ActionForward forward = null;
        JSONObject jsonObject = new JSONObject();
        //deptno의 JSON정보를 담을 Array 선언   
        JSONArray deptnolist = new JSONArray();
        
        try {
            Dao dao = new Dao();
            List<Emp> EmpList = dao.SelectAllList();
            
            for(int i = 0; i < EmpList.size(); i++) {
                Emp e = EmpList.get(i);
                  //deptno의 한명 정보가 들어갈 JSONObject 선언
                  JSONObject deptnoinfo = new JSONObject();
                  deptnoinfo.put("empno", e.getEmpno());
                  deptnoinfo.put("ename", e.getEname());
                  deptnoinfo.put("job", e.getJob());
                  deptnoinfo.put("mgr", e.getMgr());
                  deptnoinfo.put("hiredate", e.getHiredate().toString());
                  deptnoinfo.put("sal", e.getSal());
                  deptnoinfo.put("comm", e.getComm());
                  deptnoinfo.put("deptno", e.getDeptno());
                  
                  deptnolist.add(deptnoinfo);
             }
             jsonObject.put("emplist", deptnolist);

             System.out.println("전체 : " + jsonObject);
                 
            
            
            
            request.setAttribute("emplist", jsonObject);
            forward = new ActionForward();
            forward.setPath("/WEB-INF/Ajax/main.jsp");
            System.out.println(forward);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return forward;
    }
}



