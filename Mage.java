import java.util.Scanner;
import java.util.InputMismatchException;

public class Mage extends Player {

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
    System.out.println("You dealt " + damage + " damage!");
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
  * The actions method shows the basic actions.
  */
  public void actions() {
    super.actions();
  }

  /**
  * The mageSkills method shows the skills of the mage class.
  */
  public void mageSkills() {
    System.out.println("\nSkills:");
    System.out.println("Inferno(A): 5Mp");
    System.out.println("Thunder(S): 5Mp");
    System.out.println("Icicle Spear(D): 5Mp");
    System.out.println("Back(F)");
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
          mageSkills();
          skillAction = userInput.nextLine();
          skillAction = skillAction.toLowerCase();
          if (currentMp >= spellCost) {
            if (skillAction.equals("a")) {
              damage = inferno(eMdf, type);
              act += 1;
              currentMp -= spellCost;
              attackDamage(damage);
            } else if (skillAction.equals("s")) {
              damage = thunder(eMdf, type);
              act += 1;
              currentMp -= spellCost;
              attackDamage(damage);
            } else if (skillAction.equals("d")) {
              damage = icicleSpear(eMdf, type);
              act += 1;
              currentMp -= spellCost;
              attackDamage(damage);
            } else if (skillAction.equals("f")) {
              damage = mageAttack(eDef, eMdf, type);
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
    System.out.println("Levelup!");
    System.out.println("Your max HP increased by " + choiceC + "!");
    System.out.println("Your max MP increased by " + mpUp + "!");
    System.out.println("Your magic increased by 2!");
    System.out.println("Your defence increased by 1!");
  }

  /**
  * The help method.
  */
  public void help() {
    final Scanner userInput = new Scanner(System.in);
    System.out.println("HP (health points): how much damage you can take"
      + " before losing.");
    System.out.println("MP (mana points): spent when activating skills, "
      + "regained after killing a monster.");
    System.out.println("Strength: used when dealing damage"
      + " through you physically touching the enemy.");
    System.out.println("Magic: used when dealing damage with"
      + " any sort of special created object.");
    System.out.println("\nAll monsters will have 1 of 4 types: "
      + "fire, frost, lightning, or neutral.");
    System.out.println("Based on the type of the monster, "
      + "they will take more or less damage from certain skills.");
    System.out.println("Elemental damage: Fire damage deals extra to "
      + "frost enemies, frost deals extra "
      + "to lightning, and lightning does extra to fire.");
    System.out.println("Hint: The name of the monster gives "
      + "info on their type.");
    System.out.println("\nSkills:");
    System.out.println("Inferno: Incinerate the enemy, dealing large"
      + " fire damage.");
    System.out.println("Thunder: Call upon the storm gods,"
      + " dealing large lightning damage.");
    System.out.println("Icicle Spear: Throw a spear of pure ice "
      + "at the enemy, dealing large ice damage "
      + "that negates a bit of their defences.");
    System.out.println("\nTo view this again, input 'h'"
      + " when choosing your action.");
    System.out.println("Press enter to continue");
    String waiting = userInput.nextLine();
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
