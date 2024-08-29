package com.farmstory.util;

public class SQL {


	// board
	public static final String INSERT_BOARD = "insert into `board` set "
											   + "`title`=?,"
											   + "`b_contents`=?,"
											   + "`b_fNo`=?,"
											   + "`b_regip`=?,"
											   + "`b_writer`=?,"
											   + "`b_rdate`=NOW()";
	public static final String SELECT_MAX_BOARD_NO = "select MAX(`boardNo`) from `board`";
	
	
	// file
	public static final String SELECT_BOARD_FILE = "select * from boardfile where b_fNo=?";
	public static final String INSERT_BOARD_FILE = "insert into boardfile set "
													+ "`b_pNo`=?,"
													+ "`b_oName`=?,"
													+ "`b_sName`=?,"
													+ "`b_rdate`=NOW()";
	public static final String UPDATE_BOARD_FILE_DOWNLOAD_COUNT = "update boardfile set `b_download` = `b_download` + 1 where `b_fNo`=?";
	
	
	

		//cart	
		
		//point	
		
		//order	
		
		//file	
		
		//terms
		
		//user	
		public static final String INSERT_USER = "insert into `user` set"
												+ "`uid`=?, "
												+ "`pass`=?, "
												+ "`name`=?, "
												+ "`nick`=?, "
												+ "`email`=?, "
												+ "`hp`=?, "
												+ "`zip`=?, "
												+ "`addr1`=?, "
												+ "`addr2`=?, "
												+ "`regDate`= NOW()";

	

	
	

	public static final String SELECT_USER=  "select * from `user` where uid=? and pass=sha2(?,256)";
	
	
	// admin 
	// product list
	public static final String SELECT_PRODUCT_LIST = "SELECT p.pNo, p.pName, p.prodCateNo, p.price, p.stock, p.rdate , b.pList_sName  from product as p left join  plistimgfile as b on b.pList_fNo = p.pList_FNo order by pNo desc ";
	public static final String SELECT_PRODUCT_LIST_START = "SELECT p.pNo, p.pName, p.prodCateNo, p.price, p.stock, p.rdate , b.pList_sName  from product as p left join  plistimgfile as b on b.pList_fNo = p.pList_FNo order by pNo desc LIMIT ?,5";
										
	public static final String INSERT_PRODUCT_LIST = "insert into `product` set "
												   + "`pList_oName`=?,"
												   + "`pNo`=?,"
												   + "`prodCateName`=?,"
												   + "`pName`=?,"
												   + "`price`=?,"
												   + "`stock`=?,"
												   + "`rdate`=?";
	
	public static final String SELECT_PRODUCT_LIST_MAIN = "SELECT p.pNo, p.pName, p.prodCateNo, p.price, p.stock, p.rdate , b.pList_sName  from product as p left join  plistimgfile as b on b.pList_fNo = p.pList_FNo order by pNo desc limit 0,3";


	
	
	
	


}
