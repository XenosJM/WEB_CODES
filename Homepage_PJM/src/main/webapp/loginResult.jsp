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
		String userId = (String) session.getAttribute("userId");
		// TODO 오류, 예외 처리
	%>
		 <h1><%=userId %>님 환영합니다.</h1>
		<button onclick="location.href='select.do'">회원정보</button>
		<button onclick="location.href='logout.do'">로그아웃</button>
</body>
</html>