package org.mixing.colors;

import org.mixing.colors.exceptions.NoPossibleSolutionException;
import org.mixing.colors.parsing.ShopParser;
import org.mixing.colors.shop.Color;
import org.mixing.colors.shop.ColorType;
import org.mixing.colors.shop.Shop;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {
        if (args.length != 1) {
            throw new IllegalArgumentException("The path to the file with the customers' preferences " +
                    "should be the one and only command line argument!");
        }

        String pathToFile = args[0];

        try {
            Shop shop = ShopParser.parse(pathToFile);
            List<Color> mixedColors = shop.mixColors();
            List<ColorType> result = transform(mixedColors);
            prettyPrint(result);
        } catch (NoPossibleSolutionException e) {
            System.out.println("No solution exists!");
        }
    }

    private static List<ColorType> transform(List<Color> mixedColors) {
        List<ColorType> result = new ArrayList<>();
        for (Color color : mixedColors) {
            result.add(color.getColorType());
        }
        return result;
    }

    private static void prettyPrint(List<ColorType> result) {
        for(ColorType colorType : result) {
            System.out.print(colorType + " ");
        }
    }

}
