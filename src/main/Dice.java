package main;

public class Dice {
    static int roll() {
        return (int) (Math.random() * 6 + 1);
    }

    static int rollMock(int r) {
        return r;
    }
}