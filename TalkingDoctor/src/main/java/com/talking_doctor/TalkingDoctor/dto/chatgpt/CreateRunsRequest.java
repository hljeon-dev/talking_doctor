package com.talking_doctor.TalkingDoctor.dto.chatgpt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRunsRequest {
    private String assistantId;
}
