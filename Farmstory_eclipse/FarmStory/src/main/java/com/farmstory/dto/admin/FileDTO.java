package com.farmstory.dto.admin;

public class FileDTO {
	private int fno;
	private int pNo;
	private String oName;
	private String sName;
	private String rdate;
	
	private String fieldName;
	private String pfileCate;
	
	

	
	public String getPfileCate() {
		return pfileCate;
	}
	public void setPfileCate(String pfileCate) {
		this.pfileCate = pfileCate;
	}
	private FileBasicDTO fileBaseDto;
	private FileDescDTO fileDescDto;
	private FileListDTO fileListDto;
	
	
	
	
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public String getoName() {
		return oName;
	}
	public void setoName(String oName) {
		this.oName = oName;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public FileBasicDTO getFileBaseDto() {
		return fileBaseDto;
	}
	public void setFileBaseDto(FileBasicDTO fileBaseDto) {
		this.fileBaseDto = fileBaseDto;
	}
	public FileDescDTO getFileDescDto() {
		return fileDescDto;
	}
	public void setFileDescDto(FileDescDTO fileDescDto) {
		this.fileDescDto = fileDescDto;
	}
	public FileListDTO getFileListDto() {
		return fileListDto;
	}
	public void setFileListDto(FileListDTO fileListDto) {
		this.fileListDto = fileListDto;
	}
	
	public String toStringdto() {
		return "FileDTO [fileBaseDto=" + fileBaseDto + ", fileDescDto=" + fileDescDto + ", fileListDto=" + fileListDto
				+ "]";
	}
	@Override
	public String toString() {
		return "FileDTO [fno=" + fno + ", pNo=" + pNo + ", oName=" + oName + ", sName=" + sName + ", rdate=" + rdate
				+ ", fieldName=" + fieldName + "]";
	}
	
	
	
	
	
	

}
