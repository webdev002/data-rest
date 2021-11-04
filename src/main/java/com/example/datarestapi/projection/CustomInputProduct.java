package com.example.datarestapi.projection;

import com.example.datarestapi.entity.Input;
import com.example.datarestapi.entity.InputProduct;
import com.example.datarestapi.entity.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = InputProduct.class)
public interface CustomInputProduct {

    Integer getId();

    Product getProduct();

    Integer getAmount();

    Double getPrice();

    String getExpireDate();

    Input getInput();
}
