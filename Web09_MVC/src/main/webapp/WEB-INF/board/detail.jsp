<%@page import="edu.web.domain.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		/* if(session.getAttribute("userId") == null) {
			if (msg != null) {
			out.print("<script>alert('" + msg + "');</script>");
			} 
		out.println("<script>location.href='login.do'</script>");
		}; */
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
	
	<c:if test="${vo.userId eq sessionScope.userId }">
	<button onclick="location.href='update.do?boardId=<%=vo.getBoardId()%>'">게시글 수정하기</button>
		<form action="delete.do" Method="post">
			<%-- <input readOnly type="hidden" id="nestedId" name="nestedId" value="${vo.userId }"> --%>
			<input readOnly type="hidden" id="boardId" name="boardId" value="<%=vo.getBoardId()%>">
			<input type="submit" value="삭제하기">
		</form>
	</c:if>
	<button onclick="window.location.href='list.do'">돌아가기</button>
	<%-- <input readOnly type="hidden" id="nestedId" name="nestedId" value="${vo.userId }"> --%>
	<input readOnly type="hidden" id="boardId" name="boardId" value="${vo.boardId }">
	<c:if test="${not empty sessionScope.userId }">
		<div style="text-align: center;">
			<input type="text" id="userId" value="${sessionScope.userId }" readOnly>
			<input type="text" id="replyContent">
			<button id="btnAdd"> 댓글 작성</button>
		</div>
	</c:if>

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
			getAllReplies(); // 함수 호출 코드 추가
			
			$('#btnAdd').click(function() {
				
				// $('#boardId').
				let boardId = $('#boardId').val();
				let userId = $('#userId').val();
				let replyContent = $('#replyContent').val();
				let nestedId = $('#nestedId').val();
				console.log(nestedId);
				let obj = {
					'boardId' : boardId,
					'userId' : userId,
					'replyContent' : replyContent,
					'nestedId' : nestedId
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
					if(result == 'success'){
						alert('댓글 입력 성공');							
						getAllReplies();
						}
					}
				}); // end ajax()
			}); // end btnAdd.click()
			
			// 게시판 댓글 전체 가져오기
			function getAllReplies(){
				// 댓글 가져오기위한 게시글 번호
				var boardId = $('#boardId').val();
				
				var sessionId = '${sessionScope.userId }';
				//console.log(userId);
				//var sessionUserId = ${sessionScope.userId};
				//console.log(sessionUserId);
				// url에 boardId 전송
				var url = 'replies/all?boardId=' + boardId;
			
				// 가져올 데이터가 json이므로
				// getJSON으로 파싱하는게 편함
				$.getJSON(
					url,
					function(data){
						// data : 서버에서 전송받은 list 데이터가 저장되어 있음.
						// getJSON()에서 json 데이터는
						// javascript object로 자동 parsing 됨
						console.log(data);
						console.log(url);
					
					let list = ''; // 댓글 데이터를 HTML에 표현할 문자열 변수
					
					// $(컬렉션).each() : 컬렉션 데이터를 반복문으로 꺼내는 함수
					$(data).each(function(){
						// this : 컬렉션의 각 인덱스 데이터를 의미
						console.log(this);
						// 프론트엔드의 장바구니와 유사한데 그 이유는 비동기로 처리하기 때문
						
							
						let replyDateCreated = new Date(this.replyDateCreated);
						let disabled = '';
						let readonly = '';
						// let nestedId = $('#replyID').val();
						if(this.userId != sessionId){
							disabled = 'disabled';
							readonly = 'readonly';
						}
						//if(nestedId == 0){
						//	nestedId = $('#userId').val();
						//}
						
						list += '<div class="reply_item">'
							+ '<pre>'
							+ '<input type="hidden" id="replyId" + value="' + this.replyId +'">'
							+ this.userId + '이(가)'
							+ '&nbsp;&nbsp;' // 공백
							
							+ '에게'
							+ '<input type="text" id="replyContent"' + readonly + 'value="' + this.replyContent +'">'
							+ replyDateCreated
							+ '<button class="btn_reply">댓글추가</button>'
							+ '<button class="btn_update"' + disabled + '>수정</button>'
							+ '<button class="btn_delete"' + disabled + '>삭제</button>'	
							+ '</pre>'
							+ '</div>';
						
					}); // end each()
					
						$('#replies').html(list);
					}
				); // end getJSON
			} // end getAllReplies()
			
			// 수정 버튼을 클릭하면 선택된 댓글 수정
			$('#replies').on('click', '.reply_item .btn_update', function(){
				// this = 클릭한 요소 정보
				console.log(this);
				
				// 선택된 댓글의 replyId, replyContent 값을 저장
				// prevAll() : 선택된 노드 이전에 있는모든 형제 노드를 접근
				var replyId = $(this).prevAll('#replyId').val();
				var replyContent = $(this).prevAll('#replyContent').val();
				console.log("선택된 댓글 번호 : " + replyId + ", 댓글 내용 : " + replyContent);
				
				// ajax로 데이터 전송해 수정기능 수행후 결과를 리턴하는 코드
				//ajax 요청
				$.ajax({
					type : 'POST',
					url : 'replies/update',
					data : {
						'replyId' : replyId,
						'replyContent' : replyContent
					},
					success : function(result){
						console.log(result);
					if(result == 'success'){
						alert('댓글 수정 성공');							
						getAllReplies();
						}
					}					
				}); // end ajax()
			}); // end replies.on()
			
			// 댓글 수정
			$('#replies').on('click', '.reply_item .btn_delete', function(){
				// this = 클릭한 요소 정보
				console.log(this);
				
				// 선택된 댓글의 replyId 값을 저장
				// prevAll() : 선택된 노드 이전에 있는모든 형제 노드를 접근
				var replyId = $(this).prevAll('#replyId').val();
				console.log("선택된 댓글 번호 : " + replyId);
				
				// ajax로 데이터 전송해 수정기능 수행후 결과를 리턴하는 코드
				//ajax 요청
				$.ajax({
					type : 'POST',
					url : 'replies/delete',
					data : {
						'replyId' : replyId,
					},
					success : function(result){
						console.log(result);
						if(result == 'success'){
						alert('댓글 삭제 성공');							
						getAllReplies();
						}
					} // end success
				}); // end ajax
			}); // end delete
			
			// 누르면 입력창이 뜨고 추가 버튼을 누르면 입력이 된다. 여기서 컨테이너로 요청할 필요는 없고 그냥 요소 추가만 하면 끝
			
			$('#replies').on('click', '.reply_item .btn_reply', function(){
				// this = 클릭한 요소 정보
				console.log(this);
				
				// 선택된 댓글의 replyId, replyContent 값을 저장
				// prevAll() : 선택된 노드 이전에 있는모든 형제 노드를 접근
				var nestedId = $(this).prevAll('#replyId').val();
				var replyContent = $(this).prevAll('#replyContent').val();
				console.log("선택된 댓글 번호 : " + replyId + ", 댓글 내용 : " + replyContent);
				
				// ajax로 데이터 전송해 수정기능 수행후 결과를 리턴하는 코드
				//ajax 요청
				$.ajax({
					type : 'POST',
					url : 'replies/update',
					data : {
						'replyId' : replyId,
						'replyContent' : replyContent
					},
					success : function(result){
						console.log(result);
					if(result == 'success'){
						alert('댓글 수정 성공');							
						getAllReplies();
						}
					}					
				}); // end ajax()
			}); // end replies.on()
		}); // end document($document.ready(function(){ 내용 });
	</script>

</body>
</html>



