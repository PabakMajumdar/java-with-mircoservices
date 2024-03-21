package com.spring.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.entity.ClientRequest;
import com.spring.entity.ServerResponse;

public interface OrderService {

	public ServerResponse saveOrder(ClientRequest request) throws JsonProcessingException;
}
