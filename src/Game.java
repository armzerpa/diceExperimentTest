import java.util.List;

abstract class Game
{
    List<Integer> payouts;
    abstract void run(int totalRolls);
    abstract boolean win(int rollResult, int rollCount);
    abstract void printStadistics();
    protected int rollDices(int numberOfDices) {
        int result = 0;
        for (int i=0; i<numberOfDices; i++) {
            result += Dice.roll();
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
