import java.util.Scanner;
import java.util.InputMismatchException;

public class Knight extends Character {

  /**
  * The starting hp value of the knight.
  */
  private final int hp = 50;

  /**
  * The starting mp value.
  */
  private final int mp = 4;

  /**
  * The starting str (strength) value.
  */
  private final int str = 9;

  /**
  * The starting intel (intelligence) value.
  */
  private final int intel = 2;

  /**
  * The starting def (defence) value.
  */
  private final int def = 10;

  /**
  * The starting mdf (magic defence) value.
  */
  private final int mdf = 10;

  /**
  * The starting level value.
  */
  private int lvl = 1;

  /**
  * The tempdef (temporary defence) value.
  */
  private int tempDef = 0;

  /**
  * The frenzy casts value (amount of.
  * Times frenzy has been used this fight).
  */
  private int frenzyCasts = 0;

  /**
  * The mp cost of the slam skill.
  */
  private final int slamCost = 1;

  /**
  * The mp cost of the piercing strike skill.
  */
  private final int piercestrikeCost = 3;

  /**
  * The mp cost of the frenzy skill.
  */
  private final int frenzyCost = 4;

  /**
  * The current mp you have.
  */
  private int currentMp = 4;

  /**
  * The value used every time a 1 is needed.
  */
  private final int choiceA = 1;

  /**
  * The value used every time a 2 is needed.
  */
  private final int choiceB = 2;

  /**
  * The value used every time a 3 is needed.
  */
  private final int choiceC = 3;

  /**
  * The value used every time a 4 is needed.
  */
  private final int choiceD = 4;

  /**
  * The value that strength increases by.
  */
  private final int strUp = 3;

  /**
  * The value that hp increases by.
  */
  private final int hpUp = 8;

  /**
  * The value that mp increases by.
  */
  private final int mpUp = 1;

  /**
  * The value that defence increases by.
  */
  private final int defUp = 1;

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
    int strengthIncrease = (strUp * lvl) + (strUp * frenzyCasts);
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
          damage = attack(Edef, strengthIncrease);
          act += 1;
          attackDamage(damage);
        } else if (action == choiceB) {
          knightSkills();
          skillAction = userInput.nextInt();
          if (skillAction == choiceA) {
            if (checkMp(slamCost)) {
              damage = slam(Edef, strengthIncrease);
              act += 1;
              currentMp -= slamCost;
              attackDamage(damage);
            } else {
              invalidMp();
            }
          } else if (skillAction == choiceB) {
            if (checkMp(piercestrikeCost)) {
              damage = piercingStrike(strengthIncrease);
              act += 1;
              currentMp -= piercestrikeCost;
              attackDamage(damage);
            } else {
              invalidMp();
            }
          } else if (skillAction == choiceC) {
            if (checkMp(frenzyCost)) {
              frenzy();
              act += 1;
              currentMp -= frenzyCost;
            } else {
              invalidMp();
            }
          } else if (skillAction == choiceD) {
            damage = knightAttack(Edef);
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

  public boolean checkMp(final int mpCost) {
    return (mpCost <= currentMp);
  }

  public void invalidMp() {
    System.out.println("Not enough Mp!");
  }

  public int attack(final int Edef, final int strengthUp) {
    final int damage = super.attack((str + strengthUp), (Edef - lvl));
    return damage;
  }

  public int slam(final int Edef, final int strengthUp) {
    final int damage = super.attack((str + strengthUp), (Edef - 3));
    return damage;
  }

  public int piercingStrike(final int strengthUp) {
    int damage = str + (strUp * frenzyCasts);
    int extra = Math.round((str + (strUp * frenzyCasts)) / 2);
    damage += extra;
    return damage;
  }

  public void frenzy() {
    frenzyCasts += 1;
  }

  public int getDef() {
    return (def + tempDef) - (3 * frenzyCasts) + (defUp * lvl);
  }

  public int getMdf() {
    return mdf - (3 * frenzyCasts) + (defUp * lvl);
  }

  public int getHp() {
    return hp + (hpUp * lvl);
  }

  public int getMp() {
    return currentMp;
  }

  public void levelUp() {
    frenzyCasts = 0;
    lvl += 1;
    currentMp = mp + (mpUp * (lvl - 1));
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
