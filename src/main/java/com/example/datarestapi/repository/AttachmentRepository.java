package com.example.datarestapi.repository;

import com.example.datarestapi.entity.Attachment;
import com.example.datarestapi.projection.CustomAttachment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "attachment",collectionResourceRel = "Attachment",excerptProjection = CustomAttachment.class)
public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {
    @RestResource(path = "byName")
    public Page<Attachment> findAllByName(@Param("name") String name, Pageable pageable);
}
