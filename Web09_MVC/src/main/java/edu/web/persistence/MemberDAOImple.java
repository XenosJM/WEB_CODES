package edu.web.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import edu.web.dbcp.connmgr.ConnMgr;
import edu.web.domain.MemberVO;

public class MemberDAOImple implements MemberDAO, MemberQuery {
	private static MemberDAOImple instance = null;

	private MemberDAOImple() {
	}

	public static MemberDAOImple getInstance() {
		if (instance == null) {
			instance = new MemberDAOImple();
		}
		return instance;
	}

	@Override
	public int insert(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO select(String userId) {
		System.out.println("회원 정보 조회 시작");
		MemberVO vo = null;
		System.out.println("받아온 userId = " + userId);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnMgr.getConnection();
			pstmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();
			String password;

			if (rs.next()) {
				userId = rs.getString(COL_USER_ID);
				System.out.println("검색후 가져온 userId = " + userId);
				password = rs.getString(COL_PASSWORD);
				vo = new MemberVO(userId, password);
			}
			System.out.println("회원 정보 검색 성공");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnMgr.close(conn, pstmt, rs);
		}

		return vo;
	}

	@Override
	public int update(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
