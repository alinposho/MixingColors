package org.mixing.colors;

import java.util.ArrayList;
import java.util.List;

public class MixingAlgoritmUtils {


    public static List<Customer> createCustomers(int... customerNumbers) {
        List<Customer> customers = new ArrayList<>();
        for (int customerNumber : customerNumbers) {
            customers.add(new Customer(customerNumber));
        }
        return customers;
    }

    public static FavoriteColor create(int colorNumber, ColorType colorType, List<Customer> customersThatLikeColor) {
        Color color = new Color(colorNumber, colorType);
        return new FavoriteColor(color, customersThatLikeColor);
    }

    public static List<Color> createColorList(ColorType... colorProperties) {
        List<Color> colors = new ArrayList<Color>();
        for (int i = 0; i < colorProperties.length; i++) {
            Color color = new Color(i + 1, colorProperties[i]);
            colors.add(color);
        }
        return colors;
    }
}
