package mikhail.shell.deeplay;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static mikhail.shell.deeplay.ArrayGenerator.generateArray;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayGeneratorTester {
    private final static int MIN = -10, MAX = 10, NUM = 30;
    @Test
    void testGeneratedArrayNotNull()
    {
        final int[] arr = generateArray(MIN, MAX, NUM);
        assertNotNull(arr);
    }
    @Test
    void testBoundsAreRespected() {
        final int[] arr = generateArray(MIN, MAX, NUM);
        Arrays.stream(arr).forEachOrdered(number -> assertTrue(number < MAX && number >= MIN));
    }
}
