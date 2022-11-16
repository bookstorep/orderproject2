package com.mkj.gtest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mkj.gtest.entity.Order;

@Repository

public interface IOrderCustomRepository {
	
	public List<Order>  getOrderByUserName(String userName) throws Exception;
	public List<Order>  getOrderByBookName(String bookName) throws Exception;
	public List<Order> getOrderByOrderDate(String orderDate) throws Exception;
	public List<Order> getOrderByOrderStatus(String orderstatus) throws Exception;
	
	public List <Order> getOrderById(int orderId)throws Exception;
	
	@Query("from Order where orderId >= :range1 and orderId <= :range2")
    public List<Order> getOrdersBetweenIds(@Param("range1") int range1,@Param("range2") int range2)throws Exception;


}