<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://www.gstatic.com/firebsejs/4.2.0/firebase-app.js"></script>
	<script src="https://www.gstatic.com/firebsejs/4.2.0/firebase-firestore.js"></script>
	<script src="resources/sockjs.min.js"></script>
	<script src="resources/app.js"></script>
</head>
<body>
	<div style = "font-size:14px;border-radius:10px 10px 0px 0px;color:white;font-weight:bold;background-color : black;margin : 0px 50px 0px 50px;width:50%;padding : 8px 0px 8px 30px">
	비트캠프 채팅방</div>
	<div id="chat" style = "background-color:#F2F2F2;width:50%;height:500px;resize: none;padding : 30px 0px 0px 30px;
						    overflow: auto;margin : 0px 50px 20px 50px;border-radius: 0px 0px 10px 10px"></div>
						    
	<form id="chatForm" style = " margin:0px 50px 50px 50px;" >
		사용자 : <input type="text" id="name" style = "width : 55px;"/><br>
		메세지 : <input type="text" id="message"/>
		<button>보내기</button>
	</form>
	<script>
	
	
		function moveScroll() { 
			var el = document.getElementById("chat"); 
			if (el.scrollHeight > 0) el.scrollTop = el.scrollHeight; 
		} 


		$(document).ready(function(){
			$("#chatForm").submit(function(event){
				event.preventDefault();
				if($('#name').val()===''){alert('이름을 입력하세요');$('#name').val('').focus()}
				else if($('#message').val()===''){alert('메세지를 입력하세요');$('#message').val('').focus()}
				else{				
					sock.send("<b>"+$("#name").val()+"</b> : "+$("#message").val());
					$("#message").val('').focus();
					//sock.send는 웹소켓으로 메세지를 전달해준다
				}

			});
		});
		
		//WebSocket을 지정한 URL로 가서 연결한다
		//서버랑 연결하고 echohandler가서 출력한다
		var sock = new SockJS("/echo");
		
		
		//sock 서버가 켜지면 뜨는 메세지
		sock.onopen = function(){
			$("#chat").append("<center>채팅방 입장 성공</center> <br>");
		}
		
		sock.onmessage = function(e){
			$("#chat").append(e.data + "<br>");
			$("#chat").scrollTop($("#chat")[0].scrollHeight);  //채팅글이 많아져서
			//스크롤이 생기면 자동으로 내려주는 메소드
		}
		
		sock.onclose = function(){
			$("#chat").append("연결 종료");
		}
		
	</script>
</body>
</html>
