package com.farmstory.service.user;

import com.farmstory.dao.user.TermsDAO;
import com.farmstory.dto.user.TermsDTO;

public enum TermsService {
	INSTANCE;
	
	private TermsDAO dao = TermsDAO.getInstance();
	
	public TermsDTO selectTerms() {
		return dao.selectTerms();
	}
}
