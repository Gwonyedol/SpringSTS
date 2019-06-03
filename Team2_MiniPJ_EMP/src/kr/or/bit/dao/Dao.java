package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.bit.dto.Emp;

/*
 
 CREATE TABLE EMP
(EMPNO number not null,
ENAME VARCHAR2(10),
JOB VARCHAR2(9),
MGR number ,
HIREDATE date,
SAL number ,
COMM number ,
DEPTNO number );
--alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';
 */

/*
 EMP , DEPT 

--------------------------------------------
1. 조회기능 (EMP 데이터 조회)

1.1 사원번호 조회

1.2 부서번호 조회
부서번호는 load 시에 비동기로 데이터
select Tag change 이벤시  데이터 비동기 조회

-------------------------------------------
2. 사원등록 기능 
-------------------------------------------
3. 사원수정 기능
-------------------------------------------
4. 사원삭제 기능
-------------------------------------------
5. 사원 사진 파일 업로드 
   Table
   사번
   파일명
   보기기능
   다운로드기능
------------------------------------------- 
6. 관리자 기능  (session 처리 : login - logout)
//관리자 로그인 리스트 테이블을 만듭니다  
create table adminlist(
userid varchar2(20) not null,
pwd varchar2(20) not null
);

//관리자를 입력
insert into adminlist values('admin', '1004');
insert into adminlist values('adminkim', '1234');

-----------------------------------------------------
예제)
WebServlet_9_memo_mvc_url_Interface

가지는 package 구조 : Model2 기반 MVC
Webcontent 구조 
---------------------------------------------------- 
 
 * */



public class Dao {
	DataSource ds = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public Dao() { //constructer 사용 커넥션
		try {
			  Context context = new InitialContext(); //이름기반 검색
			 ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			
		}catch (Exception e) {
			System.out.println("look yp Fail"+ e.getMessage());
		}
	}
	
