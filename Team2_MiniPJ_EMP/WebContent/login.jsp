<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.mid{
		display: flex;
	}
	
	.mid2{
		display: flex;
	}
	.sibal{
		margin : auto;
	}
	.sibal2{
		margin : auto;
	}
</style>
</head>
<body>
<div class="mid">
<img src="img/233.jpg" alt="왜 못찾아?" class="sibal">
</div>
<div class="mid2">
	<form action="LoginOk.do" method="post" class="sibal2">
		<div class = login>
		<input type="text" id="id" name="id" placeholder="ID">
		<input type="password" id="pwd" name="pwd" placeholder="PWD">
		<input type="submit" value="LOGIN">
		</div>
	</form>
</div>
</body>
</html>