import java.util.Scanner;

public class Knight extends Player {

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
  private final int startingHp = 60;

  /**
  * The base mp value.
  */
  private final int startingMp = 4;

  /**
  * The base str value.
  */
  private final int startingStr = 10;

  /**
  * The base value for def and mdf.
  */
  private final int startingBulk = 8;

  /**
  * The newMp value is used for Mp checks.
  */
  private int newMp;

  /**
  * The no arguements knight constructor.
  */
  public Knight() {
    lvl = 1;
    mdf = startingBulk;
    def = startingBulk;
    intel = 2;
    hp = startingHp;
    str = startingStr;
    mp = startingMp;
    newMp = startingMp;
  }

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
  * The value that hp increases by.
  */
  private final int hpUp = 8;

  /**
  * The actions method shows the basic actions.
  */
  public void actions() {
    super.actions();
  }

  /**
  * The knightSkills method shows the skills of knight class.
  */
  public void knightSkills() {
    System.out.println("\nSkills:");
    System.out.println("Slam(A): 1MP");
    System.out.println("Piercing Strike(S): 3MP");
    System.out.println("Frenzy(D): 4MP");
    System.out.println("Back(F)");
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
    final int showMp = newMp;
    System.out.println("\n" + enemyName + " HP: " + enemyHp);
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
  * The knightAttack method, used for when it's.
  * your turn using the knight class.
  *
  * @param eDef the enemy defence value.
  *
  * @return damage.
  */
  public int knightAttack(final int eDef) {
    tempDef = 0;
    String choice = "0";
    String skillAction = "0";
    int damage = 0;
    int act = 0;
    final Scanner userInput = new Scanner(System.in);
    while (act == 0) {
      actions();
      choice = "";
      choice = userInput.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("h")) {
        help();
      } else if (choice.equals("a")) {
        damage = attack(eDef);
        act += 1;
      } else if (choice.equals("s")) {
        knightSkills();
        skillAction = userInput.nextLine();
        skillAction = skillAction.toLowerCase();
        if (skillAction.equals("a")) {
          if (checkMp(slamCost)) {
            damage = slam(eDef);
            act += 1;
            newMp -= slamCost;
          } else {
            invalidMp();
          }
        } else if (skillAction.equals("s")) {
          if (checkMp(piercestrikeCost)) {
            damage = piercingStrike();
            newMp -= piercestrikeCost;
            act += 1;
          } else {
            invalidMp();
          }
        } else if (skillAction.equals("d")) {
          if (checkMp(frenzyCost)) {
            frenzy();
            newMp -= frenzyCost;
            act += 1;
          } else {
            invalidMp();
          }
        } else if (skillAction.equals("f")) {
          damage = 0;
        }
      } else if (choice.equals("d")) {
        System.out.println("You steeled yourself "
          + "for the opponent's attack.");
        tempDef += choiceC;
        act += 1;
      } else {
        System.out.println("That isn't a viable input.");
      }
    }
  if (damage >= 1) {
    attackDamage(damage);
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
  *
  * @return damage the damage dealt.
  */
  public int attack(final int eDef) {
    final int damage = super.attack(str, (eDef - 2));
    return damage;
  }

  /**
  * The slam method.
  *
  * @param eDef the enemy defence value.
  *
  * @return damage the damage dealt.
  */
  public int slam(final int eDef) {
    final int defense = eDef - choiceC;
    final int damage = super.attack(str, (defense - 1));
    return damage;
  }

  /**
  * The piercingStrike method.
  *
  * @return damage the damage dealt.
  */
  public int piercingStrike() {
    int damage = str;
    int extra = Math.round(str / 2);
    damage += extra;
    return damage;
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
    System.out.println("\nThe Knight uses strength for skills.");
    System.out.println("Skills:");
    System.out.println("    Slam: Attack the enemy, "
      + "negating a small amount of their defence while doing so.");
    System.out.println("    Piercing Strike: attack the enemy,"
      + " completely negating their defence.");
    System.out.println("    Frenzy: sacrifice some of "
      + "your defence in exchange for more strength.");
    System.out.println("\nTo view this again, input 'h'"
      + " when choosing your action.");
    System.out.println("Press enter to continue");
    String waiting = userInput.nextLine();
  }

  /**
  * The frenzy method keeps track of the number of times you use.
  * Frenzy during a battle.
  */
  public void frenzy() {
    str += strUp;
    def -= choiceD;
    mdf -= choiceD;
    frenzyCasts += 1;
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
    while (frenzyCasts != 0) {
      str -= strUp;
      def += choiceD;
      mdf += choiceD;
      frenzyCasts -= 1;
    }
    lvl += 1;
    str += strUp;
    mp += 1;
    hp += hpUp;
    def += 1;
    mdf += 1;
    newMp = mp;
    System.out.println("Levelup!");
    System.out.println("Your max HP increased by " + hpUp + "!");
    System.out.println("Your max MP increased by 1!");
    System.out.println("Your strength increased by " + strUp + "!");
    System.out.println("Your defence increased by 1!");
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
