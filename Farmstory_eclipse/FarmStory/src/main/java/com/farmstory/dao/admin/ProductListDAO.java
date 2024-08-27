package com.farmstory.dao.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.admin.ProductListDTO;

public class ProductListDAO {

	private static ProductListDAO instance = new ProductListDAO();
	public static ProductListDAO getInstance() {
		return instance;
	}
	private ProductListDAO() {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	public int insertProductList(ProductListDTO dto) {
		return 0;
	}
	
	public void selectProductList(String pNo) {}
	
	public List<ProductListDTO> selectProductLists(int pNo) {
		return null;
	}
	
	public void updateProductList(ProductListDTO dto) {}
	public void deleteProductList(int pNo) {}

	
	
	
	
}
