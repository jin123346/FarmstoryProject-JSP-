package com.farmstory.service.user;

import com.farmstory.dao.user.TermsDao;

import com.farmstory.dto.user.TermsDTO;

public enum TermsService {
	INSTANCE;
	
	private TermsDao dao = TermsDao.getInstance();
	
	public TermsDTO selectTerms() {
		return dao.selectTerms();
	}
}
