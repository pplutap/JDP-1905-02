package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupMapper {

    public List<GroupDto> mapToGroupDtoList(final List<Group>groups){
        return groups.stream()
                .map(g->new GroupDto(g.getId(),g.getName()))
                .collect(Collectors.toList());
    }

    public GroupDto mapToGroupDto(final Group group){
        return new GroupDto(group.getId(),
                group.getName());
    }

    public Group mapToGroup(final GroupDto groupDto){
        return new Group(
                groupDto.getName());
    }

}
