package com.example.demo.adapters.driving.http.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserRequest {

    private String name;
    private String email;
    private String password;
}
