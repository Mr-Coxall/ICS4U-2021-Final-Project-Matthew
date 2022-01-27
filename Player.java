import java.util.Scanner;
import java.util.InputMismatchException;

public class Player extends Character {

  /**
  * The starting hp value.
  */
  private int hp = 30;

  /**
  * The starting mp value.
  */
  private int mp = 6;

  /**
  * The starting str (strength) value.
  */
  private int str = 5;

  /**
  * The starting intel (intelligence) value.
  */
  private int intel = 4;

  /**
  * The starting def (defence) value.
  */
  private int def = 2;

  /**
  * The starting mdf (magic defence) value.
  */
  private int mdf = 2;

  /**
  * The starting level value.
  */
  private int lvl = 1;

  private final int choiceA = 1;

  private final int choiceB = 2;

  private final int choiceC = 3;

  private final int choiceD = 4;

  private final int spellCost = 2;

  private int tempDef = 0;

  private int currentMp = 6;

  /**
  * The actions method, used to show the basic actions.
  */
  public void actions() {
    System.out.println("Attack(1)");
    System.out.println("Skills(2)");
    System.out.println("Defend(3)");
  }

  /**
  * The skills menu, showing the starting class' skills.
  */
  public void skills() {
    System.out.println("\nSkills:");
    System.out.println("Fireball(1): 2Mp");
    System.out.println("Zap(2): 2Mp");
    System.out.println("Frostblast(3): 2Mp");
    System.out.println("Back(4)");
  }

  public int playerAttack(final int Edef, final int Emdf,
    final String type) {
    tempDef = 0;
    int action = 0;
    int skillAction = 0;
    int damage = 0;
    int act = 0;
    final Scanner userInput = new Scanner(System.in);
    while (act == 0) {
      try {
        actions();
        action = userInput.nextInt();
        if (action == choiceA) {
          damage = attack(Edef);
          act += 1;
          attackDamage(damage);
        } else if (action == choiceB) {
          skills();
          skillAction = userInput.nextInt();
          if (currentMp >= spellCost) {
            if (skillAction == choiceA) {
              damage = fireball(Emdf, type);
              act += 1;
              currentMp -= spellCost;
              attackDamage(damage);
            } else if (skillAction == choiceB) {
              damage = zap(Emdf, type);
              act += 1;
              currentMp -= spellCost;
              attackDamage(damage);
            } else if (skillAction == choiceC) {
              damage = frostblast(Emdf, type);
              act += 1;
              currentMp -= spellCost;
              attackDamage(damage);
            } else if (skillAction == choiceD) {
              damage = playerAttack(Edef, Emdf, type);
            }
          } else {
            invalidMp();
          }
        } else if (action == choiceC) {
          tempDef += 3;
          act += 1;
        } else {
          System.out.println("That isn't a viable input.");
        }
      } catch (InputMismatchException errorCode) {
        System.out.println("That is not a viable input.");
      }
    }
    return damage;
  }

  public void attackDamage(final int damage) {
    System.out.println("You attacked for " + damage + " damage!");
  }

  public void invalidMp() {
    System.out.println("Not enough Mp!");
  }

  /**
  * The attack method.
  *
  * @param Edef the enemy defence value.
  *
  * @return damage the damage dealt.
  */
  public int attack(final int Edef) {
    // final int damage = super.attack(str, Edef) + lvl;
    final int damage = 50;
    return damage;
  }

  /**
  * The fireball method.
  *
  * @param Emdf the enemy magic defence value.
  * @param type the enemy's elemental type.
  *
  * @return fireDmg the damage dealt.
  */
  public int fireball(final int Emdf, final String type) {
    int fireDmg = super.fireball(intel, Emdf);
    if (type.equals("ice")) {
      fireDmg += 3;
    } else if (type.equals("lightning")) {
      fireDmg -= 2;
    }
    return fireDmg;
  }

  /**
  * The zap method.
  *
  * @param Emdf the enemy magic defence value.
  * @param type the enemy's elemental type.
  *
  * @return zapDmg the damage dealt.
  */
  public int zap(final int Emdf, final String type) {
    int zapDmg = super.zap(intel, Emdf);
    if (type.equals("fire")) {
      zapDmg = zapDmg * 3;
    } else if (type.equals("ice")) {
      zapDmg -= 2;
    }
    return zapDmg;
  }

  /**
  * The frostblast method.
  *
  * @param Emdf the enemy magic defence value.
  * @param type the enemy's elemental type.
  *
  * @return frostDmg the damage dealt.
  */
  public int frostblast(final int Emdf, final String type) {
    int frostDmg = super.frostblast(intel, Emdf);
    if (type.equals("lightning")) {
      frostDmg += 3;
    } else if (type.equals("fire")) {
      frostDmg -= 2;
    }
    return frostDmg;
  }

  public int getDef() {
    return (def + tempDef);
  }

  public int getMdf() {
    return mdf;
  }

  public int getHp() {
    return hp;
  }

  public int getMp() {
    return currentMp;
  }

  public void levelUp() {
    str += 2;
    hp += 5;
    mp += 1;
    intel += 1;
    def += 1;
    mdf += 1;
    lvl += 1;
    currentMp = mp;
  }

  public int getLevel() {
    return lvl;
  }
}
