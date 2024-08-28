package com.farmstory.util;

public class PRODUCTSQL {


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
	public static final String UPDATE_BOARD_FILE_DOWNLOAD_COUNT = "update boardfile set `download` = `download` + 1 where `fno`=?";
	
	
	

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
	
	
	//product
	
	public static final String SELECT_COUNT_TOTAL = "select COUNT(*) from `product`";
	
	public static final String SELECT_PRODUCTS = "SELECT ROW_NUMBER() OVER(ORDER BY `pNo` DESC)"
												+ ", a.*, b.prodCateName FROM `product` as a "
												+ "left join `prodCate` as b on a.prodCateNo = b.prodCateNo"
												+ " ORDER BY `pNo` desc limit ?, 5";


}
