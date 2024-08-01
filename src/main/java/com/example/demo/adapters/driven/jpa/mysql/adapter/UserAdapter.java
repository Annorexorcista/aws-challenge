package com.example.demo.adapters.driven.jpa.mysql.adapter;

import com.example.demo.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.example.demo.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.example.demo.domain.model.User;
import com.example.demo.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public void registerUser(User user) {
        userRepository.save(userEntityMapper.toEntity(user));
    }
}
