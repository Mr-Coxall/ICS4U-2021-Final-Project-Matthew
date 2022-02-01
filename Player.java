import java.util.Scanner;
import java.util.InputMismatchException;

public class Player extends Character {

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
  * The base hp value.
  */
  private final int startingHp = 30;

  /**
  * The base mp value.
  */
  private final int startingMp = 6;

  /**
  * The base str value.
  */
  private final int startingStr = 5;

  /**
  * The base intel value.
  */
  private final int startingIntel = 4;

  /**
  * The mp value used for skills.
  */
  private int currentMp;

  /**
  * The no arguements player constructor.
  */
  public Player() {
    lvl = 1;
    mdf = 2;
    def = 2;
    intel = startingIntel;
    str = startingStr;
    mp = startingMp;
    currentMp = startingMp;
    hp = startingHp;
  }

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
  * The value that hp increases by.
  */
  private final int hpUp = 5;

  /**
  * The actions method, used to show the basic actions.
  */
  public void actions() {
    System.out.println("Attack(A)");
    System.out.println("Skills(S)");
    System.out.println("Defend(D)");
    System.out.println("Your turn: ");
  }

  /**
  * The skills menu, showing the starting class' skills.
  */
  public void skills() {
    System.out.println("\nSkills:");
    System.out.println("Fireball(A): 2MP");
    System.out.println("Zap(S): 2MP");
    System.out.println("Frostblast(D): 2MP");
    System.out.println("Back(F)");
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
    String choice = "0";
    String skillAction = "0";
    int damage = 0;
    int act = 0;
    final Scanner userInput = new Scanner(System.in);
    while (act == 0) {
      actions();
      choice = "";
      try {
        choice = userInput.nextLine();
        choice = choice.toLowerCase();
        if (choice.equals("h")) {
          help();
        } else if (choice.equals("a")) {
          damage = attack(eDef);
          act += 1;
          attackDamage(damage);
        } else if (choice.equals("s")) {
          skills();
          skillAction = userInput.nextLine();
          skillAction = skillAction.toLowerCase();
          if (currentMp >= spellCost) {
            if (skillAction.equals("a")) {
              damage = fireball(eMdf, type);
              act += 1;
              currentMp -= spellCost;
              attackDamage(damage);
            } else if (skillAction.equals("s")) {
              damage = zap(eMdf, type);
              act += 1;
              currentMp -= spellCost;
              attackDamage(damage);
            } else if (skillAction.equals("d")) {
              damage = frostblast(eMdf, type);
              act += 1;
              currentMp -= spellCost;
              attackDamage(damage);
            } else if (skillAction.equals("f")) {
              damage = playerAttack(eDef, eMdf, type);
            }
          } else {
            invalidMp();
          }
        } else if (choice.equals("d")) {
          tempDef += choiceC;
          act += 1;
        } else {
          System.out.println("That isn't a viable input.");
        }
      } catch (InputMismatchException errorCode) {
        System.out.println("That is not a valid input.");
      }
    }
    return damage;
  }

  /**
  * The showHp method.
  *
  * @param enemyName the enemy name
  * @param enemyHp the enemy hp value.
  * @param playerHp the player's hp
  */
  public void showHp(final String enemyName, final int enemyHp,
    final int playerHp) {
    final int showMp = currentMp;
    System.out.println(enemyName + " HP: " + enemyHp);
    System.out.println("\nPlayer HP: " + playerHp);
    System.out.println("Player MP: " + showMp);
    System.out.println("Player strength: " + str);
    System.out.println("Player magic: " + intel);
    System.out.println("Player defence: " + def);
  }

  /**
  * The attackDamage method tells you how much damage you dealt.
  *
  * @param damage the damage amount.
  */
  public void attackDamage(final int damage) {
    System.out.println("You dealt " + damage + " damage!");
  }

  /**
  * The invalidMp method tells you when you don't have enough Mp.
  */
  public void invalidMp() {
    System.out.println("Not enough MP!");
  }

  /**
  * The attack method.
  *
  * @param eDef the enemy defence value.
  *
  * @return damage the damage dealt.
  */
  public int attack(final int eDef) {
    final int damage = super.attack(str, eDef) + lvl;
    return damage;
  }

  /**
  * The help method.
  */
  public void help() {
    super.help();
  }

  /**
  * The fireball method.
  *
  * @param eMdf the enemy magic defence value.
  * @param type the enemy's elemental type.
  *
  * @return fireDmg the damage dealt.
  */
  public int fireball(final int eMdf, final String type) {
    int fireDmg = super.fireball(intel, eMdf);
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
  *
  * @return zapDmg the damage dealt.
  */
  public int zap(final int eMdf, final String type) {
    int zapDmg = super.zap(intel, eMdf);
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
  *
  * @return frostDmg the damage dealt.
  */
  public int frostblast(final int eMdf, final String type) {
    int frostDmg = super.frostblast(intel, eMdf);
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

  /**
  * The levelup method.
  */
  public void levelUp() {
    lvl += 1;
    mp += 1;
    str += 2;
    intel += 1;
    def += 1;
    mdf += 1;
    hp += hpUp;
    currentMp = mp;
    System.out.println("Levelup!");
    System.out.println("Your max HP increased by " + hpUp + "!");
    System.out.println("Your max MP increased by 1!");
    System.out.println("Your strength increased by 2!");
    System.out.println("Your magic increased by 1!");
    System.out.println("Your defence increased by 1!");
  }
}
