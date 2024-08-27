package com.farmstory.dto.admin;
// 관리자 상품관리 > 상품목록 
public class ProductListDTO {

	// 추가필드 사진 (상품목록 이미지)
	private String pList_oName; // 상품목록 이미지
	
	private int pNo; // 상품번호
	//private String cate; // 카테고리 // 구분 (과일)
	//private String prodCateNo; // 구분 (과일)
	private String prodCateName; // 구분 (과일)
	private String pName; // 상품명
	private int price; // 가격 
	private int stock; // 재고
	private int rdate; // 등록일
	
	public String getpList_oName() {
		return pList_oName;
	}
	public void setpList_oName(String pList_oName) {
		this.pList_oName = pList_oName;
	}
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public String getProdCateName() {
		return prodCateName;
	}
	public void setProdCateName(String prodCateName) {
		this.prodCateName = prodCateName;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getRdate() {
		return rdate;
	}
	public void setRdate(int rdate) {
		this.rdate = rdate;
	}
	
	@Override
	public String toString() {
		return "AdminProductListDTO [pList_oName=" + pList_oName + ", pNo=" + pNo + ", prodCateName=" + prodCateName
				+ ", pName=" + pName + ", price=" + price + ", stock=" + stock + ", rdate=" + rdate + "]";
	}
}
