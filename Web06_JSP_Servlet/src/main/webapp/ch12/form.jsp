<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form 테스트</title>

</head>
<body>
	<h2>이름/나이 입력</h2>
	<!-- POST 방식으로 result.jsp에 데이터를 전송
	서버사이드로 전송하는 데이터는 거의 대부분 post방식 사용
	 -->
	<form action="result.jsp" method="post">
		<p>이름</p>
		<input type="text" name="name" placeholder="이름 입력">
		<p>나이</p>
		<input type="number" name="age" placeholder="나이 입력">
		<br><br>
		<input type="submit" value="전송">
	</form>
	<!--
		input name="parameter 이름" : 전송할 데이터를 인식하는 parameter 이름
		input value="값" : 전송할 값
	 -->
	 
	 <!-- get 방식으로 result.jsp에 데이터를 전송
	 	get 방식은 쿼리스트링으로 감 = url에 보임.
	  -->
	 <form action="result.jsp" method="get">
		<p>이름</p>
		<input type="text" name="name" placeholder="이름 입력">
		<p>나이</p>
		<input type="number" name="age" placeholder="나이 입력">
		<br><br>
		<input type="submit" value="전송">
	</form>
	
</body>
</html>