package org.mixing.colors;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class MixingAlgorithmTestAllColorsGlossy {

    @Test
    public void
    should_return_all_the_colors_glossy() {
        // Prepare
        MixingAlgorithm mixingAlgorithm = new MixingAlgorithm(6);

        // Exercise
        List<Color> result = mixingAlgorithm.mix(createFavoriteColorMatte(), createFavoriteColorGlossy());

        // Verify
        assertNotNull(result);
        assertEquals(createColorList(ColorType.GLOSSY,
                                     ColorType.GLOSSY,
                                     ColorType.GLOSSY,
                                     ColorType.GLOSSY), result);
    }

    private List<FavoriteColor> createFavoriteColorGlossy() {
        List<FavoriteColor> glossyFavorites = new ArrayList<>();

        glossyFavorites.add(create(1, ColorType.GLOSSY, createCustomers(1, 3, 5)));
        glossyFavorites.add(create(2, ColorType.GLOSSY, createCustomers(2, 4, 6)));
        glossyFavorites.add(create(3, ColorType.GLOSSY, createCustomers(1, 2)));
        glossyFavorites.add(create(4, ColorType.GLOSSY, createCustomers(3, 6, 5)));

        return glossyFavorites;
    }

    private List<Customer> createCustomers(int... customerNumbers) {
        List<Customer> customers = new ArrayList<>();
        for (int customerNumber: customerNumbers) {
            customers.add(new Customer(customerNumber));
        }
        return customers;
    }

    private List<FavoriteColor> createFavoriteColorMatte() {
        return Collections.emptyList();
    }

    private FavoriteColor create(int colorNumber, ColorType colorType, List<Customer> customersThatLikeColor) {
        Color color = new Color(colorNumber, colorType);
        return new FavoriteColor(color, customersThatLikeColor);
    }

    private List<Color> createColorList(ColorType... colorProperties) {
        List<Color> colors = new ArrayList<Color>();
        for (int i = 0; i < colorProperties.length; i++) {
            Color color = new Color(i + 1, colorProperties[i]);
            colors.add(color);
        }
        return colors;
    }


}
