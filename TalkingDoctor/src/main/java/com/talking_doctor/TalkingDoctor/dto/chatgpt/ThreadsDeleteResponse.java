package com.talking_doctor.TalkingDoctor.dto.chatgpt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThreadsDeleteResponse {

    private String id;
    private String object;
    private String deleted;
}