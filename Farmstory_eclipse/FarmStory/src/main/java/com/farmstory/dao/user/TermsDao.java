package com.farmstory.dao.user;

import com.farmstory.dto.user.TermsDTO;
import com.farmstory.util.DBHelper;
import com.farmstory.util.SQL;
import com.farmstory.util.USERSQL;

public class TermsDao extends DBHelper{

	private static TermsDao instance = new TermsDao();
	
	public static TermsDao getInstance() {
		return instance;
	}
	
	private TermsDao () {}
	
	public TermsDTO selectTerms() {
		TermsDTO dto = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(USERSQL.SELECT_TERMS);
			
			if(rs.next()) {
				dto = new TermsDTO();
				dto.setTerms(rs.getString(1));
				dto.setPrivacy(rs.getString(2));
			}
				closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
}
