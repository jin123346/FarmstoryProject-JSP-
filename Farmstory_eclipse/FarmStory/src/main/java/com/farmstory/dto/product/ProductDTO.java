package com.farmstory.dto.product;

public class ProductDTO {
	private int row;
	private int pNo;
	private String prodCateNo;
	private String pName;
	private int price;
	private int point;
	private int discount;
	private int delivery;
	private int pList_fNo;
	private int pBasic_fNo;
	private int pDesc_fNo;
	private String prodCateName;
	private String pListimgPath;
	private String sName;
	private String sNameB;
	private String sNameD;
	
	
	public String getsNameB() {
		return sNameB;
	}
	public void setsNameB(String sNameB) {
		this.sNameB = sNameB;
	}
	public String getsNameD() {
		return sNameD;
	}
	public void setsNameD(String sNameD) {
		this.sNameD = sNameD;
	}
	
	
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getpListimgPath() {
		return pListimgPath;
	}
	public void setpListimgPath(String pListimgPath) {
		this.pListimgPath = pListimgPath;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public String getProdCateName() {
		return prodCateName;
	}
	public void setProdCateName(String prodCateName) {
		this.prodCateName = prodCateName;
	}
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public String getProdCateNo() {
		return prodCateNo;
	}
	public void setProdCateNo(String prodCateNo) {
		this.prodCateNo = prodCateNo;
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

	@Override
	public String toString() {
		return "ProductDTO [row=" + row + ", pNo=" + pNo + ", prodCateNo=" + prodCateNo + ", pName=" + pName
				+ ", price=" + price + ", point=" + point + ", discount=" + discount + ", delivery=" + delivery
				+ ", pList_fNo=" + pList_fNo + ", pBasic_fNo=" + pBasic_fNo + ", pDesc_fNo=" + pDesc_fNo
				+ ", prodCateName=" + prodCateName + ", pListimgPath=" + pListimgPath + ", sName=" + sName + ", sNameB="
				+ sNameB + ", sNameD=" + sNameD + "]";
	}
	
}
