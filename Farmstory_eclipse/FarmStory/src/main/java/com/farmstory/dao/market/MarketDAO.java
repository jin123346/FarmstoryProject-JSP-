package com.farmstory.dao.market;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.market.CartDTO;
import com.farmstory.util.DBHelper;
import com.farmstory.util.MARKETSQL;

public class MarketDAO extends DBHelper{

	private static MarketDAO instance = new MarketDAO();
	
	public static MarketDAO getInstance() {
		return instance;
	}
	
	private MarketDAO () {}
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public int insertCart (CartDTO dto) {
		
		int result = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(MARKETSQL.INSERT_CART);
			pstmt.setString(1, dto.getC_uid());
			pstmt.setInt(2, dto.getProdNo());
			pstmt.setInt(3, dto.getCartProdQty());
			
			result = pstmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return result;
		
	}
	
}
