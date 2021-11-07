package com.example.datarestapi.repository;

import com.example.datarestapi.entity.Input;
import com.example.datarestapi.projection.CustomInput;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "input",collectionResourceRel = "Input",excerptProjection = CustomInput.class)
public interface InputRepository extends CrudRepository<Input,Integer> {
    @RestResource(path = "ByDate")
    public Page<Input> findAllByDatee(@Param("date") String datee, Pageable pageable);
}
