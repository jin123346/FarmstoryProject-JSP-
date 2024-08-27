package com.farmstory.dto.community;

public class BoardCateDTO {

	private String bCateNo;
	private String bCateName;
	

	public String getbCateNo() {
		return bCateNo;
	}
	public void setbCateNo(String bCateNo) {
		this.bCateNo = bCateNo;
	}
	public String getbCateName() {
		return bCateName;
	}
	public void setbCateName(String bCateName) {
		this.bCateName = bCateName;
	}
	
	@Override
	public String toString() {
		return "BoardCateDTO [bCateNo=" + bCateNo + ", bCateName=" + bCateName + "]";
	}
	
}
