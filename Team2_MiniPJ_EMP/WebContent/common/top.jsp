<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="css/bootstrap.css" media="screen">	
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>    
    
    
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="main.do">EMP Table</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarColor01">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="SelectAllList.do">사원 리스트 </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="add.do">사원 추가하기</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="search.do">검색하기</a>
      </li>
    </ul>
    </form>

		<c:choose>
			<c:when test="${sessionScope.id == 'admin'}">
				<b style = "color : white;">${sessionScope.id }님 환영합니다</b>
				<a href="logout.do" style = "color : white" id = "logout">[로그아웃]</a>
			</c:when>
			<c:otherwise>
				
				<c:redirect url="../login.jsp"></c:redirect>
			</c:otherwise>
</c:choose>   

	
  </div>
</nav>