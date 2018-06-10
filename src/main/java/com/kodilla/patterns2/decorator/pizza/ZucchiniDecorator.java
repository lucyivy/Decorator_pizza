package com.kodilla.patterns2.decorator.pizza;

public class ZucchiniDecorator extends AbstractPizzaDecorator {

    public ZucchiniDecorator(PizzaOrder order) {
        super(order);
    }

    @Override
    public double getCost() {
        return super.getCost() + PizzaComponents.getPriceList().get(PizzaComponents.ZUCCHINI);
    }

    @Override
    public String getSpecs() {
        return super.getSpecs() + ", " + PizzaComponents.ZUCCHINI;
    }
}
