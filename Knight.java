import java.util.Scanner;
import java.util.InputMismatchException;

public class Knight extends Character {

  private int hp = 50;

  private int mp = 4;

  private int str = 14;

  private int intel = 2;

  private int def = 10;

  private int mdf = 10;

  private int lvl = 6;

  private int tempDef = 0;

  private int frenzyCasts = 0;

  private int slamCost = 1;

  private int piercestrikeCost = 3;

  private int frenzyCost = 4;

  private int currentMp = 4;

  public void actions() {
    System.out.println("Attack(1)");
    System.out.println("Skills(2)");
    System.out.println("Defend(3)");
  }

  public void knightSkills() {
    System.out.println("\nSkills:");
    System.out.println("Slam(1): 1Mp");
    System.out.println("Piercing Strike(2): 3Mp");
    System.out.println("Frenzy(3): 4Mp");
    System.out.println("Back(4)");
  }

  public void attackDamage(final int damage) {
    System.out.println("You attacked for " + damage + " damage!");
  }

  public int knightAttack(final int Edef) {
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
        if (action == 1) {
          damage = attack(Edef);
          act += 1;
          attackDamage(damage);
        }
        else if (action == 2) {
          knightSkills();
          skillAction = userInput.nextInt();
          if (skillAction == 1) {
            if (checkMp(slamCost)) {
              damage = slam(Edef);
              act += 1;
              currentMp -= slamCost;
              attackDamage(damage);
            }
            else {
              invalidMp();
            }
          }
          else if (skillAction == 2) {
            if (checkMp(piercestrikeCost)) {
              damage = piercingStrike();
              act += 1;
              currentMp -= piercestrikeCost;
              attackDamage(damage);
            }
            else {
              invalidMp();
            }
          }
          else if (skillAction == 3) {
            if (checkMp(frenzyCost)) {
              frenzy();
              act += 1;
              currentMp -= frenzyCost;
            }
            else {
              invalidMp();
            }
          }
          else if (skillAction == 4) {
            damage = knightAttack(Edef);
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

  public boolean checkMp(final int mpCost) {
    return (mpCost <= currentMp);
  }

  public void invalidMp() {
    System.out.println("Not enough Mp!");
  }

  public int attack(final int Edef) {
    final int damage = super.attack(str, Edef) + lvl;
    return damage;
  }

  public int slam(final int Edef) {
    final int damage = super.attack(str, (Edef - 3));
    return damage;
  }

  public int piercingStrike() {
    int damage = str;
    int extra = Math.round(str / 2);
    damage += extra;
    return damage;
  }

  public void frenzy() {
    str += 3;
    def -= 4;
    mdf -= 4;
    frenzyCasts += 1;
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

  public void levelUp() {
    while (frenzyCasts > 0) {
      frenzyCasts -= 1;
      str -= 3;
      def += 4;
      mdf += 4;
    }
    str += 3;
    hp += 8;
    mp += 1;
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
}
