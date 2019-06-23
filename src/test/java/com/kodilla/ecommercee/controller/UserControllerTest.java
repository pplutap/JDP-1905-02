package com.kodilla.ecommercee.controller;



import com.google.gson.Gson;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.repository.UserRepository;
import com.kodilla.ecommercee.service.TokenService;
import com.kodilla.ecommercee.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)

public class UserControllerTest {

    private final static User user = new User("KOWALSKI JAN", "UNBLOCKED", 12345L);
    private final static UserDto userDto = new UserDto("KOWALSKI JAN", "UNBLOCKED", 12345L);
    private final static Long userId = 300L;
    private static Gson gson = new Gson();
    private final static String jsonContent = gson.toJson(userDto);



    @MockBean
    private UserService service;

    @MockBean
    private UserMapper userMapper;

    @MockBean
    private TokenService tokenService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createUserTest() throws Exception {
        when(userMapper.mapToUserDto(ArgumentMatchers.any())).thenReturn(userDto);
        when(service.saveUser(ArgumentMatchers.any())).thenReturn(user);
        when(tokenService.generateRandomKey()).thenReturn(12345L);

        mockMvc.perform(post("/superShop/createUser")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }


    @Test
    public void blockingUserTest() throws Exception{
        when(userMapper.mapToUserDto(ArgumentMatchers.any())).thenReturn(userDto);
        when(service.saveUser(ArgumentMatchers.any())).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.put("/superShop/blockingUser?userId=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void generateUserKeyTest() throws Exception{
        when(userMapper.mapToUserDto(ArgumentMatchers.any())).thenReturn(userDto);
        when(service.saveUser(ArgumentMatchers.any())).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.put("/superShop/generateUserKey?userId=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
