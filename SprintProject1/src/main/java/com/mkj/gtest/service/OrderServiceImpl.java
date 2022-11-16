
package com.mkj.gtest.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkj.gtest.comparator.SortingBasedOnBookName;
import com.mkj.gtest.comparator.SortingBasedOnOrderDateLowtoHigh;
import com.mkj.gtest.comparator.SortingBasedOnUserName;
import com.mkj.gtest.entity.Order;
import com.mkj.gtest.repository.OrderRepository;

@Service

public class OrderServiceImpl  implements OrderService {
	@Autowired
	OrderRepository orderRepository;

	@Override
	public Order insertOrder(Order order) throws Exception {
		Order savedOrder = orderRepository.save(order);
		if(savedOrder != null)
		{
			return savedOrder;
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<Order> getAllOrders() throws Exception {
		List<Order> allBooks = orderRepository.findAll();
		return allBooks;
	}

	@Override
	public Order updateOrderById(int orderId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order deleteOrderById(int orderId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int orderId) throws Exception {
		orderRepository.deleteById(orderId);
		
		
	}

	

	@Override
	public List<Order> getOrderByBookName(String bookName) throws Exception {
		return orderRepository.getOrderByBookName(bookName);
	}

	@Override
	public List<Order> getOrderByOrderDate(String orderDate) throws Exception {
		// TODO Auto-generated method stub
		return orderRepository.getOrderByOrderDate(orderDate);
	}

	@Override
	public List<Order> getOrderByOrderStatus(String orderStatus) throws Exception {
		// TODO Auto-generated method stub
		return orderRepository.getOrderByOrderStatus(orderStatus);
	}

	@Override
	public List<Order> getOrderBetweenIds(int id1, int id2) throws Exception {
		// TODO Auto-generated method stub
		return orderRepository.getOrdersBetweenIds(id1, id2);
	}

	@Override
	public List<Order> sortOrderByUserName() throws Exception {
		List<Order> list = orderRepository.findAll();
        List<Order> order = new ArrayList<>();
        Collections.sort(list, new SortingBasedOnUserName());
        return list; 
	}

	@Override
	public List<Order> sortOrderByBookName() throws Exception {
		List<Order> list = orderRepository.findAll();
        List<Order> order = new ArrayList<>();
        Collections.sort(list, new SortingBasedOnBookName());
        return list; 
		
	}

	@Override
	public List<Order> getOrderByUserName(String userName) throws Exception {
		
		return orderRepository.getOrderByUserName(userName);
	}

	@Override
	public List<Order> sortOrderByOrderDate()throws Exception{
		// TODO Auto-generated method stub
		List<Order> list = orderRepository.findAll();
        List<Order> order = new ArrayList<>();
        Collections.sort(list, new SortingBasedOnOrderDateLowtoHigh());
        return list; 
	}

	@Override
	public List<Order> getOrderByOrderId(int orderId) throws Exception {
		// TODO Auto-generated method stub
		return orderRepository.getOrderById(orderId);
	}

	

	

	
	}
	

