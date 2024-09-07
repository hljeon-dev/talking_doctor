package com.talking_doctor.TalkingDoctor.dto.diary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiaryUpdateRequest {
    private String content;
    private LocalDateTime updatedDateTime = LocalDateTime.now();
}
