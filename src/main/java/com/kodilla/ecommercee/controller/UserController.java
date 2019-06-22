package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.TokenService;
import com.kodilla.ecommercee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins =  "https://glacial-reef-77706.herokuapp.com")
@RestController
@RequestMapping("/superShop")
public class UserController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService service;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        service.saveUser(userMapper.mapToUser(userDto));
    }


    public UserDto blockingUser(@RequestParam Long userId) {
        System.out.println("PRZED MODYFIKACJA: " + service.getUser(userId).getStatus());
        service.blockUser(userId);
        System.out.println("PO MODYFIKACJA: " + service.getUser(userId).getStatus());
        return userMapper.mapToUserDto(service.getUser(userId));
    }


    @RequestMapping(method = RequestMethod.PUT, value = "generateUserKey")
    public UserDto generatingKeyOfFourNumbersValidForOneHour(@RequestParam Long userId) {
        UserDto userDto = userMapper.mapToUserDto(service.getUser(userId));
        userDto.setUserKey(tokenService.generateRandomKey());
        return userMapper.mapToUserDto(service.saveUser(userMapper.mapToUser(userDto)));
    }
}