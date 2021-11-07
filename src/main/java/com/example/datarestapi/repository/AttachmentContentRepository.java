package com.example.datarestapi.repository;


import com.example.datarestapi.entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AttachmentContentRepository extends JpaRepository<AttachmentContent,Integer> {
    AttachmentContent findByAttachmentId(Integer attachment_id);
}
