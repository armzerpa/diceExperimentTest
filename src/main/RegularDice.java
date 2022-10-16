package main;

public class RegularDice implements IDice {
    protected Integer fixedResult;

    public RegularDice(Integer fixedResult) {
        this.fixedResult = fixedResult;
    }

    @Override
    public int roll() {
        if (fixedResult == null) {
            return (int) (Math.random() * 6 + 1);
        }
        return fixedResult;
    }
}
