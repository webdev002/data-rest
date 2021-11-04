package com.example.datarestapi.repository;

import com.example.datarestapi.entity.InputProduct;
import com.example.datarestapi.projection.CustomInputProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "inputProduct",collectionResourceRel = "InputProduct",excerptProjection = CustomInputProduct.class)
public interface InputProductRepository extends CrudRepository<InputProduct,Integer> {
    @RestResource(path = "ByAmount")
    public Page<InputProduct> findAllByAmount(@Param("amount") Integer amount, Pageable pageable);
}
