package org.mixing.colors;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class MixingAlgorithmTest {

    @Test
    public void
    should_return_all_the_colors_glossy_except_for_the_first() {
        // Prepare
        MixingAlgorithm mixingAlgorithm = new MixingAlgorithm();

        // Exercise
        List<Color> result = mixingAlgorithm.mix();

        // Verify
        assertNotNull(result);
        assertEquals(createColorList(Property.MATTE,
                                     Property.GLOSSY,
                                     Property.GLOSSY,
                                     Property.GLOSSY,
                                     Property.GLOSSY), result);
    }

    private List<Color> createColorList(Property... colorProperties) {
        List<Color> colors = new ArrayList<Color>();
        for (int i = 0; i < colorProperties.length; i++) {
            Color color = new Color(i + 1, colorProperties[i]);
            colors.add(color);
        }
        return colors;
    }


}
