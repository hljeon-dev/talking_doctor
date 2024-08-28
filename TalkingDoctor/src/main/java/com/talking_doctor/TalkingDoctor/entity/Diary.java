package com.talking_doctor.TalkingDoctor.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "diary")
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_id")
    private int id;

    @NotNull
    @Column(name = "contents")
    private String content;

    //@NotNull
    @Column(name = "contents_check")
    private String contentCheck;

    @NotNull
    @Column
    private LocalDate createdDate; //= LocalDateTime.now();

    @NotNull
    @Column
    private LocalDateTime updatedDatetime;
}
