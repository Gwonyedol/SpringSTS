<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
	          $('input[name=edit]').click(function(){
	                var index = $('input[name=edit]').index(this);
	                var url = $('#editform').attr('action');
	                var empno = $("input[name=editno]").eq(index).val()
	                console.log('url '+url);
	                
	                
	                $.ajax({
	                    url : url,
	                    data : {empno:$("input[name=editno]").eq(index).val()},
	                    type : "post",
	                    success : function(data){
	                            $("#listtable").empty();
	                            $("#listtable").append(data);
	                            
	                    },
	                    error : function(xhr){
	                        alert('이동 실패 : ' + xhr.status );
	                    }
	                });
	                    
	                
	            });
	            
	            $('input[name=delete]').click(function(){
	                var index = ($('input[name=delete]').index(this));
	                var url = $('#deleteform').attr('action');
	                console.log($('input[name=delno]').eq(index).val());
	                
	                var check = confirm("정말로 삭제하시겠습니까?")
	            
	                if(check) {
	                    alert('삭제실행');
	                    console.log(check);
	                }else {
	                      alert('삭제를 취소합니다.');
	                      return
	                }
	                
	                $.ajax({
	                    url : url,
	                    data : {empno:$('input[name=delno]').eq(index).val()},
	                    type : "post",
	                    datatype : "html",
	                    success : function(data){
	                        alert($('input[name=delno]').eq(index).val() + "번 사원 삭제 완료");
	                            $("#listtable").empty();
	                                $("#listtable").append(data);
	                        

	                        
	                    },
	                
	                    error : function(xhr){
	                        alert('삭제 실패 : ' + xhr.status );
	                    }
	                });
	                
	                
	            });
	        });
	</script>
	<style type="text/css">
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
	#namephoto {
		text-decoration: none;
	}
	#namephoto:hover {
	color: white;
	}
	
	</style>
</head>
<body>

<div id = "listtable">
<jsp:include page="../../common/top.jsp"></jsp:include>
<br>
	<div id = "tablediv">
	<table class="table table-hover" border="1">
		  <thead>
		<tr>
		<th>사원 번호</th><th>사원 이름</th><th>사원 직책</th><th>담당 선임</th><th>입사일</th><th>월급</th><th>추가급여</th><th>부서번호</th><th>수정</th><th>삭제</th>
		</tr>
		  </thead>
		    <tbody>
		<c:forEach var = "list" items = "${requestScope.emplist }">
		<tr class ="table-primary" id = "row" name = "row">
		<td>${list.empno }</td>
		<td><a href ="${list.filepath }" id="namephoto">${list.ename }</a></td>
		<td>${list.job }</td>
		<td>${list.mgr }</td>
		<td>${list.hiredate}</td>
		<td>${list.sal }</td>
		<td>${list.comm }</td>
		<td>${list.deptno }</td>
		<td>
		<from action = "UpdateEmp.do" method = "post" id = "editform">
		<input type = "button" class = "btn btn-outline-primary" name = "edit"id = "edit" value = "수정">
		<input type = "hidden" name = "editno${var.index }"id = "editno${var.index }" value = "${list.empno }">
		</form>
		</td>
		<td>
		<form action = "DeleteEmp.do" method = "post" id = "deleteform">
		<input type = "button" class = "btn btn-outline-primary" name = "delete"id = "delete" value = "삭제">
		<input type = "hidden" name = "delno${var.index }"id = "delno${var.index }" value = "${list.empno }">
		</form>
		</td>
		</tr>
		</c:forEach>
		</tbody>
		
	</table>
	</div>
</div>
</body>
</html>