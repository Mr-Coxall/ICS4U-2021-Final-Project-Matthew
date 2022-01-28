import java.util.Scanner;
import java.util.InputMismatchException;

public class Mage extends Character {

  /**
  * The starting hp value.
  */
  private int hp;

  /**
  * The starting mp value.
  */
  private int mp;

  /**
  * The starting str (strength) value.
  */
  private int str;

  /**
  * The starting intel (intelligence) value.
  */
  private int intel;

  /**
  * The starting def (defence) value.
  */
  private int def;

  /**
  * The starting mdf (magic defence) value.
  */
  private int mdf;

  /**
  * The starting level value.
  */
  private int lvl;

  /**
  * The value used to check if skills can be.
  * used for mage (all skills cost 5 mp)
  */
  private final int spellCost = 5;

  /**
  * The base hp value.
  */
  private final int startingHp = 35;

  /**
  * The base mp value.
  */
  private final int startingMp = 20;

  /**
  * The base intel value.
  */
  private final int startingIntel = 12;

  /**
  * The base value for str, def, and mdf.
  */
  private final int startingBulk = 4;

  /**
  * The no arguements mage constructor.
  */
  public Mage() {
    lvl = 1;
    mdf = startingBulk;
    def = startingBulk;
    intel = startingIntel;
    hp = startingHp;
    str = startingBulk;
    mp = startingMp;
  }

  /**
  * The temporary defence value.
  */
  private int tempDef = 0;

  /**
  * The mp value used for skills.
  */
  private int currentMp = mp;

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
  * Value that mp goes up by each levelup.
  */
  private final int mpUp = 5;

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
  * The mageSkills method shows the skills of the mage class.
  */
  public void mageSkills() {
    System.out.println("\nSkills:");
    System.out.println("Inferno(1): 5Mp");
    System.out.println("Thunder(2): 5Mp");
    System.out.println("Icicle Spear(3): 5Mp");
    System.out.println("Back(4)");
  }

  /**
  * The mageAttack method, used for when it's.
  * your turn using the mage class.
  *
  * @param eDef the enemy defence value.
  * @param eMdf the enemy magic defence value.
  * @param type the enemy type.
  *
  * @return damage.
  */
  public int mageAttack(final int eDef, final int eMdf,
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
          damage = attack(eDef);
          act += 1;
          attackDamage(damage);
        } else if (action == choiceB) {
          mageSkills();
          skillAction = userInput.nextInt();
          if (currentMp >= spellCost) {
            if (skillAction == choiceA) {
              damage = inferno(eMdf, type);
              act += 1;
              currentMp -= spellCost;
              attackDamage(damage);
            } else if (skillAction == choiceB) {
              damage = thunder(eMdf, type);
              act += 1;
              currentMp -= spellCost;
              attackDamage(damage);
            } else if (skillAction == choiceC) {
              damage = icicleSpear(eMdf, type);
              act += 1;
              currentMp -= spellCost;
              attackDamage(damage);
            } else if (skillAction == choiceD) {
              damage = mageAttack(eDef, eMdf, type);
            }
          } else {
            invalidMp();
          }
        } else if (action == choiceC) {
          tempDef += choiceC;
          act += 1;
          System.out.println("You steeled yourself "
            + "for the opponent's attack.");
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
  * The invalidMp method tells you when you don't have enough Mp.
  */
  public void invalidMp() {
    System.out.println("Not enough Mp!");
  }

  /**
  * The attack method.
  *
  * @param eDef the enemy defence value.
  *
  * @return damage the damage dealt.
  */
  public int attack(final int eDef) {
    final int damage = super.attack(str, eDef);
    return damage;
  }

  /**
  * The thunder method.
  *
  * @param eMdf the enemy magic defence value.
  * @param type the enemy type.
  *
  * @return zapDmg the damage dealt.
  */
  public int thunder(final int eMdf, final String type) {
    int zapDmg = super.zap(intel, eMdf);
    if (type.equals("fire")) {
      zapDmg = zapDmg * choiceC;
    } else if (type.equals("lightning")) {
      zapDmg = 1;
    }
    return (zapDmg + choiceC);
  }

  /**
  * The inferno method.
  *
  * @param eMdf the enemy magic defence value.
  * @param type the enemy type.
  *
  * @return fireDmg the damage dealt.
  */
  public int inferno(final int eMdf, final String type) {
    int fireDmg = super.fireball((intel + choiceC), eMdf);
    if (type.equals("ice")) {
      fireDmg += choiceC;
    } else if (type.equals("lightning")) {
      fireDmg -= choiceB;
    }
    return fireDmg;
  }

  /**
  * The icicleSpear method.
  *
  * @param eMdf the enemy magic defence value.
  * @param type the enemy type.
  *
  * @return frostDmg the damage dealt.
  */
  public int icicleSpear(final int eMdf, final String type) {
    int frostDmg = super.frostblast((intel + choiceB),
      (eMdf - choiceA));
    if (type.equals("lightning")) {
      frostDmg += choiceC;
    } else if (type.equals("fire")) {
      frostDmg -= choiceB;
    }
    return frostDmg;
  }

  /**
  * The levelUp method.
  */
  public void levelUp() {
    lvl += 1;
    mp += mpUp;
    intel += 2;
    def += 1;
    mdf += 1;
    hp += choiceC;
    currentMp = mp;
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
    return (def + tempDef);
  }

  /**
  * The getMdf method.
  *
  * @return mdf
  */
  public int getMdf() {
    return mdf;
  }

  /**
  * The getHp method.
  *
  * @return hp
  */
  public int getHp() {
    return hp;
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
