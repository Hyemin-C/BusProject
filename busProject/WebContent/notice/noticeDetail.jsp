<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="notice.noticeDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BusReservation</title>
<link rel="stylesheet" type="text/css" href="./css/noticeDetailCSS.css">
</head>
<script src="./js/notice.js"></script>
<jsp:include page="../header.jsp"></jsp:include>
<body>
	<div class="table">
		<table align="center">
			<tr>
				<td class="noticeTitle" colspan="4">
					<a href="noticeList.do"><h1>공지사항</h1><a>
					<p>BusReservation의 새로운 소식을 알려드립니다.	새로운 소식들과 함께 즐거운 여행되세요.</p>
				</td>
			</tr>
			<tr>
				<th colspan="2">
					${title} 
					<font class="birthDate">
						<c:if test="${level==9}">
							<a href="noticeUpdate.do?cnct=update&rn=${rn}">[수정]</a>
							<a onclick="noticeDeleteJS(${no})">[삭제]</a> 
							<font class="hit">${hit}hits</font>
						</c:if>
						등록일: ${date} &nbsp;&nbsp; 최종수정일: ${editDate}
					</font>
				</th>
			</tr>
			<tr>
				<td colspan="2" class="content"><div>${content}</div></td>
			</tr>
			<c:if test="${titleN!=null}">
				<tr>
					<td>▲ 다음글</td>
					<td><a href="noticeHit.do?rn=${rn-1}&no=${noN}">${titleN}</a></td>
				</tr>
			</c:if>
			<c:if test="${titleP!=null}">
				<tr>
					<td width="10%">▼ 이전글</td>
					<td><a href="noticeHit.do?rn=${rn+1}&no=${noP}">${titleP}</a></td>
				</tr>
			</c:if>
		</table>
	</div>
</body>
<jsp:include page="../footer.jsp"></jsp:include>
</html>