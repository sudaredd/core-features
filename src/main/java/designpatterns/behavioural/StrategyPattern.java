package designpatterns.behavioural;

import java.util.ArrayList;
import java.util.List;

interface BillingStrategy {
    double getPrice(double price);

    static BillingStrategy regularBilling() {
        return p -> p;
    }

    static BillingStrategy happyHourBilling() {
        return p -> p / 2;
    }
}

class CustomerBill {
    private final List<Double> drinks = new ArrayList<>();
    private BillingStrategy strategy;

    public CustomerBill(BillingStrategy strategy) {
        this.strategy = strategy;
    }
    public void add(int qty, double price) {
        drinks.add(qty * strategy.getPrice(price));
    }

    // Payment of bill
    public void print() {
        double sum = this.drinks.stream().mapToDouble(v -> v).sum();
        System.out.println("Total due: " + sum);
        this.drinks.clear();
    }
    // Set Strategy
    public void setStrategy(BillingStrategy strategy) {
        this.strategy = strategy;
    }
}

public class StrategyPattern {

    public static void main(String[] args) {
        BillingStrategy regularBillingStrategy = BillingStrategy.regularBilling();
        BillingStrategy happyHourStrategy = BillingStrategy.happyHourBilling();

        CustomerBill firstCustomer = new CustomerBill(regularBillingStrategy);
        firstCustomer.add(10, 1.5);
        firstCustomer.setStrategy(happyHourStrategy);
        firstCustomer.add(100, 2);

        // New Customer
        CustomerBill secondCustomer = new CustomerBill(happyHourStrategy);
        secondCustomer.add(80, 1);
        // The Customer pays
        firstCustomer.print();

        // End Happy Hour
        secondCustomer.setStrategy(regularBillingStrategy);
        secondCustomer.add(130, 2);
        secondCustomer.add(250, 1);
        secondCustomer.print();

    }
}
