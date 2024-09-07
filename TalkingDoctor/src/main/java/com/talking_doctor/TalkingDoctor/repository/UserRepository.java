package com.talking_doctor.TalkingDoctor.repository;

import com.talking_doctor.TalkingDoctor.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

}
