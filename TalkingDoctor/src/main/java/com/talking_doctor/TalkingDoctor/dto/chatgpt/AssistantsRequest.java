package com.talking_doctor.TalkingDoctor.dto.chatgpt;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssistantsRequest {

    private String model;
    private String name;
    private String instructions;
    private List<Tool> tools;

    // 생성자 (tools가 null인 경우)
    public AssistantsRequest(String model, String name, String instructions) {
        this.model = model;
        this.name = name;
        this.instructions = instructions;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Tool {
        private String type;
    }
}
