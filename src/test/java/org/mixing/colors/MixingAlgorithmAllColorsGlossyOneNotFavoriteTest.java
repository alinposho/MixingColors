package org.mixing.colors;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mixing.colors.MixingAlgoritmUtils.*;

public class MixingAlgorithmAllColorsGlossyOneNotFavoriteTest {

    public static final int NUMBER_OF_CUSTOMERS = 6;
    public static final int NUMBER_OF_COLORS = 4;

    @Ignore("Not yet implemented")
    @Test
    public void
    should_return_all_the_colors_glossy_including_the_one_that_is_not_favorite() {
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

        glossyFavorites.add(create(2, ColorType.GLOSSY, createCustomers(2, 4, 6)));
        glossyFavorites.add(create(3, ColorType.GLOSSY, createCustomers(1, 2)));
        glossyFavorites.add(create(4, ColorType.GLOSSY, createCustomers(3, 6, 5)));

        return glossyFavorites;
    }

    private List<FavoriteColor> createFavoriteColorMatte() {
        return Collections.emptyList();
    }

}
