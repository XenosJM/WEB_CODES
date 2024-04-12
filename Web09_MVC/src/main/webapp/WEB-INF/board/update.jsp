<%@page import="edu.web.domain.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정해보아요</title>
</head>
<body>
<%
BoardVO vo = (BoardVO)request.getAttribute("vo");
%>
<h2>게시글 수정</h2>
	<form action="update.do" Method="post">
		<input name="boardId" value="<%=vo.getBoardId() %>" readOnly>
		<input name="title" required="required" placeholder="<%=vo.getBoardTitle() %>">
		<input name="content" required="required" style="width: 300px;"	placeholder="<%=vo.getBoardContent() %>">
		<input name="userId" value="<%=vo.getUserId() %>" readOnly>
		<input name="createTime" value="<%=vo.getBoardDateCreated() %>" readOnly>
		<input type="submit" value="수정완료">
	</form>
</body>
</html>