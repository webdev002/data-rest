package com.example.datarestapi.projection;

import com.example.datarestapi.entity.Category;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Category.class)
public interface CustomCategory {

    Integer getId();

    String getName();

    Category getParentCategory();
}
