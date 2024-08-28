package com.farmstory.service.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dao.admin.FileDAO;
import com.farmstory.dto.admin.FileDTO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public enum FileService {

	INSTANCE;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
		
	FileDAO dao = FileDAO.getInstance();
		
	


	public List<FileDTO> fileUpload(HttpServletRequest req ){
			List<FileDTO> files = new ArrayList<FileDTO>();
			
			
			
			ServletContext ctx = req.getServletContext();
			String uploadPath = ctx.getRealPath("/thumbs/product");
			logger.debug(uploadPath);
			
			
			try {
				
				Collection<Part> parts =req.getParts();
				for(Part part : parts) {
					String oName = part.getSubmittedFileName();
					String fieldName= part.getName();
					
					if(oName != null && !oName.isEmpty()) {
						logger.debug("OName : "+oName);
						
						
						int idx = oName.lastIndexOf(".");
						String ext = oName.substring(idx);
						
						String sName = UUID.randomUUID().toString()+ext;
						logger.debug("oName : "+oName + ", sName : "+sName+", feildName : "+fieldName);
						part.write(uploadPath+File.separator+sName);
						
						//파일저장
						 FileDTO dto = new FileDTO();
						 dto.setoName(oName);
						 dto.setsName(sName);
						 dto.setFieldName(fieldName);
						 files.add(dto);
					}
				}
				
				
				
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			
			return files;
			
		}
		
		public void insertFile(FileDTO dto) { dao.insertFile(dto);}
		public int selectListFile_fNo(int pno) { return dao.selectListFile_fNo(pno);}
		public int selectBasicFile_fNo(int pno) { return dao.selectBasicFile_fno(pno);}
		public int selectDescFile_fNo(int pno) { return dao.selectDescFile_fno(pno);}

		
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
