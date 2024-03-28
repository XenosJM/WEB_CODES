<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jspTag</title>
</head>
<body>
	<%-- Declaration(선언문) --%>
	<%! // 클래스 내부 Class Test {} 안에 쓰인것과 같음
		public int add(int x, int y) {
			return x + y;
		}
	%>
	
	<%-- Scriptlet --%>
	<%
		// 지역 변수 선언, 즉 이 공간은 어떤 메소드 안이라는 뜻도 된다.
		int result = add(20, 30);
		// JSP에서 출력 방법
		// 1) 로그
		System.out.println("result = " + result);
		
		// 2) JspWriter 객체를 사용하여 응답(response)으로 출력
		out.write("<p>result = " + result + "</p>\r\n"); // java와 html이 혼용되어있는 형태	
		
		// 3) Expression 사용
	%>
	<%-- // 3) Expression 사용 --%>
	<p>결과 = <%=result %></p>
	
	<%
		Date date = new Date();
	%>
	
	<p><%=date %></p>
	
	
</body>
</html>






