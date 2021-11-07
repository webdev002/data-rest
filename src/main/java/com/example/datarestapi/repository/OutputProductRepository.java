package com.example.datarestapi.repository;

import com.example.datarestapi.entity.OutputProduct;
import com.example.datarestapi.projection.CustomOutputProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "outputProduct",collectionResourceRel = "OutputProduct",excerptProjection = CustomOutputProduct.class)
public interface OutputProductRepository extends CrudRepository<OutputProduct,Integer> {
    @RestResource(path = "ByAmount")
    public Page<OutputProduct> findAllByAmount(@Param("amount") Integer amount, Pageable pageable);
}