	public List<Emp> SelectAllList() {// 전체 테이블 보기
	      
		  PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      List<Emp> Emplist = new ArrayList<>();
	      
	      try {
	    	 conn = ds.getConnection();
	         String sql = "select * from emp";
	         pstmt = conn.prepareStatement(sql);
	                  
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()){
	            Emp Emp = new Emp();
	            Emp.setEmpno(rs.getInt("empno"));
	            Emp.setEname(rs.getString("ename"));
	            Emp.setJob(rs.getString("job"));
	            Emp.setMgr(rs.getInt("mgr"));
	            Emp.setHiredate(rs.getString("hiredate"));
	            Emp.setSal(rs.getInt("sal"));
	            Emp.setComm(rs.getInt("comm"));
	            Emp.setDeptno(rs.getInt("deptno"));
	            Emp.setFilepath(rs.getString("filepath"));
	            Emplist.add(Emp);
	         }
	         
	      } catch (Exception e) {
	         System.out.println(e.getMessage());
	      }finally{
				if(rs!=null) try {rs.close();}catch(Exception e) {}
	    	  	if(pstmt!=null) try{pstmt.close();}catch (Exception e){}
				if(conn!=null) try{conn.close();}catch (Exception e){} //반환
	      }
	      return Emplist;
	}
	
	
	
	public Emp SelectByEmpno(int empno) {//번호로 사원조회
		     
		  PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      Emp Emp= new Emp();
	      
	      try {
	    	 conn = ds.getConnection();
	         String sql = "select * from emp where empno= ?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, empno);
	                  
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()){
	            Emp.setEmpno(rs.getInt("empno"));
	            Emp.setEname(rs.getString("ename"));
	            Emp.setJob(rs.getString("job"));
	            Emp.setMgr(rs.getInt("mgr"));
	            Emp.setHiredate(rs.getString("hiredate"));
	            Emp.setSal(rs.getInt("sal"));
	            Emp.setComm(rs.getInt("comm"));
	            Emp.setDeptno(rs.getInt("deptno"));
	            Emp.setFilepath(rs.getString("filepath"));
	         }
	         
	      } catch (Exception e) {
	         System.out.println(e.getMessage());
	      }finally{
				if(rs!=null) try {rs.close();}catch(Exception e) {}
	    	  	if(pstmt!=null) try{pstmt.close();}catch (Exception e){}
				if(conn!=null) try{conn.close();}catch (Exception e){} //반환
	      }
	      return Emp;
	}
	
	
	
	public List<Emp> SelectByDeptno(int deptno) {//부서번호로 조회하기
		
	      
		  PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      List<Emp> Emplist = new ArrayList<>();
	      
	      try {
	    	 conn = ds.getConnection();
	         String sql = "select * from emp where deptno=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, deptno);
	                  
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()){
	            Emp Emp = new Emp();
	            Emp.setEmpno(rs.getInt("empno"));
	            Emp.setEname(rs.getString("ename"));
	            Emp.setJob(rs.getString("job"));
	            Emp.setMgr(rs.getInt("mgr"));
	            Emp.setHiredate(rs.getString("hiredate"));
	            Emp.setSal(rs.getInt("sal"));
	            Emp.setComm(rs.getInt("comm"));
	            Emp.setDeptno(rs.getInt("deptno"));
	            Emplist.add(Emp);
	         }
	         
	      } catch (Exception e) {
	         System.out.println(e.getMessage());
	      }finally{
				if(rs!=null) try {rs.close();}catch(Exception e) {}
	    	  	if(pstmt!=null) try{pstmt.close();}catch (Exception e){}
				if(conn!=null) try{conn.close();}catch (Exception e){} //반환
	      }
	      return Emplist;
	}
	
	public int InsertEmp(Emp emp) {//사원정보 입력하기
		int row = 0;
		 try {
	         conn = ds.getConnection();
	         String sql = "insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(?,?,?,?,?,?,?,?)"; 
	         pstmt = conn.prepareStatement(sql);
	                  
	         pstmt.setInt(1, emp.getEmpno());
	         pstmt.setString(2, emp.getEname());
	         pstmt.setString(3, emp.getJob());
	         pstmt.setInt(4, emp.getMgr());
	         pstmt.setString(5, emp.getHiredate());
	         //pstmt.setDate(5, (Date) dto.getHiredate());
	         pstmt.setInt(6, emp.getSal());
	         pstmt.setInt(7, emp.getComm());
	         pstmt.setInt(8, emp.getDeptno());
	         row = pstmt.executeUpdate();
	         
	      } catch (Exception e) {
	         System.out.println(e.getMessage());
	      }finally{
	    	  	if(pstmt!=null) try{pstmt.close();}catch (Exception e){}
				if(conn!=null) try{conn.close();}catch (Exception e){} //반환
	      }
		return row;
	}
	
	
	public int UpdateEmp(Emp emp) {//사원정보 업데이트하기
		int row = 0;
		   PreparedStatement pstmt = null;
    
		         try{
		            conn = ds.getConnection();
		            String sql="update emp set job=?, ename=?, mgr=?, sal=?, comm=?, deptno=? , filepath=? where empno=?";
		            pstmt = conn.prepareStatement(sql);
		            pstmt.setString(1, emp.getJob());
		            pstmt.setString(2, emp.getEname());
		            pstmt.setInt(3, emp.getMgr());
		            pstmt.setInt(4, emp.getSal());
			        pstmt.setInt(5, emp.getComm());
			        pstmt.setInt(6, emp.getDeptno());
			        pstmt.setString(7,(String)emp.getFilepath());
			        pstmt.setInt(8, emp.getEmpno());
			        row = pstmt.executeUpdate();
			         //pstmt.setDate(5, (Date) dto.getHiredate());
		                       
		            row=pstmt.executeUpdate();      

		         }catch(Exception e){
		            System.out.println(e.getMessage());
		         }finally {
			    	 if(pstmt!=null) try{pstmt.close();}catch (Exception e){}
					if(conn!=null) try{conn.close();}catch (Exception e){} //반환
		         }
		         return row;
	   }

	public int DeleteEmp(int empno) {//번호로 정보삭제
		  int row = 0;
	      PreparedStatement pstmt = null;

	      try{
	         conn = ds.getConnection();
	         String sql = "delete from emp where empno=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, empno);
	         row = pstmt.executeUpdate();

	      }catch(Exception e){
	         System.out.println(e.getMessage());
	      }finally {
		    if(pstmt!=null) try{pstmt.close();}catch (Exception e){}
			if(conn!=null) try{conn.close();}catch (Exception e){} //반환
	      }
		return row;
	}
}
