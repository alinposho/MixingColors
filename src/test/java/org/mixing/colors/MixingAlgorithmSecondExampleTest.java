package org.mixing.colors;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mixing.colors.MixingAlgoritmUtils.create;
import static org.mixing.colors.MixingAlgoritmUtils.createCustomers;

public class MixingAlgorithmSecondExampleTest {


    public static final int NUMBER_OF_CUSTOMERS = 2;

    @Test
    public void
    should_return_an_empty_list_since_the_two_customers_prefer_different_types_of_same_colors() {
        // Prepare
        MixingAlgorithm mixingAlgorithm = new MixingAlgorithm(NUMBER_OF_CUSTOMERS);

        // Exercise
        List<Color> result = mixingAlgorithm.mix(createFavoriteColorMatte(), createFavoriteColorGlossy());

        // Verify
        assertTrue(result.isEmpty());
    }

    private List<FavoriteColor> createFavoriteColorGlossy() {
        List<FavoriteColor> favoriteColors = new ArrayList<>();
        favoriteColors.add(create(1, ColorType.GLOSSY, createCustomers(1)));
        return favoriteColors;
    }

    private List<FavoriteColor> createFavoriteColorMatte() {
        List<FavoriteColor> glossyFavorites = new ArrayList<>();
        glossyFavorites.add(create(1, ColorType.MATTE, createCustomers(2)));
        return glossyFavorites;
    }

}
