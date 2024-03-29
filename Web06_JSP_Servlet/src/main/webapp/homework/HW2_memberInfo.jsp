<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HW2_회원 정보</title>
</head>
<body>

	<%--

	3. HW2_memberInfo.jsp 파일
	- Hw2.jsp에서 전송된 데이터를 출력
	- request.getParameter of request.getParameterValues를
	  사용하지 않고 구현
	- 아래 코드를 추가하면 해결됨
	<jsp:useBean id="member" class="edu.web.homework.MemberVO"/>
	<jsp:setProperty property="*" name="member" />
	- property="*"의 의미 : HW2.jsp에서 넘어온 모든 parameter 값을 member 객체에 저장
	
	 --%>
	 <% request.setCharacterEncoding("UTF-8"); %>
	<jsp:useBean id="member" class="edu.web.homework.MemberVO"/>
	<jsp:setProperty property="*" name="member"/>
	
	<h2>회원 정보</h2>
	아이디 : <%= member.getUserid() %><br>
	비밀번호 : <%= member.getPassword() %><br>
	이메일 : <%= member.getEmail() %><br>
	이메일 수신여부 : <%= member.getEmailAgree() %><br>
	관심사항 : <%= member.getInto() %><br>
	핸드폰 : <%= member.getPhone() %><br>
	자기소개 : <%= member.getIntroduce() %><br>
	


</body>
</html>






