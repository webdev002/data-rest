package com.example.datarestapi.projection;

import com.example.datarestapi.entity.Attachment;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Attachment.class)
public interface CustomAttachment {
    Integer getId();

    String getName();

    Integer getSize();

    String getContent_type();
}
