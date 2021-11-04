package com.example.datarestapi.repository;

import com.example.datarestapi.entity.Supplier;
import com.example.datarestapi.projection.CustomSupplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "supplier",collectionResourceRel = "Supplier",excerptProjection = CustomSupplier.class)
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {

    @RestResource(path = "ByPhoneNumber")
    public default Page<Supplier> findAllByPhone_number(@Param("p_number") String phone_number, Pageable pageable) {
        return null;
    }
}
