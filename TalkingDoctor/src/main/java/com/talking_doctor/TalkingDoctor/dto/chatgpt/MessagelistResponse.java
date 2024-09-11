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
public class MessagelistResponse {
    private String object;
    private List<MessageData> data;
    private String firstId;
    private String lastId;
    private boolean hasMore;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class MessageData {
        private String id;
        private String object;
        private Long createdAt;
        private String threadId;
        private String role;
        private List<Content> content;
        private List<String> fileIds;
        private String assistantId;
        private String runId;
        private Map<String, Object> metadata;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Content {
            private String type;
            private Text text;

            @Data
            @NoArgsConstructor
            @AllArgsConstructor
            public static class Text {
                private String value;
                private List<Object> annotations; // Any 타입을 Object로 대체
            }
        }
    }
}