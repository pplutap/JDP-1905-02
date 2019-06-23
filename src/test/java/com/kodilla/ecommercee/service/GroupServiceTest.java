package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static org.hamcrest.MatcherAssert.assertThat;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupServiceTest {
    @Autowired
    private GroupService groupService;

    @Autowired
    GroupRepository groupRepository;

    @Test
    public void getAllGroupsAndSave()  {
        //Given
        Group group1 = new Group("group1");
        Group group2 = new Group("group2");

        //When
        groupService.saveGroup(group1);
        groupService.saveGroup(group2);
        List<Group> allGroups = groupService.getAllGroups();

        //Then
        assertThat(group1, sameBeanAs(allGroups.get(allGroups.size()-2)));
        assertThat(group2, sameBeanAs(allGroups.get(allGroups.size()-1)));


        //Clean Up
        groupService.deleteGroup(group1.getId());
        groupService.deleteGroup(group2.getId());
    }

    @Test
    public void getGroup() {
        //Given
        Group group1 = new Group("test group");
        groupService.saveGroup(group1);

        //When
        Group foundGroup = groupService.getGroup(group1.getId());

        //Then
        assertThat(group1, sameBeanAs(foundGroup));

        //Clean Up
        groupService.deleteGroup(foundGroup.getId());
    }

    @Test
    public void deleteGroup() {
        //Given
        Group group1 = new Group("GroupX");
        groupService.saveGroup(group1);
        Group foundGroup = groupService.getGroup(group1.getId());
        long groupCounterBeforeDeletion = groupRepository.count();

        //When
        groupService.deleteGroup(foundGroup.getId());
        long groupCounter = groupRepository.count();

        //Then
        Assert.assertEquals(groupCounterBeforeDeletion - 1, groupCounter);
    }
}


