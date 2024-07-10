package mikhail.shell.deeplay;

import java.util.Random;

/**
 * Класс для симуляции игры
 */
public class Game {
    /**
     * Игроки
     */
    private final Player p1, p2;
    /**
     * Количество бросков кубиков
     */
    private final int N;
    private final Random random;
    public Game(final int[] p1sequence, final int[] p2sequence, final int N)
    {
        this.N = N;
        random = new Random();
        p1 = new Player(p1sequence);
        p2 = new Player(p2sequence);
    }

    /**
     *
     * @return Возвращает 1 в случае победы первого игрока, 2 - второго, 3 - ничьи
     */
    public int play()
    {
        for (int i = 0; i < N; i++)
        {
            final int number = getRandomNumber();
            System.out.print(number + " ");
            updatePoints(number);
        }

        if (p1.points > p2.points)
            return 1;
        else if (p1.points < p2.points)
            return -1;
        else
            return 0;
    }

    /**
     *
     * @param number Проверяет и в случае необходимости обновляет число очков для каждого игрока
     */
    private void updatePoints(final int number)
    {
        p1.checkMatch(number);
        p2.checkMatch(number);
    }

    /**
     *
     * @return Возвращает случайное число от 1 до 6
     */
    private int getRandomNumber()
    {
        return random.nextInt(1, 7);
    }
}
