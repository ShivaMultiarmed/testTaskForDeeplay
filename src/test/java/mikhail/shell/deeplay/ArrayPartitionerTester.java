package mikhail.shell.deeplay;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayPartitionerTester {
    @Test
    void testEvaluatingL()
    {
        final int[] arrayToBePartitioned = {5, 2, 6, 4, 3, 6};
        final ArrayPartitioner partitioner = new ArrayPartitioner(arrayToBePartitioned, 4);
        final int expected = 5;
        final int real = partitioner.evaluateMinSum();
        assertEquals(expected,real);
    }
    @Test
    void testPartitioningArray()
    {
        final int[] initialArray = {10, 11, 7, 7, 12};

        final List<List<Integer>> expectedList = new ArrayList<>();
        expectedList.add(List.of(11, 12));
        expectedList.add(List.of(10, 7, 7));

        final ArrayPartitioner partitioner = new ArrayPartitioner(initialArray, 2);
        final List<List<Integer>> actualList = partitioner.partition();


        assertNotNull(actualList);
        assertIterableEquals(expectedList, actualList);
    }
}
