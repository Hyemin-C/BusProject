<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="notice.noticeDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BusReservation</title>
<link rel="stylesheet" type="text/css" href="./css/noticeListCSS.css">
</head>
<script src="./js/notice.js"></script>
<jsp:include page="../header.jsp"></jsp:include>
<body>
	<div class="table">
		<table align="center">
			<tr>
				<td colspan="2" class="noticeTitle">
					<a href="FaQList.do"><h1>자주 묻는 질문(FaQ)</h1><a>
					<p class="subTitle">Bus에 대해 궁금하신 것을 해결해 드립니다. <br> 다른 문의사항이 있으시다면 이메일 또는 문의전화를 이용해 주시기 바랍니다.</p>
				</td>
			</tr>
			<tr>
				<td colspan="2" class="admin">
					<c:if test="${level==9}">
						<a href="FaQInsert.do?cnct=write">[FaQ작성]</a>
					</c:if>
				</td>
			</tr>
			<c:forEach var="n" items="${List}">
				<tr class="list" onmouseover="style.backgroundColor='rgb(230,255,255)'" onmouseout="style.backgroundColor=''">
					<td onclick="location.href='FaQHit.do?rn=${n.getRn()}&no=${n.getNo()}'">
						<p class="FaQTitle">${n.getTitle()}</p>
						<div class="FaQSubTitle">${n.getContent()}</div>
					</td>
					<c:if test="${level==9}">
						<td>
							<div><font>${n.getHit()}hits</font><br><a onclick="FaQDeleteJS(${n.getNo()})">[삭제]</a></div>
						</td>
					</c:if>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="2" align="center" class="pages">
					<c:if test="${startPage!=1}">
						<a href="FaQList.do?kef=${kef}&kew=${kew}&page=${startPage-1}">[이전]</a>
					</c:if>
					<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
						<c:choose>
							<c:when test="${i==page}"><a href="FaQList.do?kef=${kef}&kew=${kew}&page=${i}"><font>[${i}]</font></a></c:when>
							<c:otherwise><a href="FaQList.do?kef=${kef}&kew=${kew}&page=${i}">[${i}]</a></c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${endPage!=totalPage}">
						<a href="FaQList.do?kef=${kef}&kew=${kew}&page=${endPage+1}">[다음]</a>
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" class="search">
					<form action="FaQList.do" method="get">
						<select class="sc_sel" name="kef">
							<option value="n_title"  <c:if test="${!kef.equals('n_content')}"> selected </c:if> >제목</option>
							<option value="n_content"  <c:if test="${kef.equals('n_content')}"> selected </c:if> >내용</option>
						</select>
						<input type="text" class="sc_txt" name="kew" value="${kew}">
						<input type="submit" value=" 검색 " class="sc_btn">
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
<jsp:include page="../footer.jsp"></jsp:include>
</html>