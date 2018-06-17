package com.kodilla.patterns2.facade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kodilla.patterns2.facade.api.ItemDto;
import com.kodilla.patterns2.facade.api.*;
import com.kodilla.patterns2.facade.api.OrderFacade;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopServiceTestSuite {

    @Autowired
    private OrderFacade orderFacade;

    @Test
    public void testOrderFacade() {
        OrderDto order = new OrderDto();
        order.addItem(new ItemDto(10L, 2));
        order.addItem(new ItemDto(216L, 1));
        order.addItem(new ItemDto(25L, 1));
        order.addItem(new ItemDto(18L, 3));

        try {
            orderFacade.processOrder(order, 1L);
        } catch (OrderProcessingException e) {
            System.out.println("@@@@@@@@@@@ There was an exception: " + e);
        }
    }
}
