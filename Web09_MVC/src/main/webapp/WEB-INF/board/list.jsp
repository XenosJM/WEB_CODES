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
	<% 	
	if(session.getAttribute("userId")!= null){ %>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>게시글 내용</td>
			<td>작성자</td>
			<td>작성일</td>
		</tr>
		<%
	} else {
		%>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
		</tr>
		<%
		} // end 세션 체크
		%>
		<%
		if(session.getAttribute("userId")!=null){
			List<BoardVO> vo = (List<BoardVO>) request.getAttribute("vo");
			for (int i = 0; i < vo.size(); i++) {
				BoardVO board = vo.get(i);
			%>
			<tbody>
				<tr onclick="location.href='detail.do?boardId=<%=board.getBoardId()%>'">
					<td><%=board.getBoardId()%></td>
					<td><%=board.getBoardTitle()%></td>
					<td><%=board.getBoardContent()%></td>
					<td><%=board.getUserId()%></td>
					<td><%=board.getBoardDateCreated()%></td>
				</tr>
			</tbody>
		<%
			} // end !=null for문
		} else {
		List<BoardVO> vo = (List<BoardVO>) request.getAttribute("vo");
		for (int i = 0; i < vo.size(); i++) {
			BoardVO board = vo.get(i);
		%>
		<tbody>
			<tr onclick="location.href='detail.do?boardId=<%=board.getBoardId()%>'">
				<td><%=board.getBoardId()%></td>
				<td><%=board.getBoardTitle()%></td>
				<td><%=board.getUserId()%></td>
				<td><%=board.getBoardDateCreated()%></td>
			</tr>
		</tbody>
		<%
			} // end ==null for문
		} // end 테이블바디 세션체크 
		%>
	</table>
	<button onclick="location.href='register.do'">게시글 작성</button>
	<button onclick="location.href='logout.do'" value="<%session.invalidate();%>">로그아웃</button>
</body>
</html>




