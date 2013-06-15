package org.mixing.colors.parsing;

import org.mixing.colors.Color;
import org.mixing.colors.Customer;
import org.mixing.colors.shop.Shop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShopParser {

    /**
     * Precondition: The file conforms to the format specified in the documentation:<br/>
     * the first line contains an integer representing the number of colors form the shop
     * The subsequent lines contain the favorite colors for each customer in the format: color id followed by M or G
     * representing matte or glossy, e.g. 1M 2G 4G represents 1st color matte, second glossy etc.
     * Additionally, No customer will like more than one color in matte.
     *
     * @param pathToFile - the path to the file containing a string with the above mentioned format.
     * @return
     */
    public static Shop parse(String pathToFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            return parseNoExceptions(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No file with the name " + pathToFile, e);
        } catch (IOException e) {
            throw new RuntimeException("Exception while parsing the file " + pathToFile, e);
        }
    }

    private static Shop parseNoExceptions(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        int numberOfColors = Integer.parseInt(line.trim());
        List<Customer> customers = parseCustomers(reader);

        return new Shop(numberOfColors, customers);
    }

    private static List<Customer> parseCustomers(BufferedReader reader) throws IOException {

        List<Customer> customers = new ArrayList<>();
        int id = 1;

        String line;
        while ((line = reader.readLine()) != null) {
            List<Color> favoriteColors = ColorParser.parse(line);
            customers.add(new Customer(id++, favoriteColors));
        }
        return customers;
    }

}
