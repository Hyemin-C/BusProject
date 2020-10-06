<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">

function idok(m_id) {
	opener.frm.m_id.value = document.frm.m_id.value;
	opener.frm.reid.value = document.frm.m_id.value;
	self.close();
}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <script type="text/javascript" src="../js/member.js"></script> -->
</head>
<link rel="stylesheet" type="text/css" href="css/idCheck.css"/>
<body>
	<div class="container">
	<h2>아이디 중복확인</h2>
	<form action="idCheck.do" method="get" name="frm">
		<div class="idBox">
		아이디 <input type=text name="m_id" value="${m_id}"> 
		<input type=submit value="중복 체크">
		</div>
		<div class="comment">
		<c:if test="${result == 1}">
			<script type="text/javascript">
				opener.document.frm.m_id.value = "";
			</script>
			<font>${m_id}</font>은(는) 이미 사용 중인 아이디입니다.
		</c:if>
		<c:if test="${result==-1}">
		<font>${m_id}</font>은(는) 사용 가능한 아이디입니다.
		<input type="button" value="사용" class="cancel" onclick="idok('${m_id}')">
		</c:if>
		</div>
	</form>
	</div>
</body>
</html>