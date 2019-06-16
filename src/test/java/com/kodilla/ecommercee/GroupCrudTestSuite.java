package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.repository.GroupRepository;
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
public class GroupCrudTestSuite {

    private static final String GROUP_NAME_AGD = "Drobne AGD";
    private static final String GROUP_NAME_FOOD = "Zywnosc";
    private static final String GROUP_NAME_CLOTHES = "Ubrania";

    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void testGroupSave() {
        //Given
        Group group = new Group(GROUP_NAME_AGD);

        //When
        groupRepository.save(group);

        //Then
        Long id = group.getId();
        Optional<Group> groupById = groupRepository.findById(id);
        Assert.assertEquals("Drobne AGD", groupById.get().getName());

    }

    @Test
    public void testGroupUpdate() {
        //Given
        Group group = new Group(GROUP_NAME_AGD);

        //When
        groupRepository.save(group);
        group.setName(GROUP_NAME_CLOTHES);

        //Then
        Long id = group.getId();
        Optional<Group> groupById = groupRepository.findById(id);
        Assert.assertEquals("Ubrania", groupById.get().getName());

    }


    @Test
     public void testGroupDeleteOne() {
        //Given
        Group groupAgd = new Group(GROUP_NAME_AGD);
        Group groupFood = new Group(GROUP_NAME_FOOD);
        Group groupClothes= new Group(GROUP_NAME_CLOTHES);

        //When
        groupRepository.save(groupAgd);
        groupRepository.save(groupFood);
        groupRepository.save(groupClothes);
        Long recordCount = groupRepository.count();

        //Then
        groupRepository.delete(groupAgd);
        Assert.assertEquals(recordCount-1, groupRepository.count());

     }
}
