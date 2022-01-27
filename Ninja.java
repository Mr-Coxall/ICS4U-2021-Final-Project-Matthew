import java.util.Scanner;
import java.util.InputMismatchException;

public class Ninja extends Character {

  /**
  * The starting hp value.
  */
  private final int hp = 40;

  /**
  * The starting mp value.
  */
  private final int mp = 8;

  /**
  * The starting str (strength) value.
  */
  private final int str = 8;

  /**
  * The starting intel (intelligence) value.
  */
  private final int intel = 8;

  /**
  * The starting def (defence) value.
  */
  private final int def = 6;

  /**
  * The starting mdf (magic defence) value.
  */
  private final int mdf = 6;

  /**
  * The starting level value.
  */
  private int lvl = 0;

  /**
  * The temporary defence value.
  */
  private int tempDef = 0;

  /**
  * The mp value used for skills.
  */
  private int currentMp = mp;

  /**
  * The prep value used for when you use the prepare skill.
  */
  private int prep = 0;

  /**
  * The Mp cost of multislash.
  */
  private final int multislashCost = 4;

  /**
  * The Mp cost of prepare.
  */
  private final int prepareCost = 2;

  /**
  * The Mp cost of animeCut.
  */
  private final int animeCost = 6;

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
  * The value that hp increases by.
  */
  private final int hpUp = 4;

  /**
  * The value that mp increases by.
  */
  private final int mpUp = 2;

  /**
  * The value that defence increases by.
  */
  private final int defUp = 1;

  /**
  * The value that damage increases by.
  */
  private final int damageUp = 2;

  /**
  * The attackDamage method tells you how much damage you dealt.
  *
  * @param damage the damage amount.
  */
  public void attackDamage(final int damage) {
    System.out.println("You attacked for " + damage + " damage!");
  }

  /**
  * The actions method shows the basic actions.
  */
  public void actions() {
    System.out.println("Attack(1)");
    System.out.println("Skills(2)");
    System.out.println("Defend(3)");
  }

  /**
  * The ninjaSkills method shows the skills of the ninja class.
  */
  public void ninjaSkills() {
    System.out.println("\nSkills:");
    System.out.println("Multislash: 4Mp");
    System.out.println("Prepare: 2Mp");
    System.out.println("Animecut: AllMp (minimum of 6Mp required)");
    System.out.println("Back(4)");
  }

  /**
  * The ninjaAttack method, used for when it's.
  * your turn using the ninja class.
  *
  * @param eDef the enemy defence value.
  * @param eHp the enemy's current hp value
  *
  * @return damage.
  */
  public int ninjaAttack(final int eDef, final int eHp) {
    tempDef = 0;
    final int powerUp = damageUp * lvl;
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
          damage = attack(eDef, (prep + powerUp));
          prep = 0;
          act += 1;
          attackDamage(damage);
        } else if (action == choiceB) {
          ninjaSkills();
          skillAction = userInput.nextInt();
          if (skillAction == choiceA) {
            if (checkMp(multislashCost)) {
              damage = multislash(eDef, (prep + powerUp));
              act += 1;
              currentMp -= multislashCost;
              attackDamage(damage);
              prep = 0;
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
              damage = animeCut(eHp);
              act += 1;
              currentMp = 0;
              attackDamage(damage);
            } else {
              invalidMp();
            }
          } else if (skillAction == choiceD) {
            damage = ninjaAttack(eDef, eHp);
          }
        } else if (action == choiceC) {
          System.out.println("You steeled yourself "
            + "for the opponent's attack.");
          tempDef += choiceC;
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
    return (mpCost <= currentMp);
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
  * @param buff the increase to damage.
  *
  * @return damage.
  */
  public int attack(final int eDef, final int buff) {
    final int physicalDamage = super.attack((str + buff), eDef);
    final int magicalDamage = super.attack((intel + buff), eDef);
    final int damage = physicalDamage + magicalDamage;
    return damage;
  }

  /**
  * The multislash method.
  *
  * @param eDef the enemy defence value.
  * @param buff the increase to damage.
  *
  * @return damage.
  */
  public int multislash(final int eDef, final int buff) {
    final int increase = buff * 2;
    final int damage = super.attack((str + intel + increase), eDef);
    return damage;
  }

  /**
  * The prepare method.
  */
  public void prepare() {
    prep += 1;
  }

  /**
  * The animeCut method.
  *
  * @param eHp the enemy's current Hp value.
  *
  * @return damage.
  */
  public int animeCut(final int eHp) {
    final int damage = Math.round(eHp / 3);
    return damage;
  }

  /**
  * The levelUp method.
  */
  public void levelUp() {
    lvl += 1;
    currentMp = mp + (mpUp * lvl);
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

  /**
  * The getDef method.
  *
  * @return def
  */
  public int getDef() {
    return (def + tempDef) + (defUp * lvl);
  }

  /**
  * The getMdf method.
  *
  * @return mdf
  */
  public int getMdf() {
    return mdf + (defUp * lvl);
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
  * @return currentMp
  */
  public int getMp() {
    return currentMp;
  }
}
