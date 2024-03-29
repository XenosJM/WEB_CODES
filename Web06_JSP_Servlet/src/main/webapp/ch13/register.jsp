<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 Register</title>
</head>
<body>
	<h2>회원 가입 페이지</h2>
	<form action="MemverVO.jsp" method="POST">
		<p>아이디</p>
		<input type="text" name="userId" placeholder="아이디 입력" required="required">
		<p>비밀번호</p>
		<input type="password" name="password" placeholder="비밀번호 입력" required="required">
		<p>이메일</p>
		<input type="email" name="email" placeholder="이메일 입력" required="required">
		<p>이메일 수신여부</p>
		<input type="radio" name="emailAgree" value="yes">네
		<input type="radio" name="emailAgree" value="no"
		checked="checked">아니요
		<p>관심사항</p>
		<input type="checkbox" name="interest" value="reading">독서
		<input type="checkbox" name="interest" value="IT">IT/인터넷
		<input type="checkbox" name="interest" value="movie">영화
		<input type="checkbox" name="interest" value="game">게임
		<input type="checkbox" name="interest" value="exercise">운동
		<input type="checkbox" name="interest" value="hike">하이킹
		<input type="checkbox" name="interest" value="jogging">조깅
		<p>핸드폰</p>
		<input type="text" name="phone" placeholder="전화번호 입력" required="required">
		<p>자기소개</p>
		<textarea rows="4" cols="30" name="introduce" placeholder="자기소개 입력" required="required"></textarea>
		<br>
		<input type="submit" value="전송">
	</form>
</body>
</html>