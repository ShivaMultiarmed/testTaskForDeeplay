package mikhail.shell.deeplay;

import java.util.Random;

/**
 * Класс для генерации массивов
 */
public class ArrayGenerator {
	/**
	* Генератор случайных чисел.
	*/
    private final static Random random = new Random();

    /**
     * Генерирует массив случайных целых чисел согласно параметрам.
     *
     * @param min Минимальное число в массиве.
     * @param max Максимальное число в массиве
     * @param num Размер массива.
     * @return Возвращает int[].
     */
    public static int[] generateArray(int min, int max, int num)
    {
        int[] arr = new int[num];
        for (int i = 0; i < num; i++)
            arr[i] = random.nextInt(min, max);
        return arr;
    }
}
