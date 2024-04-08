<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
	전송된 데이터가
	만약 'a'로 시작하면 "apple"
	'b'면 "banana"
	'c'면 "coconut"
	그외는 "not fruits"를 출력
--%>
<%-- <%

	String txt = request.getParameter("txt");
	String result;
	
	if(txt.charAt(0) == 'a'){
		result = "apple";
	} else if(txt.charAt(0) == 'b'){
		result = "banana";
	} else if(txt.charAt(0) == 'c'){
		result = "coconut";
	} else {
		result = "not fruit";
	}
%>

<%=result %> --%>

<ul>
	<c:choose>
		<c:when test="${param.txt.equals('a') }">
			<li>apple</li>
		</c:when>
		<c:when test="${param.txt.equals('b')}">
			<li>banana</li>
		</c:when>
		<c:when test="${param.txt.equals('c') }">
			<li>coconut</li>
		</c:when>
		<c:otherwise>
			<li>not fruit</li>
		</c:otherwise>
	</c:choose>
</ul>

