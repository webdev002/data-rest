package com.example.datarestapi.projection;

import com.example.datarestapi.entity.Client;
import com.example.datarestapi.entity.Currency;
import com.example.datarestapi.entity.Output;
import com.example.datarestapi.entity.WareHouse;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Output.class)
public interface CustomOutput {
    Integer getId();

    String getDatee();

    WareHouse getWareHouse();

    Currency getCurrency();

    Integer getFacture_number();

    Integer getCode();

    Client getClient();

}
