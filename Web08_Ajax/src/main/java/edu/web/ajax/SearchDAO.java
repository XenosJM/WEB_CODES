package edu.web.ajax;

import java.util.List;

public interface SearchDAO {
	
	
	// 회원 정보 검색
	public abstract List<SearchVO> select(String title);
}
