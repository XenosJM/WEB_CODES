<%@page import="edu.web.domain.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판</title>
<style type="text/css">
table, th, td {
	border-style: solid;
	border-width: 1px;
	text-align: center;
}

ul {
	list-style-type: none;
}

li {
	display: inline-block;
}
</style>
</head>
<body>
	<%
	String msg = (String) request.getAttribute("msg");
	if (msg != null) {
		out.print("<script>alert('" + msg + "');</script>");
	}
	%>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
		</tr>
		<%
		List<BoardVO> vo = (List<BoardVO>) request.getAttribute("vo");
		%>
		<tbody>
			<c:forEach var="vo" items="${vo }">
					<!-- 내가 한방식 -->
				<tr onclick="location.href='detail.do?boardId=${vo.boardId }'">
					<!-- 강사님 -->
					<td>${vo.boardId }</td>
					<td><a href="detail.do?boardId=${vo.boardId }">${vo.boardTitle }</a></td>
					<td>${vo.userId }</td>
					<td>${vo.boardDateCreated }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<ul>
		<c:if test="${pageMaker.hasPrev }">
			<li><a href="list.do?page=${pageMaker.startPageNo - 1 }">이전</a></li>
		</c:if>
		<c:forEach begin="${pageMaker.startPageNo }"
			end="${pageMaker.endPageNo }" var="num">
			<li><a href="list.do?page=${num }">${num }</a></li>
		</c:forEach>
		<c:if test="${pageMaker.hasNext }">
			<li><a href="list.do?page=${pageMaker.endPageNo + 1 }">다음</a></li>
		</c:if>
	</ul>
	<a href="register.do"><input type="button" value="게시글 작성"></a>
	<c:if test="${empty sessionScope.userId }">
		<button onclick="location.href='login.login'">로그인</button>
	</c:if>
	<c:if test="${not empty sessionScope.userId }">
		<button onclick="location.href='logout.login'">로그아웃</button>
	</c:if>
</body>
</html>




