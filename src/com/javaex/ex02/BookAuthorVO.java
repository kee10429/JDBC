package com.javaex.ex02;

public class BookAuthorVO {
	
	
	//필드
	private int id;
	private String title;
	private String pubs;
	private int authorId;
	private String authorName;
	private String authorDesc;
	
	//생성자
	public BookAuthorVO(int id, String title, String pubs, int authorId, String authorName,
			String authorDesc) {
		super();
		this.id = id;
		this.title = title;
		this.pubs = pubs;
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}
	//매소드 gs

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubs() {
		return pubs;
	}

	public void setPubs(String pubs) {
		this.pubs = pubs;
	}


	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorDesc() {
		return authorDesc;
	}

	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}


	//매소드 일반
	@Override
	public String toString() {
		return "BookAuthorVO [id=" + id + ", title=" + title + ", pubs=" + pubs +  ", authorId="
				+ authorId + ", authorName=" + authorName + ", authorDesc=" + authorDesc + "]";
	}
	
	
}
