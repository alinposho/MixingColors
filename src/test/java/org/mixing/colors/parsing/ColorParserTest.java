package org.mixing.colors.parsing;

import org.junit.Test;
import org.mixing.colors.Color;
import org.mixing.colors.ColorType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ColorParserTest {

    @Test
    public void
    should_return_a_list_of_one_favorite_matte_color() {

        List<Color> favoriteColors = ColorParser.parse("1 M");

        assertEquals(1, favoriteColors.size());
        assertEquals(new Color(1, ColorType.MATTE), favoriteColors.get(0));
    }

    @Test
    public void
    should_return_a_list_of_one_favorite_glossy_color() {

        List<Color> favoriteColors = ColorParser.parse("2 G");

        assertEquals(1, favoriteColors.size());
        assertEquals(new Color(2, ColorType.GLOSSY), favoriteColors.get(0));
    }

    @Test
    public void
    should_return_a_list_of_favorite_colors() {

        // Notice that we do not check for duplicate entries nor for duplicate matte colors
        List<Color> favoriteColors = ColorParser.parse("1 G 2 G 3 M 1 G 4 M");

        assertEquals(5, favoriteColors.size());
        assertIsExpected(favoriteColors);
    }

    private void assertIsExpected(List<Color> favoriteColors) {
        List<Color> expectedColors = new ArrayList<>();
        expectedColors.add(new Color(1, ColorType.GLOSSY));
        expectedColors.add(new Color(2, ColorType.GLOSSY));
        expectedColors.add(new Color(3, ColorType.MATTE));
        expectedColors.add(new Color(1, ColorType.GLOSSY));
        expectedColors.add(new Color(4, ColorType.MATTE));

        assertEquals(expectedColors, favoriteColors);
    }
}
