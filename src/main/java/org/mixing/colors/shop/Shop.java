package org.mixing.colors.shop;

import org.mixing.colors.Customer;

import java.util.List;

public class Shop {

    private final int numberOfColors;
    private final List<Customer> customers;

    public Shop(int numberOfColors, List<Customer> customers) {
        this.numberOfColors = numberOfColors;
        this.customers = customers;
    }

    public int getNumberOfColors() {
        return numberOfColors;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;

        if (numberOfColors != shop.numberOfColors) return false;
        if (customers != null ? !customers.equals(shop.customers) : shop.customers != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numberOfColors;
        result = 31 * result + (customers != null ? customers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "numberOfColors=" + numberOfColors +
                ", customers=" + customers +
                '}';
    }
}
