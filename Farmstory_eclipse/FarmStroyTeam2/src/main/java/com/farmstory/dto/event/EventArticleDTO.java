package com.farmstory.dto.event;

public class EventArticleDTO {
	
	private int boardNo;
	private String b_cateNo;
	private String title;
	private String b_contents;
	private int b_comNo;
	private int b_fNo;
	private int b_hit;
	private String b_regip;
	private String b_writer;
	private String b_rdate;
	
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getB_cateNo() {
		return b_cateNo;
	}
	public void setB_cateNo(String b_cateNo) {
		this.b_cateNo = b_cateNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getB_contents() {
		return b_contents;
	}
	public void setB_contents(String b_contents) {
		this.b_contents = b_contents;
	}
	public int getB_comNo() {
		return b_comNo;
	}
	public void setB_comNo(int b_comNo) {
		this.b_comNo = b_comNo;
	}
	public int getB_fNo() {
		return b_fNo;
	}
	public void setB_fNo(int b_fNo) {
		this.b_fNo = b_fNo;
	}
	public int getB_hit() {
		return b_hit;
	}
	public void setB_hit(int b_hit) {
		this.b_hit = b_hit;
	}
	public String getB_regip() {
		return b_regip;
	}
	public void setB_regip(String b_regip) {
		this.b_regip = b_regip;
	}
	public String getB_writer() {
		return b_writer;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	public String getB_rdate() {
		return b_rdate;
	}
	public void setB_rdate(String b_rdate) {
		this.b_rdate = b_rdate;
	}
	@Override
	public String toString() {
		return "EventArticleDTO [boardNo=" + boardNo + ", b_cateNo=" + b_cateNo + ", title=" + title + ", b_contents="
				+ b_contents + ", b_comNo=" + b_comNo + ", b_fNo=" + b_fNo + ", b_hit=" + b_hit + ", b_regip=" + b_regip
				+ ", b_writer=" + b_writer + ", b_rdate=" + b_rdate + "]";
	}


}
