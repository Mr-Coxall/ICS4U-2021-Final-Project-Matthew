import java.util.Scanner;
import java.util.InputMismatchException;

public class Ninja extends Character {

  private int hp = 40;

  private int mp = 8;

  private int str = 6;

  private int intel = 6;

  private int def = 6;

  private int mdf = 6;

  private int lvl = 6;

  private int tempDef = 0;

  private int prep = 0;

  private int currentMp = 8;

  private final int multislashCost = 4;

  private final int prepareCost = 2;

  private final int animeCost = 6;

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

  public void ninjaSkills() {
    System.out.println("\nSkills:");
    System.out.println("Multislash: 4Mp");
    System.out.println("Prepare: 2Mp");
    System.out.println("Animecut: AllMp (minimum of 6Mp required)");
    System.out.println("Back(4)");
  }

  public int ninjaAttack(final int Edf, final int Ehp) {
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
          damage = attack(Edf);
          act += 1;
          attackDamage(damage);
        } else if (action == choiceB) {
          ninjaSkills();
          skillAction = userInput.nextInt();
          if (skillAction == choiceA) {
            if (checkMp(multislashCost)) {
              damage = multislash(Edf);
              act += 1;
              currentMp -= multislashCost;
              attackDamage(damage);
            } else {
              invalidMp();
            }
          } else if (skillAction == choiceB) {
            if (checkMp(prepareCost)) {
              prepare();
              currentMp -= prepareCost;
              act += 1;
              attackDamage(damage);
            } else {
              invalidMp();
            }
          } else if (skillAction == choiceC) {
            if (checkMp(animeCost)) {
              damage = animeCut(Ehp);
              act += 1;
              currentMp = 0;
              attackDamage(damage);
            } else {
              invalidMp();
            }
          } else if (skillAction == choiceD) {
            damage = ninjaAttack(Edf, Ehp);
          }
        } else if (action == choiceC) {
          System.out.println("You steeled yourself "
            + "for the opponent's attack.");
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

  public boolean checkMp(final int mpCost) {
    return (mpCost <= currentMp);
  }

  public void invalidMp() {
    System.out.println("Not enough Mp!");
  }

  public int attack(final int Edf) {
    final int physicalDamage = super.attack(str, Edf);
    final int magicalDamage = super.attack(intel, Edf);
    final int damage = physicalDamage + magicalDamage;
    return damage;
  }

  public int multislash(final int Edef) {
    final int damage = super.attack((str + intel), Edef);
    return damage;
  }

  public void prepare() {
    str += 1;
    intel += 1;
    prep += 1;
  }

  public int animeCut(final int Ehp) {
    final int damage = Math.round(Ehp / 3);
    return damage;
  }

  public void levelUp() {
    hp += 4;
    mp += 2;
    intel += 1;
    str += 1;
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
    return mp;
  }
}
