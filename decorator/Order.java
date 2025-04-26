package decorator;

import factory.Product;
import java.util.List;

public interface Order {
    double getCost();
    String getDescription();
    List<Product> getProducts();
}