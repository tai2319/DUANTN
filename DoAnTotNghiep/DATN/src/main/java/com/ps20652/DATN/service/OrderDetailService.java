<<<<<<< HEAD
package com.ps20652.DATN.service;

import java.util.List;

import com.ps20652.DATN.entity.Order;
import com.ps20652.DATN.entity.OrderDetail;
import com.ps20652.DATN.entity.Product;


public interface OrderDetailService {

	
	


	public List<OrderDetail> create(List<OrderDetail> orderDetails);
	
	List<OrderDetail> getOrderDeTails(int orderId);
	
	public int getProductSell(Product product);

	  public List<OrderDetail> getOrderDetailsByProduct(Product product);
	  
	  OrderDetail getOrderDetailById (Integer orderDetailId);
	
//	public Product findbyId(Integer id);
//	
//	public Product findbyIdPro(Product product);
//	
//	Product update(Product product);
//
//	void delete(Product id);
//	
//	List<Product> findByName(String name);
//	
//	List<Product> findByPrice(double minPrice, double maxPrice);
//	
//	List<Product> findByCategoryCategoryId(int categoryId);
}
=======
package com.ps20652.DATN.service;

import com.ps20652.DATN.entity.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {
    List<OrderDetail> getAllOrderDetails();
    Optional<OrderDetail> getOrderDetailById(Long orderDetailId);
    OrderDetail saveOrderDetail(OrderDetail orderDetail);
    void deleteOrderDetail(Long orderDetailId);
}
>>>>>>> parent of d5754ee (tai)
