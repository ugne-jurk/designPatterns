package strategy;

public class BankTransferPayment implements PaymentStrategy {
    private String accountNumber;

    public BankTransferPayment(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("Mokama %.2f€ banko pavedimu į sąskaitą %s%n",
                amount, accountNumber);
    }
}