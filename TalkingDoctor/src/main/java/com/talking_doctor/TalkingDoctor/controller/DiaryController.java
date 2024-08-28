package com.talking_doctor.TalkingDoctor.controller;

import com.talking_doctor.TalkingDoctor.dto.DiaryRequest;
import com.talking_doctor.TalkingDoctor.dto.DiaryResponse;
import com.talking_doctor.TalkingDoctor.dto.DiaryUpdateRequest;
import com.talking_doctor.TalkingDoctor.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/diary")
public class DiaryController {
    @Autowired
    DiaryService diaryService;

    // 일기 작성
    @PostMapping("/add")
    public ResponseEntity<Integer> addDiary(@RequestBody DiaryRequest diaryRequest) {
        int diaryId = diaryService.addDiary(diaryRequest);
        return ResponseEntity.ok(diaryId);
    }

    //일기 수정
    @PutMapping("/update/{id}")
    public ResponseEntity<Integer> updateDiary(@PathVariable("id") int diaryId, @RequestBody DiaryUpdateRequest diaryUpdateRequest) {
        int updatedDiaryId = diaryService.updateDiary(diaryId, diaryUpdateRequest);
        return ResponseEntity.ok(updatedDiaryId);
    }

    //특정 날짜의 일기 목록 조회
    @GetMapping("/get/{date}")
    public ResponseEntity<List<DiaryResponse>> selectDiaryDetailsByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
                List<DiaryResponse> diaryResponseList = diaryService.selectDiaryDetailsByDate(date);
                return ResponseEntity.ok(diaryResponseList);
    }

    //일기 삭제
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDiary(@PathVariable int id) {
        diaryService.deleteDiary(id);
        //return new ResponseEntity<>("Deleted", HttpStatus.OK); //ResponseEntity<String>로 선언해야힘
        return ResponseEntity.noContent().build(); //ResponseEntity<Void>로 선언해야힘
    }

}
