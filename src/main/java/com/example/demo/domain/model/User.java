package com.example.demo.domain.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class User {

    private String id;
    private String name;
    private String email;
    private String password;
}
