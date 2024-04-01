<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Cookie</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		// 파라미터 값으로 쿠기 생성
		Cookie firstNameCookie = new Cookie("firstName", firstName);
		Cookie lastNameCookie = new Cookie("lastName", lastName);
		
		// 만료 시간 설정(초단위) : 24시간
		firstNameCookie.setMaxAge(60 * 60 * 24);
		lastNameCookie.setMaxAge(60 * 60 * 24);
		
		// response.header에 쿠키를 추가
		response.addCookie(firstNameCookie);
		response.addCookie(lastNameCookie);
	%>
</body>
</html>




