package com.example.datarestapi.repository;

import com.example.datarestapi.entity.Product;
import com.example.datarestapi.projection.CustomProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "product",collectionResourceRel = "Product",excerptProjection = CustomProduct.class)
public interface ProductRepository extends CrudRepository<Product,Integer> {
    @RestResource(path = "ByProduct")
    public Page<Product> findAllByName(@Param("name") String name, Pageable pageable);
}
