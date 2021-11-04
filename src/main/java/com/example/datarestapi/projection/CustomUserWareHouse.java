package com.example.datarestapi.projection;

import com.example.datarestapi.entity.UserWareHouse;
import com.example.datarestapi.entity.Users;
import com.example.datarestapi.entity.WareHouse;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = UserWareHouse.class)
public interface CustomUserWareHouse {
    Integer getId();

    Users getUsers();

    WareHouse getWareHouse();
}
