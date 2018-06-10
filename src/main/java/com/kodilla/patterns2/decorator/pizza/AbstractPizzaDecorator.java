package com.kodilla.patterns2.decorator.pizza;

public abstract class AbstractPizzaDecorator implements PizzaOrder {
    private PizzaOrder pizzaOrder;

    protected AbstractPizzaDecorator(PizzaOrder order) {
        this.pizzaOrder = order;
    }

    @Override
    public double getCost() {
        return pizzaOrder.getCost();
    }

    @Override
    public String getSpecs() {
        return pizzaOrder.getSpecs();
    }

}
