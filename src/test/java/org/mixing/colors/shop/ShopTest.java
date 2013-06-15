package org.mixing.colors.shop;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopTest {

    private static final int NUMBER_OF_DUMMY_COLORS = 5;

    @Test
    public void
    should_not_add_elements_to_the_list() {
        // Prepare
        int numberOfColors = NUMBER_OF_DUMMY_COLORS;
        Shop shop = new Shop(numberOfColors, Collections.<Customer>emptyList());

        List<Color> colorMix = createDummyColorMix(NUMBER_OF_DUMMY_COLORS);
        int initialNumberOfColors = colorMix.size();

        // Exercise
        List<Color> result = shop.addColorsToTheListIfNecessary(colorMix);

        // Verify
        assertEquals(initialNumberOfColors, result.size());
    }

    @Test
    public void
    should_add_one_color_to_the_input_list() {
        int numberOfColors = NUMBER_OF_DUMMY_COLORS + 1;
        runTestThatAddsColorsToTheInputListFor(numberOfColors);
    }

    @Test
    public void
    should_add_three_colors_to_the_input_list() {
        int numberOfColors = NUMBER_OF_DUMMY_COLORS + 3;
        runTestThatAddsColorsToTheInputListFor(numberOfColors);
    }

    private void runTestThatAddsColorsToTheInputListFor(int numberOfColors) {
        // Prepare
        Shop shop = new Shop(numberOfColors, Collections.<Customer>emptyList());
        List<Color> colorMix = createDummyColorMix(NUMBER_OF_DUMMY_COLORS);

        // Exercise
        List<Color> result = shop.addColorsToTheListIfNecessary(colorMix);

        // Verify
        assertEquals(numberOfColors, result.size());
    }


    private List<Color> createDummyColorMix(int numberOfDummyColors) {
        List<Color> dummyColors = new ArrayList<>();
        for (int i = 0; i < numberOfDummyColors; i++) {
            dummyColors.add(new Color(i + 1, ColorType.MATTE));
        }

        return dummyColors;
    }

}
