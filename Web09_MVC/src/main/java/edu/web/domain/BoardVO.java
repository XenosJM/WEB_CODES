package edu.web.domain;

import java.util.Date;

public class BoardVO {
	int boardId;
	String boardTitle;
	String boardContent;
	String userId;
	Date boardDateCreated;
	
	public BoardVO() {}

	public BoardVO(int boardId, String boardTitle, String boardContent, String userId, Date boardDateCreated) {
		this.boardId = boardId;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.userId = userId;
		this.boardDateCreated = boardDateCreated;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getBoardDateCreated() {
		return boardDateCreated;
	}

	public void setBoardDateCreated(Date boardDateCreated) {
		this.boardDateCreated = boardDateCreated;
	}

	@Override
	public String toString() {
		return "BoardVO [boardId=" + boardId + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", userId=" + userId + ", boardDateCreated=" + boardDateCreated + "]";
	}
	
	
}
