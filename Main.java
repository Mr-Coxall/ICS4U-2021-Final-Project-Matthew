import java.util.Scanner;
import java.util.InputMismatchException;

final class Main {

  /**
  * Prevent instantiation
  * Throw an exception IllegalStateException.
  * if this ever is called
  *
  * @throws IllegalStateException
  *
  */
  private Main() {
    throw new IllegalStateException("Cannot be initiated.");
  }

  /**
  * The starting main() function.
  *
  * @param args Name of file containing a
  string of numbers.
  */
  public static void main(final String[] args) {
    final int choiceA = 1;
    int battle = 0;
    final int choiceB = 2;
    final int choiceC = 3;
    final int choiceD = 4;
    final int checkBoss = 5;
    final int checkFinal = 10;
    String type = "none";
    int newClass = 0;
    int dmgDealt = 0;
    Player user = new Player();
    Knight knight = new Knight();
    Mage mage = new Mage();
    Ninja ninja = new Ninja();
    Enemy monster = new Enemy();
    Boss boss = new Boss();
    Finale finalBoss = new Finale();
    Actions act = new Actions();
    act.basics();
    while (true) {
      int enemyHp = 0;
      int enemyDef = 0;
      int enemyMdf = 0;
      boolean bossBattle = false;
      boolean finalBattle = false;
      int level = monster.getLevel();
      if (level % checkBoss == 0 && level % checkFinal != 0) {
        enemyHp = boss.getHp();
        enemyDef = boss.getDef();
        enemyMdf = boss.getMdf();
        bossBattle = true;
        type = boss.getType();
      } else if (level % checkFinal == 0) {
        enemyHp = finalBoss.getHp();
        enemyDef = finalBoss.getDef();
        enemyMdf = finalBoss.getMdf();
        finalBattle = true;
        type = finalBoss.getType();
      } else {
        enemyHp = monster.getHp();
        enemyDef = monster.getDef();
        enemyMdf = monster.getMdf();
        type = monster.getType();
      }
      int playerHp = user.getHp();
      int playerDef = user.getDef();
      final Scanner userInput = new Scanner(System.in);
      String name = monster.getName();
      if (finalBattle) {
        name = "Amalgamation";
      }
      if (newClass == choiceA) {
        playerHp = knight.getHp();
        playerDef = knight.getDef();
      } else if (newClass == choiceB) {
        playerHp = mage.getHp();
        playerDef = mage.getDef();
      } else if (newClass == choiceC) {
        playerHp = ninja.getHp();
        playerDef = ninja.getDef();
      }
      while (playerHp >= 1 && enemyHp >= 1) {
        int enemyCurrentHp = enemyHp;
        int tempDef = 0;
        if (newClass == 0) {
          user.showHp(name, enemyCurrentHp, playerHp);
          dmgDealt = user.playerAttack(enemyDef, enemyMdf, type);
          enemyHp -= dmgDealt;
        } else if (newClass == choiceA) {
          knight.showHp(name, enemyCurrentHp, playerHp);
          dmgDealt = knight.knightAttack(enemyDef);
          enemyHp -= dmgDealt;
        } else if (newClass == choiceB) {
          mage.showHp(name, enemyCurrentHp, playerHp);
          dmgDealt = mage.mageAttack(enemyDef, enemyMdf, type);
          enemyHp -= dmgDealt;
        } else if (newClass == choiceC) {
          ninja.showHp(name, enemyCurrentHp, playerHp);
          dmgDealt = ninja.ninjaAttack(((enemyDef + enemyMdf) / choiceB),
            enemyCurrentHp);
          enemyHp -= dmgDealt;
        }
      if (enemyHp >= 1 && (tempDef != 0 || enemyCurrentHp != enemyHp)) {
        if (finalBattle) {
          dmgDealt = finalBoss.attack(playerDef);
          int healAmount = checkFinal;
        }
        if (bossBattle) {
          dmgDealt = boss.attack(playerDef);
          int healAmount = boss.heal();
          System.out.println("The boss attacked for "
            + dmgDealt + " damage!");
          System.out.println("The boss regained "
            + healAmount + " Hp!");
        } else {
          dmgDealt = monster.attack(playerDef);
          System.out.println("The " + name + " attacked for "
            + dmgDealt + " damage.");
        }
        playerHp = playerHp - dmgDealt;
      }
      if (finalBattle) {
        if (enemyHp <= 0 && (tempDef != 0 || enemyCurrentHp != enemyHp)
          && finalBoss.checkStage() != choiceB) {
          enemyHp = finalBoss.revive();
          System.out.println("The Amalgamation stood up, refusing to die!");
        }
      }
    }
    boolean decision = true;
    if (finalBattle) {
      System.out.println("You win!");
      System.exit(0);
    } else if (bossBattle) {
      newClass = act.classChange();
    }
    while (decision) {
      battle = 0;
      int warning = monster.getLevel();
      System.out.println("\nThe defeated the monster.");
      System.out.println("Continue?: (1/0)");
      if ((warning + 1) % checkBoss == 0) {
        System.out.println("Warning! Boss battle ahead!");
      }
      try {
        battle = userInput.nextInt();
        if (battle == 1) {
          bossBattle = false;
          monster.levelUp();
          user.levelUp();
          if (newClass == choiceA) {
            knight.levelUp();
          } else if (newClass == choiceB) {
            mage.levelUp();
          } else if (newClass == choiceC) {
            ninja.levelUp();
          }
          decision = false;
        } else if (battle == 0) {
          System.out.println("Game ended.");
          System.exit(0);
        } else {
          System.out.println("Invalid input, please input real value.");
        }
      } catch (InputMismatchException errorCode) {
        System.out.println("That is not a viable input.");
      }
    }
  }
  }
}
