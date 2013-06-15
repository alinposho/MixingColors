package org.mixing.colors.shop;

import org.mixing.colors.Color;
import org.mixing.colors.Customer;

import java.util.ArrayList;
import java.util.List;

class ColorMixing {

    private final List<Customer> customers;
    private List<Customer> initialCustomers;
    private List<Customer> resultingCustomers;
    private List<Color> resultingColors;
    private FavoriteColorCollection favoriteColorCollection;
    private List<Customer> outlaws;

    public ColorMixing(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Color> mix() {
        resetState();

        while (!initialCustomers.isEmpty()) {
            addCustomerAndSimblingsToResult();
        }

        return resultingColors;
    }

    private void resetState() {
        resultingColors = new ArrayList<>();
        initialCustomers = new ArrayList<>(customers);
        resultingCustomers = new ArrayList<>();
        favoriteColorCollection = FavoriteColorCollection.transform(customers);
        outlaws = new ArrayList<>();
    }

    private void addCustomerAndSimblingsToResult() {
        Customer firstCustomer = initialCustomers.remove(0);
        List<Color> glossyColors = firstCustomer.getGlossyFavoriteColors();
        if (glossyColors.isEmpty()) {
            outlaws.add(firstCustomer);
        } else {
            resultingColors.addAll(glossyColors);
            addSiblingsToResult(glossyColors);
        }

    }

    private void addSiblingsToResult(List<Color> favoriteColors) {
        List<Customer> siblings = favoriteColorCollection.getCustomersWhoFavor(favoriteColors);
        resultingCustomers.addAll(siblings);
        initialCustomers.removeAll(siblings);
    }

}
