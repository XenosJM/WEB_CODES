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
	<!-- POST 방식으로 result.jsp에 데이터를 전송 -->
	<form action="result.jsp" method="post">
		<p>이름</p>
		<input type="text" name="name" placeholder="이름 입력">
		<p>나이</p>
		<input type="number" name="age" placeholder="나이 입력">
		<br><br>
		<input type="submit" value="전송">
	</form>
	
	
</body>
</html>