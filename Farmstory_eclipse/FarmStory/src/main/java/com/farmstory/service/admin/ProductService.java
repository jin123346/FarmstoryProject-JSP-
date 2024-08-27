package com.farmstory.service.admin;

import java.util.List;

import com.farmstory.dao.admin.ProductDAO;
import com.farmstory.dto.admin.ProductDTO;
import com.farmstory.dto.admin.ProductListDTO;

public enum ProductService {

	INSTANCE;
	private ProductDAO dao = ProductDAO.getInstance();
	
	

	
	public int insertProduct(ProductDTO dto) {
		return dao.insertProduct(dto);
	}
	
	public ProductDTO selectProduct(String pNo) {
		return dao.selectProduct(pNo);
	}
	
	public List<ProductListDTO> selectProducts() {
		return dao.selectProducts();
	}
	
	public void updateProduct(ProductDTO dto) {
		dao.updateProduct(dto);
	}
	public void deleteProduct(int pNo) {
		dao.deleteProduct(pNo);
	}
	
	
	
}
