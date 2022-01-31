import java.util.Scanner;
import java.util.InputMismatchException;

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
  private final int startingHp = 50;

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
  * The newMp value is used for Mp checks.
  */
  private int newMp = mp;

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
    System.out.println("Slam(1): 1MP");
    System.out.println("Piercing Strike(2): 3MP");
    System.out.println("Frenzy(3): 4MP");
    System.out.println("Back(4)");
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
    int choice = 0;
    int skillAction = 0;
    int damage = 0;
    int act = 0;
    final Scanner userInput = new Scanner(System.in);
    while (act == 0) {
      actions();
      choice = 0;
      try {
        choice = userInput.nextInt();
        if (choice == choiceA) {
          damage = attack(eDef);
          act += 1;
          attackDamage(damage);
        } else if (choice == choiceB) {
          knightSkills();
          skillAction = userInput.nextInt();
          if (skillAction == choiceA) {
            if (checkMp(slamCost)) {
              damage = slam(eDef);
              act += 1;
              newMp -= slamCost;
              attackDamage(damage);
            } else {
              invalidMp();
            }
          } else if (skillAction == choiceB) {
            if (checkMp(piercestrikeCost)) {
              damage = piercingStrike();
              newMp -= piercestrikeCost;
              act += 1;
              attackDamage(damage);
            } else {
              invalidMp();
            }
          } else if (skillAction == choiceC) {
            if (checkMp(frenzyCost)) {
              frenzy();
              newMp -= frenzyCost;
              act += 1;
            } else {
              invalidMp();
            }
          } else if (skillAction == choiceD) {
            damage = knightAttack(eDef);
          }
        } else if (choice == choiceC) {
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
    final int damage = super.attack(str, eDef);
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
    final int damage = super.attack(str, (eDef - choiceC));
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
    super.help();
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
