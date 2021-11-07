package com.example.datarestapi.repository;

import com.example.datarestapi.entity.Currency;
import com.example.datarestapi.projection.CustomCurrency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "currency",collectionResourceRel = "Currency",excerptProjection = CustomCurrency.class)
public interface CurrencyRepository extends JpaRepository<Currency,Integer> {
    @RestResource(path = "ByName")
    public Page<Currency> findAllByName(@Param("name") String name, Pageable pageable);
}
