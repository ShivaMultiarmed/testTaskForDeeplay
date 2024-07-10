package mikhail.shell.deeplay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс, предназначенный для разделения массивов
 */
public class ArrayPartitioner {
    /**
     * Исходный массив, который нужно разделить
     */
    private final int[] arr;
    /**
     * Массив из сумм, которые должны быть в каждой из частей разделённого массива.
     */
    private final int[] targetSums;
    /**
     * Минимальная сумма среди частей.
     */
    private int minSum;
    /**
     * Количество частей, на которые нужно разделить массив.
     */
    private final int K;
    /**
     * Результат деления массива на части.
     */
    private final List<List<Integer>> partitions;

    /**
     *
     * @param arr Исходный массив int[]
     * @param K Число частей.
     */
    public ArrayPartitioner(final int[] arr, final int K)
    {
        this.K = K;
        this.arr = arr;
        partitions = new ArrayList<>();
        targetSums = new int[K];
        minSum = evaluateMinSum();
        for (int i = 0; i< K; i++)
        {
            partitions.add(new ArrayList<>());
            targetSums[i] = minSum + i;
        }
    }

    /**
     * Вычисляет минимальную сумму.
     * @return Минимальная сумма среди частей.
     */
    public int evaluateMinSum()
    {
        final int totalSum = Arrays.stream(arr).sum();
        return (totalSum - K*(K-1)/2) / K;
    }

    /**
     * Разделяет массив на части с соответствующимим суммами.
     * @return Список из частей исходного массива.
     */
    public List<List<Integer>> partition()
    {
        if (canPartition(0)) {
            sortPartitions(partitions);
            return partitions;
        } else {
            return null;
        }
    }

    /**
     * Проверяет, удовлетворяют ли части правилу: сумма чисел в одной из частей равна L,
     * во второй L + 1 и т.д., сумма чисел в последней части равна L + K - 1,
     * где L – некоторое число.
     *
     * @param index Индекс части.
     * @return Истина или ложь в зависимости от того, удовлетворяют ли части правилу или нет
     */
    private boolean canPartition(final int index)
    {
        List<List<Integer>> partitionsCopy = (List)((ArrayList) partitions).clone();
        sortPartitions(partitionsCopy);
        if (index == arr.length) {
            for (int i = 0; i < targetSums.length; i++) {
                final int sum = partitionsCopy.get(i).stream().mapToInt(Integer::intValue).sum();
                if (sum != targetSums[i]) { // проверяем совпадают ли суммы с ожидаемыми
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < partitions.size(); i++) {
            partitions.get(i).add(arr[index]);
            if (canPartition(index + 1)) { // Проверяем, можем ли добавить в i-ую часть ещё число
                return true;
            }
            partitions.get(i).remove(partitions.get(i).size() - 1);

            if (partitions.get(i).isEmpty()) { // часть не должна быть пустой, поэтому прерываем цикл
                break;
            }
        }

        return false;
    }

    /**
     * Сортирует части по возрастанию их сумм.
     *
     * @param partitions Список частей, которые нужно отсортировать.
     */
    private void sortPartitions(List<List<Integer>> partitions)
    {
        partitions.sort((list1, list2) ->
        {
            final int sum1 = list1.stream().mapToInt(Integer::intValue).sum();
            final int sum2 = list2.stream().mapToInt(Integer::intValue).sum();
            if (sum1 < sum2)
                return -1;
            else if (sum2 < sum1)
                return 1;
            else
                return 0;
        });
    }
}
