package org.mixing.colors.shop;

import org.mixing.colors.Customer;
import org.mixing.colors.FavoriteColor;

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
}
