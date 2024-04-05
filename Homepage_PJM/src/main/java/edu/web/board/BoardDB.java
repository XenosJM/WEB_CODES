package edu.web.board;

import edu.web.member.DBConnection;

public interface BoardDB extends DBConnection {
	public static final String TABLE_BOARD = "TEST_BOARD";
	public static final String COL_NUMBER = "BOARD_NUMBER";
	public static final String COL_ID = "USER_ID";
	public static final String COL_TITLE = "BOARD_TITLE";
	public static final String COL_CONTENT = "BOARD_CONTENT";
	public static final String COL_DATE = "BOARD_DATE";
	
	public static final String TABLE_REPLY = "TEST_REPLY";
	public static final String COL_REPLY_ID = "REPLY_ID";
	public static final String COL_REPLY_CONTENT = "REPLY_CONTENT";
	public static final String COL_REPLY_DATE = "REPLY_DATE";
	
	// 게시글 등록
	String SQL_INSERT_BOARD = "INSERT INTO " + TABLE_BOARD
			+ " VALUES (?, ?, ?, ?, ?)";
			
	// 게시글 검색(전달받은 값을 내용에 포함하는 글)
	String SQL_SELECT_ALL = ("SELECT * FROM ") + TABLE_BOARD
			+ " WHERE " + COL_ID + " = ? OR " + COL_TITLE + " = ? OR "
			+ COL_CONTENT + " = ?"; 
	
	// 게시글 조회(내가 쓴 게시글 조회)
	String SQL_SELECT_MY = "SELECT " + COL_TITLE + " FROM " + TABLE_BOARD
			+ " WHERE " + COL_ID + " = ?";
	
	// 게시글 수정(수정 날짜를 따로 데이터테이블에 추가하지말고 그냥 업데이트 시키면서 따로 변수에 넣어버릴것)
	String SQL_UPDATE =  
			"UPDATE " + TABLE_BOARD + " SET " + 
					COL_TITLE + " = ?, " +
					COL_CONTENT + " = ? " +
					"WHERE " + COL_NUMBER + " = ?";
	
	// 게시글 삭제(입력받은 게시글 번호를 값으로 가지고있는 모든 데이터 삭제. 댓글도 포함)
	
	
	// 댓글 작성
	String SQL_INSERT_REPLY = "INSERT INTO " + TABLE_REPLY
			+ " VALUES (?, ?, ?, ?, ?)";
	
	// 댓글에 대한 댓글 작성 쿼리(대댓글)
	
	
	// 댓글 수정
	
	
	// 댓글에 대한 댓글 수정 쿼리(대댓글)
	
	
	// 댓글 삭제
	
	
	// 댓글에 대한 댓글 삭제 쿼리(대댓글)
	
}
