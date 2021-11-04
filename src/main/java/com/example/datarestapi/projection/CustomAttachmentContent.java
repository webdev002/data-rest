package com.example.datarestapi.projection;

import com.example.datarestapi.entity.Attachment;
import com.example.datarestapi.entity.AttachmentContent;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = AttachmentContent.class)
public interface CustomAttachmentContent {
    Integer getId();

    Integer getBayt();

    Attachment getAttachment();
}
