package com.example.datarestapi.projection;

import com.example.datarestapi.entity.Supplier;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Supplier.class)
public interface CustomSupplier {

    Integer getId();

    String getName();

    boolean getActive();

    String getPhone_number();
}
