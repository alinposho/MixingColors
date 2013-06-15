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

    @Test
    public void
    should_return_one_matte_color_in_the_output_no_conflicting_preferences() throws NoPossibleSolutionException {
        runTestForOneColorInTheShop("OneResultingColorMatte-NoConflictingPreferences.txt", "1 G 2 G 3 G 4 G 5 M");
    }

    @Test
    public void
    should_return_one_matte_color_in_the_output_with_conflicting_preferences() throws NoPossibleSolutionException {
        runTestForOneColorInTheShop("OneResultingColorMatte-WithConflictingPreferences.txt", "1 G 2 G 3 G 4 G 5 M");
    }

    @Test(expected = NoPossibleSolutionException.class)
    public void
    should_return_raise_an_exception_since_there_are_no_possible_solutions_one_color() throws NoPossibleSolutionException {
        runTestForOneColorInTheShop("NoPossibleSolutionOneCustomerDifferentOptions.txt", "1 G");
    }

    @Test(expected = NoPossibleSolutionException.class)
    public void
    should_return_raise_an_exception_since_there_are_no_possible_solutions_two_colors() throws NoPossibleSolutionException {
        runTestForOneColorInTheShop("NoPossibleSolutionTwoColors.txt", "1 G");
    }

    @Test
    public void
    should_return_all_colors_matte_although_we_have_glossy_options() throws NoPossibleSolutionException {
        runTestForOneColorInTheShop("SomeFavoritreColorsGlossyAllResultingColorsMatte.txt", "1 M 2 M 3 M");
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
