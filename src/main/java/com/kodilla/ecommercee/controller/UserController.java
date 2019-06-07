package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/superShop")
public class UserController {
    private Random fiveRandomNumbersGenerator = new Random();
    private Integer a = fiveRandomNumbersGenerator.nextInt(9);
    private Integer b = fiveRandomNumbersGenerator.nextInt(9);
    private Integer c = fiveRandomNumbersGenerator.nextInt(9);
    private Integer d = fiveRandomNumbersGenerator.nextInt(9);
    private Integer e = fiveRandomNumbersGenerator.nextInt(9);

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = APPLICATION_JSON_VALUE)
    public UserDto createUser(@RequestBody UserDto userDto) {
        return new UserDto(1L, "testUser", "1", null);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockingUser")
    public UserDto blockingUser(@RequestParam Long userId) {
        return new UserDto(1L, "testUser", "0", null);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "generatingKeyOfFiveNumbersValidForOneHour")
    public UserDto generatingKeyOfFourNumbersValidForOneHour(@RequestParam Long userId) {
        return new UserDto(1L, "testUser", "1" , a.toString() + b.toString() +
                c.toString() + d.toString() + e.toString());
    }

}
