package com.example.datarestapi.repository;

import com.example.datarestapi.entity.Category;
import com.example.datarestapi.projection.CustomCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "category",collectionResourceRel = "Category",excerptProjection = CustomCategory.class)
public interface CategoryRepository extends CrudRepository<Category,Integer> {
    @RestResource(path = "ByName")
    public Page<Category> findAllByName(@Param("name") String name, Pageable pageable);
}
