package com.farmstory.dto.admin;

public class FileListDTO {
	private int pList_fno;
	private int pNo;
	private String pList_oName;
	private String pList_sName;
	private String rdate;
	
	
	public int getpList_fno() {
		return pList_fno;
	}
	public void setpList_fno(int pList_fno) {
		this.pList_fno = pList_fno;
	}
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public String getpList_oName() {
		return pList_oName;
	}
	public void setpList_oName(String pList_oName) {
		this.pList_oName = pList_oName;
	}
	public String getpList_sName() {
		return pList_sName;
	}
	public void setpList_sName(String pList_sName) {
		this.pList_sName = pList_sName;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	@Override
	public String toString() {
		return "FileListDTO [pList_fno=" + pList_fno + ", pNo=" + pNo + ", pList_oName=" + pList_oName
				+ ", pList_sName=" + pList_sName + ", rdate=" + rdate + "]";
	}
	
	
	

}
