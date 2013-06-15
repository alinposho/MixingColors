package org.mixing.colors.parsing;

import org.junit.Test;
import org.mixing.colors.Color;
import org.mixing.colors.ColorType;
import org.mixing.colors.Customer;
import org.mixing.colors.shop.Shop;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.mixing.colors.FilePathUtils.getFilePathFrom;

public class ShopParserTest {

    @Test
    public void
    should_return_a_shop_with_one_color_and_one_customer() {
        int numberOfColors = 1;
        runTestFor(numberOfColors, "OneColorAndOneCustomer.txt");
    }

    @Test
    public void
    should_return_a_shop_with_two_colors_and_one_customer() {
        int numberOfColors = 2;
        runTestFor(numberOfColors, "TwoColorsAndOneCustomer.txt");
    }

    private void runTestFor(int noOfDeclaredColors, String fileName) {
        // Prepare
        Shop expected = createOneCustomerShop(noOfDeclaredColors);

        // Exercise
        Shop oneCustomerShop = ShopParser.parse(getFilePathFrom(fileName, this.getClass()));

        // Verify
        assertEquals(expected, oneCustomerShop);
    }

    private Shop createOneCustomerShop(int numberOfColors) {
        return new Shop(numberOfColors, Arrays.asList(new Customer(1, Arrays.asList(new Color(1, ColorType.MATTE)))));
    }

    @Test
    public void
    should_return_a_shop_with_one_color_and_two_customer() {
        // Prepare
        int numberOfColors = 1;
        Shop expected = createTwoCustomersShop(numberOfColors);

        // Exercise
        String fileName = "OneColorAndTwoCustomers.txt";
        Shop parsedShop = ShopParser.parse(getFilePathFrom(fileName, this.getClass()));

        // Verify
        assertEquals(expected, parsedShop);
    }

    private Shop createTwoCustomersShop(int numberOfColors) {
        List<Customer> customers = Arrays.asList(
                new Customer(1, Arrays.asList(new Color(1, ColorType.MATTE))),
                new Customer(2, Arrays.asList(new Color(1, ColorType.GLOSSY)))
        );
        return new Shop(numberOfColors, customers);
    }

    @Test
    public void
    should_return_a_shop_with_one_declared_color_but_two_used_colors() {
        // Prepare
        Color color1 = new Color(1, ColorType.MATTE);
        Color color2 = new Color(2, ColorType.GLOSSY);
        List<Customer> customers = Arrays.asList(
                new Customer(1, Arrays.asList(color1)),
                new Customer(2, Arrays.asList(color2))
        );
        int numberOfColors = 1;
        Shop expected = new Shop(numberOfColors, customers);

        assertNotSame(color1, color2);

        // Exercise
        String fileName = "OneDeclaredColorTwoUsed.txt";
        Shop parsedShop = ShopParser.parse(getFilePathFrom(fileName, this.getClass()));

        // Verify
        assertEquals(expected, parsedShop);
    }

    @Test
    public void
    should_parse_the_file_containing_the_first_example_in_the_requirements() {
        // Prepare
        List<Customer> customers = Arrays.asList(
                createCustomerWith(1, "1 M 3 G 5 G"),
                createCustomerWith(2, "2 G 3 M 4 G"),
                createCustomerWith(3, "5 M")
        );
        int numberOfColors = 5;
        Shop expected = new Shop(numberOfColors, customers);

        // Exercise
        String fileName = "FirstExampleInTheRequirements.txt";
        Shop parsedShop = ShopParser.parse(getFilePathFrom(fileName, this.getClass()));

        // Verify
        assertEquals(expected, parsedShop);
    }

    @Test
    public void
    should_parse_the_file_containing_the_third_example_in_the_requirements() {
        // Prepare
        List<Customer> customers = Arrays.asList(
                createCustomerWith(1, "2 M"),
                createCustomerWith(2, "5 G"),
                createCustomerWith(3, "1 G"),
                createCustomerWith(4, "5 G 1 G 4 M"),
                createCustomerWith(5, "3 G"),
                createCustomerWith(6, "5 G"),
                createCustomerWith(7, "3 G 5 G 1 G"),
                createCustomerWith(8, "3 G"),
                createCustomerWith(9, "2 M"),
                createCustomerWith(10, "5 G 1 G"),
                createCustomerWith(11, "2 M"),
                createCustomerWith(12, "5 G"),
                createCustomerWith(13, "4 M"),
                createCustomerWith(14, "5 G 4 M")
        );
        int numberOfColors = 5;
        Shop expected = new Shop(numberOfColors, customers);

        // Exercise
        String fileName = "ThirdExampleInTheRequirements.txt";
        Shop parsedShop = ShopParser.parse(getFilePathFrom(fileName, this.getClass()));

        // Verify
        assertEquals(expected, parsedShop);
    }

    private Customer createCustomerWith(int customerId, String favoriteColors) {
        return new Customer(customerId, ColorParser.parse(favoriteColors));
    }

}
