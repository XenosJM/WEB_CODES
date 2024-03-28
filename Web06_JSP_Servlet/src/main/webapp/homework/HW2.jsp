<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HW2, 회원 가입</title>
</head>
<body>
	
	<%-- 
		1. HW2.jsp 파일
	- 회원 가입 form 만들기
	- POST 방식
	- action="HW2_memberInfo.jsp"
	- 아이디(text) : neme="userid"
	- 패스워드(password) : name="password"
	- 이메일(email) : name="email"
	- 이메일 수신여부(radio 버튼) : name="emailAgree"
	- 관심사항(checkbox, 관심사항 4개 이상 설정)
		ㄴ 예시) 영화, 독서, 게임, 운동, 조깅, 하이킹, 등
		<input type="checkbox" name="interest" value="IT">IT/인터넷
		<input type="checkbox" name="interest" value="movie">영화
	- 핸드폰(text) : name="phone"
	- 자기소개(<textarea>) : name="introduce"
	 --%> 
	<jsp:useBean id="member" class="edu.web.homework.MemberVO"/>
	<jsp:setProperty property="*" name="member"/>
	 <form action="HW2_memberInfo.jsp" method="post">
		<p>아이디</p>
		<input type="text" name="userid" >
		<p>패스워드</p>
		<input type="password" name="password" >
		<p>이메일</p>
		<input type="email" name="email" >
		<p>이메일 수신여부</p>
		<input type="radio" name="emailAgree" value="agree">동의
		<input type="radio" name="emailAgree" value="disagree">비동의
		<p>관심사항</p>
		<input type="checkbox" name="interest" value="reading">독서
		<input type="checkbox" name="interest" value="IT">IT/인터넷
		<input type="checkbox" name="interest" value="movie">영화
		<input type="checkbox" name="interest" value="game">게임
		<input type="checkbox" name="interest" value="exercise">운동
		<input type="checkbox" name="interest" value="hike">하이킹
		<input type="checkbox" name="interest" value="jogging">조깅
		<p>핸드폰</p>
		<input type="text" name="phone" >
		<p>자기소개</p>
		<textarea name="introduce"></textarea><br>
		<input type="submit" value="전송">
	</form>


</body>
</html>