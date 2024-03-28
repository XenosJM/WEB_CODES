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
	 
	<jsp:useBean id="member" class="edu.web.homework.MemberVO"/>
	<jsp:setProperty property="*" name="member"/>

	아이디 : <jsp:getProperty name="member" property="userid"/><br>
	비밀번호 : <jsp:getProperty name="member" property="password"/><br>
	이메일 : <jsp:getProperty name="member" property="email"/><br>
	이메일 수신여부 : <jsp:getProperty name="member" property="emailAgree"/><br>
		<%
		String[] interest = member.getInterest();
			if(interest == null){
				String value = "관심없음";	 %>
			<p>관심사항 :<%= "관심없음"  %></p>
		<%} else {
		for(int i = 0; i < interest.length;i++){ %>
		<p>관심사항 :<%= interest[i] %></p>
				<%}} %>
	핸드폰 : <jsp:getProperty name="member" property="phone"/><br>
	자기소개 : <jsp:getProperty name="member" property="introduce"/><br>
	


</body>
</html>






