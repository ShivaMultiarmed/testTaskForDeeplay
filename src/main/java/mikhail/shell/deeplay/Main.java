package mikhail.shell.deeplay;

import java.util.Arrays;

import static mikhail.shell.deeplay.ArrayGenerator.*;
import static mikhail.shell.deeplay.ArraySorter.*;

public class Main {
    public static void main(String[] args) {
        int[] data = generateArray(-10, 10, 30);
        Arrays.stream(data).forEachOrdered(num -> System.out.print(num + " "));

        System.out.println();
        data = reorganize(data);
        Arrays.stream(data).forEachOrdered(num -> System.out.print(num + " "));

        //final List<Integer> mostEncountered = getMostEncountered(data);
        //mostEncountered.forEach(System.out::print);
    }
}
