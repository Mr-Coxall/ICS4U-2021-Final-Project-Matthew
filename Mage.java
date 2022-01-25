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
        action = userInput.nextInt();
        if (action == 1) {
          damage = attack(Edef);
          act += 1;
        }
        else if (action == 2) {
          mageSkills();
          skillAction = userInput.nextInt();
          if (skillAction == 1) {
            damage = Inferno(Emdf, type);
            act += 1;
          }
          else if (skillAction == 2) {
            damage = Thunder(Emdf, type);
            act += 1;
          }
          else if (skillAction == 3) {
            damage = IcicleSpear(Emdf, type);
            act += 1;
          }
        }
        else if (action == 3) {
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

  public int attack(final int Edef) {
    final int damage = super.attack(str, Edef) + lvl;
    return damage;
  }

  public int Thunder(final int Emdf, final String type) {
    int zapDmg = super.zap(intel, Emdf);
    if (type.equals("fire")) {
      zapDmg = zapDmg * 3;
    }
    else if (type.equals("lightning")) {
      zapDmg = 1;
    }
    return (zapDmg + 3);
  }

  public int Inferno(final int Emdf, final String type) {
    int fireDmg = super.fireball((intel + 3), Emdf);
    if (type.equals("ice")) {
      fireDmg += 3;
    }
    else if (type.equals("fire")) {
      fireDmg = 0;
    }
    else if (type.equals("lightning")) {
      fireDmg -= 2;
    }
    return fireDmg;
  }

  public int IcicleSpear(final int Emdf, final String type) {
    int frostDmg = super.frostblast((intel + 2), (Emdf - 1));
    if (type.equals("lightning")) {
      frostDmg += 3;
    }
    else if (type.equals("ice")) {
      frostDmg = 0;
    }
    else if (type.equals("fire")) {
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