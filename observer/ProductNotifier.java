package observer;

import factory.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductNotifier {
    private List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notify(Product product) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(product);
        }
    }
}