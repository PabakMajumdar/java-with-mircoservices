package com.productservice.model;


import lombok.Getter;

@Getter
public class Product {

    private String productDesc;
    private Long productId;
    private int quantity;
    private Long price;
}
