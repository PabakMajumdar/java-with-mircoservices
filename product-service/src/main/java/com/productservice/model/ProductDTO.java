package com.productservice.model;


import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ProductDTO {

    private String productDesc;
    private Long productId;

    private Long price;
}
