package com.talking_doctor.TalkingDoctor.dto.chatgpt;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RunsResponse {

    private String id;
    private String object;
    private Long createdAt;
    private String assistantId;
    private String threadId;
    private String status;
    private Long startedAt;
    private Long expiresAt;
    private Long cancelledAt;
    private Long failedAt;
    private Long completedAt;
    private Object lastError; // 모든 타입을 처리할 수 있도록 Object 사용
    private String model;
    private Object instructions; // 모든 타입을 처리할 수 있도록 Object 사용
    private List<Tool> tools;
    private List<String> fileIds;
    private Map<String, Object> metadata;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Tool {
        private String type;
    }
}