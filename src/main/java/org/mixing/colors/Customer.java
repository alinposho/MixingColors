package org.mixing.colors;

import java.util.List;

public class Customer {

    private final int id;
    private final List<Color> favoriteColor;

    public Customer(int id, List<Color> favoriteColor) {
        this.id = id;
        this.favoriteColor = favoriteColor;
    }

    public int getId() {
        return id;
    }

    public List<Color> getFavoriteColor() {
        return favoriteColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != customer.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                '}';
    }
}
