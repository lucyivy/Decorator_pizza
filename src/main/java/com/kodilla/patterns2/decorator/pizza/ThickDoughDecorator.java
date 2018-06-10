package com.kodilla.patterns2.decorator.pizza;

public class ThickDoughDecorator extends AbstractPizzaDecorator {

    public ThickDoughDecorator(PizzaOrder order) {
        super(order);
    }

    @Override
    public double getCost() {
        return super.getCost() + PizzaComponents.getPriceList().get(PizzaComponents.THICK_DOUGH);
    }

    @Override
    public String getSpecs() {
        return super.getSpecs() + ", " + PizzaComponents.THICK_DOUGH;
    }

}
