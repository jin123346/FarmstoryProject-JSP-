package com.farmstory.util;

public class BOARDSQL {


	// board
	public static final String SELECT_COUNT_TOTAL = "select count(*) from `board`";
	public static final String SELECT_COUNT_TOTAL_CATE = "select count(*) from `board` where b_cateNo=?";
	public static final String INSERT_BOARD = "insert into `board` set "
											   + "`title`=?,"
											   + "`b_contents`=?,"
											   + "`b_fNo`=?,"
											   + "`b_regip`=?,"
											   + "`b_writer`=?,"
											   + "`b_cateNo`=?,"
											   + "`b_rdate`=NOW()";
	public static final String SELECT_MAX_BOARD_NO = "select MAX(`boardNo`) from `board`";
	// 글목록 & 글쓴이를 닉네임으로 조회
	public static final String SELECT_BOARDS = "SELECT a.*, b.nick, " +
											    "(SELECT COUNT(*) FROM `comment` c WHERE c.com_parent = a.boardNo) AS commentCount " +
											    "FROM `board` AS a " +
											    "JOIN `user` AS b ON a.b_writer = b.uid " +
											    "ORDER BY `boardNo` DESC " +
											    "LIMIT ?, 10";
	public static final String SELECT_BOARDS_CATE = "SELECT a.*, b.nick, " +
											    "(SELECT COUNT(*) FROM `comment` c WHERE c.com_parent = a.boardNo) AS commentCount " +
											    "FROM `board` AS a " +
											    "JOIN `user` AS b ON a.b_writer = b.uid "
											    + "WHERE a.b_cateNo= ? "
											    +"ORDER BY `boardNo` DESC "
										    	+"LIMIT ?, 10";

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
	// comment
	public static final String INSERT_COMMENT = "INSERT INTO `comment` SET `com_parent`=?, `com_content`=?, `com_writer` =?, `com_regip`=?, com_rdate=NOW()";
	public static final String INSERT_COMMENT_SELECT = "INSERT INTO `comment` SET `com_parent`=?, `com_content`=?, `com_writer` =?, `com_regip`=?, com_rdate=NOW()";
	public static final String SELECT_COMMENTS = "SELECT c.* , u.NICK FROM comment AS c JOIN `user` AS u ON  u.uid=c.com_writer where com_parent=? order by c.comNo";
	public static final String SELECT_COMMENTS_NO= "SELECT * FROM comment where comNo= ?";

	
	public static final String UPDATE_COMMENT= "UPDATE `comment` SET com_content = ?, com_rdate = now()  where `comNo` = ?";
	public static final String DELETE_COMMENT= "delete from `comment` where `comNo` =?";
		

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
