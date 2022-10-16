package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spock.lang.Specification;

import static org.junit.jupiter.api.Assertions.*;

class ArmandoGameTest extends Specification {
    Game game;

    @BeforeEach
    void setUp() {
        game = new ArmandoGame("test2", 1, 6, 4);
    }

    @Test
    void test_run_exact_games() {
        game.run(1000);
        int size = game.payouts.size();
        assertEquals(250, size);

        game.run(1000);
        size = game.payouts.size();
        assertEquals(250, size);

        game.run(1000);
        size = game.payouts.size();
        assertEquals(250, size);

        game.run(1000);
        size = game.payouts.size();
        assertEquals(250, size);
    }

    @Test
    void test_run_missing_games() {
        game.run(10);
        int size = game.payouts.size();
        assertEquals(2, size);

        game.run(10);
        size = game.payouts.size();
        assertEquals(2, size);

        game.run(10);
        size = game.payouts.size();
        assertEquals(2, size);

        game.run(10);
        size = game.payouts.size();
        assertEquals(2, size);
    }

    @Test
    void test_win() {
        boolean win = game.win(1, 1);
        assertEquals(win, false);

        win = game.win(6, 1);
        assertTrue(win);
    }
    @Test
    void test_calculateTotalPayouts_amount_bigger_than_zero() {
        game.run(10);
        int total = game.calculateTotalPayouts();
        assertTrue (total >= 0);
    }
}