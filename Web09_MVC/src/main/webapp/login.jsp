<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 하숑</title>
</head>
	<%
		String msg = request.getParameter("msg");
		if(msg != null){
		out.print("<script>alert('" + msg + "');</script>");
		}
	%>
<body>
	<h2>로그인</h2>
	<form action="login.do" Method="post">
	<input type="text" name="userId" required="required" placeholder="아이디를 입력해 주세요"><br>
	<input type="password" name="password" required="required" placeholder="비밀번호를 입력해 주세요"><br>
	<input type="submit" value="로그인">
	</form>
</body>
</html>