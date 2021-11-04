package com.example.datarestapi.repository;

import com.example.datarestapi.entity.WareHouse;
import com.example.datarestapi.projection.CustomWareHouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "wareHouse",collectionResourceRel = "WareHouse",excerptProjection = CustomWareHouse.class)
public interface WareHouseRepository extends JpaRepository<WareHouse,Integer> {

    @RestResource(path = "byActive")
    public Page<WareHouse> findAllByActive(@Param("active") boolean active, Pageable pageable);
}
