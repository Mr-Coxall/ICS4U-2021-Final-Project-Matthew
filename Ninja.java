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

  public void ninjaSkills() {
    System.out.println("\nSkills:");
    System.out.println("Multislash: 4Mp");
    System.out.println("Prepare: 2Mp");
    System.out.println("Animecut: AllMp (minimum of 6 required)");
    System.out.println("Back(4)");
  }

  public int ninjaAttack(final int Edef, final int Ehp) {
    tempDef = 0;
    int action = 0;
    int skillAction = 0;
    int damage = 0;
    int act = 0;
    final Scanner userInput = new Scanner(System.in);
    while (act == 0) {
      try {
        action = userInput.nextInt();
        if (action == 1) {
          damage = attack(Edef);
          act += 1;
        }
        else if (action == 2) {
          ninjaSkills();
          skillAction = userInput.nextInt();
          if (skillAction == 1) {
            damage = multislash(Edef);
            mp -= 4;
            act += 1;
          }
          else if (skillAction == 2) {
            prepare();
            mp -= 2;
            act += 1;
          }
          else if (skillAction == 3) {
            damage = animeCut(Ehp);
            act += 1;
            mp = 0;
          }
        }
        else if (action == 3) {
          System.out.println("You steeled yourself"
            + "for the opponent's attack.");
          tempDef += 3;
          act += 1;
        }
        else {
          System.out.println("That isn't a viable input.");
        }
      }
      catch (InputMismatchException errorCode) {
        System.out.println("That is not a viable input.");
      }
    }
    return damage;
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
    return def;
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
