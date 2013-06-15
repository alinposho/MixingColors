package org.mixing.colors.shop;

import org.mixing.colors.Color;
import org.mixing.colors.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavoriteColorCollection {

    private final Map<Color, List<Customer>> favoriteColor;

    public FavoriteColorCollection(Map<Color, List<Customer>> favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public List<Customer> getCustomersWhoFavor(List<Color> colors) {
        List<Customer> result = new ArrayList<>();
        for (Color color : colors) {
            result.addAll(favoriteColor.get(color));
        }
        return result;
    }

    public static FavoriteColorCollection transform(List<Customer> customers) {

        Map<Color, List<Customer>> favoriteColorMap = new HashMap<>();
        for (Customer customer : customers) {
            for (Color favoriteColor : customer.getFavoriteColors()) {
                List<Customer> associatedCustomers = favoriteColorMap.get(favoriteColor);
                if (associatedCustomers == null) {
                    associatedCustomers = new ArrayList<>();
                    favoriteColorMap.put(favoriteColor, associatedCustomers);
                }
                associatedCustomers.add(customer);
            }
        }

        return new FavoriteColorCollection(favoriteColorMap);
    }
}
