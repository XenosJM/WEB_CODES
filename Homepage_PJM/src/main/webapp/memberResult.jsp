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
		if (session.getAttribute("userId") == null) {
		out.println("<script>alert('로그인해 주세욧!!');</script>");
		out.println("<script>location.href='login.jsp'</script>");
		} else{
		}
	%>
	<h2>회원 정보 : <%=request.getAttribute("vo") %></h2>
	
	
	<button onclick="location.href='memberUpdate.jsp'">회원 정보 수정</button>
	<button onclick="location.href='loginResult.jsp'">돌아가기</button>
	<button onclick="location.href='delete.do'">회원 탈퇴</button>
</body>
</html>