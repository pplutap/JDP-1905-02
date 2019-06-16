package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserCrudTestSuite {

    private static final String USER_NAME_NOWAK = "NOWAK JAN";
    private static final String USER_NAME_KOWALSKI = "KOWALSKI JAKUB";


    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUserSave() {
        //Given
        User user = new User(USER_NAME_NOWAK);

        //When
        userRepository.save(user);

        //Then
        Long id = user.getId();
        Optional<User> userById = userRepository.findById(id);
        Assert.assertEquals("NOWAK JAN", userById.get().getUsername());
        Assert.assertEquals("UNBLOCKED", userById.get().getStatus());

    }

    @Test
    public void testUserUpdate() {
        //Given
        User user = new User(USER_NAME_NOWAK);

        //When
        userRepository.save(user);
        user.setStatus("BLOCKED");
        user.setUsername(USER_NAME_KOWALSKI);

        //Then
        Long id = user.getId();
        Optional<User> userById = userRepository.findById(id);
        Assert.assertEquals("KOWALSKI JAKUB", userById.get().getUsername());
        Assert.assertEquals("BLOCKED", userById.get().getStatus());

    }


    @Test
     public void testGroupDeleteOne() {
        //Given
        User userNowak = new User(USER_NAME_NOWAK);
        User userKowalski = new User(USER_NAME_KOWALSKI);

        //When
        userRepository.save(userNowak);
        userRepository.save(userKowalski);
        Long recordCount = userRepository.count();

        //Then
        userRepository.delete(userNowak);
        Assert.assertEquals(recordCount-1, userRepository.count());

     }



}
