package com.example.datarestapi.projection;

import com.example.datarestapi.entity.Output;
import com.example.datarestapi.entity.OutputProduct;
import com.example.datarestapi.entity.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = OutputProduct.class)
public interface CustomOutputProduct {
    Integer getId();

    Product getProduct();

    Integer getAmount();

    Double getPrice();

    Output getOutput();

}
