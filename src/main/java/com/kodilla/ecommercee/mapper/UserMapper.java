package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public UserDto mapToUserDto(User user) {
        return new UserDto(user.getId(), user.getUsername(), user.getStatus(), user.getUserKey());
    }

    public User mapToUser(UserDto userDto) {
        return new User(userDto.getUsername());
    }

}
