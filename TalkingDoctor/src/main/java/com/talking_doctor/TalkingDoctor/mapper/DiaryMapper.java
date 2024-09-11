package com.talking_doctor.TalkingDoctor.mapper;

import com.talking_doctor.TalkingDoctor.dto.diary.DiaryRequest;
import com.talking_doctor.TalkingDoctor.dto.diary.DiaryResponse;
import com.talking_doctor.TalkingDoctor.entity.Diary;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiaryMapper {
    Diary diaryRequestToDiary(DiaryRequest diaryRequest);

    DiaryResponse diaryToDiaryResponse(Diary diary);
}
