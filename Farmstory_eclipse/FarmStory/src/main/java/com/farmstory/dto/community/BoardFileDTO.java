package com.farmstory.dto.community;

public class BoardFileDTO {

	private int b_fNo;
	private int b_pNo;
	private String b_oName;
	private String b_sName;
	private String b_rdate;
	private int b_download;
	
	
	public int getB_fNo() {
		return b_fNo;
	}
	public void setB_fNo(int b_fNo) {
		this.b_fNo = b_fNo;
	}
	public int getB_pNo() {
		return b_pNo;
	}
	public void setB_pNo(int b_pNo) {
		this.b_pNo = b_pNo;
	}
	public void setB_pNo(String b_pNo) {
		this.b_pNo = Integer.parseInt(b_pNo);
	}
	public String getB_oName() {
		return b_oName;
	}
	public void setB_oName(String b_oName) {
		this.b_oName = b_oName;
	}
	public String getB_sName() {
		return b_sName;
	}
	public void setB_sName(String b_sName) {
		this.b_sName = b_sName;
	}
	public String getB_rdate() {
		return b_rdate;
	}
	public void setB_rdate(String b_rdate) {
		this.b_rdate = b_rdate;
	}
	public int getB_download() {
		return b_download;
	}
	public void setB_download(int b_download) {
		this.b_download = b_download;
	}
	
	@Override
	public String toString() {
		return "BoardFileDTO [b_fNo=" + b_fNo + ", b_pNo=" + b_pNo + ", b_oName=" + b_oName + ", b_sName=" + b_sName
				+ ", b_rdate=" + b_rdate + ", b_download=" + b_download + "]";
	}
	
}
