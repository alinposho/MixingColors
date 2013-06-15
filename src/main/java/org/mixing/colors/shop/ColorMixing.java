package org.mixing.colors.shop;

import org.mixing.colors.exceptions.NoPossibleSolutionException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ColorMixing {

    private List<Customer> initialCustomers;
    private List<Color> resultingColors;
    private FavoriteColorCollection favoriteColorCollection;
    private List<Customer> outlawCustomers;  //Because they have matte color preferences :)

    public ColorMixing(List<Customer> customers) {
        resultingColors = new ArrayList<>();
        initialCustomers = new ArrayList<>(customers);
        favoriteColorCollection = FavoriteColorCollection.transform(customers);
        outlawCustomers = new ArrayList<>();
    }

    public List<Color> mix() throws NoPossibleSolutionException {
        while (!initialCustomers.isEmpty()) {                                     // // O(number of colors * number of customers)
            Customer firstCustomer = initialCustomers.remove(0);
            addCustomerAndSimblingsToResult(firstCustomer); // O(number of colors)
        }

        if (outlawCustomers.isEmpty()) {
            return resultingColors;
        }

        addOutlawsToResult();
        return resultingColors;

    }

    private void addCustomerAndSimblingsToResult(Customer customer) {   //O(number of colors)
        List<Color> glossyColors = customer.getGlossyFavoriteColors(); // O(number of colors)
        if (glossyColors.isEmpty()) {
            outlawCustomers.add(customer);
        } else {
            resultingColors.addAll(glossyColors);
            addSiblingsToResult(glossyColors);    // O(number of colors)
        }
    }

    private void addSiblingsToResult(List<Color> favoriteColors) {
        List<Customer> siblings = favoriteColorCollection.getCustomersWhoFavor(favoriteColors); // O(number of colors)
        initialCustomers.removeAll(siblings);
    }

    private void addOutlawsToResult() throws NoPossibleSolutionException {  // O(number of colors * number of customers ^ 2)
        while (!outlawCustomers.isEmpty()) {
            Customer customer = outlawCustomers.remove(0);
            Color favoriteColor = customer.getFavoriteColors().get(0);
            if (containsSimilarGlossyColor(favoriteColor)) {
                replaceWith(favoriteColor);          // O(number of colors * number of customers)
            } else {
                addSiblingsToResult(favoriteColor);  // O(number of customers)
                if (!resultingColors.contains(favoriteColor)) {
                    resultingColors.add(favoriteColor);
                }
            }
        }
    }

    private void addSiblingsToResult(Color favoriteColor) { // O(number of customers)
        List<Customer> customersWhoFavor = getCustomersWhoFavor(favoriteColor);
        outlawCustomers.removeAll(customersWhoFavor); // O(number of customers)
    }

    private List<Customer> getCustomersWhoFavor(Color favoriteColor) { // O(1)
        return favoriteColorCollection.getCustomersWhoFavor(Arrays.asList(favoriteColor));
    }

    private boolean containsSimilarGlossyColor(Color favoriteColor) {
        return getGlossyColorSimilarTo(favoriteColor) != null;
    }

    private void replaceWith(Color favoriteColor) throws NoPossibleSolutionException {       // O(number of colors * number of customers)
        Color similar = getGlossyColorSimilarTo(favoriteColor);
        for (Customer customer : getCustomersWhoFavor(similar)) { // // O(number of customers)
            if (noSolutionPossible(customer)) {
                throw new NoPossibleSolutionException("Color " + favoriteColor + " and color " + similar + " are conflicting options!");
            } else {
                customer.getFavoriteColors().remove(similar);
                if (customer.getGlossyFavoriteColors().isEmpty()) { // O(number of colors)
                    outlawCustomers.add(customer);
                }// else this customer is OK, It has other glossy color options.
            }
        }

        resultingColors.remove(similar);
        resultingColors.add(favoriteColor);
        addSiblingsToResult(favoriteColor);
    }

    private boolean noSolutionPossible(Customer customer) {
        return customer.getFavoriteColors().size() == 1;
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
