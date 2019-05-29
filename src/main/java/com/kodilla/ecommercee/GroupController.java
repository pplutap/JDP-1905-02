package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/superShop")
public class GroupController {
    private static final ProductDto butter = new ProductDto(1L,"SuperButter", "Super Fat Butter.", 3.99);
    private static final ProductDto meal = new ProductDto(2L, "Mega Meal", "Epic meal moment.",8.99);
    private static final ProductDto socks = new ProductDto(3L, "Sport socks", "Most breathable fabric.",9.99);
    private static final ProductDto tshirt = new ProductDto(4L, "UV T-Shirt", "100% UV protection", 29.99);
    private static final GroupDto food = new GroupDto(1L, "Food", "Food of various types.", Arrays.asList(butter,meal));
    private static final GroupDto clothes = new GroupDto(2L, "Clothes", "Summer clothing", Arrays.asList(socks,tshirt));

    @RequestMapping(method = RequestMethod.GET, value = "getGroups")
    public List<GroupDto> getGroups(){
        return new ArrayList<>(Arrays.asList(food, clothes));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createGroup", consumes = APPLICATION_JSON_VALUE)
    public void createGroup(GroupDto groupDto){

    }

    @RequestMapping(method = RequestMethod.GET, value = "getGroup")
    public GroupDto getGroup(@RequestParam Long groupId) throws GroupNotFoundException {
        return food;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGroup", consumes = APPLICATION_JSON_VALUE)
    public GroupDto updateGroup(GroupDto groupDto){
        return clothes;
    }
}
