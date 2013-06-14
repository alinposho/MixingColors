package org.mixing.colors;

import java.util.List;

public class FavoriteColor {

    private final Color color;
    private final List<Customer> customers;

    public FavoriteColor(Color color, List<Customer> customers) {
        this.color = color;
        this.customers = customers;
    }

    public Color getColor() {
        return color;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FavoriteColor that = (FavoriteColor) o;

        if (color != null ? !color.equals(that.color) : that.color != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return color != null ? color.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "FavoriteColor{" +
                "color=" + color +
                ", customers=" + customers +
                '}';
    }
}
