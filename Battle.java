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
    Actions act = new Actions();
    while (true) {
      int enemyHp = monster.getHp();
      int playerHp = user.getHp();
      int playerMp = user.getMp();
      final Scanner userInput = new Scanner(System.in);
      String weakness = monster.getWeakness();
      while (playerHp >= 1 && enemyHp >= 1) {
        int enemyCurrentHp = enemyHp;
        int tempDef = 0;
        int input = 0;
        int skillInput = 0;
        System.out.println("Enemy hp: " + enemyHp);
        System.out.println("\nPlayer hp: " + playerHp);
        System.out.println("Player mp: " + playerMp);
        act.actions();
        try {
          input = userInput.nextInt();
          if (input <= 0 || input >= 4) {
            System.out.println("That is not a viable input"
              + " (must be 1, 2, or 3).");
          }
          else if (input == 1) {
            dmgDealt = user.attack(monster.getDef());
            enemyHp = enemyHp - dmgDealt;
            System.out.println("You hit for " + dmgDealt + " damage.");
          }
          else if (input == 2) {
            act.skills();
            try {
              skillInput = userInput.nextInt();
              if (skillInput <= 0 || skillInput >= 5) {
                System.out.println("That is not a viable input "
                  + "(must be 1, 2, 3 or 4).");
              }
              else if (skillInput == 1) {
                dmgDealt = user.fireball(monster.getMdf());
                if (weakness.equals("fire")) {
                  dmgDealt += 3;
                }
                else if (weakness.equals("ice")) {
                  dmgDealt = 0;
                }
                else if (weakness.equals("lightning")) {
                  dmgDealt -= 2;
                }
                if (playerMp >= 2) {
                  enemyHp = enemyHp - dmgDealt;
                  System.out.println("You hit for "
                    + dmgDealt + " damage.");
                  playerMp -= 2;
                }
                else {
                  System.out.println("Not enough Mp!");
                }
              }
              else if (skillInput == 2) {
                dmgDealt = user.zap(monster.getMdf());
                if (weakness.equals("lightning")) {
                  dmgDealt += 3;
                }
                else if (weakness.equals("fire")) {
                  dmgDealt = 0;
                }
                else if (weakness.equals("ice")) {
                  dmgDealt -= 2;
                }
                if (playerMp >= 2) {
                  enemyHp = enemyHp - dmgDealt;
                  System.out.println("You hit for "
                    + dmgDealt + " damage.");
                  playerMp -= 2;
                }
                else {
                  System.out.println("Not enough Mp!");
                }
              }
              else if (skillInput == 3) {
                dmgDealt = user.frostblast(monster.getMdf());
                if (weakness.equals("ice")) {
                  dmgDealt += 3;
                }
                else if (weakness.equals("lightning")) {
                  dmgDealt = 0;
                }
                else if (weakness.equals("fire")) {
                  dmgDealt -= 2;
                }
                if (playerMp >= 2) {
                  enemyHp = enemyHp - dmgDealt;
                  System.out.println("You hit for "
                    + dmgDealt + " damage.");
                  playerMp -= 2;
                }
                else {
                  System.out.println("Not enough Mp!");
                }
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
      if (enemyHp >= 1 && (tempDef != 0 || enemyCurrentHp != enemyHp)) {
        dmgDealt = monster.attack(user.getDef() + tempDef);
        playerHp = playerHp - dmgDealt;
        System.out.println("The enemy attacked for "
          + dmgDealt + " damage.");
      }
    }
  int decision = 1;
  while (decision == 1) {
    System.out.println("Continue?: (1/0)");
    try {
      int battle = userInput.nextInt();
      if (battle == 1) {
        monster.levelUp();
        user.levelUp();
        decision = 0;
      }
      else if (battle == 0) {
        System.out.println("Game ended.");
        System.exit(0);
      }
      else {
        System.out.println("Invalid input, please input real value.");
      }
    }
    catch (InputMismatchException errorCode) {
      System.out.println("That is not a viable input.");
    }
    }
  }
}
}
