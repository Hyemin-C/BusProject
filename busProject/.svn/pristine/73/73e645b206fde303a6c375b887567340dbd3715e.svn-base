<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../header.jsp"%>
<%-- <%@ include file="/admin/sub_menu.jsp"%> --%>
<script type="text/javascript">
	function go_search() {
		document.frm.action = "NonageServlet?command=admin_member_list";
		document.frm.submit();
	}
</script>

<article>
	<h1>회원리스트</h1>
	<form name="frm" method="post">
		<table style="float: right;">
			<tr>
				<td>회원 이름 <input type="text" name="key"> <input
					class="btn" type="button" value="검색" onclick="go_search()">
				</td>
			</tr>
		</table>
		<br>
		<table id="orderList">
			<tr>
				<th>아이디</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>가입일</th>
			</tr>
			<c:forEach items="${memberList}" var="dto">
				
					<td>${dto.m_id}</td>
					<td>${dto.m_email}</td>
					<td>${dto.m_phone}</td>
					<td>${dto.m_date}</td>
					<td><fmt:formatDate value="${memberVO.indate}" /></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>