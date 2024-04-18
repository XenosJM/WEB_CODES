package edu.web.domain;

import java.util.Date;

public class ReplyVO {
	int replyId;
	int boardId;
	String userId;
	String replyContent;
	Date replyDateCreated;
	int nestedReplyId;
	
	public ReplyVO() {}
	
	public ReplyVO(int replyId, int boardId, String userId, String replyContent, Date replyDateCreated,
			int nestedReplyId) {
		this.replyId = replyId;
		this.boardId = boardId;
		this.userId = userId;
		this.replyContent = replyContent;
		this.replyDateCreated = replyDateCreated;
		this.nestedReplyId = nestedReplyId;
	}

	public ReplyVO(int replyId, int boardId, String userId, String replyContent,
			Date replyDateCreated) {
		this.replyId = replyId;
		this.boardId = boardId;
		this.userId = userId;
		this.replyContent = replyContent;
		this.replyDateCreated = replyDateCreated;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getNestedReplyId() {
		return nestedReplyId;
	}

	public void setNestedReplyId(int nestedReplyId) {
		this.nestedReplyId = nestedReplyId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyDateCreated() {
		return replyDateCreated;
	}

	public void setReplyDateCreated(Date replyDateCreated) {
		this.replyDateCreated = replyDateCreated;
	}

	@Override
	public String toString() {
		return "ReplyVO [replyId=" + replyId + ", boardId=" + boardId +  ", userId=" + userId + ", replyContent=" + replyContent +
				", replyDateCreated=" + replyDateCreated + ", nestedReplyId=" + nestedReplyId + "]";
	}


	
	
	
	
}
