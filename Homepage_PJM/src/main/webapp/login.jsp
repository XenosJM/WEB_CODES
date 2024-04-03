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
	// 세션을 이용해서 로그아웃 여부 체크도 가능 

	// 리퀘스트 요청온 값중 "로그아웃"의 값이 널이 아니라면
	if (request.getParameter("logout") != null) {
		// 로그아웃 경고창 띄운다.
		out.println("<script>alert('로그아웃 했습니다!');</script>");
		// 세션을 무효화(만료)시킨다
		session.invalidate();
		// 이 페이지로 이동
		out.print("<script>location.href='login.jsp'</script>");
	}

	// request.getRequestURL(); 리퀘스트요청이 왔을떄 메소드를 호출한 URL을 반환 하는 메소드 뭔가 있겠지 싶어 찾아본 결과 나옴.
	// ㄴ 이 코드만 써도 로그아웃이 잘 작동함.
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