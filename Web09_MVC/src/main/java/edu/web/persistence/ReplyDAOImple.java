package edu.web.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import edu.web.dbcp.connmgr.ConnMgr;
import edu.web.domain.ReplyVO;

public class ReplyDAOImple implements ReplyDAO, ReplyQuery {
	private static ReplyDAOImple instance = null;

	private ReplyDAOImple() {
	}

	public static ReplyDAOImple getInstance() {
		if (instance == null) {
			instance = new ReplyDAOImple();
		}
		return instance;
	}
	
	
	@Override
	public int insert(ReplyVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnMgr.getConnection();
			pstmt = conn.prepareStatement(SQL_INSERT_REPLY);
			pstmt.setInt(1, vo.getBoardId());
			pstmt.setString(2, vo.getUserId());
			pstmt.setInt(3, 0);
			pstmt.setString(4, vo.getReplyContent());

			result = pstmt.executeUpdate();
			System.out.println("insert 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnMgr.close(conn, pstmt);
		}
		return result;
	}

	@Override
	public List<ReplyVO> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(ReplyVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int replyId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
