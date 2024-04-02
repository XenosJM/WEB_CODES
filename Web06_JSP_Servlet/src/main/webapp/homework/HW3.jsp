<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HW3 Login</title>
</head>
<body>
	<%--
	1. 로그인 정보 전송 페이지(HW3.jsp)
	- <form action="HW3_login_auth.jsp" method="POST">
	- id, pw input 태그 생성
	
	 --%>
	 
	<%	
		if(request.getParameter("logout") != null){
			out.println("<script>alert('로그아웃 합니다!');</script>");
			session.invalidate();
			out.print("<script>location.href='HW3.jsp'</script>");					
		} 
	
	// request.getRequestURL(); 리퀘스트요청이 왔을떄 메소드를 호출한 URL을 반환 하는 메소드 뭔가 있겠지 싶어 찾아본 결과 나옴.
	// ㄴ 이 코드만 써도 로그아웃이 잘 작동함.
	%>

	<form action="HW3_login_auth.jsp" method="POST">
		아이디<br>
		<input type="text" name="id"><br>
		비밀번호<br>
		<input type="password" name="pw"><br>
		<input type="submit" value="로그인">
	</form>

</body>
</html>





