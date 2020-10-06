<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function loginCheck() {
	if (document.frm.m_id.value.length == 0) {
		alert("아이디를 써주세요");
		frm.m_id.focus();
		return false;
	}
	if (document.frm.m_pw.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	return true;
}
function idCheck() {
	if (document.frm.m_id.value == "") {
		alert('아이디를 입력하여 주십시오.');
		document.formm.m_id.focus();
		return;
	}
	var url = "idCheck.do?m_id=" + document.frm.m_id.value;
	window.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}



function joinCheck() {
	if (document.frm.m_id.value.length == 0) {
		alert("아이디를 써주세요");
		frm.m_id.focus();
		return false;
	}
	if (document.frm.m_id.value.length < 4) {
		alert("아이디는 4글자이상이어야 합니다.");
		frm.m_id.focus();
		return false;
	}
	if (document.frm.m_pw.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.m_pw.focus();
		return false;
	}
	if (document.frm.m_pw.value != document.frm.m_pw_check.value) {
		alert("암호가 일치하지 않습니다.");
		frm.m_pw.focus();
		return false;
	}
	if (document.frm.reid.value.length == 0) {
		alert("중복 체크를 하지 않았습니다.");
		frm.m_id.focus();
		return false;
	}
	alert("회원가입이 완료 되었습니다. ");
	return true;
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <script type="text/javascript" src="../js/member.js"></script> -->
</head>
<link rel="stylesheet" type="text/css" href="css/b_join.css"/>
<body>
	<div class="frame">
	<form action="Join.do?con=real" method="post" name="frm">
		<table>
			<tr>
				<td colspan="2" align="center">
					<h2>회원 가입</h2>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<p class="emphasis"><font>*</font> 표시 항목은 필수 입력 항목입니다.</p>
				</td>
			</tr>
			<tr>
				<td>
					<p class="attribute"><font>*</font>아이디 <input type="button" value="중복체크" onclick="idCheck();"></p>
					<input type="text" name="m_id" size="20" id="m_id">
					<input type="hidden" name="reid" size="20" >
				</td>
			</tr>
			<tr>
				<td>
					<p class="attribute"><font>*</font>암호</p>
					<input type="password" name="m_pw" size="20">
				</td>
			</tr>
			<tr>
				<td>
					<p class="attribute"><font>*</font>암호확인</p>
					<input type="password" name="m_pw_check" size="20">
				</td>
			</tr>
			<tr>
				<td>
					<p class="attribute"><font>*</font>이메일</p>
					<input type="text" name="m_email" size="20">
				</td>
				
			</tr>
			<tr>
				<td>
					<p class="attribute">전화번호</p>
					<input type="text" name="m_phone" size="20">
				</td>
			</tr>
			<tr>
				<td>${message }</td>
			</tr>
			<tr>
				<td align="center">
					<input type="submit" value="가입하기" onclick="return joinCheck()"> <br>
				</td>
			</tr>
			<tr>
				<td class="etc_btn" align="center">
					<a href="b_main.jsp">홈으로</a> | <a href="Login.do">로그인</a> | <a onclick="document.frm.reset()">다시작성</a>
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>