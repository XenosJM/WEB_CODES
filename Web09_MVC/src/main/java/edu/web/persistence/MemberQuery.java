package edu.web.persistence;

public interface MemberQuery {

	public static final String TABLE_NAME = "MEMBER";
	public static final String COL_USER_ID = "USER_ID";
	public static final String COL_PASSWORD = "USER_PASSWORD";
	
	
	String SQL_INSERT_MEMBER = "INSERT INTO " + TABLE_NAME + " VALUES (?, ?)";	
	String SQL_SELECT_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_USER_ID + " = ?";
}
