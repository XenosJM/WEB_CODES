package edu.web.member;

public interface DBConnection {
	// DB 접속에 필요한 상수 정의
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";
	
	// DB 테이블 컬럼 상수 정의
	public static final String TABLE_NAME = "TEST_MEMBER";
	public static final String COL_USERID = "USERID";
	public static final String COL_PASSWORD = "PASSWORD";
	public static final String COL_EMAIL = "EMAIL";
	public static final String COL_EMAIL_AGREE = "EMAIL_AGREE";
	public static final String COL_INTEREST = "INTEREST";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_INTRODUCE = "INTRODUCE";
	
	// DB 쿼리작성
	
	// INSERT INTO TEST_MEMBER VALUES
	// (?, ?, ?, ?, ?, ?, ?)
	public static final String SQL_INSERT = "INSERT INTO " + TABLE_NAME
			+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	String SQL_SELECT = "SELECT * FROM " + TABLE_NAME +
			" WHERE " + COL_USERID + " = ?";
	
	String SQL_UPDATE =  
			"UPDATE " + TABLE_NAME + " SET " + 
					COL_PASSWORD + " = ?, " +
					COL_EMAIL + " = ?, " +
					COL_EMAIL_AGREE + " = ?, " +
					COL_INTEREST + " = ?, " +
					COL_PHONE + " = ?, " +
					COL_INTRODUCE + " = ? " +
					"WHERE " + COL_USERID + " = ?";
	
	String SQL_DELETE = "DELETE " + TABLE_NAME + " WHERE " + COL_USERID + " = ?";
			
}






