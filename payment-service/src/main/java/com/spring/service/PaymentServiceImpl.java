package com.spring.service;

import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.entity.Payment;
import com.spring.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentRepository;

	Logger logger= LoggerFactory.getLogger(PaymentServiceImpl.class);
	
	@Override
	public Payment doPayment(Payment payment) throws JsonProcessingException {
		
		payment.setPaymentStatus(PaymentStatusRandomValue());
		payment.setTransactionId(UUID.randomUUID().toString());
		logger.info("PAYMENT-SERVICE REQUEST" + new ObjectMapper().writeValueAsString(payment));
		return paymentRepository.save(payment);
	}

	public String PaymentStatusRandomValue()
	{
		return new Random().nextBoolean()?"SUCCESS":"FAILURE";
	}
	
}
