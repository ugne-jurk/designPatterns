package factory;

import java.util.Scanner;

public abstract class Creator {
    protected Scanner scanner = new Scanner(System.in);


    public abstract Product createProduct();

    protected int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Įveskite skaičių!");
            scanner.next(); // clear invalid input
        }
        return scanner.nextInt();
    }

    protected double getDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Įveskite skaičių su kableliu!");
            scanner.next(); // clear invalid input
        }
        return scanner.nextDouble();
    }
}