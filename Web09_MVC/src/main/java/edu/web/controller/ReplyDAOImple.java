package edu.web.controller;

import java.util.List;

import edu.web.domain.ReplyVO;
import edu.web.persistence.ReplyDAO;
import edu.web.persistence.ReplyQuery;

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
		// TODO Auto-generated method stub
		return 0;
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
