package mikhail.shell.deeplay;

/**
 * Класс, обозначающий игрока
 */
public class Player {
    /**
     * Последовательность из трёх чисел, которую выбрал игрок
     */
    private final int[] sequence;
    /**
     * Количество очков
     */
    public int points = 0;
    /**
     * Количество совпадений для поиска последовательности игрока
     */
    private int matches = 0;

    /**
     *
     * @param sequence
     */
    public Player(final int[] sequence) {
        this.sequence = sequence;
    }

    /**
     * Проверяет не совпадает ли передааемое число, с тем что находится в выбранной последовательности
     *
     * @param number
     */
    public void checkMatch(final int number)
    {
        if (sequence[matches] == number)
            matches++;
        else
            matches = 0;
        if (matches == 3)
        {
            matches = 0;
            points++;
        }
    }
}
