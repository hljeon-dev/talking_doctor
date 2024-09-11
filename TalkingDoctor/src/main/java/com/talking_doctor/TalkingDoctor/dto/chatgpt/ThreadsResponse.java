package com.talking_doctor.TalkingDoctor.dto.chatgpt;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThreadsResponse {

    private String id;
    private String object;

    @JsonProperty("created_at")
    private Long createdAt;

    private Object metadata;
}