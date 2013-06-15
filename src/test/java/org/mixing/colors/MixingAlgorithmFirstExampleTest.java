package org.mixing.colors;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class MixingAlgorithmFirstExampleTest {

    public static final int NUMBER_OF_CUSTOMERS = 1;
    public static final int NUMBER_OF_COLORS = 5;

    @Ignore("Not yet implemented")
    @Test
    public void
    should_return_all_the_colors_glossy_except_for_the_first() {
        // Prepare
        MixingAlgorithm mixingAlgorithm = new MixingAlgorithm(NUMBER_OF_CUSTOMERS, NUMBER_OF_COLORS);

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

        glossyFavorites.add(create(1, ColorType.GLOSSY, Arrays.asList(new Customer(2, Collections.<Color>emptyList()))));
        glossyFavorites.add(create(3, ColorType.GLOSSY, Arrays.asList(new Customer(1, Collections.<Color>emptyList()))));
        glossyFavorites.add(create(4, ColorType.GLOSSY, Arrays.asList(new Customer(2, Collections.<Color>emptyList()))));
        glossyFavorites.add(create(5, ColorType.GLOSSY, Arrays.asList(new Customer(1, Collections.<Color>emptyList()))));

        return glossyFavorites;
    }

    private List<FavoriteColor> createFavoriteColorMatte() {
        List<FavoriteColor> favoriteColors = new ArrayList<>();

        favoriteColors.add(create(1, ColorType.MATTE, Arrays.asList(new Customer(1, Collections.<Color>emptyList()))));
        favoriteColors.add(create(3, ColorType.MATTE, Arrays.asList(new Customer(2, Collections.<Color>emptyList()))));
        favoriteColors.add(create(5, ColorType.MATTE, Arrays.asList(new Customer(3, Collections.<Color>emptyList()))));

        return favoriteColors;
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
