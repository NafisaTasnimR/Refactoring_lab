package edu.iutcs.cr.persons;

import java.util.Scanner;

/**
 * @author Raian Rahman
 * @since 4/18/2024
 */
public class Buyer extends Person {

    private String paymentMethod;

    public Buyer() {
        super();
        setPaymentMethod();
    }

    public Buyer(String id) {
        super(id);
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new payment method:");
        this.paymentMethod = scanner.nextLine();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", paymentMethod='" + paymentMethod + '\'';
    }
}
