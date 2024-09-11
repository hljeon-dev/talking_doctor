package com.talking_doctor.TalkingDoctor.dto.chatgpt;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessagelistRequest {
    private String limit;
    private String order;
    private String after;
    private String before;
}
