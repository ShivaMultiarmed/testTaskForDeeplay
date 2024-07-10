package mikhail.shell.deeplay;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static mikhail.shell.deeplay.ArrayGenerator.generateArray;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTester {
    @Test
    void testEvaluatingProbability()
    {
        final int N = 100, M = 10000; // N - число бросков за одну игру, M - количество суимуляций игры
        int p1 = 0, draws = 0; // p1 - количество побед первого игрока, draws - количество ничей
        for (int i = 0; i < M; i++)
        {
            final int[] sequence1 = generateArray(1,7,3), sequence2 = generateArray(1, 7, 3);
            final Game game = new Game(sequence1, sequence2, N);
            final int result = game.play();
            if (result == 1)
                p1++;
            else if (result == 0)
                draws++;
        }
        final double winProbability = 1.0 * p1 / M, drawProbability = 1.0 * draws / M;
        final double lossProbability = 1 - winProbability - drawProbability;
        final double delta = 0.05;
        assertEquals(0.25, winProbability, delta);
        assertEquals(0.25, lossProbability, delta);
        assertEquals(0.5, drawProbability, delta);
        assertEquals(1, winProbability + lossProbability + drawProbability, delta);
    }
}
