import java.util.ArrayList;

public class ArmandoGame extends Game {
    private static final Integer WIN_PAYOUT = 1;
    private String gameName;
    private int numberOfDice;
    private int winnerNumber;
    private int maxRollForGame;

    public ArmandoGame(String name, int numberOfDice, int winnerNumber, int maxRollForGame) {
        this.gameName = name;
        this.numberOfDice = numberOfDice;
        this.winnerNumber = winnerNumber;
        this.maxRollForGame = maxRollForGame;
    }
    @Override
    public void run(int totalRolls) {
        System.out.println("Starting Armando Game!!!");
        System.out.println("#Dices="+numberOfDice);
        System.out.println("Payout$="+WIN_PAYOUT);

        payouts = new ArrayList<>();
        int count = 1;
        int rollNumber = 1;
        while (count <= totalRolls) {
            int dice = super.rollDices(this.numberOfDice);
            boolean win = win(dice, rollNumber);
            calculatePayout(win, rollNumber);
            count = setupCount(win, count, rollNumber, totalRolls);
            rollNumber = setupRollsNumber(rollNumber, win);
            if (!canRollAgain(count, rollNumber, totalRolls)) {
                count = totalRolls + 1;
            }
        }
    }
    @Override
    public boolean win(int rollResult, int rollCount) {
        if(rollResult == this.winnerNumber && rollCount <= this.maxRollForGame) {
            return true;
        }
        return false;
    }

    @Override
    public void printStadistics() {
        System.out.println(gameName + ". Total games: " + super.getGamesCount());

        double totalPayouts = (double) super.calculateTotalPayouts();
        System.out.println(gameName + ". Total payouts " + totalPayouts);
        System.out.println(gameName + ". Mean " + UtilStadistics.calculateMean(totalPayouts, payouts));
        System.out.println(gameName + ". Variance " + UtilStadistics.calculateVariance(totalPayouts, payouts));
        System.out.println(gameName + ". Deviation std " + UtilStadistics.calculateStandardDeviation(totalPayouts, payouts));
    }
    private void calculatePayout(boolean win, int rollNumber) {
        if (win) {
            payouts.add(WIN_PAYOUT);
        } else if (rollNumber == this.maxRollForGame) {
            payouts.add(0);
        }
    }
    private int setupRollsNumber(int rollNumber, boolean win) {
        if (rollNumber == this.maxRollForGame || win) {
            rollNumber = 1;
        } else {
            rollNumber++;
        }
        return rollNumber;
    }
    private int setupCount(boolean win, int count, int rollNumber, int totalRolls) {
        count++;
        if (win && rollNumber < this.maxRollForGame) {
            count = count + (this.maxRollForGame - rollNumber);
        }
        return count;
    }
    private boolean canRollAgain(int count, int rollNumber, int totalRolls) {
        int rollsLeft = totalRolls - count;
        return rollNumber == 1 && rollsLeft < (this.maxRollForGame -1) ? false : true;
    }
}
