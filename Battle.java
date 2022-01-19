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
    int dmgDealt = 0;
    Player user = new Player();
    Enemy monster = new Enemy();
    int playerHp = user.getHp();
    int enemyHp = monster.getHp();
    final Scanner userInput = new Scanner(System.in);
    while (true) {
    int tempDef = 0;
    int input = 0;
    int skillInput = 0;
    System.out.println("Enemy hp: " + enemyHp);
    System.out.println("\nPlayer hp: " + playerHp);
    System.out.println("Attack(1)");
    System.out.println("Skills(2)");
    System.out.println("Defend(3)");
    try {
        input = userInput.nextInt();
        if (input <= 0 || input >= 4) {
            System.out.println("That is not a viable input (must be 1, 2, or 3).");
        }
        else if (input == 1) {
            dmgDealt = user.attack(monster.getDef());
            enemyHp = enemyHp - dmgDealt;
        }
        else if (input == 2) {
          System.out.println("\nSkills:");
          System.out.println("Fireball(1)");
          System.out.println("Zap(2)");
          System.out.println("Frostblast(3)");
          try {
            skillInput = userInput.nextInt();
            if (skillInput <= 0 || skillInput >= 4) {
              System.out.println("That is not a viable input (must be 1, 2, or 3).");
            }
            else if (skillInput == 1) {
              dmgDealt = user.fireball(monster.getMdf());
              enemyHp = enemyHp - dmgDealt;
            }
            else if (skillInput == 2) {
              dmgDealt = user.zap(monster.getMdf());
              enemyHp = enemyHp - dmgDealt;
            }
            else {
              dmgDealt = user.frostblast(monster.getMdf());
              enemyHp = enemyHp - dmgDealt;
            }
          }
          catch (InputMismatchException errorCode) {
            System.out.println("That is not a viable input.");
          }
        }
        else {
          tempDef = 2;
        }
    }
    catch (InputMismatchException errorCode) {
        System.out.println("That is not a viable input.");
    }
    System.out.println("\nDone.");
    dmgDealt = monster.attack(user.getDef() + tempDef);
    playerHp = playerHp - dmgDealt;
}
}
}
