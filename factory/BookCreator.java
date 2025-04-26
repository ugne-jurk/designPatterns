package factory;


public class BookCreator extends Creator {
    @Override
    public Product createProduct() {
        System.out.println("\n=== Naujos knygos kūrimas ===");

        scanner.nextLine(); // Clear buffer if needed
        System.out.print("Įveskite pavadinimą: ");
        String title = scanner.nextLine();

        System.out.print("Įveskite autorių: ");
        String author = scanner.nextLine();

        System.out.print("Įveskite kainą: ");
        double price = getDoubleInput();

        // Čia naudojamas "new" raktažodis tiesiogiai kuriant konkretų produktą
        return new Book(title, author, price);
    }
}
