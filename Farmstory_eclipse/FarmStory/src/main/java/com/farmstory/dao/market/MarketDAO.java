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
			pstmt.setInt(1, dto.getCartNo());
			pstmt.setString(2, dto.getC_uid());
			pstmt.setInt(3, dto.getProdNo());
			pstmt.setInt(4, dto.getCartProdQty());
			pstmt.setString(5, dto.getCartProdDate());
			
			result = pstmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return result;
		
	}
	
}
