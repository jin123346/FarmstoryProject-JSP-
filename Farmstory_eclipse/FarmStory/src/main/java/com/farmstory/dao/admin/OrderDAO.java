package com.farmstory.dao.admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.admin.OrderItemDTO;
import com.farmstory.dto.community.PageGroupDTO;
import com.farmstory.util.BOARDSQL;
import com.farmstory.util.DBHelper;
import com.farmstory.util.PRODUCTSQL;

public class OrderDAO extends DBHelper{
	
	private static OrderDAO instance = new OrderDAO();
	public static OrderDAO getInstance() {return instance;}
	private OrderDAO() {}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
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
	
	
//	전체 게시물 갯수 구하기
	public int selectOrderItemCountTotal() {
		
		int total = 0;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(PRODUCTSQL.SELECT_ORDERITEM_COUNT_TOTAL);
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return total;
	}
	
	
	public List<OrderItemDTO> selectOrderItems(int start) {
		List<OrderItemDTO> orderitems = new ArrayList<OrderItemDTO>();
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement(PRODUCTSQL.SELECT_ORDERITEMS);
			pstmt.setInt(1, start);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderItemDTO dto = new OrderItemDTO();
				dto.setOrderItemNo(rs.getInt(1));
				dto.setOrderNo(rs.getInt(2));
				dto.setItemPrice(rs.getInt(3));
				dto.setpName(rs.getString(4));
				dto.setItemQty(rs.getInt(5));
				dto.setO_delivery(rs.getInt(6));
				dto.setO_discount(rs.getInt(7));
				dto.setName(rs.getString(8));
				dto.setOrderDate(rs.getString(9));
				dto.setpNo(rs.getInt(10));
				dto.setItemDiscountPrice(dto.getItemPrice());
				dto.setOrderItemTotal();
				orderitems.add(dto);
				
			}
			
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				closeAll();
			} catch (SQLException e) {
				logger.error("SELECT_ORDERITEMS"+e.getMessage());

			}
		}
		
		
		return orderitems;
		
	}
	
	
	public List<OrderItemDTO> selectOrderItems() {
		List<OrderItemDTO> orderitems = new ArrayList<OrderItemDTO>();
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement(PRODUCTSQL.SELECT_ORDERITEMS_MAIN);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderItemDTO dto = new OrderItemDTO();
				dto.setOrderItemNo(rs.getInt(1));
				dto.setOrderNo(rs.getInt(2));
				dto.setItemPrice(rs.getInt(3));
				dto.setpName(rs.getString(4));
				dto.setItemQty(rs.getInt(5));
				dto.setO_delivery(rs.getInt(6));
				dto.setO_discount(rs.getInt(7));
				dto.setName(rs.getString(8));
				dto.setSubStringOrderDate(rs.getString(9));
				dto.setpNo(rs.getInt(10));
				dto.setItemDiscountPrice(dto.getItemPrice());
				dto.setOrderItemTotal();
				orderitems.add(dto);
				
			}
			
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				closeAll();
			} catch (SQLException e) {
				logger.error("SELECT_ORDERITEMS"+e.getMessage());

			}
		}
		
		
		return orderitems;
		
	}
	
	public void insertOrder() {	}
	public void selectOrder() {	}
	public void selectOrders() {	}
	public void updateOrder() {	}
	public void deleteOrder() {	}
	

	
	
}
