package org.mixing.colors.shop;

import org.mixing.colors.Color;
import org.mixing.colors.ColorType;
import org.mixing.colors.Customer;
import org.mixing.colors.exceptions.NoPossibleSolutionException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ColorMixing {

    private final List<Customer> customers;
    private List<Customer> initialCustomers;
    private List<Customer> resultingCustomers;
    private List<Color> resultingColors;
    private FavoriteColorCollection favoriteColorCollection;
    private List<Customer> oneFavoriteColorMatteCustomers;

    public ColorMixing(List<Customer> customers) {
        this.customers = customers;
        resultingColors = new ArrayList<>();
        initialCustomers = new ArrayList<>(customers);
        resultingCustomers = new ArrayList<>();
        favoriteColorCollection = FavoriteColorCollection.transform(customers);
        oneFavoriteColorMatteCustomers = new ArrayList<>();
    }

    public List<Color> mix() throws NoPossibleSolutionException {
        while (!initialCustomers.isEmpty()) {
            Customer firstCustomer = initialCustomers.remove(0);
            addCustomerAndSimblingsToResult(firstCustomer);
        }

        if (oneFavoriteColorMatteCustomers.isEmpty()) {
            return resultingColors;
        }

        addOutlawsToResult();

        return resultingColors;

    }

    private void addCustomerAndSimblingsToResult(Customer customer) {
        List<Color> glossyColors = customer.getGlossyFavoriteColors();
        if (glossyColors.isEmpty()) {
            oneFavoriteColorMatteCustomers.add(customer);
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

    /**
     * We are adding the customers who have only one preferred color and that color is matte.
     */
    private void addOutlawsToResult() throws NoPossibleSolutionException {
        while (!oneFavoriteColorMatteCustomers.isEmpty()) {
            Customer customer = oneFavoriteColorMatteCustomers.remove(0);
            Color favoriteColor = customer.getFavoriteColors().get(0);
            if (containsSimilarGlossyColor(favoriteColor)) {
                replaceWith(favoriteColor);
            } else {
                resultingCustomers.add(customer);
                addSiblingsToResult(favoriteColor);
                resultingColors.add(favoriteColor);
            }
        }
    }

    private void addSiblingsToResult(Color favoriteColor) {
        resultingCustomers.addAll(favoriteColorCollection.getCustomersWhoFavor(Arrays.asList(favoriteColor)));
    }

    private boolean containsSimilarGlossyColor(Color favoriteColor) {
        for (Color color : resultingColors) {
            if (color.getId() == favoriteColor.getId()) {
                assert color.getColorType() == ColorType.GLOSSY && favoriteColor.getColorType() == ColorType.MATTE;
                return true;
            }
        }
        return false;
    }

    private void replaceWith(Color favoriteColor) throws NoPossibleSolutionException {
    }

}
