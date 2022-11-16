package com.mkj.gtest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkj.gtest.entity.Order;
import com.mkj.gtest.service.OrderService;





@RestController
@RequestMapping("/orderstore")

public class OrderRestController {

	@Autowired
	OrderService orderService;
	
	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());
	
	public OrderRestController() {
		System.out.println("\n\n\n=======>> Inside Contructor "+this);
	}

	
	@PostMapping("/addorder")
	public ResponseEntity<String> addOrder(@RequestBody Order order)
	{
		try {
			Order savedOrder = orderService.insertOrder(order);
			String responseMsg = savedOrder.getUserName()+"BookName"+savedOrder.getBookName();
			return new ResponseEntity<String>(responseMsg,HttpStatus.OK);
		}catch(Exception e) {
			String errorMsg = "Contact customer care Ph.no:- 1800-250-900 or mail to:- bookstore@gmail.com";
			return new ResponseEntity<String>(errorMsg,HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		
	}
	
	@GetMapping("/orders")
	public List<Order> getAllOrders()
	{
		try {
			List<Order> allExtractedOrders = orderService.getAllOrders();
			return allExtractedOrders;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	
	
	@DeleteMapping("/orderid/{searchOrderId}")   
    public void deleteUser(@PathVariable int searchOrderId)
    {  
      try {
        orderService.delete(searchOrderId);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }  
    }
	

	@GetMapping("/username/{userName}")
	public List<Order> getOrderByUserName(@PathVariable String userName) throws Exception
	{
		
		return orderService.getOrderByUserName(userName);
		
	}
	
	@GetMapping("/bookname/{bookName}")
	public List<Order> getOrderByBookName(@PathVariable String bookName) throws Exception
	{
		
		return orderService.getOrderByBookName(bookName);
		
	}
	
	@GetMapping("/orderdate/{orderDate}")
	public List<Order> getOrderByOrderDate(@PathVariable String orderDate) throws Exception
	{
		
		return orderService.getOrderByOrderDate(orderDate);
		
	}
	
	@GetMapping("/orderstatus/{oderStatus}")
	public List<Order> getOrderByOrderStatus(@PathVariable String orderStatus) throws Exception
	{
		
		return orderService.getOrderByOrderStatus(orderStatus);
		
	}
	
	@GetMapping("/sort/bookname")
	public List<Order> sortingByBookName() throws Exception{
		
		return orderService.sortOrderByBookName();
		
	}
	@GetMapping("/sort/orderdate")
	public List<Order> sortingByOrderDate() throws Exception{
		
		return orderService.sortOrderByOrderDate();
		
	}
	@GetMapping("/sort/username")
	public List<Order> sortingByUserName() throws Exception{
		
		return orderService.sortOrderByUserName();
		
	}
	@PutMapping("/orderid/{orderId}")
    public   Order updateOrder(@PathVariable int orderId, @RequestBody Order orderDetails) throws Exception {
        orderService.getOrderByOrderId(orderId);
        orderDetails.setOrderId(orderId);
        Order updateOrder = orderService.insertOrder(orderDetails);
        return updateOrder;
    }
	@GetMapping("/orderid/{orderId}")
	public List<Order> getOrderByOrderId(@PathVariable int orderId) throws Exception
	{
		
		return orderService.getOrderByOrderId( orderId);
			
		
	}
	
	@GetMapping("/orderid")
	public List<Order> getOrderBetweenId(@RequestParam int id1, @RequestParam int id2) throws Exception
	{
		
		return orderService.getOrderBetweenIds(id1, id2);
			
		
	}
	
}


