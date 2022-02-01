import java.util.Scanner;

public class Ninja extends Player {

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
  private final int startingHp = 55;

  /**
  * The base offensive (str, intel, mp) value.
  */
  private final int startingOffensive = 9;

  /**
  * The base defensive (def, mdf) value.
  */
  private final int startingDefensive = 6;

  /**
  * The mp value used for skills.
  */
  private int currentMp;

  /**
  * The no arguements ninja constructor.
  */
  public Ninja() {
    lvl = 1;
    mdf = startingDefensive;
    def = startingDefensive;
    intel = startingOffensive;
    str = startingOffensive;
    mp = (startingOffensive - 1);
    hp = startingHp;
    currentMp = (startingOffensive - 1);
  }

  /**
  * The temporary defence value.
  */
  private int tempDef = 0;

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
    System.out.println("\n" + enemyName + " HP: " + enemyHp);
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
  * The ninjaSkills method shows the skills of the ninja class.
  */
  public void ninjaSkills() {
    System.out.println("\nSkills:");
    System.out.println("Multislash(A): 4Mp");
    System.out.println("Prepare(S): 2Mp");
    System.out.println("Animecut(D): AllMp (minimum of 6Mp required)");
    System.out.println("Back(F)");
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
    String choice = "0";
    String skillAction = "0";
    int damage = 0;
    int act = 0;
    int skillAct = 0;
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
        skillAct = 0;
        while (skillAct == 0) {
          ninjaSkills();
          skillAction = userInput.nextLine();
          skillAction = skillAction.toLowerCase();
          if (skillAction.equals("a")) {
            if (checkMp(multislashCost)) {
              damage = multislash(eDef);
              act += 1;
              currentMp -= multislashCost;
              skillAct += 1;
            } else {
              invalidMp();
            }
          } else if (skillAction.equals("s")) {
            if (checkMp(prepareCost)) {
              prepare();
              currentMp -= prepareCost;
              act += 1;
              skillAct += 1;
            } else {
              invalidMp();
            }
          } else if (skillAction.equals("d")) {
            if (checkMp(animeCost)) {
              damage = animeCut(eHp);
              act += 1;
              currentMp = 0;
              skillAct += 1;
            } else {
              invalidMp();
            }
          } else if (skillAction.equals("f")) {
            damage = 0;
            skillAct += 1;
          } else {
            System.out.println("That is not a valid input.");
          }
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
    return (mpCost <= currentMp);
  }

  /**
  * The invalidMp method tells you when you don't have enough Mp.
  */
  public void invalidMp() {
    System.out.println("Not enough Mp!");
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
    System.out.println("Prepare: Increases strength and "
      + "magic slightly for one attack.");
    System.out.println("Multislash: A flurry of strikes,"
      + " dealing massive damage.");
    System.out.println("Animecut: The anime sword strike, "
      + "sacrificing all your MP in exchange for huge damage.");
    System.out.println("\nTo view this again, input 'h'"
      + " when choosing your action.");
    System.out.println("Press enter to continue");
    String waiting = userInput.nextLine();
  }

  /**
  * The attack method.
  *
  * @param eDef the enemy defence value.
  *
  * @return damage.
  */
  public int attack(final int eDef) {
    final int physicalDamage = super.attack(str, eDef);
    final int magicalDamage = super.attack(intel, eDef);
    final int damage = physicalDamage + magicalDamage;
    return damage;
  }

  /**
  * The multislash method.
  *
  * @param eDef the enemy defence value.
  *
  * @return damage.
  */
  public int multislash(final int eDef) {
    final int damage = super.attack((str + intel), eDef);
    return (damage + choiceD);
  }

  /**
  * The prepare method.
  */
  public void prepare() {
    prep += 1;
    str += 1;
    intel += 1;
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
    while (prep != 0) {
      str -= 1;
      intel -= 1;
      prep -= 1;
    }
    lvl += 1;
    str += 2;
    intel += 2;
    mp += 2;
    hp += hpUp;
    def += 1;
    mdf += 1;
    currentMp = mp;
    System.out.println("Level up!");
    System.out.println("Your max HP increased by " + hpUp + "!");
    System.out.println("Your max MP increased by 2!");
    System.out.println("Your strength increased by 2!");
    System.out.println("Your magic increased by 2!");
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
