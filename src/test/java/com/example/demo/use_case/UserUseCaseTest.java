package com.example.demo.use_case;

import com.example.demo.domain.api.use_case.UserUseCase;
import com.example.demo.domain.model.User;
import com.example.demo.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserUseCaseTest {

    @Mock
    private IUserPersistencePort userPersistencePort;

    @InjectMocks
    private UserUseCase userUseCase;

    @Test
    void registerUser() {

        User user = new User();

        userUseCase.registerUser(user);

        verify(userPersistencePort, times(1)).registerUser(user);
    }
}
