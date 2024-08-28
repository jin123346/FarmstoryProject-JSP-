package com.farmstory.dto.admin;

public class ProductDTO {
	private int pNo;
	private String p_sellerNo;
	private String prodCateNo;
	private String pName;
	private int price;
	private int stock;
	private int point;
	private int discount;
	private int delivery;
	private int pList_fNo;
	private int pBasic_fNo;
	private int pDesc_fNo;
	private String rdate;
	private String pDesc;

	
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public String getP_sellerNo() {
		return p_sellerNo;
	}
	public void setP_sellerNo(String p_sellerNo) {
		this.p_sellerNo = p_sellerNo;
	}
	public String getProdCateNo() {
		return prodCateNo;
	}
	public void setProdCateNo(String prodCateNo) {
		this.prodCateNo = prodCateNo;
	}
	public int getProdCateNoAsInt() {
        try {
            return Integer.parseInt(prodCateNo);
        } catch (NumberFormatException e) {
            // 기본값이나 오류 처리
            return 0; // 또는 예외를 던지거나 로그를 기록하는 방식으로 처리할 수 있음
        }
    }
	public void setProdCateNo(int prodCateNo) {
        this.prodCateNo = Integer.toString(prodCateNo);
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
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getDelivery() {
		return delivery;
	}
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	public int getpList_fNo() {
		return pList_fNo;
	}
	public void setpList_fNo(int pList_fNo) {
		this.pList_fNo = pList_fNo;
	}
	public int getpBasic_fNo() {
		return pBasic_fNo;
	}
	public void setpBasic_fNo(int pBasic_fNo) {
		this.pBasic_fNo = pBasic_fNo;
	}
	public int getpDesc_fNo() {
		return pDesc_fNo;
	}
	public void setpDesc_fNo(int pDesc_fNo) {
		this.pDesc_fNo = pDesc_fNo;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getpDesc() {
		return pDesc;
	}
	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}

	@Override
	public String toString() {
		return "ProductDTO [pNo=" + pNo + ", p_sellerNo=" + p_sellerNo + ", prodCateNo=" + prodCateNo + ", pName="
				+ pName + ", price=" + price + ", stock=" + stock + ", point=" + point + ", discount=" + discount
				+ ", delivery=" + delivery + ", pList_fNo=" + pList_fNo + ", pBasic_fNo=" + pBasic_fNo + ", pDesc_fNo="
				+ pDesc_fNo + ", rdate=" + rdate + ", pDesc=" + pDesc + "]";
		}

	}
	
	

	
	
	
	
	


