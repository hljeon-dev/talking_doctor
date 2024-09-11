package com.talking_doctor.TalkingDoctor.dto.chatgpt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssistantsCreateRequest {
    private String name;
    private String instruction;
}