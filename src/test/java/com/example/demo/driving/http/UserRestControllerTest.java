package com.example.demo.driving.http;

import com.example.demo.adapters.driving.http.controller.UserController;
import com.example.demo.adapters.driving.http.dto.request.UserRequest;
import com.example.demo.adapters.driving.http.mapper.IUserRequestMapper;
import com.example.demo.domain.api.IUserServicePort;
import com.example.demo.domain.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserRestControllerTest {

    @Mock
    private IUserServicePort userServicePort;

    @Mock
    private IUserRequestMapper userRequestMapper;

    @InjectMocks
    private UserController userController;

    @Test
    void registerUserTest() {
        UserRequest userRequest = new UserRequest("Jeremy","jeremy@asd.com","Dadada1234@");
        User user = new User();
        when(userRequestMapper.toUser(userRequest)).thenReturn(user);

        ResponseEntity<Void> response = userController.registerUser(userRequest);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(userRequestMapper).toUser(userRequest);
        verify(userServicePort).registerUser(user);
    }

    @Test
    void healthCheck() {

        String response = userController.healthCheck();

        assertEquals("Healthy", response);
    }
}
