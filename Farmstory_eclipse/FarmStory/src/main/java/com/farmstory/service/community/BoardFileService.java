package com.farmstory.service.community;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dao.community.BoardFileDAO;
import com.farmstory.dto.community.BoardFileDTO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

public enum BoardFileService {

	INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private BoardFileDAO dao = BoardFileDAO.getInstance();
	
	// 파일 등록
	public void insertBoardFile(BoardFileDTO dto) {
		dao.insertBoardFile(dto);
	}
	
	public BoardFileDTO selectBoardFile(String b_fNo) { // b_fNo 파라미터가 string이라서 int > string으로 바꿈
		return dao.selectBoardFile(b_fNo);
	}
	
	public List<BoardFileDTO> selectBoardFiles() {
		return dao.selectBoardFiles();
	}
	
	public void updateBoardFile(int b_fNo) {
		dao.updateBoardFile(b_fNo);
	}
	
	public void updateBoardFileDownloadCount(String b_fNo) {
		dao.updateBoardFileDownloadCount(b_fNo);
	}
	
	public void deleteBoardFile(int b_fNo) {
		dao.deleteBoardFile(b_fNo);
	}
	
	// 게시글 삭제시 파일 삭제
	public void deleteBoardFiles(String boardNo) {
		dao.deleteBoardFiles(boardNo);
	}
	
	public List<BoardFileDTO> boardFileUpload(HttpServletRequest req) {
		
		List<BoardFileDTO> boardFiles = new ArrayList<>();
		
		ServletContext ctx = req.getServletContext();
		String uploadPath = ctx.getRealPath("/uploads");
		logger.debug("uploadPath : " + uploadPath);
		
		try {
			// 첨부파일 정보객체 가져오기
			Collection<Part> parts  = req.getParts(); 
		
			for(Part part : parts) {
				
				// 파일명 추출
				String ofileName = part.getSubmittedFileName();
				
				// 파일을 첨부했으면
				if(ofileName != null && !ofileName.isEmpty()) {
					logger.debug("ofileName : " + ofileName);
					
					// 고유 파일명 생성
					int idx = ofileName.lastIndexOf(".");
					String ext = ofileName.substring(idx);
					
					String sfileName = UUID.randomUUID().toString() + ext;
					logger.debug("sfileName : " + sfileName);
					
					// 파일 저장
					part.write(uploadPath + File.separator + sfileName);
					
					// fileDTO 생성 
					BoardFileDTO boardFileDTO = new BoardFileDTO();
					boardFileDTO.setB_oName(ofileName);
					boardFileDTO.setB_sName(sfileName);
					boardFiles.add(boardFileDTO);
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return boardFiles;
	}
	
	
	public void boardFileDownload(HttpServletRequest req, HttpServletResponse resp) {
		
		// 공유 참조값 가져오기
		BoardFileDTO boardFileDTO = (BoardFileDTO) req.getAttribute("boardFileDTO");
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			// response 헤더정보 수정
			resp.setContentType("application/octet-stream");
			resp.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(boardFileDTO.getB_oName(), "utf-8"));
			resp.setHeader("Content-Transfer-Encoding", "binary");
			resp.setHeader("Pragma", "no-cache");
			resp.setHeader("Cache-Control", "private");
	
			// 파일 내용 스트림 처리
			ServletContext ctx = req.getServletContext();
			String path = ctx.getRealPath("/uploads");
			File file = new File(path + File.separator + boardFileDTO.getB_sName());
			
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(resp.getOutputStream());
			
			bis.transferTo(bos);
			bos.flush();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}finally {
			
			try {
				if(bos != null) {
					bos.close();	
				}
				
				if(bis != null) {
					bis.close();	
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
	
}