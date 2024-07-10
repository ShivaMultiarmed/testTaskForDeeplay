package mikhail.shell.deeplay;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, для поиска наиболее встречающихся чисел
 */
public class MostEncountersCalculator {
    /**
     * Метод, для поиска наиболее встречающихся чисел в переданном массиве.
     *
     * @param arr Переданный массив.
     * @return Список искомых чисел.
     */
    public static List<Integer> getMostEncountered(int[] arr)
    {
        final List<Integer> mostEncountered = new ArrayList<>();
        int maxEncounter = 0, curEncounter;
        for (int i = 0; i < arr.length; i++)
        {
            if (mostEncountered.contains(arr[i]))
                continue;
            curEncounter = 0;
            // кол-во повторений
            for (int j = 0; j < arr.length; j++)
                if (arr[i] == arr[j])
                    curEncounter++;
            if (curEncounter > maxEncounter)
            {
                maxEncounter = curEncounter;
                mostEncountered.clear();
            }
            else if (curEncounter == maxEncounter)
                mostEncountered.add(arr[i]);
        }
        return mostEncountered;
    }
}
