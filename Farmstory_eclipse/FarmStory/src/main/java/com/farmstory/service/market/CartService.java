package com.farmstory.service.market;

import java.util.List;

import com.farmstory.dao.market.MarketDAO;
import com.farmstory.dto.market.CartDTO;
import com.farmstory.dto.product.ProductCartDTO;

public enum CartService {
	INSTANCE;
	
	private MarketDAO dao = MarketDAO.getInstance();
	
	public int total(ProductCartDTO dto) {
		int totalPrice = 0;
		
		totalPrice = (int )(dto.getPrice() - (dto.getPrice() /dto.getDiscount())) * dto.getProdQty() ;
		
		return totalPrice;
	}
	
	
	public int insertCart(CartDTO dto) {
		return dao.insertCart(dto);
	}

	public List<ProductCartDTO> selectCarts(String uid) {
		return dao.selectCarts(uid);
	}
	
}
