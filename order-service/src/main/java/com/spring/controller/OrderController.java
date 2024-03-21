package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.entity.ClientRequest;
import com.spring.entity.Order;
import com.spring.entity.ServerResponse;
import com.spring.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/bookOrder")
	public ServerResponse bookOrder(@RequestBody ClientRequest order) throws JsonProcessingException
	{
		return orderService.saveOrder(order);
	}
}
