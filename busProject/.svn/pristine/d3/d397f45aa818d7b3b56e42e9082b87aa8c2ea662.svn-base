<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>관리자와 회원 고객상담 채팅</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" type="text/css" href="../css/b_main.css"/>
	<style type="text/css">
	  body{
	    padding: 0;
	    background-image: url("../img/main.jpg");
	    background-repeat: no-repeat;
	    background-size: cover;
	    background-attachment: fixed;
	  }
	</style>
	<style type="text/css">
		#chat-doc {
			z-index:1;
		    width: 100%;
		    height:600px;
		    overflow: auto;
		    border: 1px solid black;
			background-image: url("../images/aaa.gif"), url("../images/bbb.gif");
			opacity: 0.8!important; filter:alpha(opacity=80);
			background-color: #cccccc;
			background-position: center; /* Center the image */
			background-repeat: no-repeat; /* Do not repeat the image */
			background-size: cover; /* Resize the background image to cover the entire container */
		}
		#chat-doc div {
		    margin: 10px;
		    padding: 10px;
		    /* background: #eee; */
		}
		.boxL {
		    text-align:left;
		}
		.boxR {
		    text-align:right;
		}
	</style>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>

	<div class="chat-box">
		<div id="chat-doc"></div>
		<span>
			<form>
				<img src="../images/x.gif" width="20px" height="20px">
				<input type="text" id="user" value="손님">
				<input type="text" id="msg" placeholder="입력">
				<input type="button" id="sendBtn" value="보내기">
				<input type="button" id="closeBtn" value="접속종료">
			</form>
		</span>

	</div>

</body>
	<script type="text/javascript">
		var protocol = "ws:";
		var vChatUrl, sChatUrl;
		var sChat = "webChat3";//var sChat = "webChat3";
		var vChat = "chatbox/mChat.jsp";
		var stx = window.location.origin;
		var ctx = location.href.replace(window.location.origin,"").split("/").slice(0,2).join("/");// 서버에 올릴때 처리 않함
		var aCtx = protocol+window.location.origin.replace(window.location.protocol,"") + ctx;
		console.log(vChatUrl = stx + ctx + "/" + vChat)//ws://localhost:8080/webChat3
		console.log(sChatUrl = aCtx + "/" + sChat)//http://localhost:8080/bookTest1/chatbot/chatbot2.jsp
	</script>
	<script type="text/javascript">
		var ws = new WebSocket(sChatUrl);
		ws.onopen=function(msgs){ }
		ws.onclose=function(msgs){ }
		ws.onerror=function(msgs){ }
		ws.onmessage=function(msgs){
			/* mB.add+="Receive => " + msg.data+"\n"; */
			msg = "Receive => " + msgs.data;
			onSMsg(msg);
		}
	</script>
	<script type="text/javascript">
    var i = 0;
   	var sendBtn = document.getElementById("sendBtn");
   	var closeBtn = document.getElementById("closeBtn");
	var $user = document.getElementById("user");
	var $msg = document.getElementById("msg");
	var $div, msg;
   	//var objDiv = document.getElementById("chat-doc");
	var lChats = document.getElementById("chat-doc");
	var obs = new MutationObserver(function(t_races) {
		var newNodesHeight = t_races.reduce(function(sum, t_race) {
        	return sum + [].slice.call(t_race.addedNodes)
            .map(function (node) { return node.scrollHeight || 0; })
            .reduce(function(sum, height) {return sum + height});
		}, 0);
	    if (lChats.clientHeight + lChats.scrollTop + newNodesHeight -1 < lChats.scrollHeight) {
	        lChats.scrollTop = lChats.scrollHeight;
	    }
	});
	obs.observe(lChats, {childList: true});
		


  	sendBtn.addEventListener('click', function(e){
  		console.log('send - mouseClick')
		$user = document.getElementById("user");
		$msg = document.getElementById("msg");
		//msg;

		if($msg.value!="") {
			$msg.value = $msg.value.replace(/^\s+|\s+$|\n|\r/gi, "");
			msg = "{{" + $user.value + "}}" + $msg.value;
			$msg.value="";
			onCMsg(msg);
		}
  	});
  	closeBtn.addEventListener('click', function(e){
  		console.log('disConnect - mouseClick')
		$msg.value="";
  		onCClose(msg);
  	});
  	function onSMsg(msg){
  		console.log('sMsgSend')
  		$div = createDiv("boxL");
  		$div.innerHTML = '<img src="../images/2.gif" width="30px" height="30">' + msg + '</a>';
  		lChats.appendChild($div);
  	}
  	function onCMsg(msg){
  		console.log('cMsgSend')
		if(msg!="") {// 메세지는 안전성을 고려하여 callback() 메세지 처리로 한라인씩 처리
		  	// 1초단위로 메세지콜백이 없으면 비전송(x)으로 표기
			// 메세지 보내고 대기아이콘 올린다.
			// 글쓰기창 / 글전송 버튼 비활성화 시킨다.
			// 그사이에 다른 메세지가 오면 채팅창에 표시한다.
			// 글쓰기창 / 글전송 버튼 활성화 시킨다.
			// 서버에서 메세지가 오면 채팅창에 자신의 글을 올린다.
			ws.send(msg); 
		}
  		// 자신의 메세지는 오른쪽
  		$div=createDiv("boxR"); // $div=i%2?createDiv("boxR"):createDiv("boxL");
  		//$div.innerHTML = '<img src="../images/a1.png" width="30px" height="30">' + msg + '</a>';
  		$div.innerHTML = '<img src="../images/1.gif" width="30px" height="30">' + msg + '</a>';
  		lChats.appendChild($div);
  	}
  	function onCClose(msg){
  		console.log('cCClose')
		ws.close();
  		// 자신의 메세지는 오른쪽
  		$div=createDiv("boxR"); // $div=i%2?createDiv("boxR"):createDiv("boxL");
  		$div.innerHTML = '<img src="../images/2.gif" width="30px" height="30">' + "채팅이 종료가 되었습니다." + '</a>';
  		lChats.appendChild($div);
  	}
	function createDiv(d) {
		$div = document.createElement('Div');
		$div.classList.add(d);//.boxR,.boxL
		$div.id = d+i;//#boxR0 #boxL1
		$div.innerHTML = "Test"+i;
		i++;
		return $div;
	}

	</script>
</html>