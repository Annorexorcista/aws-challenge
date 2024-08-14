package com.example.demo.driven.jpa.mysql;

import com.example.demo.adapters.driven.jpa.mysql.adapter.UserAdapter;
import com.example.demo.adapters.driven.jpa.mysql.entity.UserEntity;
import com.example.demo.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.example.demo.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.example.demo.domain.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserAdapterTest {

    @Mock
    private IUserRepository userRepository;

    @Mock
    private IUserEntityMapper userEntityMapper;

    @InjectMocks
    private UserAdapter userAdapter;

    @Test
    void registerUserTest() {

        User user = new User();
        UserEntity userEntity = new UserEntity();

        when(userEntityMapper.toEntity(user)).thenReturn(userEntity);

        userAdapter.registerUser(user);

        verify(userEntityMapper).toEntity(user);
        verify(userRepository).save(userEntity);
    }
}
