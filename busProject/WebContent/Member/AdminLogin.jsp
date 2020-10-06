<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <script type="text/javascript">
 function AdminloginCheck() {
	 location.href="AdminLogin.do";
	 if (document.frm.m_id.value.length == 0) {
			alert("관리자 아이디를 써주세요");
			frm.m_id.focus();
			return false;
		}
		if (document.frm.m_pw.value == "") {
			alert("암호는 반드시 입력해야 합니다.");
			frm.m_pw.focus();
			return false;
		}
		
		return true;
}
 </script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="css/b_login.css"/>
<body>
	<div class="frame">
		<form action="AdminLogin.do" method="post" name="frm">
			<table>
				<tr>
					<td colspan="2" align="center">
						<h2>Log In</h2>
					</td>
				</tr>
				<tr>
					<td class="attribute" align="right">아이디</td>
					<td><input type="text" id="m_id" name="m_id" value="${m_id}"></td>
				</tr>
				<tr>
					<td class="attribute" align="right">비밀번호</td>
					<td><input type="password" id="m_pw" name="m_pw"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="관리자 로그인" onclick="return AdminloginCheck()">
					</td>
				</tr>
				<tr>
					<td colspan="2" class="message" align="center">${message}</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>