package com.kodilla.ecommercee.controller;

import com.google.gson.Gson;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GroupController.class)
public class GroupControllerTest {

    private final static Group group1 = new Group("testGroup");
    private final static GroupDto groupDto1 = new GroupDto(1L,"testGroup");
    private static Gson gson = new Gson();
    private final static String jsonContent = gson.toJson(groupDto1);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroupService groupService;

    @MockBean
    private GroupMapper groupMapper;

    @Test
    public void getGroupsTest() throws Exception {
        mockMvc.perform(get("/superShop/getGroups")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getGroupAndCreateGroupTest() throws Exception {
        Mockito.when(groupService.getGroup(anyLong())).thenReturn(group1);
        Mockito.when(groupMapper.mapToGroupDto(ArgumentMatchers.any())).thenReturn(groupDto1);

        mockMvc.perform(get("/superShop/getGroup?groupId=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createGroupTest() throws Exception {
        Mockito.when(groupMapper.mapToGroupDto(ArgumentMatchers.any())).thenReturn(groupDto1);
        Mockito.when(groupService.saveGroup(ArgumentMatchers.any())).thenReturn(group1);

        mockMvc.perform(post("/superShop/createGroup")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void updateGroupTest() throws Exception{
        Mockito.when(groupMapper.mapToGroup(ArgumentMatchers.any())).thenReturn(group1);
        Mockito.when(groupService.saveGroup(ArgumentMatchers.any())).thenReturn(group1);
        Mockito.when(groupMapper.mapToGroupDto(ArgumentMatchers.any())).thenReturn(groupDto1);

        mockMvc.perform(MockMvcRequestBuilders.put("/superShop/updateGroup")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

}