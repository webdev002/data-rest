package com.example.datarestapi.repository;

import com.example.datarestapi.entity.UserWareHouse;
import com.example.datarestapi.projection.CustomUserWareHouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "userWareHouse",collectionResourceRel = "UserWareHouse",excerptProjection = CustomUserWareHouse.class)
public interface UserWareHouseRepository extends CrudRepository<UserWareHouse,Integer> {
    @RestResource(path = "userWareHouse")
    public Page<UserWareHouse> findAllById(@Param("id") Integer id, Pageable pageable);
}
