package mikhail.shell.deeplay;

import org.junit.jupiter.api.Test;

import java.util.List;

import static mikhail.shell.deeplay.MostEncountersCalculator.*;
import static org.junit.jupiter.api.Assertions.*;


public class MostEncountersCalculatorTester {

    @Test
    void testGettingMostEncountered()
    {
        final int[] arr = new int[] {10, 20, 19, 31, 0, 5, -1, 20, 19};
        final List<Integer> expected = List.of(19,20);
        final List<Integer> actual = getMostEncountered(arr);
        assertIterableEquals(expected, actual);
    }
}
