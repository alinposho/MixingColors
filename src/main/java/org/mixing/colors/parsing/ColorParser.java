package org.mixing.colors.parsing;

import org.mixing.colors.Color;
import org.mixing.colors.ColorType;

import java.util.ArrayList;
import java.util.List;

public class ColorParser {

    public static List<Color> parse(String colorEncoding) {
        String[] colorCodes = colorEncoding.split(" ");
        List<Color> colors = new ArrayList<>();
        for (String colorCode : colorCodes) {
            int endIndex = colorCode.length() - 1;
            int colorId = Integer.parseInt(colorCode.substring(0, endIndex));
            if (isColorMatteCode(colorCode.substring(endIndex))) {
                colors.add(new Color(colorId, ColorType.MATTE));
            } else {
                colors.add(new Color(colorId, ColorType.GLOSSY));
            }
        }
        return colors;
    }

    private static boolean isColorMatteCode(String substring) {
        return substring.toUpperCase().equals("M");
    }
}
