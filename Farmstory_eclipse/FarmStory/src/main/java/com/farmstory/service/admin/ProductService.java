package com.farmstory.service.admin;


import java.sql.SQLException;

import java.util.List;

import com.farmstory.dao.admin.ProductDAO;
import com.farmstory.dto.admin.ProductDTO;


public enum ProductService {
	INSTANCE;
	
	private ProductDAO dao = ProductDAO.getInstance();
	


	
	public int insertProduct(ProductDTO dto) {
		
		return dao.insertProduct(dto);
	}
	public void updateProductFno(int pList_fNo,int pDesc_fNo,int pBasic_fNo,int pNo) {
		 dao.updateProductFno( pList_fNo, pDesc_fNo, pBasic_fNo,pNo);
	}
	
	public ProductDTO selectProduct(String pNo) {
		return dao.selectProduct(pNo);
	}
	
	public List<ProductDTO> selectProducts() {
		return dao.selectProducts();
	}
	

	public void updateProduct(ProductDTO dto) {
		dao.updateProduct(dto);
	}
	public void deleteProduct(int pNo) {
		dao.deleteProduct(pNo);
	}

}

	
	
	


