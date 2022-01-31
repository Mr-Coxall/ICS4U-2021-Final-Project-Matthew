import java.util.Scanner;
import java.util.InputMismatchException;

public class Actions {

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
  * The help method, used to show the help menu.
  */
  public void help() {
    final Scanner userInput = new Scanner(System.in);
    System.out.println("Help:");
    System.out.println("Attack: deal damage up to half your strength "
      + "plus your strength minus enemy defence.");
    System.out.println("Skills: Fireball: deal fire damage equal to "
      + "half your intelligence plus intelligence "
      + "minus enemy magic defence.");
    System.out.println("Skills: Zap: Same formula as "
      + "Fireball, but deals lightning damage.");
    System.out.println("Skills: Frostblast: Same as Fireball,"
      + " but deals frost damage.");
    System.out.println("Defend: Increases defence by "
      + "3 for one enemy attack.");
    System.out.println("Elemental damage: Fire damage deals extra to "
      + "frost enemies, lightning deals extra "
      + "to fire, and frost does extra to lightning.");
    System.out.println("Press enter to continue");
    String waiting = userInput.nextLine();
  }

  /**
  * The reminder method, used when choosing the mage advanced class.
  */
  public void reminder() {
    System.out.println("Remember, Fire is strong against ice, "
      + "ice is strong against lightning, and lightning is strong "
      + "against fire.");
  }

  /**
  * The attacking method, used for the basic class' attack menu.
  *
  * @return action choice.
  */
  public int attacking() {
    int action = 0;
    final Scanner userInput = new Scanner(System.in);
    int input = 0;
    try {
      input = userInput.nextInt();
      if (input <= 0 || input >= choiceD) {
        System.out.println("That is not a viable input"
          + " (must be 1, 2, or 3).");
      } else if (input == choiceA) {
        action = choiceA;
      } else if (input == choiceB) {
        action = choiceB;
      } else {
        action = choiceC;
      }
    } catch (InputMismatchException errorCode) {
      System.out.println("That is not a viable input.");
    }
    return action;
  }

  /**
  * The skillAction method, used for the basic class' skill menu.
  *
  * @return skill choice.
  */
  public int skillAction() {
    int action = 0;
    final Scanner userInput = new Scanner(System.in);
    int skillInput = 0;
    try {
      skillInput = userInput.nextInt();
      if (skillInput <= 0 || skillInput > choiceD) {
        System.out.println("That is not a viable input"
          + " (must be 1, 2, 3, or 4).");
      } else if (skillInput == choiceA) {
        action = choiceA;
      } else if (skillInput == choiceB) {
        action = choiceB;
      } else if (skillInput == choiceC) {
        action = choiceC;
      }
    } catch (InputMismatchException errorCode) {
      System.out.println("That is not a viable input.");
    }
    return action;
  }

  /**
  * The classKnight method, used for showing.
  * The basic info about the knight class.
  */
  public void classKnight() {
    System.out.println("Knight");
    System.out.println("High strength and defence, "
      + "low mp and intelligence.");
    System.out.println("Skills:");
    System.out.println("Slam: Attack the enemy, "
      + "negating a small amount of their defence while doing so.");
    System.out.println("Piercing Strike: attack the enemy, completely "
      + "negating their defence.");
    System.out.println("Frenzy: sacrifice some of "
      + "your defence in exchange for more strength.");
  }

  /**
  * The classMage method, used for showing.
  * The basic info about the mage class.
  */
  public void classMage() {
    System.out.println("Mage");
    System.out.println("High intelligence and MP, low strength and defence.");
    System.out.println("Skills:");
    System.out.println("Inferno: Burn the enemy, dealing high fire damage.");
    System.out.println("Thunder: Strike from the heavens, "
      + "dealing mass lightning damage.");
    System.out.println("Icicle Spear: Throw a spear of pure ice "
      + "at the enemy, dealing large ice damage "
      + "that negates a bit of their defences.");
  }

  /**
  * The classNinja method, used for showing.
  * The basic info about the ninja class.
  */
  public void classNinja() {
    System.out.println("Ninja");
    System.out.println("Balanced in all stats, uses both "
      + "strength and intelligence for basic attack.");
    System.out.println("Skills:");
    System.out.println("Prepare: Increases strength and "
      + "intelligence slightly for one attack.");
    System.out.println("Multislash: A flurry of strikes,"
      + " dealing massive damage.");
    System.out.println("Animecut: The anime sword strike, "
      + "sacrificing all your MP in exchange for huge damage.");
  }

  /**
  * The class change method, used for changing to one of the advanced classes.
  *
  * @return class value.
  */
  public int classChange() {
    final Scanner userInput = new Scanner(System.in);
    int classChoice = 0;
    int classInput = 0;
    System.out.println("Time to choose an advanced class! "
      + "(Warning: this decision cannot be changed later.)");
    System.out.println("Knight(1)");
    System.out.println("Mage(2)");
    System.out.println("Ninja(3)");
    while (classChoice == 0) {
      try {
        classInput = userInput.nextInt();
        if (classInput <= 0 || classInput >= choiceD) {
          System.out.println("That is not a viable input"
            + " (must be 1, 2, or 3).");
        } else if (classInput == choiceA) {
          classKnight();
        } else if (classInput == choiceB) {
          classMage();
          reminder();
        } else if (classInput == choiceC) {
          classNinja();
        }
      } catch (InputMismatchException errorCode) {
        System.out.println("That is not a viable input.");
      }
      if (classInput <= choiceC && classInput >= choiceA) {
        System.out.println("Confirm (1/0)");
        try {
          int confirm = userInput.nextInt();
          if (confirm == choiceA) {
            classChoice = classInput;
          } else if (confirm == 0) {
            classChoice = classChange();
          } else {
            System.out.println("That is not a valid input");
            classChoice = 0;
          }
        } catch (InputMismatchException errorCode) {
          System.out.println("That is not a viable input.");
        }
      }
    }
    return classChoice;
  }
}
