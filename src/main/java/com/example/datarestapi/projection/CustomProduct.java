package com.example.datarestapi.projection;

import com.example.datarestapi.entity.Attachment;
import com.example.datarestapi.entity.Category;
import com.example.datarestapi.entity.Measurement;
import com.example.datarestapi.entity.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Product.class)
public interface CustomProduct {
    Integer getId();

    String getName();

    Category getCategory();

    Attachment getPhoto();

    Integer getCode();

    Measurement getMeasurement();

    boolean getActive();

}
