package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserCrudTestSuite {

    private static final String USER_NAME_NOWAK = "NOWAK JAN";
    private static final String USER_NAME_KOWALSKI = "KOWALSKI JAKUB";


    @Autowired
    private GenericEntityRepository genericEntityRepository;

    @Test
    public void testUserSave() {
        //Given
        User user = new User(USER_NAME_NOWAK);

        //When
        genericEntityRepository.save(user);

        //Then
        Long id = user.getId();
        User userById = (User) genericEntityRepository.getOne(id);
        Assert.assertEquals("NOWAK JAN", userById.getUsername());
        Assert.assertEquals("UNBLOCKED", userById.getStatus());

    }

    @Test
    public void testUserUpdate() {
        //Given
        User user = new User(USER_NAME_NOWAK);

        //When
        genericEntityRepository.save(user);
        user.setStatus("BLOCKED");
        user.setUsername(USER_NAME_KOWALSKI);

        //Then
        Long id = user.getId();
        User userById = (User) genericEntityRepository.getOne(id);
        Assert.assertEquals("KOWALSKI JAKUB", userById.getUsername());
        Assert.assertEquals("BLOCKED", userById.getStatus());

    }


    @Test
     public void testGroupDeleteOne() {
        //Given
        User userNowak = new User(USER_NAME_NOWAK);
        User userKowalski = new User(USER_NAME_KOWALSKI);

        //When
        genericEntityRepository.save(userNowak);
        genericEntityRepository.save(userKowalski);
        Long recordCount = genericEntityRepository.count();

        //Then
        genericEntityRepository.delete(userNowak);
        Assert.assertEquals(recordCount-1, genericEntityRepository.count());

     }



}
