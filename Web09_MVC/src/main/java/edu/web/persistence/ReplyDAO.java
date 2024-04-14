package edu.web.persistence;

import java.util.List;

import edu.web.domain.ReplyVO;

public interface ReplyDAO {
	
	// 댓글 등록
	public abstract int insert(ReplyVO vo);
	// 댓글 전체 조회(게시글 누를시 같이 수행)
	public abstract List<ReplyVO> select();
	// 댓글 수정
	public abstract int update(ReplyVO vo);
	// 댓글 삭제
	public abstract int delete(int replyId);
	
}
