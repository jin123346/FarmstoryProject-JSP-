package com.farmstory.dto.admin;

public class FileBasicDTO {
	private int pBasic_fno;
	private int pNo;
	private String pBasic_oName;
	private String pBasic_sName;
	private String rdate;
	public int getpBasic_fno() {
		return pBasic_fno;
	}
	public void setpBasic_fno(int pBasic_fno) {
		this.pBasic_fno = pBasic_fno;
	}
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public String getpBasic_oName() {
		return pBasic_oName;
	}
	public void setpBasic_oName(String pBasic_oName) {
		this.pBasic_oName = pBasic_oName;
	}
	public String getpBasic_sName() {
		return pBasic_sName;
	}
	public void setpBasic_sName(String pBasic_sName) {
		this.pBasic_sName = pBasic_sName;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	@Override
	public String toString() {
		return "FileBasicDTO [pBasic_fno=" + pBasic_fno + ", pNo=" + pNo + ", pBasic_oName=" + pBasic_oName
				+ ", pBasic_sName=" + pBasic_sName + ", rdate=" + rdate + "]";
	}
	
	

}
