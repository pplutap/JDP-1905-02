package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/superShop")
public class UserController {

    private Random fourRandomNumbersGenerator = new Random();
    private Integer a = fourRandomNumbersGenerator.nextInt(9);
    private Integer b = fourRandomNumbersGenerator.nextInt(9);
    private Integer c = fourRandomNumbersGenerator.nextInt(9);
    private Integer d = fourRandomNumbersGenerator.nextInt(9);


    @RequestMapping(method = RequestMethod.POST,value = "createUser",consumes = APPLICATION_JSON_VALUE)
    public UserDto createUser(@RequestBody UserDto userDto){
        return new UserDto(1L,"testUser",true,null);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "blockingUser",consumes = APPLICATION_JSON_VALUE)
    public UserDto blockingUser(RequestParam userId){
        return new UserDto(1L,"testUser",false,null);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "generatingKeyOfFourNumbersValidForOneHour",consumes = APPLICATION_JSON_VALUE)
    public UserDto generatingKeyOfFourNumbersValidForOneHour(RequestParam userId){
        return new UserDto(1L,"testUser",true,a.toString()+b.toString()+c.toString()+d.toString());
    }

}
