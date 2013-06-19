package org.mixing.colors.shop.stress.testing;

import org.junit.Ignore;
import org.junit.Test;
import org.mixing.colors.exceptions.NoPossibleSolutionException;
import org.mixing.colors.parsing.ColorParser;
import org.mixing.colors.parsing.ShopParser;
import org.mixing.colors.shop.Color;
import org.mixing.colors.shop.Shop;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mixing.colors.FilePathUtils.getFilePathFrom;

public class ColorMixingStressTest {

    @Test
    public void
    should_process_1000_customers() throws NoPossibleSolutionException {
        runTestForOneColorInTheShop("1000Customers.txt", "1 G 2 M 3 G 4 M 5 G");
    }

    @Test
    public void
    should_process_10_000_customers() throws NoPossibleSolutionException {
        runTestForOneColorInTheShop("10_000Customers.txt", "1 G 2 M 3 G 4 M 5 G");
    }

    /**
     * On my laptop(i5 Arrandale) this test took 2m 45s to run, which is a lot more than the 0.7s seconds it took
     * to run the 10_000 customer test. One possible explanation for this is the fact that the data structures that I
     * used do not fit into the CPU's cache for such a large number of customers. This means that for each change in the
     * data structures, and there are many, the performance penalty is high, since there are a lot of cache misses along
     * the way.
     * Another problem is that my algorithm is not scalable - I cannot parallelize it as it is.
     */
    @Ignore("Long running. The test will take a lot longer than 10 x (10_000 Customers test) to run")
    @Test
    public void
    should_process_100_000_customers() throws NoPossibleSolutionException {
        runTestForOneColorInTheShop("100_000_Customers.txt", "1 G 2 M 3 G 4 M 5 G");
    }

    @Ignore("Long running. The test will take a lot longer than 100 x (10_000 Customers test) to run")
    @Test
    public void
    should_process_1_million_customers() throws NoPossibleSolutionException {
        runTestForOneColorInTheShop("1MillionCustomers.txt", "1 G 2 M 3 G 4 M 5 G");
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
