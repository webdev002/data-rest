package com.example.datarestapi.repository;

import com.example.datarestapi.entity.Client;
import com.example.datarestapi.projection.CustomClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "client",collectionResourceRel = "Client",excerptProjection = CustomClient.class)
public interface ClientRepository extends JpaRepository<Client,Integer> {
    @RestResource(path = "byName")
    public Page<Client> findAllByName(@Param("name") String name, Pageable pageable);
}
