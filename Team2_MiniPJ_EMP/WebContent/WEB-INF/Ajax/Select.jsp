<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<script type="text/javascript">
	function myFunction() {
				
		
		var type = document.getElementById("searchType").value;
		
		
		if(type=="empno"){
			document.getElementById("one").style.display="block";
			document.getElementById("two").style.display="none";
			document.getElementById("three").style.display="block";
			document.getElementById("four").style.display="none";
		} else if(type=="deptno") {
			document.getElementById("two").style.display="block";
			document.getElementById("one").style.display="none";
			document.getElementById("four").style.display="block";
			document.getElementById("three").style.display="none";
		}
		
		
	}
	</script>
		<style type="text/css">
	input[type=text] {
  background-color: #FFDCE1;
  border: none;
  color: #0d0d0d;
  padding: 10px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 5px;
  width : 300px;
  border: 2px solid #f6f6f6;
  -webkit-transition: all 0.5s ease-in-out;
  -moz-transition: all 0.5s ease-in-out;
  -ms-transition: all 0.5s ease-in-out;
  -o-transition: all 0.5s ease-in-out;
  transition: all 0.5s ease-in-out;
  -webkit-border-radius: 5px 5px 5px 5px;
  border-radius: 5px 5px 5px 5px;
}

	input[type=text]:focus {
	width : 300px;
  background-color: #fff;
  border-bottom: 2px solid #5fbae9;
}

	input[type=text]:placeholder {
  color: #cccccc;
}
	#controllselect {
	width : 400px
}
	#tablediv {
	width : 75%;
	margin-left: 12%;
	}
	#tablediv table {
	
		    font-family: arial, sans-serif;
		    border-collapse: collapse; /* 붕괴하다 , 무너지다 */
		    
		}
		
	#tablediv th {
		    border: 1px solid #dddddd;
		    text-align: center;
		    padding: 8px;
		}
	#tablediv td{
			font-size : 15px;
			font-family : 맑은 고딕;
		    border: 1px solid #dddddd;
			text-align: center;
			padding: 8px;
			font-weight : 400;
		}
	#tablediv tr:nth-child(even) {  /* even 짝수     odd 홀수 */
		    background-color: #dddddd;
		}
		
	</style>
	
<jsp:include page="../../common/top.jsp"></jsp:include>
<br>
<br>
	<div class="table">
		<!-- 회원검색 -->
		<center><div id = "controllselect">
		<select class="form-control" id=searchType style= "float: left" onchange="myFunction()">
			<option value="#">선택해주세요</option>
			<option value="empno">사원번호</option>
			<option value="deptno">부서번호</option>
		</select>
		<div style="display:block" id="one">
		<form action="SearchEmpByEmpno.do" method="post">
				<input type="text" name="empno" id="empno" class = "form-control" placeholder="사원번호를 입력하세요" />
				<input type="submit" value="검색" id="searchbtn"
					class="btn btn-primary btn-lg" />
		</form> 		
		</div>
		
		<div style="display:none" id="two">
			<form action="SearchEmpByDeptno.do" method="post">
				<input type="text" name="deptno" id="deptno" placeholder="부서번호를 입력하세요" />
				<input type="submit" value="검색" id="searchbtn"
					class="btn btn-primary btn-lg" />
			</form>
		</div>
	</div>
	</div></center>
	<hr>

<div id="four" >
<div id = "tablediv">
	 <table class="table table-hover">
	 
	<tr class ="table-primary"><td><b>사원번호</b></td><td><b>사원이름</b></td><td><b>직업</b></td><td><b>관리자</b></td><td><b>입사일</b></td><td><b>연봉</b></td><td><b>수당</b></td><td><b>부서명</b></td></tr>
	
	<c:set var="emp" value="${requestScope.EmpListByEmpno}"></c:set>
	<tr class ="table-primary">
			<td>${emp.empno}</td>
			<td>${emp.ename}</td>
			<td>${emp.job}</td>
			<td>${emp.mgr}</td>
			<td>${emp.hiredate}</td>
			<td>${emp.sal}</td>
			<td>${emp.comm}</td>
			<td>${emp.deptno}</td>
		</tr>

	<c:forEach items="${requestScope.EmplistByDeptno}" var="list">

		<tr class ="table-primary">
			<td>${list.empno}</td>
			<td>${list.ename}</td>
			<td>${list.job}</td>
			<td>${list.mgr}</td>
			<td>${list.hiredate}</td>
			<td>${list.sal}</td>
			<td>${list.comm}</td>
			<td>${list.deptno}</td>
		</tr>
		</c:forEach>
	</table>