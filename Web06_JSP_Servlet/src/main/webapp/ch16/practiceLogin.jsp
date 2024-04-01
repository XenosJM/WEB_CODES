<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 연습 PracticeLogin</title>
</head>
<body>
	<%
		// 저장된 id, pw 쿠키를 꺼내서
		// input 태그(id, pw)에 값 보여주기
		// agreed면 체크 아니면 쿠키 없음
		Cookie[] cookies = request.getCookies();
		String id = "";
		String pw = "";
		String checked = "";
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("id")){
					id = cookie.getValue();					
				}
				if(cookie.getName().equals("pw")){
					pw = cookie.getValue();
				}
				if(cookie.getName().equals("saveAgreed")){
					checked = "checked";
				}
			}	
		}	
				
	%>
	<form action="practiceResult.jsp" method="POST">
		아이디<br>
		<input type="text" name="id" value="<%=id %>"><br>
		비밀번호<br>
		<input type="password" name="pw" value="<%=pw %>"><br>
		<input type="checkbox" name="saveAgreed" value="agreed"<%=checked %>>
		아이디 저장<br><br>
		<input type="submit" value="로그인">
	</form>
	
</body>
</html>