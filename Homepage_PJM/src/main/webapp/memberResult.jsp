<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// TODO : 에러 처리, 예외 처리
	%>
	<h1><%=session.getAttribute("회원정보") %></h1>
	<button onclick="location.href='memberUpdate.jsp'">회원 정보 수정</button>
	<button onclick="location.href='delete.do'">회원 탈퇴</button>
</body>
</html>