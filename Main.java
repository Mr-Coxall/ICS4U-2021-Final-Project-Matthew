import java.util.Scanner;

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
      if (newClass == 1) {
        playerHp = knight.getHp();
      } else if (newClass == choiceB) {
        playerHp = mage.getHp();
      } else if (newClass == choiceC) {
        playerHp = ninja.getHp();
      }
      while (enemyHp >= 1) {
        int enemyCurrentHp = enemyHp;
        int tempDef = 0;
        if (newClass == 0) {
          user.showHp(name, enemyCurrentHp, playerHp);
          dmgDealt = user.playerAttack(enemyDef, enemyMdf, type);
          enemyHp -= dmgDealt;
          playerDef = user.getDef();
        } else if (newClass == 1) {
          knight.showHp(name, enemyCurrentHp, playerHp);
          dmgDealt = knight.knightAttack(enemyDef);
          enemyHp -= dmgDealt;
          playerDef = knight.getDef();
        } else if (newClass == choiceB) {
          mage.showHp(name, enemyCurrentHp, playerHp);
          dmgDealt = mage.mageAttack(enemyDef, enemyMdf, type);
          enemyHp -= dmgDealt;
          playerDef = mage.getDef();
        } else if (newClass == choiceC) {
          ninja.showHp(name, enemyCurrentHp, playerHp);
          dmgDealt = ninja.ninjaAttack(((enemyDef + enemyMdf) / choiceB),
            enemyCurrentHp);
          enemyHp -= dmgDealt;
          playerDef = ninja.getDef();
        }
        if (enemyHp >= 1) {
          if (finalBattle) {
            dmgDealt = finalBoss.attack(playerDef);
            int healAmount = checkFinal;
          } else if (bossBattle) {
            dmgDealt = boss.attack(playerDef);
            int healAmount = boss.heal();
            System.out.println("The boss dealt " + dmgDealt + " damage!");
            System.out.println("The boss regained " + healAmount + " Hp!");
          } else {
            dmgDealt = monster.attack(playerDef);
            System.out.println("The " + name + " dealt " + dmgDealt
              + " damage!");
          }
          playerHp = playerHp - dmgDealt;
          if (playerHp <= 0) {
            System.out.println("You lose!");
            System.exit(0);
          }
        }
      }
      boolean decision = true;
      boolean cont = true;
      if (finalBattle) {
        System.out.println("You win!");
        System.exit(0);
      }
      while (decision) {
        int warning = monster.getLevel();
        System.out.println("\nYou defeated the monster.");
        System.out.println("Continue?: (y)es/(n)o");
        if ((warning + 1) % checkBoss == 0) {
          System.out.println("Warning! Boss battle ahead!");
        }
        int battleChoice = 0;
        while (battleChoice == 0) {
          cont = act.continueBattle();
          act.clear();
          if (cont) {
            if (bossBattle) {
              newClass = act.classChange();
            }
            decision = false;
            monster.levelUp();
            if (newClass == 0) {
              user.levelUp();
            } else if (newClass == 1 && !(bossBattle)) {
              knight.levelUp();
            } else if (newClass == choiceB && !(bossBattle)) {
              mage.levelUp();
            } else if (newClass == choiceC && !(bossBattle)) {
              ninja.levelUp();
            }
            bossBattle = false;
            battleChoice = 1;
          } else {
            System.out.println("Game ended.");
            System.exit(0);
          }
        }
      }
    }
  }
}
