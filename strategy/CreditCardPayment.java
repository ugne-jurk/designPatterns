package strategy;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("Mokama %.2f€ su kreditine kortele (***%s), savininkas: %s%n",
                amount, cardNumber.substring(cardNumber.length() - 4), cardHolder);
    }
}