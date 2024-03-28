<%@page import="java.util.Date"%>
<%@page import="edu.web.homework.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HW1</title>
<style>
    table {
        width: 100%;
        border-collapse: collapse;
    }
    th, td {
        padding: 12px;
        border: 1px solid #ddd;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
    tr:hover {
        background-color: #f5f5f5;
    }
</style>
</head>
<body>
	<%
		ArrayList<BoardVO> list = new ArrayList<>();
		
		// 게시글 데이터 5개를 list에 추가
		
		Date day = new Date();
		for(int i = 0; i < 5; i++){
		list.add(new BoardVO(i+1, "test"+(i+1), "tester"+(i+1), day));
		}
	%>
	
	<!-- table을 생성하여 5개의 게시글 출력 -->
	<table>
		<thead>
			<tr>
				<th>게시글 번호</th>
				<th>게시글 제목</th>
				<th>유저 아이디</th>
				<th>등록 날짜</th>
			</tr>
		</thead>
		<tbody>
			<%for(int i = 0; i<list.size();i++){%>
				<tr>
					<td><%=list.get(i).getBoardId() %></td>
					<td><%=list.get(i).getBoardTitle() %></td>
					<td><%=list.get(i).getUserId() %></td>
					<td><%=list.get(i).getBoardRegDate() %></td>
				</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>








