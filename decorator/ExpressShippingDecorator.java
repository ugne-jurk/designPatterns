package decorator;

public class ExpressShippingDecorator extends OrderDecorator {
    private final double shippingCost;

    public ExpressShippingDecorator(Order decoratedOrder, double shippingCost) {
        super(decoratedOrder);
        this.shippingCost = shippingCost;
    }

    @Override
    public double getCost() {
        return super.getCost() + shippingCost;
    }

    @Override
    public String getDescription() {
        return super.getDescription() +
                String.format("\n+ Express Shipping: %.2f€", shippingCost);
    }
}