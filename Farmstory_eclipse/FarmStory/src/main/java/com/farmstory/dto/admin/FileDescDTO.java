package com.farmstory.dto.admin;

public class FileDescDTO {
	private int pDesc_fno;
	private int pNo;
	private String pDesc_oName;
	private String pDesc_sName;
	private String rdate;
	public int getpDesc_fno() {
		return pDesc_fno;
	}
	public void setpDesc_fno(int pDesc_fno) {
		this.pDesc_fno = pDesc_fno;
	}
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public String getpDesc_oName() {
		return pDesc_oName;
	}
	public void setpDesc_oName(String pDesc_oName) {
		this.pDesc_oName = pDesc_oName;
	}
	public String getpDesc_sName() {
		return pDesc_sName;
	}
	public void setpDesc_sName(String pDesc_sName) {
		this.pDesc_sName = pDesc_sName;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	@Override
	public String toString() {
		return "FileDescDTO [pDesc_fno=" + pDesc_fno + ", pNo=" + pNo + ", pDesc_oName=" + pDesc_oName
				+ ", pDesc_sName=" + pDesc_sName + ", rdate=" + rdate + "]";
	}
	
	

}
