<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tomcat Connection Pool</title>
</head>
<body>
	<%
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
	
		Context context = new InitialContext(); //이름기반 검색
		//context.lookup("java:comp/env/jdbc/oracle"); // jdbc/oracle pool 검색
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		//ds.getConnection(); //pool안에 있는 connection 객체
		conn = ds.getConnection(); //얻어오기
		out.println("db연결 됐는지 : " + conn.isClosed()+"<br>");
		
		conn.close(); //여기서는 닫아주는게 아닌 , 객체를 pool에 다시 반환시키는 것으로 인지.
		out.println("db연결 됐는지 : " + conn.isClosed()+"<br>");
	%>
</body>
</html>