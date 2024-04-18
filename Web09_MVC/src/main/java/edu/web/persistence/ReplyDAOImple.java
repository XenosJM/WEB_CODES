package edu.web.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.web.dbcp.connmgr.ConnMgr;
import edu.web.domain.MemberVO;
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
			pstmt.setString(3, vo.getReplyContent());

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
	public List<ReplyVO> select(int boardId) {
		System.out.println("댓글 조회 시작");
		List<ReplyVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnMgr.getConnection();
			pstmt = conn.prepareStatement(SQL_SELECT_REPLY);
			pstmt.setInt(1, boardId);

			rs = pstmt.executeQuery();
//			int replyId;
//			int nestedReplyId;
//			String userId;
//			String replyContent;
//			String replyDateCreated;
			
			while (rs.next()) {
			ReplyVO vo = new ReplyVO(rs.getInt(1), boardId, rs.getString(3), rs.getString(4), rs.getTimestamp(5), rs.getInt(6));
			list.add(vo);
			}
			System.out.println("댓글 검색 성공");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnMgr.close(conn, pstmt, rs);
		}

		return list;
	}

	@Override
	public int update(ReplyVO vo) {
		 int result = 0;
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      
	      try {
	         conn = ConnMgr.getConnection();
	         pstmt = conn.prepareStatement(SQL_UPDATE_REPLY);
	         pstmt.setString(1, vo.getReplyContent());
	         pstmt.setInt(2, vo.getReplyId());
	         
	         result = pstmt.executeUpdate();
	         System.out.println("reply update 성공");
	      } catch (Exception e) {
	         
	         e.printStackTrace();
	      } finally {
	         ConnMgr.close(conn, pstmt);
	      }
	      return result;

	}

	@Override
	public int delete(int replyId) {
		 int result = 0;
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      
	      try {
	         conn = ConnMgr.getConnection();
	         pstmt = conn.prepareStatement(SQL_DELETE_REPLY);
	         pstmt.setInt(1, replyId);
	         
	         result = pstmt.executeUpdate();
	         System.out.println("reply update 성공");
	      } catch (Exception e) {
	         
	         e.printStackTrace();
	      } finally {
	         ConnMgr.close(conn, pstmt);
	      }
	      return result;
	}

}
