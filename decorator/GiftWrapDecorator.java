package decorator;

public class GiftWrapDecorator extends OrderDecorator {
    private final double wrapCost;

    public GiftWrapDecorator(Order decoratedOrder, double wrapCost) {
        super(decoratedOrder);
        this.wrapCost = wrapCost;
    }

    @Override
    public double getCost() {
        return super.getCost() + wrapCost;
    }

    @Override
    public String getDescription() {
        return super.getDescription() +
                String.format("\n+ Gift Wrapping: %.2f€", wrapCost);
    }
}