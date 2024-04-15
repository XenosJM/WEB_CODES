<%@page import="edu.web.domain.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js">
	
</script>
<title>Insert title here</title>
</head>
<body>
	<%
	String msg = (String) request.getAttribute("msg");
		if(session.getAttribute("userId") == null) {
			if (msg != null) {
			out.print("<script>alert('" + msg + "');</script>");
			} 
		out.println("<script>location.href='login.do'</script>");
		};
	request.removeAttribute("msg");
	%>
	<%
	BoardVO vo = (BoardVO) request.getAttribute("vo");
	%>
	<h2>
		환영합니다. detail.jsp 입니다.
		<%=session.getAttribute("userId") + "님이시군요!"%></h2>
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
				<td><%=vo.getBoardId()%></td>
				<td><%=vo.getBoardTitle()%></td>
				<td><%=vo.getBoardContent()%></td>
				<td><%=vo.getUserId()%></td>
				<td><%=vo.getBoardDateCreated()%></td>
			</tr>
		</tbody>
	</table>
	<button
		onclick="location.href='update.do?boardId=<%=vo.getBoardId()%>'">게시글
		수정하기</button>
	<form action="delete.do" Method="post">
		<input readOnly type="hidden" id="boardId" name="boardId"
			value="<%=vo.getBoardId()%>"> <input type="submit"
			value="삭제하기">
	</form>
	<button onclick="window.location.href='list.do'">돌아가기</button>

	<div style="text-align: center;">
		<input type="text" id="userId"> <input type="text"
			id="replyContent">
		<button id="btnAdd">작성</button>
	</div>

	<hr>

	<div style="text-align: center;">
		<div id="replies"></div>
	</div>

	<div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
	</div>

	<script type="text/javascript">
		$(function() {
			$('#btnAdd').click(function() {
				// $('#boardId').
				let boardId = $('#boardId').val();
				let userId = $('#userId').val();
				let replyContent = $('#replyContent').val();
				let obj = {
					'boardId' : boardId,
					'userId' : userId,
					'replyContent' : replyContent
				};
				console.log(obj);

				$.ajax({
					type : 'POST',
					url : 'replies/add',
					data : {
						'obj' : JSON.stringify(obj)
					},
					success : function(result) {
						console.log(result);
					}
				});
			});
		}); // end document($document.ready(function(){ 내용 });
	</script>

</body>
</html>



