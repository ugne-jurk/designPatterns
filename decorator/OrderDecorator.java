package decorator;

import java.util.List;
import factory.Product;

public abstract class OrderDecorator implements Order {
    protected final Order decoratedOrder;

    protected OrderDecorator(Order decoratedOrder) {
        this.decoratedOrder = decoratedOrder;
    }

    @Override
    public double getCost() {
        return decoratedOrder.getCost();
    }

    @Override
    public String getDescription() {
        return decoratedOrder.getDescription();
    }

    @Override
    public List<Product> getProducts() {
        return decoratedOrder.getProducts();
    }
}