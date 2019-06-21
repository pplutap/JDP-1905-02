package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserControllerTest {

    private static final String USER_NAME_KOWALSKI = "KOWALSKI JAKUB";

    @Autowired
    private UserController userController;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void createUser() {
        //Given
        UserDto userDto = new UserDto(USER_NAME_KOWALSKI);

        //When
        int usersNumber = userRepository.findAll().size();
        userController.createUser(userDto);

        //Then
        Assert.assertEquals(++usersNumber, userRepository.findAll().size());

    }

    @Test
    public void blockUser() {
        //Given
        UserDto userDto = new UserDto(USER_NAME_KOWALSKI);
        userController.createUser(userDto);

        //When
        List<User> users = userRepository.findAll();
        User user = users.get(users.size()-1);
        Long userId = user.getId();
        UserDto userDtoBlocked = userController.blockingUser(userId);

        //Then
        Assert.assertEquals("BLOCKED", userDtoBlocked.getStatus());

    }

    @Test
    public void setKeyForUser() {
        //Given
        UserDto userDto = new UserDto(USER_NAME_KOWALSKI);
        userController.createUser(userDto);

        //When
        List<User> users = userRepository.findAll();
        User user = users.get(users.size()-1);
        Long userId = user.getId();
        UserDto userDtoWithKey = userController.generatingKeyOfFourNumbersValidForOneHour(userId);

        //Then
        Assert.assertNotNull(userDtoWithKey.getUserKey());

    }



}
