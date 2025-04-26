package factory;

public class Book implements Product {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public String display() {
        return String.format("Knyga: %s, autorius: %s, kaina: %.2f€", title, author, price);
    }

    @Override
    public double getPrice() {
        return price;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}