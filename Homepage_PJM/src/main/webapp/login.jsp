<%@page import="edu.web.member.DeleteServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 해주세요!</title>
</head>
<body>
	<h1>로그인 시작!</h1>
	<%
	// TODO 오류, 예외 처리


	
	%>
	<%-- 
	포스트 형태로 폼을 만들어 로그인 auth로 값을 보낸다.	
	 --%>

	<form action="loginAuth.do" method="post">
		<label for="userId">아이디:</label><br>
		<input type="text" name="userId" required="required" ><br>
		
		<label for="password">비밀번호:</label><br>
		<input type="password" name="password" required="required" ><br>
		
		<label for="checkbox">기억해줘!</label>
		<input type="checkbox" name="saveAgreed" value="agreed" ><br>
		<input type="submit" value="로그인">
	</form>
	<button onclick="location.href='memberRegister.jsp'">회원가입</button><br>
	<a href="memberRegister.jsp">회원가입</a><br>

</body>
</html>