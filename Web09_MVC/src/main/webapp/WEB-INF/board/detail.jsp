<%@page import="edu.web.domain.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%  BoardVO vo = (BoardVO)request.getAttribute("vo");
		if (session.getAttribute("userId") == null) {
		out.println("<script>alert('로그인이 필요합니다.');</script>");
		out.println("<script>location.href='login.do'</script>");
		} else{
			String msg = request.getParameter("msg");
			if(msg != null){
			out.print("<script>alert('" + msg + "');</script>");
			}
		}
	%>
	<h2>환영합니다. detail.jsp 입니다. <%=vo.getUserId() + "님이시군요!" %></h2>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>내용</td>
			<td>작성자</td>
			<td>작성일</td>		
		</tr>
		<tbody>
			<tr>
				<td><%=vo.getBoardId() %></td>
				<td><%=vo.getBoardTitle() %></td>
				<td><%=vo.getBoardContent() %></td>
				<td><%=vo.getUserId() %></td>
				<td><%=vo.getBoardDateCreated() %></td>
			</tr>		
		</tbody>
	</table>
	<button onclick="location.href='update.do?boardId=<%=vo.getBoardId()%>'">게시글 수정하기</button>
	<form action="delete.do" Method="post">
		<input readOnly type="hidden" name="boardId" value="<%=vo.getBoardId() %>" >
		<input type="submit" value="삭제하기">
	</form>
</body>
</html>