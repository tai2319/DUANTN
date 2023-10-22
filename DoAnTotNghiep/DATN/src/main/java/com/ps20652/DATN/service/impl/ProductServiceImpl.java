package com.ps20652.DATN.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps20652.DATN.DAO.ProductDAO;
import com.ps20652.DATN.entity.Product;
import com.ps20652.DATN.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	
	@Override
	public List<Product> findAll() {
		return productDAO.findAll();
	}

	@Override
	public Product create(Product product) {
		return productDAO.save(product);
	}

	@Override
	public Product findbyId(Integer id) {
		return productDAO.findById(id).get();
	}

	@Override
	public void delete(Product id) {
		productDAO.delete(id);
		
	}

	@Override
	public List<Product> findByName(String name) {
		return productDAO.findByName(name);
	}

	@Override
	public List<Product> findByPrice(double minPrice, double maxPrice) {
		
		return productDAO.findByPrice(minPrice, maxPrice);
	}

	@Override
	public Product update(Product product) {
		return productDAO.save(product);
	}

	@Override
	public List<Product> findByCategoryCategoryId(int categoryId) {
	
		return productDAO.findByCategoryCategoryId(categoryId);
	}

	@Override
	public Product findbyIdPro(Product product) {
		return productDAO.findById(product.getProductId()).get();
	}

}
