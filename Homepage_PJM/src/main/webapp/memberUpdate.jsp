<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// TODO 예외, 오류 처리 
	%>
	<h2>회원 정보 수정</h2>
    <form action="update.do" method="post">
        <label for="userId">아이디:</label>
        <input type="text" id="userId" name="userId" readonly="readonly"
        value="<%=session.getAttribute("userId") %>"><br><br>
        
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" placeholder="비밀번호를 변경해주세요." required ><br><br>
        
        <label for="email">이메일:</label>
        <input type="email" id="email" name="email" placeholder="이메일 입력" required value="<%=session.getAttribute("email") %>"><br><br>
        
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
        <input type="tel" id="phone" name="phone" placeholder="전화번호 입력" value="<%=session.getAttribute("phone") %>"><br><br>
        
        <label for="introduce">자기 소개:</label><br>
        <textarea id="introduce" name="introduce" rows="4" cols="50" placeholder="자기소개 입력"></textarea><br><br>
        
        <input type="submit" value="수정하기">
    </form>
</body>
</html>