package com.talking_doctor.TalkingDoctor.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "LastName")
    @NotNull
    private String lastName;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "user_name", unique = true)
    @NotNull
    private String userName;

    @NotNull
    @Column
    private LocalDate createdDate;
}
