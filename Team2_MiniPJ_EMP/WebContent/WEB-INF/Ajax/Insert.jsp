<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
	
	$(function(){
			//유효성 검사
			
				$('#exit').click(function() {
					$("#formContent").remove();
				});
				$('#exit').mouseout(function() {
					$('#exit').css("color", "black");
				});
				$("#exit").mouseover(function() {
					$("#exit").css("color", "#B24BE5");
				})
			
			
			$("#insertbtn").click(function(){
		         if($("#empno").val()==""){
		             alert("사원번호 입력");
		             $("#empno").focus();
		             return false;
		         }else if($("#ename").val() ==""){
		             alert("사원이름 입력");
		             $("#ename").focus();
		             return false;
		         }else if($("#job").val() ==""){
		                 alert("job입력");
		                 $("#job").focus();
		                 return false;
		         }else if($("#mgr").val() ==""){
	                 alert("mgr입력");
	                 $("#mgr").focus();
	                 return false;
	        	 }else if($("#hiredate").val() ==""){
                alert("hiredate입력");
                $("#hiredate").focus();
                return false;
       		 }else if($("#sal").val() ==""){
	              alert("sal입력");
	               $("#sal").focus();
	               return false;
	        	}else if($("#comm").val() ==""){
		              alert("comm입력");
		               $("#comm").focus();
		               return false;
		        	}else if($("#deptno").val() ==""){
			              alert("deptno입력");
			               $("#deptno").focus();
			               return false;
			        	}else{
		             $('#insertform').submit();
		         } 
		         
		     });

		});
</script>
<style type="text/css">
/* STRUCTURE */

.wrapper {
  display: flex;
  align-items: center;
  flex-direction: column; 
  justify-content: center;
  width: 100%;
  min-height: 100%;
  padding: 20px;
}

#formContent {
  -webkit-border-radius: 10px 10px 10px 10px;
  border-radius: 10px 10px 10px 10px;
  background: #fff;
  padding: 30px;
  width: 90%;
  max-width: 450px;
  position: relative;
  padding: 0px;
  -webkit-box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
  box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
  text-align: center;
}

#formFooter {
  background-color: #f6f6f6;
  border-top: 1px solid #dce8f1;
  padding: 25px;
  text-align: center;
  -webkit-border-radius: 0 0 10px 10px;
  border-radius: 0 0 10px 10px;
}

h2.inactive {
  color: #cccccc;
}

h2.active {
  color: #0d0d0d;
  border-bottom: 2px solid #5fbae9;
}

input[type=button], input[type=submit], input[type=reset]  {
  background-color: #8a0a8a;
  border: none;
  color: white;
  padding: 15px 80px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  text-transform: uppercase;
  font-size: 15px;
  -webkit-box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);
  box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);
  -webkit-border-radius: 5px 5px 5px 5px;
  border-radius: 5px 5px 5px 5px;
  margin: 5px 20px 40px 20px;
  -webkit-transition: all 0.3s ease-in-out;
  -moz-transition: all 0.3s ease-in-out;
  -ms-transition: all 0.3s ease-in-out;
  -o-transition: all 0.3s ease-in-out;
  transition: all 0.3s ease-in-out;
}

input[type=button]:hover, input[type=submit]:hover, input[type=reset]:hover  {
  background-color: 	#aa1eaa;
}

input[type=button]:active, input[type=submit]:active, input[type=reset]:active  {
  -moz-transform: scale(0.95);
  -webkit-transform: scale(0.95);
  -o-transform: scale(0.95);
  -ms-transform: scale(0.95);
  transform: scale(0.95);
}

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
  width: 85%;
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
  background-color: #FF9DFF;
  border-bottom: 2px solid #5fbae9;
}

input[type=text]:placeholder {
  color: #cccccc;
}

.fadeInDown {
  -webkit-animation-name: fadeInDown;
  animation-name: fadeInDown;
  -webkit-animation-duration: 1s;
  animation-duration: 1s;
  -webkit-animation-fill-mode: both;
  animation-fill-mode: both;
}

@-webkit-keyframes fadeInDown {
  0% {
    opacity: 0;
    -webkit-transform: translate3d(0, -100%, 0);
    transform: translate3d(0, -100%, 0);
  }
  100% {
    opacity: 1;
    -webkit-transform: none;
    transform: none;
  }
}

