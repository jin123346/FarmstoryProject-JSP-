package com.farmstory.dto.community;

public class PageGroupDTO {

	private int start;
	private int end;
	
	// 생성자
	public PageGroupDTO(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	@Override
	public String toString() {
		return "PageGroupDTO [start=" + start + ", end=" + end + "]";
	}

}
