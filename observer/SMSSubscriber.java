package observer;

import factory.Product;

public class SMSSubscriber implements Subscriber {
    @Override
    public void update(Product product) {
        System.out.println("[SMS] Naujas produktas: " + product.display());
    }
}