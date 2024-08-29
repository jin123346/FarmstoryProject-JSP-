package com.farmstory.dao.admin;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.admin.FileListDTO;
import com.farmstory.dto.admin.ProductDTO;
import com.farmstory.util.BOARDSQL;
import com.farmstory.util.DBHelper;
import com.farmstory.util.PRODUCTSQL;
import com.farmstory.util.SQL;

public class ProductDAO extends DBHelper {

	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}
	private ProductDAO() {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private PreparedStatement psmt;
	
	public int selectCountTotal() {
		int total = 0;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(PRODUCTSQL.SELECT_COUNT_TOTAL);
			
			if(rs.next()) {
				total = rs.getInt(1);
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
		
		return total;
	}
	

	public int updateProductFno(int pList_fNo,int pDesc_fNo,int pBasic_fNo,int pNo) {
		String sql = "update `product` set pList_fNo=?, pDesc_fNo=?,pBasic_fNo=? where pNo=?";
		logger.debug("pList_fNo : "+pList_fNo);
		logger.debug("pDesc_fNo : "+pDesc_fNo);
		logger.debug("pDesc_fNo : "+pDesc_fNo);
		int result=0;
		
		try {
			conn=getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, pList_fNo);
			pstmt.setInt(2, pDesc_fNo);
			pstmt.setInt(3, pBasic_fNo);
			pstmt.setInt(4, pNo);
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				closeAll();
			} catch (SQLException e) {
				logger.error(e.getMessage());

			}
			
		}
		return result;
	}
	public int insertProduct(ProductDTO dto) {
	    int pno = 0;

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
	                   + "pDesc=?,"
	                   + "rdate=NOW()";
	    
	    try {
	        conn = getConnection();
	        pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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
	        pstmt.setString(11, dto.getpDesc());
	        pstmt.executeUpdate();
	        
	        rs = pstmt.getGeneratedKeys();
	        if (rs.next()) {
	            pno = rs.getInt(1);
	        }

	    } catch (Exception e) {
	        logger.error(e.getMessage());

	        try {
	            conn.rollback();
	        } catch (SQLException e1) {
	            logger.error(e1.getMessage());
	        }

	    } finally {
	        try {
	            closeAll();
	        } catch (SQLException e) {
	            logger.error(e.getMessage());
	        }
	    }

	    return pno;
	}
	/*
	 * public int insertProduct(ProductDTO dto) {
	 * 
	 * int pno=0;
	 * 
	 * String sql = "insert into `product` set prodCateNo=?," + "pName=?," +
	 * "price=?," + "stock=?," + "point=?," + "discount=?," + "delivery=?," +
	 * "pList_fNo=?," + "pBasic_fNo=?," + "pDesc_fNo=?," + "pDesc=?," +
	 * "rdate=NOW()";
	 * 
	 * try {
	 * 
	 * conn = getConnection(); conn.setAutoCommit(false); pstmt =
	 * conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
	 * pstmt.setString(1, dto.getProdCateNo()); pstmt.setString(2, dto.getpName());
	 * pstmt.setInt(3, dto.getPrice()); pstmt.setInt(4, dto.getStock());
	 * pstmt.setInt(5, dto.getPoint()); pstmt.setInt(6, dto.getDiscount());
	 * pstmt.setInt(7, dto.getDelivery()); pstmt.setInt(8, dto.getpList_fNo());
	 * pstmt.setInt(9, dto.getpBasic_fNo()); pstmt.setInt(10, dto.getpDesc_fNo());
	 * pstmt.setString(11, dto.getpDesc()); pstmt.executeUpdate(); conn.commit();
	 * rs=pstmt.getGeneratedKeys(); if(rs.next()) { pno = rs.getInt(1); }
	 * 
	 * } catch(Exception e) { logger.error(e.getMessage());
	 * 
	 * try { conn.rollback(); }catch(SQLException e1) {
	 * logger.error(e1.getMessage()); }
	 * 
	 * }finally { try { closeAll(); } catch (SQLException e) {
	 * logger.error(e.getMessage()); } }
	 * 
	 * 
	 * 
	 * 
	 * return pno; }
	 */
	
	public ProductDTO selectProduct(String pNo) {
		return null;
	}
	

	public List<ProductDTO> selectProducts() {
		List<ProductDTO> products = new ArrayList<>();
		try {
			conn = getConnection();
			stmt =conn.createStatement();
			rs=stmt.executeQuery(SQL.SELECT_PRODUCT_LIST);
			logger.debug(SQL.SELECT_PRODUCT_LIST);
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setpNo(rs.getInt(1));
				dto.setpName(rs.getString(2));
				dto.setProdCateNo(rs.getString(3)); 
				dto.setPrice(rs.getInt(4));
				dto.setStock(rs.getInt(5)); 
				dto.setRdateSubString(rs.getString(6));
				dto.setsName(rs.getString(7));
				logger.debug(dto.getsName());
				products.add(dto);
				logger.debug(""+dto.toString());
			}
		}catch(Exception e) {
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
	
	public List<ProductDTO> selectProducts(int start ) {
		List<ProductDTO> products = new ArrayList<>();
		try {
			conn = getConnection();
			pstmt =conn.prepareStatement(SQL.SELECT_PRODUCT_LIST_START);
			pstmt.setInt(1, start);
			rs=pstmt.executeQuery();
			logger.debug(SQL.SELECT_PRODUCT_LIST);
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setpNo(rs.getInt(1));
				dto.setpName(rs.getString(2));
				dto.setProdCateNo(rs.getString(3)); 
				dto.setPrice(rs.getInt(4));
				dto.setStock(rs.getInt(5)); 
				dto.setRdateSubString(rs.getString(6));
				dto.setsName(rs.getString(7));
				logger.debug(dto.getsName());
				products.add(dto);
				logger.debug("listdto :"+dto.toString());
			}
		}catch(Exception e) {
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

	
	public void updateProduct(ProductDTO dto) {}
	public void deleteProduct(int pNo) {}

}
	
	

