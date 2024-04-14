package edu.web.domain;

public class MemberVO {
	private String userId;
	private String userPassword;
	
	public MemberVO() {}

	public MemberVO(String userId, String userPassword) {
		this.userId = userId;
		this.userPassword = userPassword;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "MemberVO [userId=" + userId + ", userPassword=" + userPassword + "]";
	}

	
	
}
