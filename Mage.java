import java.util.Scanner;
import java.util.InputMismatchException;

public class Mage extends Character {

  /**
  * The starting hp value.
  */
  private final int hp = 35;

  /**
  * The starting mp value.
  */
  private final int mp = 20;

  /**
  * The starting str (strength) value.
  */
  private final int str = 4;

  /**
  * The starting intel (intelligence) value.
  */
  private final int intel = 12;

  /**
  * The starting def (defence) value.
  */
  private final int def = 4;

  /**
  * The starting mdf (magic defence) value.
  */
  private final int mdf = 4;

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
  * The value used to check if skills can be.
  * used for mage (all skills cost 5 mp)
  */
  private final int spellCost = 5;

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
  private final int mpUp = 5;

  /**
  * The value that defence increases by.
  */
  private final int defUp = 1;

  /**
  * The value that intelligence increases by.
  */
  private final int intUp = 2;

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
    final int intelligenceUp = intUp * lvl;
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
              damage = inferno(eMdf, type, intelligenceUp);
              act += 1;
              currentMp -= spellCost;
              attackDamage(damage);
            } else if (skillAction == choiceB) {
              damage = thunder(eMdf, type, intelligenceUp);
              act += 1;
              currentMp -= spellCost;
              attackDamage(damage);
            } else if (skillAction == choiceC) {
              damage = icicleSpear(eMdf, type, intelligenceUp);
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
  * @param improvement the extra intelligence based on level.
  *
  * @return zapDmg the damage dealt.
  */
  public int thunder(final int eMdf, final String type,
    final int improvement) {
    int zapDmg = super.zap((intel + improvement), eMdf);
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
  * @param improvement the extra intelligence based on level.
  *
  * @return fireDmg the damage dealt.
  */
  public int inferno(final int eMdf, final String type,
    final int improvement) {
    int fireDmg = super.fireball((intel + choiceC + improvement), eMdf);
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
  * @param improvement the extra intelligence based on level.
  *
  * @return frostDmg the damage dealt.
  */
  public int icicleSpear(final int eMdf, final String type,
    final int improvement) {
    int frostDmg = super.frostblast((intel + choiceB + improvement),
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
