package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void mapToOrderDtoList() {
        Order order1 = new Order();
        Order order2 = new Order();

        OrderDto orderDto1 = new OrderDto();
        OrderDto orderDto2 = new OrderDto();

        assertThat(orderDtoList, sameBeanAs(orderMapper.mapToOrderDtoList(orders)));
    }

    @Test
    public void mapToOrderDto() {
        assertThat(orderDto, sameBeanAs(orderMapper.mapToOrderDto(order)));
    }
}