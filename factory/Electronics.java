package factory;

public class Electronics implements Product {
    private String name;
    private String brand;
    private double price;

    public Electronics(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String display() {
        return String.format("Elektronika: %s, gamintojas: %s, kaina: %.2f€", name, brand, price);
    }

    @Override
    public double getPrice() {
        return price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }
}