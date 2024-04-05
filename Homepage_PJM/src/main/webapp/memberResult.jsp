<%@page import="edu.web.member.MemberVO"%>
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
		}
			MemberVO vo = (MemberVO)request.getAttribute("vo");
	%>
	<h2>아이디 : <%=vo.getUserId() %></h2>
	<h2>비밀번호 : <%=vo.getPassword() %></h2>
	<h2>이메일 : <%=vo.getEmail() %></h2>
	<h2>이메일 수신여부 : <%=vo.getEmailAgree() %></h2>
	<h2>관심 : <%=vo.getInterestJoin() %></h2>
	<h2>전화번호 : <%=vo.getPhone() %></h2>
	<h2>자기소개 : <%=vo.getIntroduce() %></h2>
	
	
	<button onclick="location.href='memberUpdate.jsp'">회원 정보 수정</button>
	<button onclick="location.href='loginResult.jsp'">돌아가기</button>
	<button onclick="location.href='delete.do'">회원 탈퇴</button>
</body>
</html>