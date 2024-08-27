package com.farmstory.util;

public class BOARDSQL {


	// board
	public static final String SELECT_COUNT_TOTAL = "select count(*) from `board`";
	public static final String INSERT_BOARD = "insert into `board` set "
											   + "`title`=?,"
											   + "`b_contents`=?,"
											   + "`b_fNo`=?,"
											   + "`b_regip`=?,"
											   + "`b_writer`=?,"
											   + "`b_rdate`=NOW()";
	public static final String SELECT_MAX_BOARD_NO = "select MAX(`boardNo`) from `board`";
	// 글목록 & 글쓴이를 닉네임으로 조회
	public static final String SELECT_BOARDS = "select a.*, b.nick from `board` AS a "
												+ "JOIN `user` AS b ON a.b_writer = b.uid "
												+ "ORDER BY `boardNo` DESC "
												+ "LIMIT ?, 10";
	
	// file
	public static final String SELECT_BOARD_FILE = "select * from `boardfile` where b_fNo=?";
	public static final String INSERT_BOARD_FILE = "insert into `boardfile` set "
													+ "`b_pNo`=?,"
													+ "`b_oName`=?,"
													+ "`b_sName`=?,"
													+ "`b_rdate`=NOW()";
	public static final String UPDATE_BOARD_FILE_DOWNLOAD_COUNT = "update `boardfile` set `download` = `download` + 1 where `b_fNo`=?";
	
	
	

		
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
	
	


}
