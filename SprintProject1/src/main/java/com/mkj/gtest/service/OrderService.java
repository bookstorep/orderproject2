package com.mkj.gtest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mkj.gtest.entity.Order;

@Service

public interface OrderService {
	
	public Order insertOrder(Order order) throws Exception;
	
	public List<Order> getAllOrders() throws Exception;
	public Order updateOrderById(int orderId) throws Exception;
	public Order deleteOrderById(int orderId) throws Exception;
	public void delete(int orderId) throws Exception;
	
	public List<Order> getOrderByUserName(String userName) throws Exception;
	public List<Order> getOrderByBookName(String bookName) throws Exception;
	public List<Order> getOrderByOrderDate(String orderDate) throws Exception;
	public List<Order> getOrderByOrderStatus(String orderStatus) throws Exception;
	
	public List<Order> getOrderBetweenIds(int range1,int range2)throws Exception;


	public List <Order> getOrderByOrderId(int orderId)throws Exception;
	
	public List<Order> sortOrderByUserName() throws Exception;
	public List<Order> sortOrderByOrderDate() throws Exception;
	public List<Order> sortOrderByBookName() throws Exception;
	}

