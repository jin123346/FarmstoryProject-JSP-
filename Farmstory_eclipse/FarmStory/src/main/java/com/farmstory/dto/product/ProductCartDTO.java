package com.farmstory.dto.product;

public class ProductCartDTO {

	private String prodCateName;
	private String prodName;
	private int prodQty;
	private int discount;
	private int point;
	private int price;
	private String pList_sName;

	public String getProdCateName() {
		return prodCateName;
	}
	public void setProdCateName(String prodCateName) {
		this.prodCateName = prodCateName;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getProdQty() {
		return prodQty;
	}
	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getpList_sName() {
		return pList_sName;
	}
	public void setpList_sName(String pList_sName) {
		this.pList_sName = pList_sName;
	}
	@Override
	public String toString() {
		return "ProductCartDTO [prodCateName=" + prodCateName + ", prodName=" + prodName + ", prodQty=" + prodQty
				+ ", discount=" + discount + ", point=" + point + ", price=" + price + ", pList_sName=" + pList_sName
				+ "]";
	}
	
}
