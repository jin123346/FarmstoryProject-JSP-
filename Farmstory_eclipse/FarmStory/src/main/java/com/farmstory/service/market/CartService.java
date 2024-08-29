package com.farmstory.service.market;

import com.farmstory.dao.market.MarketDAO;
import com.farmstory.dto.market.CartDTO;

public enum CartService {
	INSTANCE;
	
	private MarketDAO dao = MarketDAO.getInstance();
	
	
	public int insertCart(CartDTO dto) {
		return dao.insertCart(dto);
	}
	
}
