package com.example.datarestapi.projection;

import com.example.datarestapi.entity.Currency;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Currency.class)
public interface CustomCurrency {
    Integer getId();

    String getName();

    boolean getActive();
}
