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
	public static final String SELECT_BOARDS = "SELECT a.*, b.nick, " +
											    "(SELECT COUNT(*) FROM `comment` c WHERE c.com_parent = a.boardNo) AS commentCount " +
											    "FROM `board` AS a " +
											    "JOIN `user` AS b ON a.b_writer = b.uid " +
											    "ORDER BY `boardNo` DESC " +
											    "LIMIT ?, 10";

	public static final String SELECT_BOARD = "select * from `board` AS a "
												+ "LEFT JOIN `boardfile` AS b ON a.`boardNo` = b.b_pNo "
												+ "WHERE `boardNo`=?";
	public static final String UPDATE_BOARD = "update `board` set "
									            + "`title`=?,"
									            + "`b_contents`=?,"
									            + "`b_fNo`=?,"
									            + "`b_regip`=?,"
									            + "`b_writer`=?,"
									            + "`b_rdate`=NOW() "
									            + "where `boardNo`=?"; 
	public static final String UPDATE_BOARD_HIT = "update `board` set `b_hit`= `b_hit` + 1 where `boardNo`=?"; 
	public static final String DELETE_BOARD = "delete from `board` where `boardNo`=?";
	
	
	// file
	public static final String SELECT_BOARD_FILE = "select * from `boardfile` where b_fNo=?";
	public static final String INSERT_BOARD_FILE = "insert into `boardfile` set "
													+ "`b_pNo`=?,"
													+ "`b_oName`=?,"
													+ "`b_sName`=?,"
													+ "`b_rdate`=NOW()";
	public static final String UPDATE_BOARD_FILE_DOWNLOAD_COUNT = "update `boardfile` set `b_download` = `b_download` + 1 where `b_fNo`=?";
	public static final String DELETE_BOARD_FILES = "delete from `boardfile` where b_pNo =?";
	
	
	// comment
	public static final String SELECT_COMMENT = "select * from `comment` where `comNo`=?";
	
	public static final String SELECT_COMMENTS = "SELECT a.*, b.nick from `comment` AS a "
												+ "JOIN `user` AS b ON a.com_writer = b.uid "
												+ "where `com_parent`=? "
												+ "order by comNo";
	
	public static final String INSERT_COMMENT = "insert into `comment` set "
												+ "`com_parent`=?,"
												+ "`com_content`=?,"
												+ "`com_writer`=?,"
												+ "`com_regip`=?,"
												+ "`com_rdate`=NOW()";
	
	public static final String UPDATE_COMMENT = "update `comment` set `com_content`=? where `comNo`=?";
	
	public static final String DELETE_COMMENT = "delete from `comment` where `comNo`=?";

	public static final String DELETE_COMMENTS = "delete from `comment` where com_parent =?";
	
	

		
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
