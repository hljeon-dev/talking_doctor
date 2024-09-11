package com.talking_doctor.TalkingDoctor.dto.chatgpt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssistantsResponse {

    private String id;
    private String object;
    private Long createdAt;
    private String name;
    private String description;
    private String model;
    private String instructions;
    private List<Tool> tools;
    private Object fileIds; // 모든 타입을 처리할 수 있도록 Object 사용
    private Object metadata; // 모든 타입을 처리할 수 있도록 Object 사용

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Tool {
        private String type;
    }
}