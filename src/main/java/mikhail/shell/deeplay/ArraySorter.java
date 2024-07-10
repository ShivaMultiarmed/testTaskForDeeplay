package mikhail.shell.deeplay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс, предназначенный для сортировки массивов.
 */
public class ArraySorter {
    /**
     * Сортирует переданный массив в порядке неубывания или невозрастания.
     *
     * @param a Переданный массив
     * @param ascendingOrder Порядок сортировки: true - неубывание, false - невозрастание.
     * @return Новый отсортированный массив int[]
     */
    public static int[] sort(int [] a, boolean ascendingOrder)
    {
        int[] arr = new int[a.length];
        System.arraycopy(a, 0, arr, 0, arr.length);
        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = 0; j < arr.length - i - 1; j++)
            {
                final boolean condition = ascendingOrder ? arr[j+1] < arr[j] : arr[j+1] > arr[j];
                if (condition)
                {
                    final int swap = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = swap;
                }
            }
        }
        return arr;
    }

    /**
     * Из переданного массива создаётся массив только из нечётных чисел исходного массива.
     *
     * @param arr Переданный массив int[]
     * @return Новый массив int[] только из нечётных чисел
     */
    public static int[] getOddNumbers(int[] arr) // полчуить нечётные числа
    {
       return Arrays.stream(arr).filter(num -> num % 2 !=0).toArray();
    }
    /**
     * Из переданного массива создаётся массив только из чётных чисел исходного массива кроме нулей.
     *
     * @param arr Переданный массив int[]
     * @return Новый массив int[] только из чётных чисел кроме нулей.
     */
    public static int[] getEvenNumbers(int[] arr) // полчуить чётные числа кроме 0
    {
        return Arrays.stream(arr).filter(num -> num % 2 == 0 && num != 0 ).toArray();
    }
    /**
     * Из переданного массива создаётся массив только из нулей исходного массива.
     *
     * @param arr Переданный массив int[]
     * @return Новый массив int[] только из нулей
     */
    public static int[] getZeros(int[] arr)
    {
        return Arrays.stream(arr).filter(num -> num == 0).toArray();
    }
    /**
     * Из переданного массива создаётся массив, где сначала идут нечётные числа в порядке неубывания,
     * затем нули, потом чётные числа в порядке невозрастания.
     *
     * @param arr Переданный массив int[]
     * @return Новый массив int[]
     */
    public static int[] reorganize(int[] arr)
    {
        int[] odds = getOddNumbers(arr), evens = getEvenNumbers(arr), zeros = getZeros(arr);
        odds = sort(odds, true);
        evens = sort(evens, false);
        int[] reorganized = new int[arr.length];
        System.arraycopy(odds, 0, reorganized,0, odds.length);
        System.arraycopy(zeros, 0, reorganized,odds.length, zeros.length);
        System.arraycopy(evens, 0, reorganized,odds.length+zeros.length, evens.length);
        return reorganized;
    }
}
