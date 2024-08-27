package com.farmstory.service.community;

import java.util.List;

import com.farmstory.dao.community.CommentDAO;
import com.farmstory.dto.community.CommentDTO;

public enum CommentService {

	INSTANCE;
	
	private CommentDAO dao = CommentDAO.getInstance(); 
	
	public int insertComment(CommentDTO dto) {
		return dao.insertComment(dto);
	}
	
	public CommentDTO selectComment(int comNo) {
		return dao.selectComment(comNo);
	}
	
	public List<CommentDTO> selectComments(String com_parent){
		return dao.selectComments(com_parent);
	}
	
	public int updateComment(CommentDTO dto) {
		return dao.updateComment(dto);
	}
	
	public int deleteComment(String comNo) {
		return dao.deleteComment(comNo);
	}
	
}
