package com.farmstory.service;

import java.util.List;

import com.farmstory.dao.admin.OrderDAO;
import com.farmstory.dto.admin.OrderItemDTO;
import com.farmstory.dto.community.PageGroupDTO;

public enum OrderService {
	
	INSTACNE;
	
	private OrderDAO dao = OrderDAO.getInstance();
	
	// 전체 게시물 갯수에서 마지막 페이지 번호 구하기 
	public int getLastPageNum(int total) {
		
		int lastPageNum = 0;
		
		if(total % 10 == 0) {
			lastPageNum = total / 10;
		}else {
			lastPageNum = total / 10 + 1;
		}
		return lastPageNum;
	}
	
	// 페이지 시작번호(limit용)
	public int getStartNum(int currentPage) {
		return (currentPage - 1) * 10;
	}
	
	// 현재 페이지번호 구하기
	public int getCurrentPage(String pg) {
		
		int currentPage = 1; // 처음 들어왔을때 파라미터 pg가 null이라서 첫페이지가 조회됨
		
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		
		return currentPage;
	}
	
	// 현재 페이지 그룹 구하기 
	public PageGroupDTO getCurrentPageGroup(int currentPage, int lastPageNum) {
		
	 	int currentPageGroup = (int) Math.ceil(currentPage / 10.0); // 현재 그룹 번호
		int pageGroupStart = (currentPageGroup - 1) * 10 + 1; // 그룹 시작 번호 
	 	int pageGroupEnd = currentPageGroup * 10; // 그룹 마지막 번호 
	 			
	 	if(pageGroupEnd > lastPageNum){
			pageGroupEnd = lastPageNum;
		}
	 	
		return new PageGroupDTO(pageGroupStart, pageGroupEnd);
	}
	
	// 페이지 시작번호
	public int getPageStartNum(int total, int currentPage) {
		int start = (currentPage - 1) * 10;
		return total - start;
	}
	
	public int selectOrderItemCountTotal() {
		return dao.selectOrderItemCountTotal();
	}
	
	
	public List<OrderItemDTO> selectOrderItems(int pg){return dao.selectOrderItems(pg);}
	public void insertOrder() {	}
	public void selectOrder() {	}
	public void selectOrders() {	}
	public void updateOrder() {	}
	public void deleteOrder() {	}

}
