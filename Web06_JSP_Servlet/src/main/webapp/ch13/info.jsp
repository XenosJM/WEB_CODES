<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 Info</title>
</head>
<body>
	<%
	 /* form input name 이름에 맞게 parameter로 데이터 불러오기
		각 변수명은 parameter name과 동일하게 작성(권장);
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String emailAgree = request.getParameter("emailAgree");
		String introduce = request.getParameter("introduce"); */
	%>	
	<% request.setCharacterEncoding("UTF-8"); %>
	<%-- ch10 MemberBean 클래스 연결 --%>
	<jsp:useBean id="member" class="web.ch10.bean.MemberBean"/>
	<%-- request로 전송된 모든 form data를 MEmberBean 클래스의 각 프로퍼티에 저장 --%>
	<jsp:setProperty property="*" name="member"/>
	
	<h2>회원 정보</h2>
	아이디 : <%= member.getUserId() %><br>
	비밀번호 : <%= member.getPassword() %><br>
	이메일 : <%= member.getEmail() %><br>
	이메일 수신여부 : <%= member.getEmailAgree() %><br>
	자기소개 : <%= member.getIntroduce() %><br>
	
</body>
</html>









