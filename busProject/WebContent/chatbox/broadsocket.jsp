<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[ broadSocket - format : JSON ]</title>
</head>
<body>
	<form>
		<input id="iMsg" type="text">
		<input value="send" onclick="sendMsg()" type="button">
	</form>
	<textarea id="msgs" rows="10" cols="50"></textarea>
	<script>
		var ws = new WebSocket("ws://localhost:8080/Busbusiness/broadsocket")
		var msgs = document.getElementById("msgs")
		
		ws.onmessage=function(msg){
			var jsonData = JSON.parse(msg.data)
			if(jsonData.message!=null){
				msg+=jsonData.message + "\n"
			}
			msgs.value += "Recieve From Server : "+msg.data+"\n"
		}
		function sendMsg(){
			var fMsg = document.getElementById("iMsg").value
			msg = fMsg.value
			ws.send(msg);
			fMsg.value = ""
		}
	</script>
</body>
</html>