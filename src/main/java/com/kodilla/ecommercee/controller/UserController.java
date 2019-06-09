package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/superShop")
public class UserController {

    @Autowired
    private TokenService dbService;

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = APPLICATION_JSON_VALUE)
    public UserDto createUser(@RequestBody UserDto userDto) {
        return new UserDto(1L, "testUser", "1", null);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockingUser")
    public UserDto blockingUser(@RequestParam Long userId) {
        return new UserDto(1L, "testUser", "0", null);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "generateUserKey")
    public UserDto generatingKeyOfFourNumbersValidForOneHour(@RequestParam Long userId) {
        return new UserDto(1L, "testUser", "1" , dbService.generateRandomKey());
    }

}