package com.example.datarestapi.projection;

import com.example.datarestapi.entity.Currency;
import com.example.datarestapi.entity.Input;
import com.example.datarestapi.entity.Supplier;
import com.example.datarestapi.entity.WareHouse;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Input.class)
public interface CustomInput {
    Integer getId();

    String getDatee();

    WareHouse getWareHouse();

    Supplier getSupplier();

    Currency getCurrency();

    Integer getFacture_number();

    Integer getCode();
}
