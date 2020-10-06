<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="FaQ.FaQDAO" %>
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
					<a href="FaQList.do"><h1>자주 묻는 질문(FaQ)</h1><a>
					<p class="subTitle">Bus에 대해 궁금하신 것을 해결해 드립니다. <br> 다른 문의사항이 있으시다면 이메일 또는 문의전화를 이용해 주시기 바랍니다.</p>
				</td>
			</tr>
			<tr>
				<th colspan="2">
					${title} 
					<font class="birthDate">
						<c:if test="${level==9}">
							<a href="FaQUpdate.do?cnct=update&rn=${rn}">[수정]</a>
							<a onclick="FaQDeleteJS(${no})">[삭제]</a>
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
					<td><a href="FaQHit.do?rn=${rn-1}&no=${noN}">${titleN}</a></td>
				</tr>
			</c:if>
			<c:if test="${titleP!=null}">
				<tr>
					<td width="10%">▼ 이전글</td>
					<td><a href="FaQHit.do?rn=${rn+1}&no=${noP}">${titleP}</a></td>
				</tr>
			</c:if>
		</table>
	</div>
</body>
<jsp:include page="../footer.jsp"></jsp:include>
</html>