package com.farmstory.dto.market;

public class CartDTO {
	private int cartNo;
	private String c_uid;
	private int prodNo;
	private int cartProdQty;
	private String cartProdDate;
	
	public int getCartNo() {
		return cartNo;
	}
	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}
	public String getC_uid() {
		return c_uid;
	}
	public void setC_uid(String c_uid) {
		this.c_uid = c_uid;
	}
	public int getProdNo() {
		return prodNo;
	}
	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}
	public int getCartProdQty() {
		return cartProdQty;
	}
	public void setCartProdQty(int cartProdQty) {
		this.cartProdQty = cartProdQty;
	}
	public String getCartProdDate() {
		return cartProdDate;
	}
	public void setCartProdDate(String cartProdDate) {
		this.cartProdDate = cartProdDate;
	}

	@Override
	public String toString() {
		return "CartDTO [cartNo=" + cartNo + ", c_uid=" + c_uid + ", prodNo=" + prodNo + ", cartProdQty=" + cartProdQty
				+ ", cartProdDate=" + cartProdDate + "]";
	}
}
