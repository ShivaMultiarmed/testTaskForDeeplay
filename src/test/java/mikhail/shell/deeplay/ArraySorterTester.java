package mikhail.shell.deeplay;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArraySorterTester {
    @Test
    void testSortingInAscendingOrder()
    {
        final int[] expected = {-2, 1, 4, 7};
        final int[] toBeSorted  = {4, -2, 7, 1};
        final int[] real = ArraySorter.sort(toBeSorted,true);
        assertArrayEquals(expected, real);
    }
    @Test
    void testSortingInDescendingOrder()
    {
        final int[] expected = {8, 6,2,-1};
        final int[] toBeSorted  = {-1, 8, 2, 6};
        final int[] real = ArraySorter.sort(toBeSorted,false);
        assertArrayEquals(expected, real);
    }
    @Test
    void testArrayReorganisation()
    {
        final int[] expected = {-7, -3, 0, 10, 8, 4};
        final int[] toBeReorganized = {-3, 0, 10, 4, -7, 8};
        final int[] actual = ArraySorter.reorganize(toBeReorganized);
        assertArrayEquals(expected, actual);
    }
}
