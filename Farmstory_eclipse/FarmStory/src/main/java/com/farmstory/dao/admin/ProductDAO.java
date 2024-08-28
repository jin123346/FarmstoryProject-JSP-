package com.farmstory.dao.admin;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import javax.naming.NamingException;

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
		
		int pno=0;
		
		String sql = "insert into `product` set prodCateNo=?,"
											  + "pName=?,"
											  + "price=?,"
											  + "stock=?,"
											  + "point=?,"
											  + "discount=?,"
											  + "delivery=?,"
											  + "pList_fNo=?,"
											  + "pBasic_fNo=?,"
											  + "pDesc_fNo=?,"
											  + "rdate=now(),"
											  + "pDesc=?";
		
		try {
			
			conn = getConnection();
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getProdCateNo());
			pstmt.setString(2, dto.getpName());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setInt(4, dto.getStock());
			pstmt.setInt(5, dto.getPoint());
			pstmt.setInt(6, dto.getDiscount());
			pstmt.setInt(7, dto.getDelivery());
			pstmt.setInt(8, dto.getpList_fNo());
			pstmt.setInt(9, dto.getpBasic_fNo());
			pstmt.setInt(10, dto.getpDesc_fNo());
			pstmt.setString(11, dto.getRdate());
			pstmt.setString(12, dto.getpDesc());
			pstmt.executeUpdate();
			
			stmt =conn.createStatement();
			rs = stmt.executeQuery("select Max(`pNo`) from `product` ");
			if(rs.next()) {
				pno = rs.getInt(1);
			}
			conn.commit();

		} catch(Exception e) {
			logger.error(e.getMessage());
			
			try {
				conn.rollback();
			}catch(SQLException e1) {
				logger.error(e1.getMessage());
			}
			
		}finally {
			try {
				closeAll();
			} catch (SQLException e) {
				logger.error(e.getMessage());
			}
		}
		
		
		
		
		return pno;
	}
	
	public ProductDTO selectProduct(String pNo) {
		return null;
	}
	

	public List<ProductDTO> selectProducts(String prodCateNo) throws NamingException, SQLException{
		
		List<ProductDTO> products = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_PRODUCT);
			psmt.setString(1, prodCateNo);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setProdCateNo(rs.getString(1));
				dto.setpName(rs.getString(2));
				dto.setProdCateNo(rs.getString(3));
				dto.setPrice(rs.getInt(4));
				dto.setStock(rs.getInt(5)); 
				dto.setRdate(rs.getString(6));
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
	
	

