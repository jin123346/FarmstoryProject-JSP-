package com.farmstory.dao.admin;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.admin.ProductDTO;
import com.farmstory.util.DBHelper;
import com.farmstory.util.SQL;

public class ProductDAO extends DBHelper {

	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}
	private ProductDAO() {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private PreparedStatement psmt;
	
	public int insertProduct(ProductDTO dto) {
		return 0;
	}
	
	public ProductDTO selectProduct(String pNo) {
		return null;
	}
	
	public List<ProductDTO> selectProducts() throws SQLException {
		
		List<ProductDTO> products = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_PRODUCT_LIST);
			//psmt.setInt(1, pNo);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setpList_oName(rs.getString(1));
				dto.setpNo(rs.getInt(2));
				dto.setpName(rs.getString(3));
				dto.setProdCateName(rs.getString(4));
				dto.setPrice(rs.getInt(5));
				dto.setStock(rs.getInt(6)); 
				dto.setRdate(rs.getString(7));
				products.add(dto);
				
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage());
			
			try {
				conn.rollback();
			}catch(SQLException e1) {
				logger.error(e1.getMessage());
			}
			
		}finally {
			closeAll();
		}
		
		
		return products;
	}
	
	public void updateProduct(ProductDTO dto) {}
	public void deleteProduct(int pNo) {}

	
	
	
	
}