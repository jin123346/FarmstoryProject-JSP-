package com.farmstory.dao.market;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.market.CartDTO;
import com.farmstory.dto.market.OrderDTO;
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
				dto.setProdCateName(rs.getString(1));
				dto.setProdName(rs.getString(2));
				dto.setProdQty(rs.getInt(3));
				dto.setDiscount(rs.getInt(4));
				dto.setPoint(rs.getInt(5));
				dto.setPrice(rs.getInt(6));
				dto.setDelivery(rs.getInt(7));
				dto.setCartNo(rs.getInt(8));
				dto.setpList_sName(rs.getString(9));
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
	
	public void insertPoint(String uid ,int point) {
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(MARKETSQL.INSERT_POINT);
			pstmt.setInt(1, point);
			pstmt.setString(2, uid);
			
			pstmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public int insertOrder(OrderDTO dto) {
		
		int result = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(MARKETSQL.INSERT_ORDER);
			pstmt.setInt(1, dto.getO_totalPrice());
			pstmt.setInt(2, dto.getTotalQty());
			pstmt.setString(3, dto.getO_uid());
			pstmt.setString(4, dto.getReceipt());
			pstmt.setInt(5, dto.getO_delivery());
			pstmt.setString(6, dto.getRecHp());
			pstmt.setString(7, dto.getRecZip());
			pstmt.setString(8, dto.getRecAddr1());
			pstmt.setString(9, dto.getRecAddr2());
			pstmt.setInt(10, dto.getPayment());
			pstmt.setString(11, dto.getOrderDesc());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return result;
	}
	
}
