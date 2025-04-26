package singleton;

import factory.Product;
import observer.ProductNotifier;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private static InventoryManager instance;
    private List<Product> products;
    private ProductNotifier notifier = new ProductNotifier();

    private InventoryManager() {
        products = new ArrayList<>();
    }

    public static synchronized InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("\n[Inventorius] Produktas pridėtas: " + product.display());
        notifier.notify(product);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void addSubscriber(observer.Subscriber subscriber) {
        notifier.subscribe(subscriber);
    }
}