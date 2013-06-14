package org.mixing.colors;

import java.util.*;

public class MixingAlgorithm {

    private int numberOfCustomers;
    private int numberOfColors;

    public MixingAlgorithm(int numberOfCustomers, int numberOfColors) {
        this.numberOfCustomers = numberOfCustomers;
        this.numberOfColors = numberOfColors;
    }

    public List<Color> mix(List<FavoriteColor> favoriteColorMatte, List<FavoriteColor> favoriteColorGlossy) {
        Set<Customer> pickedCustomers = new HashSet<>();
        List<FavoriteColor> pickedColors = new ArrayList<>();

        for(FavoriteColor favoriteColor : favoriteColorGlossy){
            pickedCustomers.addAll(favoriteColor.getCustomers());
        }

        if(allCustomersWerePicked(pickedCustomers)) {
            List<Color> colors = extract(favoriteColorGlossy);
            if(numberOfColors == colors.size()) {
                return colors;
            }
            return appendStrayGlossyColors(colors);

        }

        return new ArrayList<>();
    }

    private List<Color> appendStrayGlossyColors(List<Color> pickedColors) {
        List<Color> result = new ArrayList<>(pickedColors);
        return result;
    }

    private boolean allCustomersWerePicked(Set<Customer> pickedCustomers) {
        return numberOfCustomers == pickedCustomers.size();
    }

    private List<Color> extract(List<FavoriteColor> favoriteColors) {
        List<Color> colors = new ArrayList<>();
        for(FavoriteColor favoriteColor : favoriteColors) {
            colors.add(favoriteColor.getColor());
        }
        return colors;
    }

    private boolean isMatte(FavoriteColor favoriteColor) {
        return favoriteColor.getColor().getColorType() == ColorType.MATTE;
    }
}
