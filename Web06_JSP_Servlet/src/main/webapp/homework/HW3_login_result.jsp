<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
	3. 로그인 결과 페이지(HW3_login_result.jsp)
	- 세션에서 id값을 꺼내서 HTML 태그에 출력
	- 만약, 로그인을 하지 않고 url로 접속할 경우 '로그인 해주세요!!' 라고 alert를 띄우고
	  HW3.jsp 페이지로 이동
	- alert 띄우는 코드
	  ㄴ out.println("<script>alert('로그인 해주세요!!');</script>");
	  
	--%>
	<%
		// 세션이 존재여부, 없다면 경고창을 띄우고 로그인 화면으로 이동
	 if(session.getAttribute("id") == null){
			out.println("<script>alert('로그인 해주세요!!');</script>");
			out.print("<script>location.href='HW3.jsp'</script>");		
	}
	%>
	<%-- 로그인 결과창 --%>
	<h2><%=session.getAttribute("id") %>님, 환영합니다.</h2>
	
	<%-- 포스트형식으로 폼을 만들어 로그인 화면으로 리퀘스트 요청 --%>
	<form action="HW3.jsp" method="POST">
	<input type="submit" name="logout" value="로그아웃">
	</form>
	
</body>
</html>


