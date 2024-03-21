package com.spring.service;

import com.spring.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.repository.OrderRepository;

import java.util.UUID;


@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public static final String ORDERSERVICE="orderservice";
	
	Logger logger= LoggerFactory.getLogger(OrderServiceImpl.class);
	
	
	@Override
	public ServerResponse saveOrder(ProductDTO dto) throws JsonProcessingException {

		//Order order= request.getOrder();
		Order order =new Order(Integer.parseInt(String.valueOf(UUID.randomUUID())),
				dto.getProductDesc(),dto.getQuantity(),dto.getPrice());
		
		Payment payment=new Payment();
		payment.setOrderId(order.getOrderId());
		payment.setPrice(order.getPrice());
		
		// call to the payment and send the orderId and Price of the Product to the PaymentService
		//logger.info("ORDER-SERVICE REQUEST" + new ObjectMapper().writeValueAsString(request));
		Payment paymentResponse=restTemplate.postForObject("http://localhost:8083/payment/doPayment", payment, Payment.class);
		
		String message=paymentResponse.getPaymentStatus().equals("SUCCESS")?"Payment succesfully Done Order Placed": "Payment Not Done Order Not Placed";
		orderRepository.save(order);
		logger.info("ORDER-SERVICE Response" + new ObjectMapper().writeValueAsString(paymentResponse));
		return new ServerResponse(order,paymentResponse.getPrice(),paymentResponse.getTransactionId(),message) ;
	}
	
	
	public  ServerResponse   OrderServiceFallBack(ClientRequest request, Exception ex)
	{
		
		Order order= request.getOrder();
		return new ServerResponse(order,9000000,"Tx1233766","Order Service is taking too much time") ;
	}

}
