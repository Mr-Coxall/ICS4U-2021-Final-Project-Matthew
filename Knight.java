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
  private int lvl = 0;

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
  * The newMp value is used for Mp checks.
  */
  private int newMp = mp;

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

  /**
  * The actions method shows basic actions.
  */
  public void actions() {
    System.out.println("Attack(1)");
    System.out.println("Skills(2)");
    System.out.println("Defend(3)");
  }

  /**
  * The knightSkills method shows skills.
  */
  public void knightSkills() {
    System.out.println("\nSkills:");
    System.out.println("Slam(1): 1Mp");
    System.out.println("Piercing Strike(2): 3Mp");
    System.out.println("Frenzy(3): 4Mp");
    System.out.println("Back(4)");
  }

  /**
  * The attackDamage method tells you how much damage you dealt.
  *
  * @param damage the damage amount.
  */
  public void attackDamage(final int damage) {
    System.out.println("You attacked for " + damage + " damage!");
  }

  /**
  * The knightAttack method, used for when it's.
  * your turn using the knight class.
  *
  * @param eDef the enemy defence value.
  *
  * @return damage.
  */
  public int knightAttack(final int eDef) {
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
          damage = attack(eDef, strengthIncrease);
          act += 1;
          attackDamage(damage);
        } else if (action == choiceB) {
          knightSkills();
          skillAction = userInput.nextInt();
          if (skillAction == choiceA) {
            if (checkMp(slamCost)) {
              damage = slam(eDef, strengthIncrease);
              act += 1;
              newMp -= slamCost;
              attackDamage(damage);
            } else {
              invalidMp();
            }
          } else if (skillAction == choiceB) {
            if (checkMp(piercestrikeCost)) {
              damage = piercingStrike(strengthIncrease);
              act += 1;
              newMp -= piercestrikeCost;
              attackDamage(damage);
            } else {
              invalidMp();
            }
          } else if (skillAction == choiceC) {
            if (checkMp(frenzyCost)) {
              frenzy();
              act += 1;
              newMp -= frenzyCost;
            } else {
              invalidMp();
            }
          } else if (skillAction == choiceD) {
            damage = knightAttack(eDef);
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

  /**
  * The checkMp method, used to see if you have enough Mp for a skill.
  *
  * @param mpCost the cost of the skill.
  *
  * @return true or false.
  */
  public boolean checkMp(final int mpCost) {
    return (mpCost <= newMp);
  }

  /**
  * The invalidMp method tells you when you don't have enough Mp.
  */
  public void invalidMp() {
    System.out.println("Not enough Mp!");
  }

  /**
  * The attack method.
  *
  * @param eDef the enemy defence value.
  * @param strengthUp the increase to strength value.
  *
  * @return damage the damage dealt.
  */
  public int attack(final int eDef, final int strengthUp) {
    final int damage = super.attack((str + strengthUp), eDef);
    return damage;
  }

  /**
  * The slam method.
  *
  * @param eDef the enemy defence value.
  * @param strengthUp the increase to strength value.
  *
  * @return damage the damage dealt.
  */
  public int slam(final int eDef, final int strengthUp) {
    final int damage = super.attack((str + strengthUp), (eDef - 3));
    return damage;
  }

  /**
  * The piercingStrike method.
  *
  * @param strengthUp the increase to strength value.
  *
  * @return damage the damage dealt.
  */
  public int piercingStrike(final int strengthUp) {
    int damage = str + (strUp * frenzyCasts);
    int extra = Math.round((str + (strUp * frenzyCasts)) / 2);
    damage += extra;
    return damage;
  }

  /**
  * The frenzy method keeps track of the number of times you use.
  * Frenzy during a battle.
  */
  public void frenzy() {
    frenzyCasts += 1;
  }

  /**
  * The getDef method.
  *
  * @return def
  */
  public int getDef() {
    return (def + tempDef) - (3 * frenzyCasts) + (defUp * lvl);
  }

  /**
  * The getMdf method.
  *
  * @return mdf
  */
  public int getMdf() {
    return mdf - (3 * frenzyCasts) + (defUp * lvl);
  }

  /**
  * The getHp method.
  *
  * @return hp
  */
  public int getHp() {
    return hp + (hpUp * lvl);
  }

  /**
  * The getMp method.
  *
  * @return newMp
  */
  public int getMp() {
    return newMp;
  }

  /**
  * The levelUp method is used to reset.
  * the frenzy casts, and newMp values.
  */
  public void levelUp() {
    frenzyCasts = 0;
    lvl += 1;
    newMp = mp + (mpUp * lvl);
  }

  /**
  * The fireball method.
  *
  * @param eMdf the enemy magic defence value.
  *
  * @return fireDmg the damage dealt.
  */
  public int fireball(final int eMdf) {
    return super.fireball(intel, eMdf);
  }

  /**
  * The zap method.
  *
  * @param eMdf the enemy magic defence value.
  *
  * @return zapDmg the damage dealt.
  */
  public int zap(final int eMdf) {
    return super.zap(intel, eMdf);
  }

  /**
  * The frostblast method.
  *
  * @param eMdf the enemy magic defence value.
  *
  * @return frostDmg the damage dealt.
  */
  public int frostblast(final int eMdf) {
    return super.frostblast(intel, eMdf);
  }
}
