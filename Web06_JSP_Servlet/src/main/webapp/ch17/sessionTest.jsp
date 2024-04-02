<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 테스트</title>
</head>
<body>
	<h2>세션 키 값 : <%= session.getAttribute("userId") %></h2>
	<%
		// String userId = session.getAttribute("userId").toString();
		String userId = (String) session.getAttribute("userId");
	%>
	<%=userId %>
</body>
</html>