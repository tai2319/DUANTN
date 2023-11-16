<<<<<<< HEAD
package com.ps20652.DATN.service;

import java.util.List;

import com.ps20652.DATN.entity.Product;

public interface ProductService {

=======
package com.ps20652.DATN.service;

import java.util.List;

import com.ps20652.DATN.entity.Product;


public interface ProductService {

	
	
	public List<Product> findAll();

	public Product create(Product pro);

	public Product findbyId(Integer id);
	
	public Product findbyIdPro(Product product);
	
	Product update(Product product);

	void delete(Product id);
	
	List<Product> findByName(String name);
	
	List<Product> findByPrice(double minPrice, double maxPrice);
	
	List<Product> findByCategoryCategoryId(int categoryId);
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of d5754ee (tai)
=======
>>>>>>> parent of d5754ee (tai)
=======
>>>>>>> parent of d5754ee (tai)
}