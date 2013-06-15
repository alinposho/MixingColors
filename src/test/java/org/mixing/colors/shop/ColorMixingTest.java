package org.mixing.colors.shop;

import org.junit.Test;
import org.mixing.colors.Color;
import org.mixing.colors.exceptions.NoPossibleSolutionException;
import org.mixing.colors.parsing.ColorParser;
import org.mixing.colors.parsing.ShopParser;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mixing.colors.FilePathUtils.getFilePathFrom;

public class ColorMixingTest {

    @Test
    public void
     should_return_the_only_color_in_the_shop_with_one_customer() throws NoPossibleSolutionException {
    runTestForOneColorInTheShop("OneColorAndOneCustomer.txt", "1 G");
    }

    @Test
    public void
    should_return_the_only_color_in_the_shop_with_two_customers() throws NoPossibleSolutionException {
        runTestForOneColorInTheShop("OneColorAndTwoCustomers.txt", "1 G");
    }

    @Test
    public void
    should_return_all_the_colors_glossy_and_complete_missing_colors() throws NoPossibleSolutionException {
        runTestForOneColorInTheShop("AllFavoriteColorsGlossy.txt", "1 G 2 G 3 G 4 G 5 G");
    }

    @Test
    public void
    should_return_all_the_colors_glossy_although_some_favorites_are_matte() throws NoPossibleSolutionException {
        runTestForOneColorInTheShop("SomeFavoriteColorsMatteButResultAllGlossy.txt", "1 G 2 G 3 G 4 G 5 G");
    }

    private void runTestForOneColorInTheShop(String fileName, String expectedColorsEncoded) throws NoPossibleSolutionException {
        // Prepare
        List<Color> expectedResult = ColorParser.parse(expectedColorsEncoded);

        // Exercise
        Shop oneCustomerShop = ShopParser.parse(getFilePathFrom(fileName, this.getClass()));

        // Verify
        assertEquals(expectedResult, oneCustomerShop.mixColors());
    }
}
