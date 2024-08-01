package com.example.demo.domain.api.use_case;

import com.example.demo.domain.api.IUserServicePort;
import com.example.demo.domain.model.User;
import com.example.demo.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    @Override
    public void registerUser(User user) {
        userPersistencePort.registerUser(user);
    }
}
