package com.example.datarestapi.repository;

import com.example.datarestapi.entity.Output;
import com.example.datarestapi.projection.CustomOutput;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "output",collectionResourceRel = "Output",excerptProjection = CustomOutput.class)
public interface OutputRepository extends CrudRepository<Output,Integer> {
    @RestResource(path = "Date")
    public Page<Output> findAllByDatee(@Param("date") String datee, Pageable pageable);
}
