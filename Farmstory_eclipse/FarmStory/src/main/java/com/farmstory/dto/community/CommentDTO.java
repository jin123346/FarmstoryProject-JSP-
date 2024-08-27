package com.farmstory.dto.community;

public class CommentDTO {

	private int comNo; 
	private int com_parent; 
	private String com_content; 
	private String com_writer; 
	private String com_regip; 
	private String com_rdate;
	
	public int getComNo() {
		return comNo;
	}
	public void setComNo(int comNo) {
		this.comNo = comNo;
	}
	public int getCom_parent() {
		return com_parent;
	}
	public void setCom_parent(int com_parent) {
		this.com_parent = com_parent;
	}
	public String getCom_content() {
		return com_content;
	}
	public void setCom_content(String com_content) {
		this.com_content = com_content;
	}
	public String getCom_writer() {
		return com_writer;
	}
	public void setCom_writer(String com_writer) {
		this.com_writer = com_writer;
	}
	public String getCom_regip() {
		return com_regip;
	}
	public void setCom_regip(String com_regip) {
		this.com_regip = com_regip;
	}
	public String getCom_rdate() {
		return com_rdate;
	}
	public void setCom_rdate(String com_rdate) {
		this.com_rdate = com_rdate;
	}
	
	@Override
	public String toString() {
		return "CommentDTO [comNo=" + comNo + ", com_parent=" + com_parent + ", com_content=" + com_content
				+ ", com_writer=" + com_writer + ", com_regip=" + com_regip + ", com_rdate=" + com_rdate + "]";
	} 
	
}
