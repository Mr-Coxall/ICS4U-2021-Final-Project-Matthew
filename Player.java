import java.util.Scanner;
import java.util.InputMismatchException;

public class Player extends Character {

  /**
  * The starting hp value.
  */
  private final int hp = 30;

  /**
  * The starting mp value.
  */
  private final int mp = 6;

  /**
  * The starting str (strength) value.
  */
  private final int str = 5;

  /**
  * The starting intel (intelligence) value.
  */
  private final int intel = 4;

  /**
  * The starting def (defence) value.
  */
  private final int def = 2;

  /**
  * The starting mdf (magic defence) value.
  */
  private final int mdf = 2;

  /**
  * The starting level value.
  */
  private int lvl = 0;

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
  * The cost to use skills.
  */
  private final int spellCost = 2;

  /**
  * The temporary defence value.
  */
  private int tempDef = 0;

  /**
  * The mp value used for skills.
  */
  private int currentMp = mp;

  /**
  * The value that hp increases by.
  */
  private final int hpUp = 5;

  /**
  * The value that mp increases by.
  */
  private final int mpUp = 1;

  /**
  * The value that defence increases by.
  */
  private final int defUp = 1;

  /**
  * The value that strength increases by.
  */
  private final int strUp = 2;

  /**
  * The value that intelligence increases by.
  */
  private final int intUp = 1;

  /**
  * The actions method, used to show the basic actions.
  */
  public void actions() {
    System.out.println("Attack(1)");
    System.out.println("Skills(2)");
    System.out.println("Defend(3)");
  }

  /**
  * The skills menu, showing the starting class' skills.
  */
  public void skills() {
    System.out.println("\nSkills:");
    System.out.println("Fireball(1): 2Mp");
    System.out.println("Zap(2): 2Mp");
    System.out.println("Frostblast(3): 2Mp");
    System.out.println("Back(4)");
  }

  /**
  * The playerAttack method, used for when it's.
  * your turn using the basic class.
  *
  * @param eDef the enemy defence value.
  * @param eMdf the enemy magic defence value.
  * @param type the enemy type.
  *
  * @return damage.
  */
  public int playerAttack(final int eDef, final int eMdf,
    final String type) {
    tempDef = 0;
    final int intelligenceIncrease = intUp * lvl;
    final int strengthIncrease = strUp * lvl;
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
          skills();
          skillAction = userInput.nextInt();
          if (currentMp >= spellCost) {
            if (skillAction == choiceA) {
              damage = fireball(eMdf, type, intelligenceIncrease);
              act += 1;
              currentMp -= spellCost;
              attackDamage(damage);
            } else if (skillAction == choiceB) {
              damage = zap(eMdf, type, intelligenceIncrease);
              act += 1;
              currentMp -= spellCost;
              attackDamage(damage);
            } else if (skillAction == choiceC) {
              damage = frostblast(eMdf, type, intelligenceIncrease);
              act += 1;
              currentMp -= spellCost;
              attackDamage(damage);
            } else if (skillAction == choiceD) {
              damage = playerAttack(eDef, eMdf, type);
            }
          } else {
            invalidMp();
          }
        } else if (action == choiceC) {
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
  * The attackDamage method tells you how much damage you dealt.
  *
  * @param damage the damage amount.
  */
  public void attackDamage(final int damage) {
    System.out.println("You attacked for " + damage + " damage!");
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
  * @param strengthBuff the increase to strength based on level
  *
  * @return damage the damage dealt.
  */
  public int attack(final int eDef, final int strengthBuff) {
    final int damage = super.attack((str + strengthBuff), eDef) + lvl;
    return damage;
  }

  /**
  * The fireball method.
  *
  * @param eMdf the enemy magic defence value.
  * @param type the enemy's elemental type.
  * @param intBuff the increase to intelligence based on level
  *
  * @return fireDmg the damage dealt.
  */
  public int fireball(final int eMdf, final String type,
    final int intBuff) {
    int fireDmg = super.fireball((intel + intBuff), eMdf);
    if (type.equals("ice")) {
      fireDmg += choiceC;
    } else if (type.equals("lightning")) {
      fireDmg -= 2;
    }
    return fireDmg;
  }

  /**
  * The zap method.
  *
  * @param eMdf the enemy magic defence value.
  * @param type the enemy's elemental type.
  * @param intBuff the increase to intelligence based on level
  *
  * @return zapDmg the damage dealt.
  */
  public int zap(final int eMdf, final String type,
    final int intBuff) {
    int zapDmg = super.zap((intel + intBuff), eMdf);
    if (type.equals("fire")) {
      zapDmg = zapDmg * choiceC;
    } else if (type.equals("ice")) {
      zapDmg -= 2;
    }
    return zapDmg;
  }

  /**
  * The frostblast method.
  *
  * @param eMdf the enemy magic defence value.
  * @param type the enemy's elemental type.
  * @param intBuff the increase to intelligence based on level
  *
  * @return frostDmg the damage dealt.
  */
  public int frostblast(final int eMdf, final String type,
    final int intBuff) {
    int frostDmg = super.frostblast((intel + intBuff), eMdf);
    if (type.equals("lightning")) {
      frostDmg += choiceC;
    } else if (type.equals("fire")) {
      frostDmg -= 2;
    }
    return frostDmg;
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

  /**
  * The levelup method.
  */
  public void levelUp() {
    lvl += 1;
    currentMp = mp;
  }
}
