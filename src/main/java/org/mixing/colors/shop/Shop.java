package org.mixing.colors.shop;

import org.mixing.colors.Color;
import org.mixing.colors.ColorType;
import org.mixing.colors.Customer;
import org.mixing.colors.exceptions.NoPossibleSolutionException;

import java.util.ArrayList;
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

    public List<Color> mixColors() throws NoPossibleSolutionException {

        List<Color> colorMix = new ArrayList<>();

        colorMix = addCustomersToEndList(colorMix);
        colorMix = addColorsToTheListIfNecessary(colorMix);

        return colorMix;
    }

    private List<Color> addCustomersToEndList(List<Color> colorMix) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    // Running time O(n^2)
    List<Color> addColorsToTheListIfNecessary(List<Color> colorMix) {
        if (colorMix.size() == numberOfColors) {
            return colorMix;
        }

        for (int i = 0; i < numberOfColors; i++) {
            int colorId = i + 1;
            if (doesNotContainColorWith(colorId, colorMix)) {
                colorMix.add(new Color(colorId, ColorType.GLOSSY));
            }
        }

        return colorMix;
    }

    private boolean doesNotContainColorWith(int colorId, List<Color> colors) {
        for (Color color : colors) {
            if (color.getId() == colorId) {
                return false;
            }
        }

        return true;
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
