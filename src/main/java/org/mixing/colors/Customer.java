package org.mixing.colors;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final int id;
    private final List<Color> favoriteColors;

    public Customer(int id, List<Color> favoriteColor) {
        this.id = id;
        this.favoriteColors = favoriteColor;
    }

    public int getId() {
        return id;
    }

    public List<Color> getFavoriteColors() {
        return favoriteColors;
    }

    public boolean hasGlossyColors() {
        for(Color color : favoriteColors) {
            if(color.getColorType() == ColorType.GLOSSY) {
                return true;
            }
        }
        return false;
    }

    public List<Color> getGlossyFavoriteColors() {
        List<Color> glossyColors = new ArrayList<>();
        for(Color color : favoriteColors) {
            if(color.getColorType() == ColorType.GLOSSY) {
                glossyColors.add(color);
            }
        }
        return glossyColors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        if (favoriteColors != null ? !favoriteColors.equals(customer.favoriteColors) : customer.favoriteColors != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (favoriteColors != null ? favoriteColors.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", favoriteColors=" + favoriteColors +
                '}';
    }

}
