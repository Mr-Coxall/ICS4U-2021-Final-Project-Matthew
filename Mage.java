import java.util.Scanner;
import java.util.InputMismatchException;

public class Mage extends Character {

  private int hp = 35;

  private int mp = 20;

  private int str = 4;

  private int intel = 12;

  private int def = 4;

  private int mdf = 4;

  private int lvl = 6;

  private int tempDef = 0;

  private int currentMp = 20;

  /**
  * The value used to check if skills can be used for mage (all skills cost 5 mp)
  */
  private final int spellCost = 5;

  private final int choiceA = 1;

  private final int choiceB = 2;

  private final int choiceC = 3;

  private final int choiceD = 4;

  public void attackDamage(final int damage) {
    System.out.println("You attacked for " + damage + " damage!");
  }

  public void actions() {
    System.out.println("Attack(1)");
    System.out.println("Skills(2)");
    System.out.println("Defend(3)");
  }

  public void mageSkills() {
    System.out.println("\nSkills:");
    System.out.println("Inferno(1): 5Mp");
    System.out.println("Thunder(2): 5Mp");
    System.out.println("Icicle Spear(3): 5Mp");
    System.out.println("Back(4)");
  }

  public int mageAttack(final int Edef, final int Emdf,
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
          mageSkills();
          skillAction = userInput.nextInt();
          if (currentMp >= spellCost) {
            if (skillAction == choiceA) {
              damage = Inferno(Emdf, type);
              act += 1;
              currentMp -= spellCost;
              attackDamage(damage);
            } else if (skillAction == choiceB) {
              damage = Thunder(Emdf, type);
              act += 1;
              currentMp -= spellCost;
              attackDamage(damage);
            } else if (skillAction == choiceC) {
              damage = IcicleSpear(Emdf, type);
              act += 1;
              currentMp -= spellCost;
              attackDamage(damage);
            } else if (skillAction == choiceD) {
              damage = mageAttack(Edef, Emdf, type);
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

  public void invalidMp() {
    System.out.println("Not enough Mp!");
  }

  public int attack(final int Edef) {
    final int damage = super.attack(str, Edef) + lvl;
    return damage;
  }

  public int Thunder(final int Emdf, final String type) {
    int zapDmg = super.zap(intel, Emdf);
    if (type.equals("fire")) {
      zapDmg = zapDmg * 3;
    } else if (type.equals("lightning")) {
      zapDmg = 1;
    }
    return (zapDmg + 3);
  }

  public int Inferno(final int Emdf, final String type) {
    int fireDmg = super.fireball((intel + 3), Emdf);
    if (type.equals("ice")) {
      fireDmg += 3;
    } else if (type.equals("fire")) {
      fireDmg = 0;
    } else if (type.equals("lightning")) {
      fireDmg -= 2;
    }
    return fireDmg;
  }

  public int IcicleSpear(final int Emdf, final String type) {
    int frostDmg = super.frostblast((intel + 2), (Emdf - 1));
    if (type.equals("lightning")) {
      frostDmg += 3;
    } else if (type.equals("ice")) {
      frostDmg = 0;
    } else if (type.equals("fire")) {
      frostDmg -= 2;
    }
    return frostDmg;
  }

  public void levelUp() {
    hp += 4;
    mp += 5;
    intel += 2;
    def += 1;
    mdf += 1;
    lvl += 1;
    currentMp = mp;
  }

  /**
  * The fireball method.
  *
  * @param Emdf the enemy magic defence value.
  *
  * @return fireDmg the damage dealt.
  */
  public int fireball(final int Emdf) {
    return super.fireball(intel, Emdf);
  }

  /**
  * The zap method.
  *
  * @param Emdf the enemy magic defence value.
  *
  * @return zapDmg the damage dealt.
  */
  public int zap(final int Emdf) {
    return super.zap(intel, Emdf);
  }

  /**
  * The frostblast method.
  *
  * @param Emdf the enemy magic defence value.
  *
  * @return frostDmg the damage dealt.
  */
  public int frostblast(final int Emdf) {
    return super.frostblast(intel, Emdf);
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
}
