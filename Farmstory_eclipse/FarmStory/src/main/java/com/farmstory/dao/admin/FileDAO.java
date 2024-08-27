package com.farmstory.dao.admin;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.admin.FileDTO;
import com.farmstory.util.DBHelper;

public class FileDAO extends DBHelper {
	private static FileDAO instance = new FileDAO();
	public static FileDAO getInstance() {
		return instance;
	}
	private FileDAO () {}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	
	public void insertFile(FileDTO dto) {
		int result=0;
		
			String sql=null;
			if(dto.getFieldName().equals("product_list_image")) {
				sql = "insert into `pListImgFile` set pList_oName =? , pList_sName=?, rdate = now()";
				
				
			}else if(dto.getFieldName().equals("product_description_image")) {
				sql = "insert into `pDescImgFile` set pDesc_oName =? , pDesc_sName=?, rdate = now()";
	
				
			}else if(dto.getFieldName().equals("basic_info_image")) {
				sql = "insert into `pBasicImgFile` set pBasic_oName =? , pBasic_sName=?, rdate = now()";
	
			}
			if(sql==null) {
				
				return;
			}
			try {
				conn=getConnection();
				pstmt=conn.prepareStatement(sql);
				stmt=conn.createStatement();
				pstmt.setString(1, dto.getoName());
				pstmt.setString(2, dto.getsName());
				result +=pstmt.executeUpdate();
				
				
			} catch (Exception e) {
				logger.error(e.getMessage());
			}finally {
				try {
					closeAll();
				} catch (SQLException e) {
					logger.error(e.getMessage());
				}
			
		}
		
	}
	public void selectListFile() {}
	public void selectListFiles() {}
	public void updateListFile() {}
	public void deleteListFile() {}
	
	public void insertBasicFile() {}
	public void selectBasicFile() {}
	public void selectBasicFiles() {}
	public void updateBasicFile() {}
	public void deleteBasicFile() {}
	
	
	
	public void insertDescFile() {}
	public void selectDescFile() {}
	public void selectDescFiles() {}
	public void updateDescFile() {}
	public void deleteDescFile() {}
	

}
