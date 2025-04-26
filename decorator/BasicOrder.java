package decorator;

import factory.Product;
import java.util.ArrayList;
import java.util.List;

public class BasicOrder implements Order {
    private final List<Product> products;

    public BasicOrder(List<Product> products) {
        this.products = new ArrayList<>(products);
    }

    @Override
    public double getCost() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    @Override
    public String getDescription() {
        StringBuilder description = new StringBuilder("Basic Order:\n");
        products.forEach(p -> description.append("- ").append(p.display()).append("\n"));
        description.append(String.format("Subtotal: %.2f€", getCost()));
        return description.toString();
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
}
