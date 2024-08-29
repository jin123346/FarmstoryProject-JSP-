package com.farmstory.dto.admin;

public class OrderItemDTO {
	private int OrderItemNo;
	private int OrderNo;
	private int pNo;
	private String orderDate;
	private int itemPrice;
	private int itemQty;
	private int o_discount;
	private String pName;
	private int o_delivery;
	private String name;
	private int OrderItemTotal;
	
	
	
	
	public void setOrderItemTotal() {
		OrderItemTotal = itemPrice*itemQty;
	}

	public int getOrderItemTotal() {
		
		return OrderItemTotal;
	}

	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getO_delivery() {
		return o_delivery;
	}
	public void setO_delivery(int o_delivery) {
		this.o_delivery = o_delivery;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "OrderItemDTO [OrderItemNo=" + OrderItemNo + ", OrderNo=" + OrderNo + ", pNo=" + pNo + ", orderDate="
				+ orderDate + ", itemPrice=" + itemPrice + ", itemQty=" + itemQty + ", o_discount=" + o_discount + "]";
	}
	public int getOrderItemNo() {
		return OrderItemNo;
	}
	public void setOrderItemNo(int orderItemNo) {
		OrderItemNo = orderItemNo;
	}
	public int getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(int orderNo) {
		OrderNo = orderNo;
	}
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public void setSubStringOrderDate(String orderDate) {
		this.orderDate = orderDate.substring(0,10);
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public void setItemDiscountPrice(int itemPrice) {
		if(this.o_discount>0) {
			this.itemPrice = (int)itemPrice*(100-this.o_discount)*100;
		}else {
			this.itemPrice = itemPrice;
		}
		
	}
	public int getItemQty() {
		return itemQty;
	}
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}
	public int getO_discount() {
		return o_discount;
	}
	public void setO_discount(int o_discount) {
		this.o_discount = o_discount;
	}
	
	
	
	

}
