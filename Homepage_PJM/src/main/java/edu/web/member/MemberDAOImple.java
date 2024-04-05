package edu.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;


public class MemberDAOImple implements MemberDAO, DBConnection {
	private static MemberDAOImple instance = null;
	
	
	private MemberDAOImple() {}
	
	public static MemberDAOImple getInstance() {
		if(instance == null) {
			instance = new MemberDAOImple();
		}
		return instance;
	}
	
	// conn, pstmt 리소스 해제 메소드
	private void colseResource(Connection conn, PreparedStatement pstmt) {
		try {
			pstmt.close();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void colseResource(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			pstmt.close();
			conn.close();
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insert(MemberVO vo) {
		System.out.println("DB insert 시작");
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getEmailAgree());
			pstmt.setString(5, vo.getInterestJoin());
			pstmt.setString(6, vo.getPhone());
			pstmt.setString(7, vo.getIntroduce());
			
			result = pstmt.executeUpdate();
			System.out.println(result + "행 등록");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			colseResource(conn, pstmt);
		}
		
		return result;
	}

	@Override
	public MemberVO select(String userId) {
	System.out.println("유저 정보 검색 시작");
	MemberVO vo = new MemberVO();

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; // select query 결과 저장할 클래스

	try {
		DriverManager.registerDriver(new OracleDriver());
		System.out.println("드라이버 로드 성공");

		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		System.out.println("DB 연결 성공");

		pstmt = conn.prepareStatement(SQL_SELECT);
		pstmt.setString(1, userId);
		
		rs = pstmt.executeQuery();
		System.out.println("쿼리 시작");
		if (rs.next()) { // 레코드가 존재할 때까지
			System.out.println("시작!");
			userId = rs.getString(1);
//			System.out.println(1);
			String password = rs.getString(2);
//			System.out.println(2);
			String email = rs.getString(3);
//			System.out.println(3);
			String emailAgree = rs.getString(4);
//			System.out.println(4);
			String[] interest = rs.getString(5).split(",");
			System.out.println();
			String phone = rs.getString(6);
			String introduce = rs.getString(7);
			System.out.println("정보 불러오기 완료");
			vo = new MemberVO(userId, password, email, emailAgree, interest, phone, introduce);
			System.out.println(vo);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		colseResource(conn, pstmt, rs);
	}
	return vo;
	}

	@Override
	public int update(String userId, MemberVO vo) {
		System.out.println("유저 정보 업데이트 시작");
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이브 로드 성공!");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공!");
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getEmailAgree());
			pstmt.setString(4, vo.getInterestJoin());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getIntroduce());
			pstmt.setString(7, userId);
			
			result = pstmt.executeUpdate();
			System.out.println(result + "행 수정");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			colseResource(conn, pstmt);
		}
		
		return result;
	}

	@Override
	public int delete(String userId) {
		System.out.println("유저 정보 삭제 시작");
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이브 로드 성공!");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공!");
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
			System.out.println(result + "행 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			colseResource(conn, pstmt);
		}
		
		return result;
	}

}
