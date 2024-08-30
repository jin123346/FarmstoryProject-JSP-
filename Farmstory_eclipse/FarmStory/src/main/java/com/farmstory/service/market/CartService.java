package com.farmstory.service.market;

import java.util.List;

import com.farmstory.dao.market.MarketDAO;
import com.farmstory.dto.market.CartDTO;
import com.farmstory.dto.market.OrderDTO;
import com.farmstory.dto.product.ProductCartDTO;

public enum CartService {
	INSTANCE;
	
	private MarketDAO dao = MarketDAO.getInstance();
	
	public int total(ProductCartDTO dto) {
		int totalPrice = 0;
		
		totalPrice = (int )(dto.getPrice() - (dto.getPrice() /dto.getDiscount())) * dto.getProdQty() ;
		
		return totalPrice;
	}
	
	// 할인된 금액 전체 총합
	public int realtotal(List<ProductCartDTO> dto) {
		
		int realtotal = 0;
		
		for(ProductCartDTO productCartDto : dto ) {
			realtotal += (int )(productCartDto.getPrice() - (productCartDto.getPrice() /productCartDto.getDiscount())) * productCartDto.getProdQty();
		}
		
		return realtotal;
	}

	// 상품갯수 총합
	public int totalQty(List<ProductCartDTO> dto) {
		
		int realtotal = 0;
		
		for(ProductCartDTO productCartDto : dto ) {
			realtotal += productCartDto.getProdQty();
		}
		
		return realtotal;
	}
	
	// 할인 안된금액 총합
	public int totalPrice(List<ProductCartDTO> dto) {
	
		int realtotal = 0;
		
		for(ProductCartDTO productCartDto : dto ) {
			realtotal += productCartDto.getPrice()*productCartDto.getProdQty();
		}
		
		return realtotal;
	}

	// 할인금액 총합
	public int totalDiscount(List<ProductCartDTO> dto) {
		
		int realtotal = 0;
		
		for(ProductCartDTO productCartDto : dto ) {
			realtotal += productCartDto.getPrice()*productCartDto.getProdQty()/productCartDto.getDiscount();
		}
		
		return realtotal;
	}

	// 배달비 총합
	public int totalDelivery(List<ProductCartDTO> dto) {
		
		int realtotal = 0;
		
		for(ProductCartDTO productCartDto : dto ) {
			realtotal += productCartDto.getDelivery();
		}
		
		return realtotal;
	}
	
	public int totalPoint(List<ProductCartDTO> dto) {
		
		int realtotal = 0;
		
		for(ProductCartDTO productCartDto : dto ) {
			realtotal += productCartDto.getPoint()*productCartDto.getProdQty();
		}
		
		return realtotal;
	}
	
	
	public int insertCart(CartDTO dto) {
		return dao.insertCart(dto);
	}

	public List<ProductCartDTO> selectCarts(String uid) {
		return dao.selectCarts(uid);
	}
	
	public int deleteCart(String pk) {
		int result = 0;
		result = dao.deleteCart(pk);
		return result;
	}
	
	public void insertPoint(String uid,int point) {
		dao.insertPoint(uid, point);
	}
	
	public int insertOrder(OrderDTO dto) {
		return dao.insertOrder(dto);
	}
	
}
