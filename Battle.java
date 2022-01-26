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
    int bossLevel = 0;
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
    act.help();
    while (true) {
      int enemyHp = 0;
      int enemyDef = 0;
      int enemyMdf = 0;
      boolean bossBattle = false;
      boolean finalBattle = false;
      int level = monster.getLevel();
      if (level % 5 == 0 && level % 10 != 0) {
        bossLevel += 1;
        enemyHp = boss.getHp(bossLevel);
        boss.getStr(bossLevel);
        enemyDef = boss.getDef(bossLevel);
        enemyMdf = boss.getMdf(bossLevel);
        bossBattle = true;
      }
      else if (level % 10 == 0) {
        enemyHp = finalBoss.getHp();
        enemyDef = finalBoss.getDef();
        enemyMdf = finalBoss.getMdf();
        finalBattle = true;
      }
      else {
        enemyHp = monster.getHp();
        enemyDef = monster.getDef();
        enemyMdf = monster.getMdf();
      }
      int playerHp = user.getHp();
      int playerMp = user.getMp();
      int playerDef = user.getDef();
      final Scanner userInput = new Scanner(System.in);
      String type = monster.getType();
      String name = monster.getName();
      while (playerHp >= 1 && enemyHp >= 1) {
        if (finalBattle) {
          enemyDef = finalBoss.getDef();
          enemyMdf = finalBoss.getMdf();
          name = "Amalgamation";
        }
        int enemyCurrentHp = enemyHp;
        int tempDef = 0;
        if (newClass == 1) {
          playerHp = knight.getHp();
          playerMp = knight.getMp();
          playerDef = knight.getDef();
        }
        else if (newClass == 2) {
          playerHp = mage.getHp();
          playerMp = mage.getMp();
          playerDef = mage.getDef();
        }
        else if (newClass == 3) {
          playerHp = ninja.getHp();
          playerMp = ninja.getMp();
          playerDef = ninja.getDef();
        }
        System.out.println(name + " hp: " + enemyHp);
        System.out.println("\nPlayer hp: " + playerHp);
        System.out.println("Player mp: " + playerMp);
        act.actions();
        if (newClass == 0) {
          int action = act.attacking();
          if (action == 1) {
            dmgDealt = user.attack(enemyDef);
            enemyHp = enemyHp - dmgDealt;
            System.out.println("You hit for " + dmgDealt + " damage.");
          }
          else if (action == 2) {
            user.skills();
            int skillAttack = act.skillAction();
            if (skillAttack == 1) {
              dmgDealt = user.fireball(enemyMdf, type);
              if (playerMp >= 2) {
                enemyHp = enemyHp - dmgDealt;
                System.out.println("You hit for "
                  + dmgDealt + " damage.");
                playerMp -= 2;
                enemyCurrentHp -= 1;
              }
              else {
                System.out.println("Not enough Mp!");
              }
            }
            else if (skillAttack == 2) {
              int dmgPerHit = 2;
              dmgDealt = user.zap(enemyMdf, type);
              if (playerMp >= 2) {
                dmgPerHit = dmgDealt;
                enemyHp = enemyHp - dmgPerHit;
                System.out.println("You hit for "
                  + dmgDealt + " damage.");
                playerMp -= 2;
                enemyCurrentHp -= 1;
              }
              else {
                System.out.println("Not enough Mp!");
              }
            }
            else if (skillAttack == 3) {
              dmgDealt = user.frostblast(enemyMdf, type);
              if (playerMp >= 2) {
                enemyHp = enemyHp - dmgDealt;
                System.out.println("You hit for "
                  + dmgDealt + " damage.");
                playerMp -= 2;
                enemyCurrentHp -= 1;
              }
              else {
                System.out.println("Not enough Mp!");
              }
            }
          }
          else if (action == 3) {
            tempDef += 3;
          }
        }
        else if (newClass == 1) {
          dmgDealt = knight.knightAttack(enemyDef);
          enemyHp -= dmgDealt;
        }
        else if (newClass == 2) {
          dmgDealt = mage.mageAttack(enemyDef, enemyMdf, type);
          enemyHp -= dmgDealt;
        }
        else if (newClass == 3) {
          dmgDealt = ninja.ninjaAttack(enemyDef, enemyCurrentHp);
          enemyHp -= dmgDealt;
        }
      if (enemyHp >= 1 && (tempDef != 0 || enemyCurrentHp != enemyHp)) {
        if (finalBattle) {
          dmgDealt = finalBoss.attack(playerDef);
          int healAmount = 10;
        }
        if (bossBattle) {
          dmgDealt = boss.attack(playerDef);
          int healAmount = boss.heal();
          System.out.println("The boss attacked for "
            + dmgDealt + " damage!");
          System.out.println("The boss regained "
            + healAmount + " Hp!");
        }
        else {
          dmgDealt = monster.attack(playerDef);
          System.out.println("The " + name + " attacked for "
            + dmgDealt + " damage.");
        }
        playerHp = playerHp - dmgDealt;
      }
      if (finalBattle) {
        if (enemyHp <= 0 && (tempDef != 0 || enemyCurrentHp != enemyHp)
          && finalBoss.checkStage() != 3) {
          enemyHp = finalBoss.revive();
          System.out.println("The Amalgamation stood up, refusing to die!");
        }
      }
    }
  boolean decision = true;
  if (bossBattle && bossLevel == 2) {
    System.out.println("You win!");
    System.exit(0);
  }
  else if (bossBattle) {
    newClass = act.classChange();
  }
  while (decision) {
    int warning = monster.getLevel();
    System.out.println("Continue?: (1/0)");
    if ((warning + 1) % 5 == 0) {
      System.out.println("Warning! Boss battle ahead!");
    }
    try {
      int battle = userInput.nextInt();
      if (battle == 1) {
        bossBattle = false;
        monster.levelUp();
        user.levelUp();
        decision = false;
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
