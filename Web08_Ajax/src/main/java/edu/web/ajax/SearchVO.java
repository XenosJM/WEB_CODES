package edu.web.ajax;

public class SearchVO {
	private String sno;
	private String title;
	
	public SearchVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchVO(String sno, String title) {
		this.sno = sno;
		this.title = title;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "SearchVO [sno=" + sno + ", title=" + title + "]";
	}
	
}
