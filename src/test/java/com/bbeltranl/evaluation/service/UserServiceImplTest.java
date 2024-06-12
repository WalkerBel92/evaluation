package com.bbeltranl.evaluation.service;

import com.bbeltranl.evaluation.model.User;
import com.bbeltranl.evaluation.dto.UserRequest;
import com.bbeltranl.evaluation.repository.UserRepository;
import com.bbeltranl.evaluation.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;


    @Test
    public void testRegisterUser() {
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail("test@example.com");

        User user = new User();
        user.setId(UUID.randomUUID());
        user.setEmail("test@example.com");

        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.empty());
        when(userRepository.save(any())).thenReturn(user);

        User result = userService.registerUser(userRequest);

        assertNotNull(result.getId());
        assertEquals("test@example.com", result.getEmail());
    }

    @Test
    public void testRegisterUserWithExistingEmail() {
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail("test@example.com");

        User user = new User();

        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.registerUser(userRequest);
        });

        assertEquals("El correo ya registrado", exception.getMessage());
    }

}
