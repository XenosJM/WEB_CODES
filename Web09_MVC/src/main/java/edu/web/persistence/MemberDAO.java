package edu.web.persistence;

import edu.web.domain.MemberVO;

public interface MemberDAO {
	
		// 회원 등록
		public abstract int insert(MemberVO vo);
		// 회원 조회(게시글 누를시 같이 수행)
		public abstract MemberVO select(String userId);
		// 회원 수정
		public abstract int update(MemberVO vo);
		// 회원 삭제
		public abstract int delete(String userId);
	
}
