package com.example.datarestapi.service;

import com.example.datarestapi.entity.Attachment;
import com.example.datarestapi.entity.AttachmentContent;
import com.example.datarestapi.payload.FileResponse;
import com.example.datarestapi.repository.AttachmentContentRepository;
import com.example.datarestapi.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;


@Service
public class AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;
    private static final String UploadDirector = "files";

    public List<Integer> uploadToDB(MultipartHttpServletRequest request) {
        try {
            List<Integer> photoIds =new ArrayList<>();
            Iterator<String> fileNames = request.getFileNames();
            List<MultipartFile> files = request.getFiles(fileNames.next());
            if (files.size()>0){
                for (MultipartFile file : files) {
                    Attachment attachment = new Attachment();
                    attachment.setName(file.getName());
                    attachment.setSize(file.getSize());
                    attachment.setContent_type(file.getContentType());
                    Attachment saveAttachment = attachmentRepository.save(attachment);

                    AttachmentContent content = new AttachmentContent();
                    content.setAttachment(saveAttachment);
                    content.setBytes(file.getBytes());
                    attachmentContentRepository.save(content);
                    photoIds.add(saveAttachment.getId());
                }

            }
            return photoIds;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }




    public HttpEntity<?> downloadFromDB(Integer id) {
        Attachment byId = attachmentRepository.getById(id);
        AttachmentContent content = attachmentContentRepository.findByAttachmentId(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(byId.getContent_type()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+byId.getName()+"\"")
                .body(content.getBytes());
    }

    public String uploadToFileSystem(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        if (file != null) {
            Attachment attachment = new Attachment();
            attachment.setName(file.getName());
            attachment.setSize(file.getSize());
            attachment.setContent_type(file.getContentType());
            attachment = attachmentRepository.save(attachment);
            String[] split = file.getOriginalFilename().split("\\.");
            String name = UUID.randomUUID().toString() + "." + split[split.length - 1];
            attachment.setFileName(name);
            Path path = Paths.get("D:\\Java project 2021\\Mantiqiy-Masalalar\\" + name);
            Files.copy(file.getInputStream(), path);
            attachment.setFilePath(path.toString());
            attachmentRepository.save(attachment);
            return "saved";
        }
        return null;
    }

    public HttpEntity<?> downloadFromSystem(Integer id) throws IOException {
        Attachment byId = attachmentRepository.getById(id);
        File file = new File(byId.getFilePath());
        byte[] bytes = Files.readAllBytes(file.toPath());
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(byId.getContent_type()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+byId.getName()+"\"")
                .body(bytes);

    }
}
