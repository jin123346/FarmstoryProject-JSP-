package com.farmstory.dao.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.admin.ProductDTO;
import com.farmstory.dto.admin.ProductListDTO;

public class ProductDAO {

	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}
	private ProductDAO() {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	public int insertProduct(ProductDTO dto) {
		return 0;
	}
	
	public ProductDTO selectProduct(String pNo) {
		return null;
	}
	
	public List<ProductListDTO> selectProducts() {

		return null;
	}
	
	public void updateProduct(ProductDTO dto) {}
	public void deleteProduct(int pNo) {}

	
	
	
	
}
