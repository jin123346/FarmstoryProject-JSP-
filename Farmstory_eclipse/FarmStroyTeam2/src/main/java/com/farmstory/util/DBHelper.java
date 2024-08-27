package com.farmstory.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBHelper {

	protected Connection conn=null;
	protected Statement stmt=null;
	protected PreparedStatement pstmt=null;
	protected ResultSet rs=null;

	
	
	protected Connection getConnection() throws NamingException, SQLException{
	
			Context initCtx = new InitialContext();
			Context ctx =(Context) initCtx.lookup("java:comp/env");
			//2단계 - 커넥션 풀에서 커넥션 객체 가져오기
			DataSource ds = (DataSource)ctx.lookup("jdbc/farmstroy");
			return ds.getConnection();
			
		
		
	}
	protected void closeAll() throws SQLException {
		if(rs !=null) {
			rs.close();
		}
		if(stmt !=null) {
			stmt.close();
		}
		if(pstmt !=null) {
			pstmt.close();
		}
		if(conn !=null) {
			conn.close();
		}
	}

}
