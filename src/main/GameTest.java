package main;

import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spock.lang.Specification;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GameTest extends Specification {
    Game game;

    @BeforeEach
    void setUp() {
        game = new ArmandoGame("test", 1, 6, 24);
    }

    @Test
    void test_rollDices() {
        int res = game.rollDices(1);
        assertTrue(res >= 1 && res <= 6);
    }
    @Test
    void test_rollDices_withMock_result() {
        Game mock_service = Mockito.mock(Game.class);
        when(mock_service.rollDices(1)).thenReturn(6);

        int res = mock_service.rollDices(1);
        assertEquals(res, 6);
    }

    @Test
    void test_calculateTotalPayouts() {
        game.payouts = Arrays.asList(5,1,1,1,1,1);
        int total = game.calculateTotalPayouts();
        assertEquals(10, total);
    }

    @Test
    void test_getGamesCount() {
        game.payouts = Arrays.asList(1,1,1,1);
        int total = game.getGamesCount();
        assertEquals(4, total);
    }
}