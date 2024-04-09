package edu.web.ajax;

public interface DBsearch {
	// DB 접속에 필요한 상수 정의
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";
	
	public static final String TABLE_NAME = "SEARCH";
	public static final String COL_NUM = "SNO";
	public static final String COL_TITLE = "TITLE";
	
	// SELECT * FROM 테이블명 WHERE 칼럼명 LIKE '%찾고자하는값%';
	// "SELECT * FROM 테이블명 WHERE 칼럼명 LIKE ?";
	String SQL_SEARCH = "SELECT " + COL_TITLE + " FROM " + TABLE_NAME
	+ " WHERE " + COL_TITLE + " LIKE ?";
}
