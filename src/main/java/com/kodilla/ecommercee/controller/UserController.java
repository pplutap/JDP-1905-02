package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.TokenService;
import com.kodilla.ecommercee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

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

    @PostMapping(path = "createUser", consumes = APPLICATION_JSON_VALUE)
    public void createUser(UserDto userDto) {
        service.saveUser(userMapper.mapToUser(userDto));
    }

    @PutMapping(path = "blockingUser")
    public UserDto blockingUser(@RequestParam Long userId) {
        service.blockUser(userId);
        return userMapper.mapToUserDto(service.getUser(userId));
    }

    @PutMapping(path = "generateUserKey")
    public UserDto generatingKeyOfFourNumbersValidForOneHour(@RequestParam Long userId) {
        service.setUserKey(tokenService.generateRandomKey(), userId);
        return userMapper.mapToUserDto(service.getUser(userId));
    }
}