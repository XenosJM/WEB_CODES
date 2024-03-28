<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UseBean</title>

</head>
<body>
	<%-- 인스턴스가 생성됨 --%>
	<jsp:useBean id="member" class="web.ch10.bean.MemberBean"></jsp:useBean>
	
	<%-- useBean 사용 방법1 --%>
	<jsp:setProperty name="member" property="userId" value="guest"/>
	
	<p>id 출력 : <jsp:getProperty name="member" property="userId"/></p>
	
	<%-- useBean 사용 방법2 : getter/setter 이용 --%>
	<%	member.setEmail("test@test.com"); %>
	<p>email 출력 : <jsp:getProperty property="email" name="member"/></p>
</body>
</html>




