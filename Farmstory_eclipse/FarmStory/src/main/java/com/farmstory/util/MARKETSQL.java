package com.farmstory.util;

public class MARKETSQL {


	

		//cart	
		public static final String INSERT_CART = "insert into `cart` set"
												+ "`c_uid`=?, "
												+ "`prodNo`=?, "
												+ "`cartProdQty`=?, "
												+ "`cartProdDate`=NOW()";
		
		public static final String DELETE_CART = "delete from `cart` where `cartNo` = ?";
		
		public static final String SELECT_CARTS = "SELECT  a.prodCateName, b.pName, c.cartProdQty, b.discount, b.point, b.price, b.delivery, c.cartNo, d.pList_sName "
												+ "FROM prodcate AS a JOIN product AS b USING(`prodCateNo`) "
												+ "JOIN cart AS c ON c.prodNo = b.pNo "
												+ "left JOIN plistimgfile AS d ON b.pNo = d.pNo "
												+ "WHERE `c_uid` = ?";
		
		public static final String INSERT_POINT = "update `user` set `point` = ? where `uid` = ? ";
		
		
		//point	
		//order	
		public static final String INSERT_ORDER = "insert into `order` set"
												+ "`orderDate`= NOW(), "
												+ "`o_totalPrice`= ?, "
												+ "`totalQty`= ?, "
												+ "`o_uid`= ?, "
												+ "`receipt`= ?, "
												+ "`o_delivery`= ?, "
												+ "`recHp`= ?, "
												+ "`recZip`= ?, "
												+ "`recAddr1`= ?, "
												+ "`recAddr2`= ?, "
												+ "`payment`= ?, "
												+ "`orderDesc`= ? ";
		//file	
		
		//terms
		public static final String SELECT_TERMS = "select * from `terms`";
		//user	
		public static final String INSERT_USER = "insert into `user` set"
												+ "`uid`=?, "
												+ "`pass`=sha2(?,256), "
												+ "`name`=?, "
												+ "`nick`=?, "
												+ "`email`=?, "
												+ "`hp`=?, "
												+ "`zip`=?, "
												+ "`addr1`=?, "
												+ "`addr2`=?, "
												+ "`regDate`= NOW()";
		
		public static final String SELECT_USERS = "select * from `user`";

		public static final String SELECT_COUNT_USER = "SELECT COUNT(*) FROM `user`";
		public static final String WHERE_UID = "WHERE `uid`=?";
		public static final String WHERE_NICK = "WHERE `nick`=?";
		public static final String WHERE_EMAIL = "WHERE `email`=?";
		public static final String WHERE_HP = "WHERE `hp`=?";

	
	

	public static final String SELECT_USER=  "select * from `user` where uid=? and pass=sha2(?,256)";
	
	


}
