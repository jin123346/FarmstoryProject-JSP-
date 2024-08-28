package com.farmstory.dao.admin;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.admin.FileDTO;
import com.farmstory.util.DBHelper;
import com.farmstory.util.PRODUCTSQL;

public class FileDAO extends DBHelper {
	private static FileDAO instance = new FileDAO();
	public static FileDAO getInstance() {
		return instance;
	}
	private FileDAO () {}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	
	public int insertFile(FileDTO dto) {
		int result=0;
		
			String sql=null;
			if(dto.getFieldName().equals("product_list_image")) {
				sql =PRODUCTSQL.INSERT_LIST_IMG_FILE;
				logger.debug(sql);
				
			}else if(dto.getFieldName().equals("product_description_image")) {
				sql=PRODUCTSQL.INSERT_DESC_IMG_FILE;
				
			}else if(dto.getFieldName().equals("basic_info_image")) {
				sql = PRODUCTSQL.INSERT_BASIC_IMG_FILE;
	
			}				
			logger.debug(sql);

			if(sql==null) {
				
				return result;
			}
			try {
				conn=getConnection();
				pstmt=conn.prepareStatement(sql);
				stmt=conn.createStatement();
				pstmt.setInt(1, dto.getpNo());
				pstmt.setString(2, dto.getoName());
				pstmt.setString(3, dto.getsName());
				result = pstmt.executeUpdate();
				
				
				
				
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
	public int selectListFile_fNo(int pno) {
		int fno=0;
		try {
			conn  = getConnection();
			pstmt = conn.prepareStatement(PRODUCTSQL.Select_List_File_fno);
			pstmt.setInt(1, pno);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				fno = rs.getInt(1);
				
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				closeAll();
			} catch (SQLException e) {
				logger.error("Select_List_File_fno"+e.getMessage());
			}
		}
		
		return fno;
		
		
	}
	public void selectListFiles() {}
	public void updateListFile() {}
	public void deleteListFile() {}
	
	public void insertBasicFile() {}
	public int selectBasicFile_fno(int pno) {
		int fno=0;
		try {
			conn  = getConnection();
			pstmt = conn.prepareStatement(PRODUCTSQL.Select_basic_File_fno);
			pstmt.setInt(1, pno);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				fno = rs.getInt(1);
				
			}
			
		} catch (Exception e) {
			logger.error("Select_basic_File_fno"+e.getMessage());
		}finally {
			try {
				closeAll();
			} catch (SQLException e) {
				logger.error("Select_basic_File_fno"+e.getMessage());
			}
		}
		
		return fno;
	}
	public void selectBasicFiles() {}
	public void updateBasicFile() {}
	public void deleteBasicFile() {}
	
	
	
	public void insertDescFile() {}
	public int selectDescFile_fno(int pno) {
		int fno=0;
		try {
			conn  = getConnection();
			pstmt = conn.prepareStatement(PRODUCTSQL.Select_Desc_File_fno);
			pstmt.setInt(1, pno);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				fno = rs.getInt(1);
				
			}
			
		} catch (Exception e) {
			logger.error("Select_Desc_File_fno"+e.getMessage());
		}finally {
			try {
				closeAll();
			} catch (SQLException e) {
				logger.error("Select_Desc_File_fno"+e.getMessage());
			}
		}
		
		return fno;
	}
	public void selectDescFiles() {}
	public void updateDescFile() {}
	public void deleteDescFile() {}
	

}
