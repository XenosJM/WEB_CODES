<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HW3_login_auth</title>
</head>
<body>

	<%-- 
	2. 로그인 인증 페이지(HW3_login_auth.jsp)
	- 전송받은 id, pw를 확인하여 id는 "test", pw는 "1234"일 경우
	  id 세션을 생성(만료 시간은 자유롭게 설정)
	- 세션을 생성한 이후에 HW3_login_result.jsp 페이지로 이동
	- 페이지 이동 코드
	ㄴ out.prinln("<script>location.href='HW3_login_result.jsp'</script>");
	- 전송받은 id, pw가 "test", "1234"가 아닌 경우, HW3.jsp 페이지로 이동
	--%>
	<%
		// 리퀘스트의 id와 pw값을 저장한다.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		// 저장한 id값이 널값이 아니라면 세션 만들기 진행
	if (id != null) {
		// 저장한 id, pw 가 둘다 일치하는 경우
		if (id.equals("test") && pw.equals("1234")) {
			// 세션 만료기간 설정
			session.setMaxInactiveInterval(60); // 60초
			// 세션의 id, pw 값 설정
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			// 세션만들기 완료후 결과창으로 이동
			out.print("<script>location.href='HW3_login_result.jsp'</script>");
			// 같지않을 경우
		} else {
			// 경고창을 띄우고 로그인 화면으로 이동
			out.print("<script>alert('아이디 또는 비밀번호가 맞지않습니다!');</script>");
			out.print("<script>location.href='HW3.jsp'</script>");
		}
		// 저장한 id값이 널값이라면(정상적인 리퀘스트가 발생하지 않았다면)
	} else {
		// 경고창을 띄우고 로그인 화면으로 이동
		out.print("<script>alert('비정상적인 접근경로 입니다!');</script>");
		out.print("<script>location.href='HW3.jsp'</script>");
	}
	%>

</body>
</html>