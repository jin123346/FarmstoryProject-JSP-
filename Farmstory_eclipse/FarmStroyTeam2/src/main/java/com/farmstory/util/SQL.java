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
	public static final String UPDATE_BOARD_FILE_DOWNLOAD_COUNT = "update boardfile set `download` = `download` + 1 where `fno`=?";
	
	
	
	
	
}
