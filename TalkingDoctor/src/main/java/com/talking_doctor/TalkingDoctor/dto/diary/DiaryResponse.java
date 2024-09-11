package com.talking_doctor.TalkingDoctor.dto.diary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiaryResponse {
    private int diaryId;
    private String content;
    private LocalDate createdDate;
    private String contentCheck;
    private LocalDateTime updatedDateTime;
}
