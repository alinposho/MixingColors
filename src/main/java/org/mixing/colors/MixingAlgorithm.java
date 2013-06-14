package org.mixing.colors;

import java.util.*;

public class MixingAlgorithm {

    private int numberOfCustomers;
    private int numberOfColors;

    public MixingAlgorithm(int numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }

    public List<Color> mix(List<FavoriteColor> favoriteColorMatte, List<FavoriteColor> favoriteColorGlossy) {
        Set<Customer> pickedCustomers = new HashSet<>();
        List<FavoriteColor> pickedColors = new ArrayList<>();

        for(FavoriteColor favoriteColor : favoriteColorGlossy){
            pickedCustomers.addAll(favoriteColor.getCustomers());
        }
        if(numberOfCustomers == pickedCustomers. size()) {
            return extract(favoriteColorGlossy);
        }

        return new ArrayList<>();
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
