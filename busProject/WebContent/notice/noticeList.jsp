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
				<td class="noticeTitle" colspan="4">
					<a href="noticeList.do"><h1>공지사항</h1><a>
					<p class="subTitle">BusReservation의 새로운 소식을 알려드립니다. 새로운 소식들과 함께 즐거운 여행되세요.</p>
				</td>
			</tr>
			<c:if test="${level==9}">
				<tr>
					<td colspan="4" class="admin"><a href="noticeInsert.do?cnct=write">[글쓰기]</a></td>
				</tr>
			</c:if>
			<tr class="attribute">
				<th>No.</th> <th>제목</th> <th>등록일</th> 
				<c:if test="${level==9}">
					<th>hits</th>
				</c:if>
			</tr>
			<c:forEach var="n" items="${List}">
				<tr class="list" onmouseover="style.backgroundColor='rgb(230,255,255)'" onmouseout="style.backgroundColor=''">
					<td align="center" onclick="location.href='noticeHit.do?rn=${n.getRn()}&no=${n.getNo()}'">${n.getNewrn()}</td>
					<td onclick="location.href='noticeHit.do?rn=${n.getRn()}&no=${n.getNo()}'"><a>${n.getTitle()}</a></td>
					<td align="center" onclick="location.href='noticeHit.do?rn=${n.getRn()}&no=${n.getNo()}'">${n.getDate()}</td>
					<c:if test="${level==9}">
						<td><font>${n.getHit()}</font> <a onclick="noticeDeleteJS(${n.getNo()})">[삭제]</a></td>
					</c:if>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4" align="center" class="pages">
					<c:if test="${startPage!=1}">
						<a href="noticeList.do?kef=${kef}&kew=${kew}&page=${startPage-1}">[이전]</a>
					</c:if>
					<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
						<c:choose>
							<c:when test="${i==page}"><a href="noticeList.do?kef=${kef}&kew=${kew}&page=${i}"><font>[${i}]</font></a></c:when>
							<c:otherwise><a href="noticeList.do?kef=${kef}&kew=${kew}&page=${i}">[${i}]</a></c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${endPage!=totalPage}">
						<a href="noticeList.do?kef=${kef}&kew=${kew}&page=${endPage+1}">[다음]</a>
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center" class="search">
					<form action="noticeList.do" method="get">
						<select class="sc_sel" name="kef">
							<option value="newrn" <c:if test="${kef.equals('newrn')}"> selected </c:if> >No.</option>
							<option value="n_title"  <c:if test="${!kef.equals('newrn')}"> selected </c:if> >제목</option>
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