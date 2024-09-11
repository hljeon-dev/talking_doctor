package com.talking_doctor.TalkingDoctor.dto.chatgpt;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageRequest {
    private String role;
    private String content;

    @JsonProperty("file_ids")
    private ArrayList<String> fileIds;
    private Object metadata;

    // 추가 생성자
    public MessageRequest(String role, String content) {
        this(role, content, null, null);
    }
}