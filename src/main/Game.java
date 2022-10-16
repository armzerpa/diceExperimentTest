package main;

import java.util.List;

public abstract class Game
{
    IDice dice;
    List<Integer> payouts;
    public abstract void run(int totalRolls);
    abstract boolean win(int rollResult, int rollCount);
    public abstract void printStadistics();
    protected int rollDices(int numberOfDices) {
        int result = 0;
        for (int i=0; i<numberOfDices; i++) {
            result += dice.roll();
        }
        return result;
    }
    protected int calculateTotalPayouts() {
        return payouts.stream().reduce(0, (a, b) -> a + b);
    }
    protected int getGamesCount() {
        return payouts.size();
    }
}
