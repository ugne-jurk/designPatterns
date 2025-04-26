package observer;

import factory.Product;

public class EmailSubscriber implements Subscriber {
    @Override
    public void update(Product product) {
        System.out.println("[EMAIL] Naujas produktas: " + product.display());
    }
}
