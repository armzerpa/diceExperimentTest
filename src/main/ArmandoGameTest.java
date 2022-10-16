package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spock.lang.Specification;

import static org.junit.jupiter.api.Assertions.*;

class ArmandoGameTest extends Specification {
    Game game;
    Game gameMock;

    @BeforeEach
    void setUp() {
        IDice dice = new RegularDice(null);
        game = new ArmandoGame("test2", 1, 6, 4, dice);
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
        //when
        boolean win = game.win(1, 1);
        assertEquals(win, false);

        //then
        win = game.win(6, 1);
        assertTrue(win);
    }
    @Test
    void test_calculateTotalPayouts_amount_bigger_than_zero() {
        game.run(10);
        int total = game.calculateTotalPayouts();
        assertTrue (total >= 0);
    }

    @Test
    void test_run_exact_games_all_wins() {
        //given
        IDice diceMockWin = new RegularDice(6);
        gameMock = new ArmandoGame("test4", 1, 6, 4, diceMockWin);

        //then
        gameMock.run(1000);
        int size = gameMock.payouts.size();
        assertEquals(250, size);

        gameMock.run(1000);
        size = gameMock.payouts.size();
        assertEquals(250, size);

        gameMock.run(1000);
        size = gameMock.payouts.size();
        assertEquals(250, size);

        gameMock.run(1000);
        size = gameMock.payouts.size();
        assertEquals(250, size);
    }

    @Test
    void test_run_exact_games_all_looses() {
        //given
        IDice diceMockLoose = new RegularDice(6);
        gameMock = new ArmandoGame("test5", 1, 6, 4, diceMockLoose);

        //then
        gameMock.run(1000);
        int size = gameMock.payouts.size();
        assertEquals(250, size);

        gameMock.run(1000);
        size = gameMock.payouts.size();
        assertEquals(250, size);

        gameMock.run(1000);
        size = gameMock.payouts.size();
        assertEquals(250, size);

        gameMock.run(1000);
        size = gameMock.payouts.size();
        assertEquals(250, size);
    }
}