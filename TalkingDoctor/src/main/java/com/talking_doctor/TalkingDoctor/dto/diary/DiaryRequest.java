package com.talking_doctor.TalkingDoctor.dto.diary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiaryRequest {
    private String content;
    private LocalDate createdDate = LocalDate.now();
}
