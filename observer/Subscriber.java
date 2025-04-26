package observer;

import factory.Product;

public interface Subscriber {
    void update(Product product);
}
