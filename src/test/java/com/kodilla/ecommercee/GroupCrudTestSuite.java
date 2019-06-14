package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Group;
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
public class GroupCrudTestSuite {

    private static final String GROUP_NAME_AGD = "Drobne AGD";
    private static final String GROUP_NAME_FOOD = "Zywnosc";
    private static final String GROUP_NAME_CLOTHES = "Ubrania";

    @Autowired
    private GenericEntityRepository genericEntityRepository;

    @Test
    public void testGroupSave() {
        //Given
        Group group = new Group(GROUP_NAME_AGD);

        //When
        genericEntityRepository.save(group);

        //Then
        Long id = group.getId();
        Group groupById = (Group) genericEntityRepository.getOne(id);
        Assert.assertEquals("Drobne AGD", groupById.getName());

    }

    @Test
    public void testGroupUpdate() {
        //Given
        Group group = new Group(GROUP_NAME_AGD);

        //When
        genericEntityRepository.save(group);
        group.setName(GROUP_NAME_CLOTHES);

        //Then
        Long id = group.getId();
        Group groupById = (Group) genericEntityRepository.getOne(id);
        Assert.assertEquals("Ubrania", groupById.getName());

    }


    @Test
     public void testGroupDeleteOne() {
        //Given
        Group groupAgd = new Group(GROUP_NAME_AGD);
        Group groupFood = new Group(GROUP_NAME_FOOD);
        Group groupClothes= new Group(GROUP_NAME_CLOTHES);

        //When
        genericEntityRepository.save(groupAgd);
        genericEntityRepository.save(groupFood);
        genericEntityRepository.save(groupClothes);
        Long recordCount = genericEntityRepository.count();

        //Then
        genericEntityRepository.delete(groupAgd);
        Assert.assertEquals(recordCount-1, genericEntityRepository.count());

     }
}
