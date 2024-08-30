package com.farmstory.dto.market;

public class OrderDTO {
	private int orderNo;
	private String orderDate;
	private int o_totalPrice;
	private int totalQty;
	private String o_uid;
	private String receipt;
	private int o_delivery;
	private String recHp;
	private String recZip;
	private String recAddr1;
	private String recAddr2;
	private int payment;
	private String orderDesc;
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getO_totalPrice() {
		return o_totalPrice;
	}
	public void setO_totalPrice(int o_totalPrice) {
		this.o_totalPrice = o_totalPrice;
	}
	public int getTotalQty() {
		return totalQty;
	}
	public void setTotalQty(int totalQty) {
		this.totalQty = totalQty;
	}
	public String getO_uid() {
		return o_uid;
	}
	public void setO_uid(String o_uid) {
		this.o_uid = o_uid;
	}
	public String getReceipt() {
		return receipt;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	public int getO_delivery() {
		return o_delivery;
	}
	public void setO_delivery(int o_delivery) {
		this.o_delivery = o_delivery;
	}
	public String getRecHp() {
		return recHp;
	}
	public void setRecHp(String recHp) {
		this.recHp = recHp;
	}
	public String getRecZip() {
		return recZip;
	}
	public void setRecZip(String recZip) {
		this.recZip = recZip;
	}
	public String getRecAddr1() {
		return recAddr1;
	}
	public void setRecAddr1(String recAddr1) {
		this.recAddr1 = recAddr1;
	}
	public String getRecAddr2() {
		return recAddr2;
	}
	public void setRecAddr2(String recAddr2) {
		this.recAddr2 = recAddr2;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public String getOrderDesc() {
		return orderDesc;
	}
	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}
	@Override
	public String toString() {
		return "OrderDTO [orderNo=" + orderNo + ", orderDate=" + orderDate + ", o_totalPrice=" + o_totalPrice
				+ ", totalQty=" + totalQty + ", o_uid=" + o_uid + ", receipt=" + receipt + ", o_delivery=" + o_delivery
				+ ", recHp=" + recHp + ", recZip=" + recZip + ", recAddr1=" + recAddr1 + ", recAddr2=" + recAddr2
				+ ", payment=" + payment + ", orderDesc=" + orderDesc + "]";
	}
}
