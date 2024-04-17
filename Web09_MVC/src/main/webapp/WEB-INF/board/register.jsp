<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글을 등록해 보아요</title>
</head>
	<%
		String msg = (String) request.getAttribute("msg");
		if (msg != null) {
			out.print("<script>alert('" + msg + "');</script>");
		}
	%>
<body>
	<h2>게시글 등록</h2>
	<form action="register.do" Method="post">
		<input name="title" placeholder="제목을 입력해주세요" required="required">
		<input name="content" placeholder="게시글 내용을 입력하세요" required="required" style="width: 300px;">
		<input name="userId" required="required" value="<%=session.getAttribute("userId") %>">
		<input type="submit" value="등록하기">
	</form>

</body>
</html>