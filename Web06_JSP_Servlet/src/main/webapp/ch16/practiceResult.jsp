<%@page import="java.awt.image.RescaleOp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과 페이지 PracticeResult</title>
</head>
<body>
	<%
		// practiceLogin.jsp에서 saveAgreed가 체크가 되어있으면
		// id, pw에 대한 쿠키를 생성한다.
		// 쿠키 만료 시간은 10분으로 설정
		request.setCharacterEncoding("UTF-8");
	
		String saveAgreed = request.getParameter("saveAgreed");
		
		if(saveAgreed != null){ // practiceLogin.jsp에서 saveAgreed가 체크가 되어있으면
		Cookie idCookie = new Cookie("id", request.getParameter("id")); 
		Cookie pwCookie = new Cookie("pw", request.getParameter("pw"));
		Cookie saveAgreedCookie = new Cookie("saveAgreed", saveAgreed);
		
		// 쿠키 만료 시간은 10분으로 설정
		idCookie.setMaxAge(60 * 10);
		pwCookie.setMaxAge(60 * 10);
		saveAgreedCookie.setMaxAge(60 * 10);
		
		response.addCookie(idCookie);
		response.addCookie(pwCookie);
		response.addCookie(saveAgreedCookie);
		}// id, pw에 대한 쿠키를 생성한다.
	%>

	<h2>로그인 결과 화면</h2>
	<p><%=request.getParameter("id") %>님, 환영합니다.</p>
	<%-- <p><%=request.getParameter("saveAgreed") %> : 체크 현황</p> --%>
</body>
</html>