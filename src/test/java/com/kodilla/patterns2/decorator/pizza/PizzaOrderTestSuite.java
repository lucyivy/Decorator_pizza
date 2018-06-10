package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {
    @Test
    public void testBasicPizzaOrder() {
        //Given
        PizzaOrder order = new BasicPizzaOrder();

        //When
        double cost = order.getCost();

        //Then
        assertEquals(15, cost, 0.001);
    }

    @Test
    public void testFancyPizzaOrder() {
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        order = new BaconDecorator(order);
        order = new PepperDecorator(order);
        order = new ZucchiniDecorator(order);
        order = new ThickDoughDecorator(order);


        //When
        double cost = order.getCost();
        String specs = order.getSpecs();

        //Then
        assertEquals(27.70, cost, 0.001);
        assertEquals("Pizza: cheese, bacon, pepper, zucchini, extra thick dough", specs);
    }

}
