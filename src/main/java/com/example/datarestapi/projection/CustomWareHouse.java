package com.example.datarestapi.projection;

import com.example.datarestapi.entity.WareHouse;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = WareHouse.class)
public interface CustomWareHouse {
    Integer getId();
    String getName();
    boolean getActive();
}
