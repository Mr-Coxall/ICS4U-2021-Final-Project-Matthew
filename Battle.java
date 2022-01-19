import java.util.Scanner;
import java.util.InputMismatchException;

final class Battle {

  /**
  * Prevent instantiation
  * Throw an exception IllegalStateException.
  * if this ever is called
  *
  * @throws IllegalStateException
  *
  */
  private Battle() {
    throw new IllegalStateException("Cannot be initiated.");
  }

  /**
  * The starting main() function.
  *
  * @param args Name of file containing a
  string of numbers.
  */
  public static void main(final String[] args) {
    Player user = new Player();
    Enemy monster = new Enemy();
    final Scanner userInput = new Scanner(System.in);
    while (true) {
    System.out.println("Enemy hp: " + monster.getHp(0));
    System.out.println("\nPlayer hp: " + user.getHp(0));
    System.out.println("Attack(1): ");
    System.out.println("Skills(2): ");
    System.out.println("Defend(3): ");
    try {
        final int input = userInput.nextInt();
        if (input <= 0 || input >= 4) {
            System.out.println("That is not a viable input (must be 1, 2, or 3).");
        }
        else if (input == 1) {
            monster.getHp(user.attack(monster.getDef()));
        }
    }
    catch (InputMismatchException errorCode) {
        System.out.println("That is not a viable input.");
    }
    System.out.println("\nDone.");
}
}
}
