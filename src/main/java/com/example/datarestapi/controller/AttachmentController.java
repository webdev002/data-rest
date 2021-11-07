package com.example.datarestapi.controller;


import com.example.datarestapi.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;

@RestController
@RequestMapping("/api/attachment")
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    @PostMapping("/uploadToDB")
    public HttpEntity<?> uploadToDB(MultipartHttpServletRequest request){
        return ResponseEntity.ok(attachmentService.uploadToDB(request));
    }

    @PostMapping("/uploadToFileSystem")
    public HttpEntity<?> uploadToFileSystem(MultipartHttpServletRequest request) throws IOException {
        return ResponseEntity.ok(attachmentService.uploadToFileSystem(request));
    }

    @GetMapping("/downloadFromDB/{id}")
    public HttpEntity<?> downloadFromDB(@PathVariable Integer id){
        HttpEntity<?> httpEntity = attachmentService.downloadFromDB(id);
        return ResponseEntity.ok(httpEntity);
    }

    @GetMapping("/downloadFromSystem/{id}")
    public HttpEntity<?> downloadFromSystem(@PathVariable Integer id) throws IOException {
        HttpEntity<?> httpEntity = attachmentService.downloadFromSystem(id);
        return ResponseEntity.ok(httpEntity);
    }



}
