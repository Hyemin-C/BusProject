<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="icon" href="data:;base64,iVBORw0KGgo=">
	<!-- https://stackoverflow.com/questions/31075893/im-getting-favicon-ico-error -->
	<title>[ 2020. 9. 24.오전 11:17:16 ]</title>
</head>
<body>
	<input onclick="sMsg()" value="send" type="button">
	<input onclick="disCon()" value="DisConnect" type="button">
	<br/>
	<textarea id="msg" rows="30" cols="50"></textarea>
</body>
	<script>
		var ws = new WebSocket("ws://localhost:8080/Busbusiness/webChat3")
		var msgBox = document.getElementById("msg")
		
		ws.onopen = function(msg){
			msgBox.value += "ServerConnnect \n"
		}
		ws.onclose = function(msg){
			msgBox.value += "ServerClose \n"
		}
		ws.onmessage = function(msg){
			msgBox.value += "ServerMessage " + msg.data + "\n"
		}
		ws.onerror = function(msg){
			msgBox.value += "ServerConnnect \n"
		}
		function sMsg()
		{
			msgBox.value += "getHttpSession \n"
			ws.send("userSend")
		}
		function disCon()
		{
			ws.close();
		}
	</script>
</html>