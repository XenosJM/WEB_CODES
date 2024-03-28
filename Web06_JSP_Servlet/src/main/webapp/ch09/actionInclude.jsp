<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action include</title>
</head>
<body>
	<h2> action tag include 예시</h2>
	
	<div>
		<p>header부분입니다.</p>
	</div>
	
	<div>
		<p>외부 파일 부분 임미다..</p>
		<jsp:include page = "part.jsp"></jsp:include>
		
	</div>
	
	<div>
		<p>footer부분입니다.</p>
	</div>
</body>
</html>