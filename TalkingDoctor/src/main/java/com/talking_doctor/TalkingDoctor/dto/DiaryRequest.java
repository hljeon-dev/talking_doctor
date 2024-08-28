package com.talking_doctor.TalkingDoctor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiaryRequest {
    private String content;
    private LocalDate createdDate = LocalDate.now();
}
