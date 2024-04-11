package edu.web.persistence;

public interface BoardQuery {
	public static final String TABLE_NAME = "BOARD";
	public static final String COL_BOARD_ID = "BOARD_ID";
	public static final String COL_USER_ID = "USER_ID";
	public static final String COL_BOARD_TITLE = "BOARD_TITLE";
	public static final String COL_BOARD_CONTENT = "BOARD_CONTENT";
	public static final String COL_BOARD_DATE_CREATED = "BOARD_DATE_CREATED";
	
	String SQL_INSERT_BOARD = "INSERT INTO " + TABLE_NAME
			+ " VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
	
	String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL_BOARD_ID + " DESC";
	
	String SQL_SELECT = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_BOARD_ID + " = ?";
	
	String SQL_SELECT_BY_USER_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_USER_ID + " LIKE ?";

	String SQL_SELECT_BY_TITLE = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_BOARD_TITLE + " LIKE ?";

	String SQL_SELECT_BY_CONTENT = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_BOARD_CONTENT + " LIKE ?";

	String SQL_SELECT_BY_ALL = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_USER_ID + " LIKE ? OR " +
			COL_BOARD_TITLE + " LIKE ? OR " + COL_BOARD_CONTENT + " LIKE ?";
	
	String SQL_UPDATE =  
			"UPDATE " + TABLE_NAME + " SET " + 
					COL_BOARD_TITLE + " = ?, " +
					COL_BOARD_CONTENT + " = ?, " +
					COL_BOARD_DATE_CREATED + " = SYSDATE" + 
					" WHERE " + COL_BOARD_ID + " = ?";
	
	String SQL_DELETE = "DELETE FROM " + TABLE_NAME +" WHERE " + COL_BOARD_ID + " = ?"; 
	
}







