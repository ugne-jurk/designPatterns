import factory.*;
import singleton.*;
import observer.*;
import decorator.*;
import strategy.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicializuojame singletoną
        InventoryManager inventory = InventoryManager.getInstance();

        // Užregistruojame observerius
        inventory.addSubscriber(new EmailSubscriber());
        inventory.addSubscriber(new SMSSubscriber());


        System.out.println("=== INTERNETINĖS PARDUOTUVĖS SISTEMA ===");

        char addMore;
        do {
            System.out.println("\nPasirinkite produkto tipą:");
            System.out.println("1. Knyga");
            System.out.println("2. Elektronika");
            System.out.print("Jūsų pasirinkimas: ");

            int productType = getIntInput(scanner);
            scanner.nextLine(); // Clear buffer

            Creator creator;
            switch (productType) {
                case 1:
                    creator = new BookCreator();
                    break;
                case 2:
                    creator = new ElectronicsCreator();
                    break;
                default:
                    System.out.println("Neteisingas pasirinkimas, pridedama knyga pagal nutylėjimą");
                    creator = new BookCreator();
                    break;
            }

            Product product = creator.createProduct();
            inventory.addProduct(product);

            System.out.print("\nAr norite pridėti dar vieną produktą? (t/n): ");
            addMore = scanner.nextLine().charAt(0);
        } while (Character.toLowerCase(addMore) == 't');;

        // 2. Užsakymo formavimas
        System.out.println("\n2. Užsakymo formavimas:");
        List<Product> products = inventory.getProducts();
        if (products.isEmpty()) {
            System.out.println("Inventorius tuščias - užsakymas negalimas");
            return;
        }

        System.out.println("Pasirinkite produktus užsakymui (įveskite numerius, atskirtus tarpais):");
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d. %s%n", i+1, products.get(i).display());
        }

        System.out.print("Jūsų pasirinkimas: ");
        String[] selections = scanner.nextLine().split(" ");
        List<Product> selectedProducts = new ArrayList<>();

        for (String s : selections) {
            try {
                int index = Integer.parseInt(s) - 1;
                if (index >= 0 && index < products.size()) {
                    selectedProducts.add(products.get(index));
                }
            } catch (NumberFormatException e) {
                // Ignoruoti netinkamus įvedimus
            }
        }

        if (selectedProducts.isEmpty()) {
            System.out.println("Nepasirinkote jokių produktų");
            return;
        }

        Order order = new BasicOrder(selectedProducts);

        // Papildomų paslaugų pasirinkimas
        System.out.println("\nPasirinkite papildomas paslaugas:");
        System.out.println("1. Dovanų pakavimas (+5.99€)");
        System.out.println("2. Greitas pristatymas (+9.99€)");
        System.out.println("0. Baigti pasirinkimą");

        int choice;
        do {
            System.out.print("Jūsų pasirinkimas: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    order = new GiftWrapDecorator(order, 5.99);
                    System.out.println("Dovanų pakavimas pridėtas");
                    break;
                case 2:
                    order = new ExpressShippingDecorator(order, 9.99);
                    System.out.println("Greitas pristatymas pridėtas");
                    break;
            }
        } while (choice != 0);

        // Užsakymo informacija
        System.out.println("\n=== JŪSŲ UŽSAKYMAS ===");
        System.out.println(order.getDescription());
        System.out.printf("\nGalutinė suma: %.2f€%n", order.getCost());

        // Mokėjimo būdo pasirinkimas
        System.out.println("\n3. Mokėjimo būdo pasirinkimas:");
        System.out.println("1. Kreditinė kortelė");
        System.out.println("2. Banko pavedimas");
        System.out.print("Jūsų pasirinkimas: ");
        int paymentChoice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        PaymentProcessor paymentProcessor = new PaymentProcessor();

        switch (paymentChoice) {
            case 1:
                System.out.print("Įveskite kortelės numerį: ");
                String cardNumber = scanner.nextLine();
                System.out.print("Įveskite savininko vardą: ");
                String name = scanner.nextLine();
                paymentProcessor.setPaymentStrategy(new CreditCardPayment(cardNumber, name));
                break;
            case 2:
                System.out.print("Įveskite sąskaitos numerį: ");
                String accountNumber = scanner.nextLine();
                paymentProcessor.setPaymentStrategy(new BankTransferPayment(accountNumber));
                break;
            default:
                System.out.println("Neteisingas pasirinkimas");
                return;
        }

        // Mokėjimo vykdymas
        System.out.println("\n=== MOKĖJIMAS ===");
        paymentProcessor.processPayment(order.getCost());

        scanner.close();
        System.out.println("\nAčiū už pirkimą!");
    }
}
