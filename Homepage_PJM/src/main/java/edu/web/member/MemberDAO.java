package edu.web.member;

public interface MemberDAO {
	
	// 회원가입
	public abstract int insert(MemberVO vo);
	// 회원 정보 검색
	public abstract MemberVO select(String userId);
	// 회원 정보 업데이트
	public abstract int update(String userId, MemberVO vo);
	// 회원 정보 삭제
	public abstract int delete(String userId);
}
