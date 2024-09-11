package com.talking_doctor.TalkingDoctor.repository;

import com.talking_doctor.TalkingDoctor.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DiaryRepsitory extends JpaRepository<Diary, Integer> {
    Optional<Diary> findById(int diaryId);

    List<Diary> findByCreatedDate(LocalDate createdDate);

    List<Diary> findAll();


}
