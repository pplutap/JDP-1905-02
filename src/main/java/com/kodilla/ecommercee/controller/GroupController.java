package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins =  "https://glacial-reef-77706.herokuapp.com")
@RestController
@RequestMapping("/superShop")
public class GroupController {

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private GroupService groupService;

    @GetMapping(path = "getGroups")
    public List<GroupDto> getGroups() {
        return groupMapper.mapToGroupDtoList(groupService.getAllGroups());
    }

    @PostMapping(path = "createGroup", consumes = APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto){
        groupService.saveGroup(groupMapper.mapToGroup(groupDto));
    }

    @GetMapping(path = "getGroup")
    public GroupDto getGroup(@RequestParam Long groupId){
        return groupMapper.mapToGroupDto(groupService.getGroup(groupId));
    }

    @PutMapping(path = "updateGroup", consumes = APPLICATION_JSON_VALUE)
    public GroupDto updateGroup(@RequestBody GroupDto groupDto){
        return groupMapper.mapToGroupDto(groupService.saveGroup(groupMapper.mapToGroup(groupDto)));
    }
}
