package factory;

package factory;

public class ElectronicsCreator extends Creator {
    @Override
    public Product createProduct() {
        System.out.println("\n=== Naujos elektronikos kūrimas ===");

        scanner.nextLine(); // Clear buffer if needed
        System.out.print("Įveskite pavadinimą: ");
        String name = scanner.nextLine();

        System.out.print("Įveskite gamintoją: ");
        String brand = scanner.nextLine();

        System.out.print("Įveskite kainą: ");
        double price = getDoubleInput();

        // Čia naudojamas "new" raktažodis tiesiogiai kuriant konkretų produktą
        return new Electronics(name, brand, price);
    }
}