package com.example.datarestapi.projection;


import com.example.datarestapi.entity.Users;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Users.class)
public interface CustomUser {

    Integer getId();

    String getFirst_name();

    String getLast_name();

    String getPhone_number();

    Integer getCode();

    Integer getPassword();

    boolean getActive();



}
