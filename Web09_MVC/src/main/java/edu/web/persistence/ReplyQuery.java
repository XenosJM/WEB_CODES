package edu.web.persistence;

public interface ReplyQuery {
	public static final String TABLE_NAME = "REPLY";
	public static final String COL_REPLY_ID = "REPLY_ID";
	public static final String COL_BOARD_ID = "BOARD_ID";
	public static final String COL_NESTED_ID = "NESTED_REPLY_ID"; 
	public static final String COL_USER_ID = "USER_ID";
	public static final String COL_REPLY_CONTENT = "REPLY_CONTENT";
	public static final String COL_REPLY_DATE_CREATED = "REPLY_DATE_CREATED";
	
	String SQL_INSERT_REPLY = "INSERT INTO " + TABLE_NAME +
			" VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
// 댓글들을 불러오는 쿼리, 근데 댓글들만 가져오면 문제가 없지만, 댓글밑에 달리는 대댓글들의 경우
// 불러오는게 문제안되지만 불러오고나서 원래 위치를 잡아주는게 문제가 된다.
//	String SQL_SELECT_REPLY = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_BOARD_ID + " =?";
	
	// SQL 쿼리 생성
	String SQL_SELECT_REPLY = 
			"SELECT * FROM " + TABLE_NAME + 
		    " WHERE " + COL_BOARD_ID + " = ?" + 
		    " ORDER BY CASE WHEN " + COL_NESTED_ID + " IS NULL THEN " + COL_REPLY_ID +
		    " ELSE " + COL_NESTED_ID + " END, " + COL_REPLY_ID;

	
	String SQL_UPDATE_REPLY = 
			"UPDATE " + TABLE_NAME + " SET " + 
			COL_REPLY_CONTENT + " = ?, " +
			COL_REPLY_DATE_CREATED + " = SYSDATE" + 
			" WHERE " + COL_REPLY_ID + " = ?";
	
	String SQL_DELETE_REPLY = 
			"DELETE FROM " + TABLE_NAME +" WHERE " + COL_REPLY_ID + " = ?";
	
}
