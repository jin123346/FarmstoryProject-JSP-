package com.farmstory.service.product;

import java.util.List;

import com.farmstory.dao.product.ProductDAO;
import com.farmstory.dto.community.PageGroupDTO;
import com.farmstory.dto.product.ProductDTO;

public enum ProductService {
	INSTANCE;
	
	private ProductDAO dao = ProductDAO.getInstance();
	
	public int getLastPageNum(int total) {
		int lastPageNum = 0;
		
		if(total % 5 == 0) {
			lastPageNum = total / 5;
		}else {
			lastPageNum = total / 5 + 1;
		}
		return lastPageNum;
	}
	
	// 페이지 시작번호(limit용)
	public int getStartNum(int currentPage) {
		return (currentPage - 1) * 5;
	}
	
	// 현재 페이지 번호 구하기
	public int getCurrentPage(String pg) {
		int currentPage = 1;
		
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		return currentPage;
	}
	
	// 현재 페이지 그룹 구하기
	public PageGroupDTO getCurrentPageGroup(int currentPage) {
		
		int currentPageGroup = (int) Math.ceil(currentPage / 5.0);
		int pageGroupStart = (currentPageGroup - 1) * 5 + 1;
		int pageGroupEnd = currentPageGroup * 5;
		
		return new PageGroupDTO(pageGroupStart, pageGroupEnd);
	}
	
	public int selectCountTotal() {
		return dao.selectCountTotal();
	}
	
	public void insertProduct() {}
	public void selectProduct() {}
	
	public List<ProductDTO> selectProducts(int start) {
		return dao.selectProducts(start);
	}
	public void updateProduct() {}
	public void deleteProduct() {}
}
