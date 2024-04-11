package edu.web.board;

import edu.web.member.DBConnection;

public interface BoardDB extends DBConnection {
	public static final String TABLE_BOARD = "TEST_BOARD";
	public static final String COL_ID = "BOARD_ID";
	public static final String COL_USER = "USER_ID";
	public static final String COL_TITLE = "BOARD_TITLE";
	public static final String COL_CONTENT = "BOARD_CONTENT";
	public static final String COL_DATE = "BOARD_DATE";
	
	public static final String TABLE_REPLY = "TEST_REPLY";
						String COL_REPLY_ID = "REPLY_ID";
	public static final String COL_REPLY_USER = "REUSER_ID";
	public static final String COL_REPLY_CONTENT = "REPLY_CONTENT";
	public static final String COL_REPLY_DATE = "REPLY_DATE";
	
	// 게시글 등록
	String SQL_INSERT_BOARD = "INSERT INTO " + TABLE_BOARD
			+ " VALUES (?, ?, ?, ?, ?)";
			
	// 게시글 검색(전달받은 값을 내용에 포함하는 글)
	String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_BOARD
			+ " WHERE " + COL_USER + " = ? OR " + COL_TITLE + " = ? OR "
			+ COL_CONTENT + " = ?"; 
	
	// 게시글 조회(작성된 게시글을 게시판에서 클릭하면 게시글 내용과 댓글 및 대댓글들 조회)
	String SQL_SELECT_MY = "SELECT " + COL_TITLE + " FROM " + TABLE_BOARD
			+ " WHERE " + COL_USER + " = ?";
	
	// 작성된 게시글을 게시판에서 클릭하면 해당 게시글의 내용과 댓글 및 대댓글들을 조회하는 쿼리
	String SQL_SELECT_BOARD = "SELECT " + TABLE_BOARD + "." + COL_TITLE + ", " + TABLE_BOARD + "." + COL_CONTENT + ", " +
	    TABLE_REPLY + "." + COL_REPLY_CONTENT + ", " + TABLE_REPLY + "." + COL_REPLY_DATE +
	    " FROM " + TABLE_BOARD +
	    " LEFT JOIN " + TABLE_REPLY + " ON " + TABLE_BOARD + "." + COL_ID + " = " + TABLE_REPLY + "." + COL_ID +
	    " WHERE " + TABLE_BOARD + "." + COL_ID + " = ?";
	
	String SQL_SELECT_MY_BOARD = "SELECT " + TABLE_BOARD + "." + COL_TITLE + ", " + TABLE_BOARD + "." + COL_USER + ", " +
		    TABLE_BOARD + "." + COL_DATE + ", " + TABLE_BOARD + "." + COL_CONTENT + ", " +
		    TABLE_REPLY + "." + COL_REPLY_CONTENT + ", " + TABLE_REPLY + "." + COL_REPLY_DATE + ", " +
		    TABLE_REPLY + "." + COL_REPLY_USER +
		    " FROM " + TABLE_BOARD +
		    " LEFT JOIN " + TABLE_REPLY + " ON " + TABLE_BOARD + "." + COL_ID + " = " + TABLE_REPLY + "." + COL_ID +
		    " WHERE " + TABLE_BOARD + "." + COL_ID + " = ?";

	
	// 게시글 수정(수정 날짜를 따로 데이터테이블에 추가하지말고 그냥 업데이트 시키면서 따로 변수에 넣어버릴것)
	String SQL_UPDATE =  
			"UPDATE " + TABLE_BOARD + " SET " + 
					COL_TITLE + " = ?, " +
					COL_CONTENT + " = ? " +
					"WHERE " + COL_ID + " = ?";
	
	// 게시글 삭제(입력받은 게시글 번호를 값으로 가지고있는 모든 데이터 삭제. 댓글도 포함) 쿼리문에서 처리 완료
	String SQL_DELETE = "DELETE " + TABLE_BOARD +" WHERE " + COL_USER + " = ?"; 
	
	// 댓글 작성(대댓글도 동일, 댓글과 대댓글을 작성한 사용자의 ID는 USER_ID에 저장. 
	// 대댓글의 부모 댓글을 나타내기 위해 부모 댓글의 ID가 REPLY_ID에 저장. 댓글일땐 REPLY_ID는 게시글 작성자가 된다.
	String SQL_INSERT_REPLY = "INSERT INTO " + TABLE_REPLY
			+ " VALUES (?, ?, ?, ?, ?)";

	// 댓글 수정. 내용 수정과 삭제만 가능.(대댓글도 같이 처리하기위해 테이블에 댓글 번호 추가하기로 결정)
	String SQL_UPDATE_REPLY = 
			"UPDATE " + TABLE_REPLY + " SET " + 
					COL_REPLY_CONTENT + " = ? " +
					"WHERE " + COL_ID + " = ? AND " +
					COL_REPLY_ID + " = ?";
	
	// 댓글 삭제(대댓글도 이거로 끝)
	String SQL_DELETE_REPLY =
			"DELETE FROM " + TABLE_REPLY + " WHERE " +
					COL_ID + " = ? AND " +
					COL_REPLY_ID + " = ?";
	
}
