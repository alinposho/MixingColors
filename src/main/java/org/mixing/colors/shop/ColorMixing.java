package org.mixing.colors.shop;

import org.mixing.colors.exceptions.NoPossibleSolutionException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ColorMixing {

    private List<Customer> initialCustomers;
    private List<Customer> resultingCustomers;
    private List<Color> resultingColors;
    private FavoriteColorCollection favoriteColorCollection;
    private List<Customer> outlawCustomers;  //Because they have matte color preferences :)

    public ColorMixing(List<Customer> customers) {
        resultingColors = new ArrayList<>();
        initialCustomers = new ArrayList<>(customers);
        resultingCustomers = new ArrayList<>();
        favoriteColorCollection = FavoriteColorCollection.transform(customers);
        outlawCustomers = new ArrayList<>();
    }

    public List<Color> mix() throws NoPossibleSolutionException {
        while (!initialCustomers.isEmpty()) {
            Customer firstCustomer = initialCustomers.remove(0);
            addCustomerAndSimblingsToResult(firstCustomer);
        }

        if (outlawCustomers.isEmpty()) {
            return resultingColors;
        }

        addOutlawsToResult();

        return resultingColors;

    }

    private void addCustomerAndSimblingsToResult(Customer customer) {
        List<Color> glossyColors = customer.getGlossyFavoriteColors();
        if (glossyColors.isEmpty()) {
            outlawCustomers.add(customer);
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
        while (!outlawCustomers.isEmpty()) {
            Customer customer = outlawCustomers.remove(0);
            Color favoriteColor = customer.getFavoriteColors().get(0);
            if (containsSimilarGlossyColor(favoriteColor)) {
                replaceWith(favoriteColor);
                resultingCustomers.add(customer);
            } else {
                resultingCustomers.add(customer);
                addSiblingsToResult(favoriteColor);
                if (!resultingColors.contains(favoriteColor)) {
                    resultingColors.add(favoriteColor);
                }
            }
        }
    }

    private void addSiblingsToResult(Color favoriteColor) {
        List<Customer> customersWhoFavor = getCustomersWhoFavor(favoriteColor);
        resultingCustomers.addAll(customersWhoFavor);
        outlawCustomers.removeAll(customersWhoFavor);
    }

    private List<Customer> getCustomersWhoFavor(Color favoriteColor) {
        return favoriteColorCollection.getCustomersWhoFavor(Arrays.asList(favoriteColor));
    }

    private boolean containsSimilarGlossyColor(Color favoriteColor) {
        return getGlossyColorSimilarTo(favoriteColor) != null;
    }

    private void replaceWith(Color favoriteColor) throws NoPossibleSolutionException {
        Color similar = getGlossyColorSimilarTo(favoriteColor);
        for (Customer customer : getCustomersWhoFavor(similar)) {
            if (customer.getFavoriteColors().size() == 1) {
                throw new NoPossibleSolutionException("Color " + favoriteColor + " and color " + similar + " are conflicting options!");
            } else {
                customer.getFavoriteColors().remove(similar);
                if (customer.getGlossyFavoriteColors().isEmpty()) {
                    outlawCustomers.add(customer);
                    resultingCustomers.remove(customer);
                }// else this customer is OK, It has other glossy color options.
            }
        }
        resultingColors.remove(similar);
        resultingColors.add(favoriteColor);
        addSiblingsToResult(favoriteColor);
    }

    private Color getGlossyColorSimilarTo(Color favoriteColor) {
        for (Color color : resultingColors) {
            if (color.getId() == favoriteColor.getId() && color.getColorType() == ColorType.GLOSSY) {
                return color;
            }
        }
        return null;
    }

}
