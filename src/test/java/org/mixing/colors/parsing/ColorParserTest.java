package org.mixing.colors.parsing;

import org.junit.Ignore;
import org.junit.Test;
import org.mixing.colors.Color;
import org.mixing.colors.ColorType;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ColorParserTest {

    @Test
    public void
    should_return_a_list_of_one_favorite_matte_color() {

        List<Color> favoriteColors = ColorParser.parse("1M");

        assertEquals(1, favoriteColors.size());
        assertEquals(new Color(1, ColorType.MATTE), favoriteColors.get(0));
    }

    @Test
    public void
    should_return_a_list_of_one_favorite_glossy_color() {

        List<Color> favoriteColors = ColorParser.parse("2G");

        assertEquals(1, favoriteColors.size());
        assertEquals(new Color(2, ColorType.GLOSSY), favoriteColors.get(0));
    }

    @Ignore("Not yet implemented")
    @Test
    public void
    should_return_a_list_of_favorite_colors() {

        // Notice that we do not check for duplicate entries nor for duplicate matte colors
        List<Color> favoriteColors = ColorParser.parse("1G 2G 3M 1G 4M");

        assertEquals(5, favoriteColors.size());
        assertIsExpected(favoriteColors);
    }

    private void assertIsExpected(List<Color> favoriteColors) {
        //To change body of created methods use File | Settings | File Templates.
    }
}
