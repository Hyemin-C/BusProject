<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../header.jsp" %>
<%
	// 세션값 가져오기
	// http://220.70.27.150:8080/bookTest1/chatbox_form_sample/admin.jsp?sid=admin
	// http://220.70.27.150:8080/bookTest1/chatbox_form_sample/admin.jsp?sid=
	// http://220.70.27.150:8080/bookTest1/chatbox_form_sample/admin.jsp?sid=
	// http://220.70.27.150:8080/bookTest1/chatbox_form_sample/_s2.html
	//String sid = (String)session.getAttribute("sId");
	String sid = (String) request.getParameter("sid");
	System.out.println("sid = " + sid);
	//if(sid == null || !sid.equals("admin")){
	if(sid == null || !sid.equals("admin")){
%>
	<script type="text/javascript">
    alert("관리자가 아닙니다.");
    history.back(-1);
	</script>
<%
	}
%>
<!DOCTYPE html>
<html>
<head>
<title>관리자 회원채팅 관리</title>
	<style>
		.float-left{
			float:left;
			margin: 5px;
		}
	</style>
</head>
<body>
	<div class="template" style="display:none">
		<form>
			<input type="text" class="message" onkeydown="if(event.keyCode === 13) return false;">
			<input value="Send" type="button" class="sendBtn">
		</form>
		<br />
		<textarea rows="10" cols="50" class="console" disabled="disabled"></textarea>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script type="text/javascript">
		var protocol = "ws:";
		var vChatUrl, sChatUrl;
		var sChat = "admin";//var sChat = "webChat3";
		var vChat = "chatbox/aChat.jsp";
		var stx = window.location.origin;
		var ctx = location.href.replace(window.location.origin,"").split("/").slice(0,2).join("/");// 서버에 올릴때 처리 않함
		var aCtx = protocol+window.location.origin.replace(window.location.protocol,"") + ctx;
		console.log(vChatUrl = stx + ctx + "/" + vChat)//ws://localhost:8080/webChat3
		console.log(sChatUrl = aCtx + "/" + sChat)//http://localhost:8080/bookTest1/chatbot/chatbot2.jsp
	</script>
	<script type="text/javascript">
		// var ws = new WebSocket("ws://localhost:8080/bookTest1/admin");
		//var ws = new WebSocket("ws://220.70.27.150:8080/bookTest1/admin");
		var ws = new WebSocket(sChatUrl);
		ws.onopen = function(msgs) { };
		ws.onclose = function(msgs) { };
		ws.onerror = function(msgs) { };
		ws.onmessage = function(msgs) {			
			// visit, message, bye
			// data-clientid,  node.status, node.user, node.message
			let node = JSON.parse(msgs.data);
			if(node.status === "visit") {
				let form = $(".template").html();
				form = $("<div class='float-left'></div>").attr("data-clientid",node.user).append(form);
				$("body").append(form);
			} else if(node.status === "message") {
				let $div = $("[data-clientid='"+node.user+"']");
				let log = $div.find(".console").val();//content.value
				$div.find(".console").val(log + "(user) => " + node.message + "\n");
			} else if(node.status === "bye") {
				$("[data-clientid='"+node.user+"']").remove();
			}
		};
		$(document).on("keydown", ".message", function(){
			if(event.keyCode === 13) {
				$(this).closest(".float-left").find(".sendBtn").trigger("click");
				return false;
			}
			return true;
		});		
		$(document).on("click", ".sendBtn", function(){
			let $div = $(this).closest(".float-left");
			let msgs = $div.find(".message").val();
			let client = $div.data("clientid");
			let log = $div.find(".console").val();
			$div.find(".console").val(log + "(me) => " + msgs + "\n");
			$div.find(".message").val("");
			ws.send(client+"#####"+msgs);
		});
	</script>
</body>
</html>