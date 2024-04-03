<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입이나 하셔!</title>
</head>
<body>
	<%
		// TODO : 회원 가입 form 생성. action="register.do" method="post"
	%>
	<h2>회원 가입</h2>
    <form action="register.do" method="post">
        <label for="userId">아이디:</label>
        <input type="text" id="userId" name="userId" placeholder="아이디 입력" required><br><br>
        
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" placeholder="비밀번호 입력" required><br><br>
        
        <label for="email">이메일:</label>
        <input type="email" id="email" name="email" placeholder="이메일 입력" required><br><br>
        
        <label for="emailAgree">이메일 수신 동의:</label>
        <select id="emailAgree" name="emailAgree" required>
            <option value="yes">동의</option>
            <option value="no">거부</option>
        </select><br><br>
        
        <label for="interest">관심 분야:</label><br>
        <input type="checkbox" id="interest1" name="interest" value="sports">
        <label for="interest1">스포츠</label><br>
        <input type="checkbox" id="interest2" name="interest" value="music">
        <label for="interest2">음악</label><br>
        <input type="checkbox" id="interest3" name="interest" value="movies">
        <label for="interest3">영화</label><br>
        <input type="checkbox" id="interest4" name="interest" value="none" checked>
        <label for="interest4">관심 분야 없음</label><br><br>
        
        <label for="phone">전화번호:</label>
        <input type="tel" id="phone" name="phone" placeholder="전화번호 입력"><br><br>
        
        <label for="introduce">자기 소개:</label><br>
        <textarea id="introduce" name="introduce" rows="4" cols="50" placeholder="자기소개 입력"></textarea><br><br>
        
        <input type="submit" value="가입하기">
    </form>
</body>
</html>