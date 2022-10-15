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
    void run() {
        game.run(12);
        int size = game.payouts.size();
        assertEquals(3, size);

        game.run(1000);
        size = game.payouts.size();
        assertEquals(250, size);
    }

    @Test
    void test_win() {
        boolean win = game.win(1, 1);
        assertFalse(win);

        win = game.win(6, 1);
        assertTrue(win);
    }
}