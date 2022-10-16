import main.ArmandoGame;
import main.Game;
import main.IDice;
import main.RegularDice;

public class Main {
    public static void main(String[] args) {
        System.out.println("Armando Zerpa Test!! ajzerpa@gmail.com");

        int rolls = 1000000;
        IDice dice = new RegularDice(null);
        Game game1 = new ArmandoGame("game 1", 1, 6, 4, dice);
        Game game2 = new ArmandoGame("game 2", 2, 12, 24, dice);

        Thread thread = new Thread(() -> {
            game1.run(rolls);
            game1.printStadistics();
        });
        Thread thread2 = new Thread(() -> {
            game2.run(rolls);
            game2.printStadistics();
        });
        thread.start();
        thread2.start();
    }
}