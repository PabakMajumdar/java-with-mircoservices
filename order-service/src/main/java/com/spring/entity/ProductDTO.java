package com.spring.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class ProductDTO {

    private String productDesc;
    private Long productId;
    private int quantity;

    private Long price;
}
