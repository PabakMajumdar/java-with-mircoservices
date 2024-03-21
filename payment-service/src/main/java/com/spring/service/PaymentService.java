package com.spring.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.entity.Payment;

public interface PaymentService {

	
	public Payment doPayment(Payment payment)throws JsonProcessingException;
	
}
