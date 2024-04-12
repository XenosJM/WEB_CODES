<%@page import="edu.web.domain.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
		</tr>
		<%
		List<BoardVO> vo = (List<BoardVO>) request.getAttribute("vo");
		for (int i = 0; i < vo.size(); i++) {
			BoardVO board = vo.get(i);
		%>
		<tbody>
			<tr onclick="location.href='detail.do?boardId=<%=board.getBoardId()%>'" > <!-- 부모 요소가 되고, 얘의 첫번째 자식 boardId를 가져와야한다. -->
				<td><%=board.getBoardId()%></td>
				<td><%=board.getBoardTitle()%></td>
				<td><%=board.getUserId()%></td>
				<td><%=board.getBoardDateCreated()%></td>
			</tr>
		</tbody>
		<%
		}
		%>
	</table>
	<button onclick="location.href='register.do'">게시글 작성</button>
</body>
</html>




