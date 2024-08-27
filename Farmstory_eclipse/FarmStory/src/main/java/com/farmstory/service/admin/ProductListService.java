package com.farmstory.service.admin;

import java.util.List;

import com.farmstory.dao.admin.ProductListDAO;
import com.farmstory.dto.admin.ProductListDTO;

public enum ProductListService {

	INSTANCE;
	private ProductListDAO dao = ProductListDAO.getInstance();
	
	
	public int insertProductList(ProductListDTO dto) {
		return dao.insertProductList(dto);
	}
	
	public void selectProductList(String pNo) {
		
	}
	
	public List<ProductListDTO> selectProductLists(int pNo) {
		return null;
	}
	
	public void updateProductList(ProductListDTO dto) {}
	public void deleteProductList(int pNo) {}
	
	
	
}
