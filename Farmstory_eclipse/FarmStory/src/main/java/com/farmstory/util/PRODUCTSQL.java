package com.farmstory.util;

public class PRODUCTSQL {




	//order
	
	public final static String SELECT_ORDERITEM_COUNT_TOTAL = "select count(*) from `orderitem`";
			
//	public final static String SELECT_ORDERITEMS = "SELECT a.orderItemNo ,"
//																+ "a.orderNo, "
//																+ "a.itemPrice, "
//																+ "pName, "
//																+ "a.itemQty, "
//																+ "b.o_delivery, "
//																+ "u.name, "
//																+ "a.orderDate ,"
//																+ "a.pNo"
//													+ "FROM orderitem AS a "
//													+ "JOIN `order` AS b ON a.orderNo = b.orderNo "
//													+ "JOIN product AS c ON c.pNo = a.pNo "
//													+ "JOIN user AS u ON u.uid=b.o_uid "
//													+ "order BY orderNo DESC "
//													+ "LIMIT ?,10";
	public final static String SELECT_ORDERITEMS = "SELECT a.orderItemNo, "
										            + "a.orderNo, "
										            + "a.itemPrice, "
										            + "c.pName, "
										            + "a.itemQty, "
										            + "b.o_delivery, "
										            + "u.`name`, "
										            + "a.orderDate, "
										            + "a.pNo "
										            + "FROM `orderitem` AS a "
										            + "JOIN `order` AS b ON a.orderNo = b.orderNo "
										            + "JOIN `product` AS c ON c.pNo = a.pNo "
										            + "JOIN `user` AS u ON u.uid = b.o_uid "
										            + "ORDER BY a.orderNo DESC "
										            + "LIMIT ?, 10;";
	
	
	public final static String SELECT_ORDERITEMS_MAIN = "SELECT a.orderItemNo, "
						            + "a.orderNo, "
						            + "a.itemPrice, "
						            + "c.pName, "
						            + "a.itemQty, "
						            + "b.o_delivery, "
						            + "u.`name`, "
						            + "a.orderDate, "
						            + "a.pNo "
						            + "FROM `orderitem` AS a "
						            + "JOIN `order` AS b ON a.orderNo = b.orderNo "
						            + "JOIN `product` AS c ON c.pNo = a.pNo "
						            + "JOIN `user` AS u ON u.uid = b.o_uid "
						            + "ORDER BY a.orderNo DESC "
						            + "LIMIT ?, 3;";

	
	


	
	//file
	
	public final static String Select_List_File_fno = "select pList_fNo from pListimgfile where pNo=?";
	
	public final static String Select_basic_File_fno = "select pBasic_fNo from pBasicimgfile where pNo=?";
  public final static String Select_Desc_File_fno = "select pDesc_fNo from pDescimgfile where pNo=?";

  
	//product
	
	public static final String SELECT_COUNT_TOTAL = "select COUNT(*) from `product`";
	public static final String SELECT_COUNT_TOTAL_A = "select COUNT(*) from `product` as a "
														+ "join `prodcate` as b on a.prodCateNo = b.prodCateNo "
														+ " where `prodCateName`=?";
	
	public static final String SELECT_PRODUCTS = "SELECT ROW_NUMBER() OVER(ORDER BY `pNo` DESC)"
												+ ", a.*, b.prodCateName FROM `product` as a "
												+ "join `prodcate` as b on a.prodCateNo = b.prodCateNo"
												+ " ORDER BY `pNo` desc limit ?, 5";

	public static final String SELECT_PRODUCTS_MAIN = "SELECT a.pNo, a.prodCateNo, a.pName, a.price, a.discount, a.pList_fNo, a.pBasic_fNo, a.pDesc_fNo, b.prodCateName FROM `product` as a "
														+ "join `prodcate` as b on a.prodCateNo = b.prodCateNo order by `pNo` desc";

	public final static String INSERT_LIST_IMG_FILE= "insert into `pListImgFile` set pno=?, pList_oName =? , pList_sName=?, rdate = now()";
	public final static String INSERT_BASIC_IMG_FILE= "insert into `pBasicImgFile` set pno=?, pBasic_oName =? , pBasic_sName=?, rdate = now()";
	public final static String INSERT_DESC_IMG_FILE= "insert into `pDescImgFile` set pno=?, pDesc_oName =? , pDesc_sName=?, rdate = now()";
	
	public static final String SELECT_PRODUCTSA = "SELECT ROW_NUMBER() OVER(ORDER BY `pNo` DESC)"
												+ ", a.*, b.prodCateName FROM `product` as a "
												+ "join `prodcate` as b on a.prodCateNo = b.prodCateNo "
												+ "where `prodCateName` = ? "
												+ "ORDER BY `pNo` desc limit ?, 5 ";

	public static final String SELECT_PRODUCT = "select * from `product` where `pNo` = ?";
	
	
	
	

}
