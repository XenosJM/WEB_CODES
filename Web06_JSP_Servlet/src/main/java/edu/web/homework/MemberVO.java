package edu.web.homework;

public class MemberVO {
	
	/*2. MemberVO.java 파일
	- src/main/java/edu.web.homework 패키지에 MemberVO.java 클래스 생성
	- (변수 개수와 변수 이름은 form 태그 input name 값과 동일하게 작성)
	- MemberVO 기본 생성자 및 매개변수 생성자, getter/setter는 무조건 생성
	- String[] interest; (관심사항은 배열로 변수 선언)
	- request.getParameterValues() : checkbox로 선택된 여러 개의 데이터를 저장
	 */
	private String userid;
	private String password; 
	private String email;
	private String emailAgree;
	private String[] interest;
	private String phone;
	private String introduce;
	
	public MemberVO() {
		System.out.println("객체 생성 되써용~");
	}

	public MemberVO(String userid, String password, String email, String emailAgree, String[] interest, String phone,
			String introduce) {
		super();
		this.userid = userid;
		this.password = password;
		this.email = email;
		this.emailAgree = emailAgree;
		this.interest = interest;
		this.phone = phone;
		this.introduce = introduce;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailAgree() {
		return emailAgree;
	}

	public void setEmailAgree(String emailAgree) {
		this.emailAgree = emailAgree;
	}

	public String[] getInterest() {
		return interest;
	}

	public void setInterest(String[] interest) {
		this.interest = interest;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	
	
}
