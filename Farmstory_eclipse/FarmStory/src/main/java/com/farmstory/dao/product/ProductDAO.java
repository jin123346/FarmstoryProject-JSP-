package com.farmstory.dao.product;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.product.ProductDTO;
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
	public void selectProduct() {}
	
	public int selectCountTotal() {
		int total = 0;
		
		try {
		conn = getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(PRODUCTSQL.SELECT_COUNT_TOTAL);
		
		if(rs.next()) {
			total = rs.getInt(1);
		}
		
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
				dto.setPoint(rs.getInt(6));
				dto.setDiscount(rs.getInt(7));
				dto.setDelivery(rs.getInt(8));
				dto.setpList_fNo(rs.getInt(9));
				dto.setpBasic_fNo(rs.getInt(10));
				dto.setpDesc_fNo(rs.getInt(11));
				dto.setProdCateName(rs.getString(12));
				
				products.add(dto);
				
				closeAll();
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
				
		return products;
	}
	public void updateProduct() {}
	public void deleteProduct() {}
	
}
