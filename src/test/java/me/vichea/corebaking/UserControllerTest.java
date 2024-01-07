package me.vichea.corebaking;

import me.vichea.corebaking.controller.UserController;
import me.vichea.corebaking.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;


    @Test
    void createShouldReturnSuccess() {

    }

}
