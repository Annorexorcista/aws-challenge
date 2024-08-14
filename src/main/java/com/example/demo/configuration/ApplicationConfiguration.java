package com.example.demo.configuration;

import com.example.demo.adapters.driven.jpa.mysql.adapter.UserAdapter;
import com.example.demo.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.example.demo.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.example.demo.domain.api.use_case.UserUseCase;
import com.example.demo.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfiguration {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Bean
    public UserUseCase userUseCase(IUserPersistencePort userPersistencePort) {
        return new UserUseCase(userPersistencePort);
    }

    @Bean
    public UserAdapter userAdapter() {
        return new UserAdapter(userRepository, userEntityMapper);
    }



}
