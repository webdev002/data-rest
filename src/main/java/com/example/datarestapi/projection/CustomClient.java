package com.example.datarestapi.projection;

import com.example.datarestapi.entity.Client;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Client.class)
public interface CustomClient {
    Integer getId();

    String getName();

    String getPhone_number();
}
