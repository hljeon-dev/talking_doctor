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
public class RunsRequest {

    @JsonProperty("assistant_id")
    private String assistantId;
    private String model;
    private String instructions;
    private ArrayList<String> tools;
    private Object metadata; // 모든 타입을 처리할 수 있도록 Object 사용

    // 추가 생성자
    public RunsRequest(String assistantId) {
        this(assistantId, null, null, null, null);
    }
}