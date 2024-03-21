package com.productservice.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.productservice.model.Product;
import com.productservice.model.ProductDTO;
import com.productservice.model.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/buy")
    public ResponseEntity buyProduct(@RequestBody Product product){
        ProductDTO productDTO =new ProductDTO(product.getProductDesc(),
                product.getProductId(), product.getPrice());

       ServerResponse response= restTemplate.postForObject("http://localhost:8082/order/bookOrder"
                ,productDTO, ServerResponse.class);

       return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
