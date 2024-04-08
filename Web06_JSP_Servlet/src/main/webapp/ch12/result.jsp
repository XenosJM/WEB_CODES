<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
	
	<!-- request 내장 객체를 이용한 데이터 출력 -->
	<%
		// 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		// String getParameter(String name) :
		// request는 form에서 전송된 데이터를 불러오는 parameter를 제공
		// request 객체에 Form Data가 저장되고, getParameter()로 데이터 참조
	/*
		* Get 방식 url 정보
		http://localhost:8081/ : 도메인 정보
		Web06_JSP_Servlet/ : Context Root(서버 기본 경로)
		ch12/result.jsp : 페이지 경로(url pattern)
		?name=%EB%B0%95%EC%A0%95%EB%AF%BC&age=1231 : Query String
		name, age parameter
		
		서버 사이드 렌더링 = 동기 방식
		장점 : 구현이 쉽다.
		클라이언트 사이드 렌더링 = 비동기 방식 
	*/
	
	/* 	 * parameter와 attribute의 차이점
		 - parameter와 attribute는 비슷한 기능을 수행
		 
		 - * parameter 특징
		 - html form 태그를 통해 전송을 수행
		 - String 타입만 전송 가능
		 - request 객체에만 존재하고,
		   client에서 server로 데이터를 전송할 때 사용
		   
		 - * attribute 특징
		 - setAttribute를 통해 전송을 수행
		 - Object 타입의 데이터로 전송 가능
		 - 주로 server 데이터를 client로 전송할 때 사용 */
	%>
	이름 : <%=request.getParameter("name") %><br>
	나이 : <%=request.getParameter("age") %><br>
	
</body>
</html>