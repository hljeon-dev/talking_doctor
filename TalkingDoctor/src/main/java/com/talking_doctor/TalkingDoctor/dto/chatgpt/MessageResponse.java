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
public class MessageResponse {
    private String id;
    private String object;
    private Long createdAt;
    private String threadId;
    private String role;
    private List<MessageContent> content;
    private List<String> fileIds;
    private String assistantId;
    private String runId;
    private Map<String, Object> metadata;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MessageContent {
        private String type;
        private TextContent text;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class TextContent {
            private String value;
            private List<Object> annotations;
        }
    }
}