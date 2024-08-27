package com.farmstory.util;

public class SQL {
	
	public static final String INSERT_BOARD = "insert into board set"
												+ "`title`=?,"
												+ "`B_contents`=?,"
												+ "`B_fNo`=?,"
												+ "`B_writer`=?,"
												+ "`B_regip`=?,"
												+ "`B_rdate`=NOW()";
}
