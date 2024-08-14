package com.example.demo.adapters.driving.http.controller;

import com.example.demo.adapters.driving.http.dto.request.UserRequest;
import com.example.demo.adapters.driving.http.mapper.IUserRequestMapper;
import com.example.demo.domain.api.IUserServicePort;
import com.example.demo.domain.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final IUserServicePort userService;
    private final IUserRequestMapper userRequestMapper;

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@Valid @RequestBody UserRequest userRequest) {
        User user = userRequestMapper.toUser(userRequest);
        userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping()
    public String healthCheck(){
        return "Healthy";
    }
}
