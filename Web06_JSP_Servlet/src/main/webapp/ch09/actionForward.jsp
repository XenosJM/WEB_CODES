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
		System.out.println("forward 실행 전");
	%>
	<jsp:forward page="part.jsp"></jsp:forward>
	<%
		System.out.println("forward 실행 후");
	%>

</body>
</html>