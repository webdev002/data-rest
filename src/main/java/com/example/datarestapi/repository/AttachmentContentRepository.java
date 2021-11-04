package com.example.datarestapi.repository;

import com.example.datarestapi.entity.AttachmentContent;
import com.example.datarestapi.projection.CustomAttachmentContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "attachmentContent",collectionResourceRel = "AttachmentContent",excerptProjection = CustomAttachmentContent.class)
public interface AttachmentContentRepository extends CrudRepository<AttachmentContent,Integer> {
    @RestResource(path = "Bayt")
    public Page<AttachmentContent> findAllByBayt(@Param("bayt") Integer bayt, Pageable pageable);

}
