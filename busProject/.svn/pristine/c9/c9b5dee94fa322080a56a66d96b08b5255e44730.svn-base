<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[ clientSocket - format : JSON ]</title>
</head>
<body>
	<form>
		<input id="iMsg" type="text">
		<input value="send" onclick="sendMsg()" type="button">
		<input value="disconnect" onclick="disconnecte()" type="button">
	</form>
	<textarea id="msgs" rows="10" cols="50"></textarea>
	<script>
		var ws = new WebSocket("ws://localhost:8080/Busbusiness/webChat3")
		var msgs = document.getElementById("msgs")
		
		ws.onopen=function(msg){
			msgs.value += "Server Connect\n"
		}
		ws.onclose=function(msg){
			msgs.value += "Server Close\n"
		}
		ws.onerror=function(msg){
			msgs.value += "Server Error\n"
		}
		ws.onmessage=function(msg){
			msgs.value += "Recieve From Server : "+msg.data+"\n"
		}
		
		function sendMsg(){
			var fMsg = document.getElementById("iMsg").value
			msg = fMsg.value
			msgs.value += "send to Server : " + msg + "\n"
			
			ws.send(msg);
			fMsg.value = ""
		}
		function disconnect(){
			ws.close()
		}
	</script>
</body>
</html>