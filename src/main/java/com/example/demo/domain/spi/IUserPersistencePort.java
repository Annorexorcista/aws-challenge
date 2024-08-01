package com.example.demo.domain.spi;

import com.example.demo.domain.model.User;

public interface IUserPersistencePort {

    void registerUser(User user);
}
