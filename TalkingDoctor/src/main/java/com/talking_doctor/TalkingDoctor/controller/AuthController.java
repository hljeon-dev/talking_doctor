package com.talking_doctor.TalkingDoctor.controller;

import com.talking_doctor.TalkingDoctor.dto.user.LoginRequest;
import com.talking_doctor.TalkingDoctor.dto.user.RegisterRequest;
import com.talking_doctor.TalkingDoctor.entity.User;
import com.talking_doctor.TalkingDoctor.repository.UserRepository;
import com.talking_doctor.TalkingDoctor.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest)  {
//
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
//            );
//            return new ResponseEntity<>(jwtUtil.generateToken(
//                    loginRequest.getEmail(),
//                    userRepository.findByEmail(loginRequest.getEmail()).getId(),
//                    userRepository.findByEmail(loginRequest.getEmail()).getFirstName()+
//                            " "+ userRepository.findByEmail(loginRequest.getEmail()).getLastName()
//            )
//                    ,HttpStatus.OK
//            );
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(), loginRequest.getPassword()
                    )
            );

            // 사용자 정보 가져오기
            User user = userRepository.findByEmail(loginRequest.getEmail());

            // JWT 토큰 생성
            //String token = jwtUtil.generateToken(loginRequest.getEmail());

            // JWT 토큰 생성
            String token = jwtUtil.generateToken(
                    loginRequest.getEmail(),        // 이메일
                    user.getId(),                   // 사용자 ID
                    user.getLastName() + " " + user.getFirstName()  // 사용자 이름
            );


            // 반환할 응답 데이터 구성
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("userName", user.getUserName());
            response.put("createdDate", user.getCreatedDate());

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest){

        if (userRepository.findByEmail(registerRequest.getEmail())!=null){
            return new ResponseEntity<>("Email already exist", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setUserName(registerRequest.getUserName());
        user.setCreatedDate(registerRequest.getCreatedDate());
        userRepository.save(user);
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(registerRequest.getEmail(), registerRequest.getPassword())
        );
        return new ResponseEntity<>(jwtUtil.generateToken(
                registerRequest.getEmail(),
                userRepository.findByEmail(registerRequest.getEmail()).getId(),
                registerRequest.getLastName() +" "+registerRequest.getFirstName()
        )
                ,HttpStatus.OK
        );
    }

}
