import java.util.Random;
import java.util.Scanner;

public abstract class Character {

  /**
  * The attack method.
  *
  * @param strength the character strength value.
  * @param eDef the enemy defence value.
  *
  * @return damage the damage dealt.
  */
  public int attack(final int strength, final int eDef) {
    final Random random = new Random();
    int range = strength - eDef;
    int damage = 1;
    if (range <= 0) {
      damage = 1;
    } else {
      damage = random.nextInt(range) + Math.round(strength / 2);
    }
    return damage;
  }

  /**
  * The fireball method.
  *
  * @param intelligence the character intelligence value.
  * @param eMdf the enemy magic defence value.
  *
  * @return fireDmg the damage dealt.
  */
  public int fireball(final int intelligence, final int eMdf) {
    final Random fireRand = new Random();
    final int range = intelligence - eMdf;
    int fireDmg = 0;
    if (range <= 0) {
      fireDmg = 1;
    } else {
      fireDmg = fireRand.nextInt(range) + Math.round(intelligence / 2);
    }
    return fireDmg;
  }

  /**
  * The zap method.
  *
  * @param intelligence the character intelligence value.
  * @param eMdf the enemy magic defence value.
  *
  * @return zapDmg the damage dealt.
  */
  public int zap(final int intelligence, final int eMdf) {
    final Random zapRand = new Random();
    final int range = intelligence - eMdf;
    int zapDmg = 0;
    if (range <= 0) {
      zapDmg = 1;
    } else {
      zapDmg = zapRand.nextInt(range) + 2;
    }
    return zapDmg;
  }

  /**
  * The frostblast method.
  *
  * @param intelligence the character intelligence value.
  * @param eMdf the enemy magic defence value.
  *
  * @return frostDmg the damage dealt.
  */
  public int frostblast(final int intelligence, final int eMdf) {
    final Random frostRand = new Random();
    int frostDmg = 0;
    final int range = intelligence - eMdf;
    if (range <= 0) {
      frostDmg = 1;
    } else {
      frostDmg = frostRand.nextInt(range) + Math.round(intelligence / 2);
    }
    return frostDmg;
  }

  /**
  * The help method, used to show the help menu.
  */
  public void help() {
    final Scanner userInput = new Scanner(System.in);
    System.out.println("Help:");
    System.out.println("\nAttack: physical damage to the enemy.");
    System.out.println("Skills: Fireball: deal fire damage to the enemy."
      + " Most skills use your intelligence stat for damage.");
    System.out.println("Skills: Zap: Deals lightning damage.");
    System.out.println("Skills: Frostblast: Deals frost damage.");
    System.out.println("Defend: Increases defence by "
      + "3 for one enemy attack.");
    System.out.println("\nAll monsters will have 1 of 4 types: "
      + "fire, frost, lightning, or neutral.");
    System.out.println("Based on the type of the monster, "
      + "they will take more or less damage from certain skills.");
    System.out.println("Elemental damage: Fire damage deals extra to "
      + "frost enemies, frost deals extra "
      + "to lightning, and lightning does extra to fire.");
    System.out.println("Hint: The name of the monster gives "
      + "info on their type.");
    System.out.println("To view this again, input 'h'"
      + " when choosing your action.");
    System.out.println("Press enter to continue");
    String waiting = userInput.nextLine();
  }
}
