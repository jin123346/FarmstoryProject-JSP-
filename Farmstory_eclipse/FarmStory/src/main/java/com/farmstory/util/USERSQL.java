package com.farmstory.util;

public class USERSQL {


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
		public static final String SELECT_USERS_MAIN = "select * from `user` order by `uid` limit 0,3";

		public static final String SELECT_COUNT_USER = "SELECT COUNT(*) FROM `user`";
		public static final String SELECT_COUNT_USERS = "SELECT * FROM `user` LIMIT ?,10";
		
		public static final String WHERE_UID = "WHERE `uid`=?";
		public static final String WHERE_NICK = "WHERE `nick`=?";
		public static final String WHERE_EMAIL = "WHERE `email`=?";
		public static final String WHERE_HP = "WHERE `hp`=?";

	
	

	public static final String SELECT_USER=  "select * from `user` where uid=? and pass=sha2(?,256)";
	
	public static final String DELETE_USER = " delete from `user` where `uid` =?";


}
