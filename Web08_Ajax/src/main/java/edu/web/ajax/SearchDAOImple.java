package edu.web.ajax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleDriver;

public class SearchDAOImple implements SearchDAO, DBsearch {

	private static SearchDAOImple instance = null;

	private SearchDAOImple() {
	}

	public static SearchDAOImple getInstance() {
		if (instance == null) {
			instance = new SearchDAOImple();
		}
		return instance;
	}

	private void closeResource(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			pstmt.close();
			conn.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<SearchVO> select(String title) {
		System.out.println("검색 시작");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SearchVO> list = new ArrayList<>();
		 
		
		// JDBC 드라이버 로드
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("레지스터 등록 성공");
			// 데이터베이스 연결
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("디비 연결 성공");

			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(SQL_SEARCH);

			// 쿼리 매개변수 설정
			pstmt.setString(1, "%" + title + "%");

			// 쿼리 실행
			rs = pstmt.executeQuery();
			while (rs.next()) {
				title = rs.getString(1);
				System.out.println("title : " + title);
				
				SearchVO vo = new SearchVO();
				vo.setTitle(rs.getString(1));
				list.add(vo);
			}
			System.out.println("imple : " + list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResource(conn, pstmt, rs);
		}

		return list;
	}

}
