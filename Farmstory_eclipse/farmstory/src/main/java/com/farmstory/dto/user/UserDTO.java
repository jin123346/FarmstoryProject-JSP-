package com.farmstory.dto.user;

public class UserDTO {
	
	private String uid;
	private String pass;
	private String name;
	private String nick;
	private String email;
	private String hp;
	private String zip;
	private String addr1;
	private String addr2;
	private String regDate;
	private String gradeNo;

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getGradeNo() {
		return gradeNo;
	}
	public void setGradeNo(String gradeNo) {
		this.gradeNo = gradeNo;
	}
	@Override
	public String toString() {
		return "UserDTO [uid=" + uid + ", pass=" + pass + ", name=" + name + ", nick=" + nick + ", email=" + email
				+ ", hp=" + hp + ", zip=" + zip + ", addr1=" + addr1 + ", addr2=" + addr2 + ", regDate=" + regDate
				+ ", gradeNo=" + gradeNo + "]";
	}
	
}
