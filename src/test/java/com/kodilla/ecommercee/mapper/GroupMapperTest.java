package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest

public class GroupMapperTest {

    @Autowired
    private GroupMapper groupMapper;

    private static final Group group1 = new Group("group1");
    private static final Group group2 = new Group("group2");

    private static final GroupDto groupDto1 = new GroupDto("group1");
    private static final GroupDto groupDto2 = new GroupDto("group2");

    private static final List<Group> groups = new ArrayList<>(Arrays.asList(group1, group2));
    private static final List<GroupDto> groupDtos = new ArrayList<>(Arrays.asList(groupDto1, groupDto2));

    @Test
    public void mapToGroupDtoList() {
        assertThat(groupDtos, sameBeanAs(groupMapper.mapToGroupDtoList(groups)));
    }

    @Test
    public void mapToGroupDto() {
        assertThat(groupDto1 ,sameBeanAs(groupMapper.mapToGroupDto(group1)));
    }

    @Test
    public void mapToGroup() {
        assertThat(group2, sameBeanAs(groupMapper.mapToGroup(groupDto2)));
    }

}


