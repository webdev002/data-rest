package com.example.datarestapi.repository;

import com.example.datarestapi.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {

}