@keyframes fadeInDown {
  0% {
    opacity: 0;
    -webkit-transform: translate3d(0, -100%, 0);
    transform: translate3d(0, -100%, 0);
  }
  100% {
    opacity: 1;
    -webkit-transform: none;
    transform: none;
  }
}

@-webkit-keyframes fadeIn { from { opacity:0; } to { opacity:1; } }
@-moz-keyframes fadeIn { from { opacity:0; } to { opacity:1; } }
@keyframes fadeIn { from { opacity:0; } to { opacity:1; } }

.fadeIn {
  opacity:0;
  -webkit-animation:fadeIn ease-in 1;
  -moz-animation:fadeIn ease-in 1;
  animation:fadeIn ease-in 1;

  -webkit-animation-fill-mode:forwards;
  -moz-animation-fill-mode:forwards;
  animation-fill-mode:forwards;

  -webkit-animation-duration:1s;
  -moz-animation-duration:1s;
  animation-duration:1s;
}

.fadeIn.first {
  -webkit-animation-delay: 0.4s;
  -moz-animation-delay: 0.4s;
  animation-delay: 0.4s;
}

.fadeIn.second {
  -webkit-animation-delay: 0.6s;
  -moz-animation-delay: 0.6s;
  animation-delay: 0.6s;
}

.fadeIn.third {
  -webkit-animation-delay: 0.8s;
  -moz-animation-delay: 0.8s;
  animation-delay: 0.8s;
}

.fadeIn.fourth {
  -webkit-animation-delay: 1s;
  -moz-animation-delay: 1s;
  animation-delay: 1s;
}

.underlineHover:after {
  display: block;
  left: 0;
  bottom: -10px;
  width: 0;
  height: 2px;
  background-color: #56baed;
  content: "";
  transition: width 0.2s;
}

.underlineHover:hover {
  color: #0d0d0d;
}

.underlineHover:hover:after{
  width: 100%;
}

*:focus {
    outline: none;
} 

#icon {
  width:60%;
}



body {
    background-image: url( "img/photo.jpg" );
    background-size: 800px 800px;
    background-repeat:no-repeat;
    background-position: center;
}
</style>
<jsp:include page="../../common/top.jsp"></jsp:include>
	<%-- <jsp:include page="/common/header.jsp"></jsp:include> --%>
<br>
<br>
<br>
<div class="wrapper fadeInDown" style = "height : 857px; ">
 	<div id="formContent" >

   		<div class="fadeIn first" >
   		<br>
   		<br>
   		<div style="column-count: 2">
	<h3 style="position: relative; left : 105px;">사원 등록</h3><h3 id = "exit" style = "margin-left: 60%">x</h3>
	</div>
	<form id="insertform" name="insertform" action="InsertEmp.do" method="post">
		<table class="table" style="width: 400px; margin-left: auto; margin-right: auto;">

			<tr>
				<th>사번</th>
				<td><input type="text" class="form-control" name="empno" id="empno" style="width: 280px;"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" class="form-control" name="ename" id="ename" style="width: 280px;"></td>
			</tr>
			<tr>
				<th>직책</th>
				<td><input type="text" class="form-control" name="job" id="job" style="width: 280px;"></td>
			</tr>
			<tr>
				<th>담당자</th>
				<td><input type="text" class="form-control" name="mgr" id="mgr" style="width: 280px;"></td>
			</tr>
			<tr>
				<th>입사일</th>
				<td><input type="text" class="form-control" name="hiredate" id="hiredate" style="width: 280px;"></td>
			</tr>
			<tr>
				<th>급여</th>
				<td><input type="text" class="form-control" name="sal" id="sal" style="width: 280px;"></td>
			</tr>
			<tr>
				<th>수당</th>
				<td><input type="text" class="form-control" name="comm" id="comm" style="width: 280px;"></td>
			</tr>
			<tr>
				<th>부서번호</th>
				<td><input type="text" class="form-control" name="deptno" id="deptno" style="width: 280px;"></td>
			</tr>
			<tr>
				<td colspan="2">
					<p style="column-count: 2; text-align: center">
					<input type="button" value="사원등록" id="insertbtn" class = "btn btn-primary btn-lg" style="width: 100px; float: left;" /> 
					<input type="reset" value="입력취소" id="cancle" class = "btn btn-primary btn-lg" style="width: 100px;" />
					</p>
					
				</td>

			</tr>
		</table>
	</form>
	</div>
	</div>
	</div>