package com.farmstory.dao.product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.product.ProductDTO;
import com.farmstory.util.BOARDSQL;
import com.farmstory.util.DBHelper;
import com.farmstory.util.PRODUCTSQL;

public class ProductDAO extends DBHelper{
	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}
	
	private ProductDAO () {}
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public void insertProduct() {}
	public ProductDTO selectProduct(String pNo) {
		
		ProductDTO dto = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(PRODUCTSQL.SELECT_PRODUCT);
			pstmt.setString(1, pNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new ProductDTO();
				dto.setpNo(rs.getInt(1));
				dto.setpName(rs.getString(3));
				dto.setPrice(rs.getInt(4));
				dto.setDelivery(rs.getInt(8));
				dto.setpBasic_fNo(rs.getInt(10));
			}
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return dto;
	}
	
	public int selectCountTotal() {
		int total = 0;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(PRODUCTSQL.SELECT_COUNT_TOTAL);
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return total;
	}
	
	public int selectCountTotalA(String cateName) {
		int total = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(PRODUCTSQL.SELECT_COUNT_TOTAL_A);
			pstmt.setString(1, cateName);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return total;
	}
	
	public List<ProductDTO> selectProducts(int start) {
		
		List<ProductDTO> products = new ArrayList<>();
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(PRODUCTSQL.SELECT_PRODUCTS);
			pstmt.setInt(1, start);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setRow(rs.getInt(1));
				dto.setpNo(rs.getInt(2));
				dto.setProdCateNo(rs.getString(3));
				dto.setpName(rs.getString(4));
				dto.setPrice(rs.getInt(5));
				dto.setPoint(rs.getInt(7));
				dto.setDiscount(rs.getInt(8));
				dto.setDelivery(rs.getInt(9));
				dto.setpList_fNo(rs.getInt(10));
				dto.setpBasic_fNo(rs.getInt(11));
				dto.setpDesc_fNo(rs.getInt(12));
				dto.setProdCateName(rs.getString(15));
				products.add(dto);
				
				
			}
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
				
		return products;
	}
	
	public List<ProductDTO> selectProductsA(int start, String cateName) {
		
		List<ProductDTO> products = new ArrayList<>();
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(PRODUCTSQL.SELECT_PRODUCTSA);
			pstmt.setString(1, cateName);
			pstmt.setInt(2, start);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setRow(rs.getInt(1));
				dto.setpNo(rs.getInt(2));
				dto.setProdCateNo(rs.getString(3));
				dto.setpName(rs.getString(4));
				dto.setPrice(rs.getInt(5));
				dto.setPoint(rs.getInt(7));
				dto.setDiscount(rs.getInt(8));
				dto.setDelivery(rs.getInt(9));
				dto.setpList_fNo(rs.getInt(10));
				dto.setpBasic_fNo(rs.getInt(11));
				dto.setpDesc_fNo(rs.getInt(12));
				dto.setProdCateName(rs.getString(15));
				products.add(dto);
				
				
			}
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return products;
	}
	
	// 메인 장보기 리스트 출력
	public List<ProductDTO> selectProductsMain() {
		
		List<ProductDTO> products = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(PRODUCTSQL.SELECT_PRODUCTS_MAIN);
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setpNo(rs.getInt(1));
				dto.setProdCateNo(rs.getString(2));
				dto.setpName(rs.getString(3));
				dto.setPrice(rs.getInt(4));
				dto.setDiscount(rs.getInt(5));
				dto.setpList_fNo(rs.getInt(6));
				dto.setpBasic_fNo(rs.getInt(7));
				dto.setpDesc_fNo(rs.getInt(8));
				dto.setProdCateName(rs.getString(9));
				dto.setsName(rs.getString(10));
				products.add(dto);
				
				logger.debug(dto.getsName());
				
			}
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return products;
	}
	
	public void updateProduct() {}
	public void deleteProduct() {}
	
}
