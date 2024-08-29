package com.farmstory.dao.market;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.market.CartDTO;
import com.farmstory.dto.product.ProductCartDTO;
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
	
	public List<ProductCartDTO> selectCarts(String uid) {
		List<ProductCartDTO> carts = new ArrayList<>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(MARKETSQL.SELECT_CARTS);
			pstmt.setString(1, uid);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductCartDTO dto = new ProductCartDTO();
				dto.setpList_sName(rs.getString(1));
				dto.setProdCateName(rs.getString(2));
				dto.setProdName(rs.getString(3));
				dto.setProdQty(rs.getInt(4));
				dto.setDiscount(rs.getInt(5));
				dto.setPoint(rs.getInt(6));
				dto.setPrice(rs.getInt(7));
				dto.setDelivery(rs.getInt(8));
				dto.setCartNo(rs.getInt(9));
				carts.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return carts;
	}
	
	public int deleteCart(String cartNo) {
		int result = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(MARKETSQL.DELETE_CART);
			pstmt.setString(1, cartNo);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
}
