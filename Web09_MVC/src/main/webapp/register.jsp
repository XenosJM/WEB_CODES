<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글을 등록해 보아요</title>
</head>
	<%
		if (session.getAttribute("userId") == null) {
		out.println("<script>alert('비정상적인 접근경로 입니다!!');</script>");
		out.println("<script>location.href='login.do'</script>");
		}
	%>
<body>
	<h2>게시글 등록</h2>
	<form action="register.do" Method="post">
		<input name="title" placeholder="제목을 입력해주세요" required="required">
		<input name="content" placeholder="게시글 내용을 입력하세요" required="required" style="width: 300px;">
		<input name="userId" placeholder="이름을 입력해주세요" required="required">
		<input type="submit" value="등록하기">
	</form>

</body>
</html>