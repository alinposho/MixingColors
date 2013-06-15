package org.mixing.colors.parsing;

import org.mixing.colors.Color;
import org.mixing.colors.ColorType;

import java.util.ArrayList;
import java.util.List;

public class ColorParser {

    public static List<Color> parse(String colorsEncoding) {
        String[] colorCodes = colorsEncoding.split(" ");
        List<Color> colors = new ArrayList<>();
        for (int i = 0; i < colorCodes.length; i+=2) {
            int colorId = Integer.parseInt(colorCodes[i]);
            if (isColorMatteCode(colorCodes[i + 1])) {
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
