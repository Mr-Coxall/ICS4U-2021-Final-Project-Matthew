import java.util.Scanner;
import java.util.InputMismatchException;

public class Actions {

  public void actions() {
    System.out.println("Attack(1)");
    System.out.println("Skills(2)");
    System.out.println("Defend(3)");
  }

  public void help() {
    final Scanner userInput = new Scanner(System.in);
    System.out.println("Help:");
    System.out.println("Attack: deal damage up to half your strength plus your strength minus enemy defence.");
    System.out.println("Skills: Fireball: deal fire damage equal to "
      + "half your intelligence plus intelligence "
      + "minus enemy magic defence.");
    System.out.println("Skills: Zap: Same formula as "
      + "Fireball, but deals lightning damage.");
    System.out.println("Skills: Frostblast: Same as Fireball,"
      + " but deals frost damage.");
    System.out.println("Defend:Increases defence by 3 for one enemy attack.");
    System.out.println("Elemental damage: Fire damage deals extra to"
      + " frost enemies, lightning deals extra "
      + "to fire, and frost does extra to lightning.");
    System.out.println("Press enter to continue");
    String waiting = userInput.nextLine();
  }

  public int attacking() {
    int action = 0;
    final Scanner userInput = new Scanner(System.in);
    int input = 0;
    try {
      input = userInput.nextInt();
      if (input <= 0 || input >= 4) {
        System.out.println("That is not a viable input"
          + " (must be 1, 2, or 3).");
      }
      else if (input == 1) {
        action = 1;
      }
      else if (input == 2) {
        action = 2;
      }
      else {
        action = 3;
      }
    }
    catch (InputMismatchException errorCode) {
      System.out.println("That is not a viable input.");
    }
    return action;
  }

  public int skillAction() {
    int action = 0;
    final Scanner userInput = new Scanner(System.in);
    int skillInput = 0;
    try {
      skillInput = userInput.nextInt();
      if (skillInput <= 0 || skillInput >= 5) {
        System.out.println("That is not a viable input"
          + " (must be 1, 2, 3, or 4).");
      }
      else if (skillInput == 1) {
        action = 1;
      }
      else if (skillInput == 2) {
        action = 2;
      }
      else if (skillInput == 3) {
        action = 3;
      }
    }
    catch (InputMismatchException errorCode) {
      System.out.println("That is not a viable input.");
    }
    return action;
  }

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

  public void classMage() {
    System.out.println("Mage");
    System.out.println("High intelligence and MP, low strength and defence.");
    System.out.println("Skills:");
    System.out.println("Inferno: Burn the enemy, dealing high fire damage.");
    System.out.println("Thunder: Strike from the heavens, "
      + "dealing mass lightning damage.");
    System.out.println("Icicle Spear: Throw a spear of pure ice at the enemy," + " dealing large ice damage that negates a bit of their defences.");
  }

  public void classNinja() {
    System.out.println("Ninja");
    System.out.println("Balanced in all stats, uses both "
      + "strength and intelligence for basic attack.");
    System.out.println("Skills:");
    System.out.println("Prepare: Increases strength and "
      + "intelligence for one attack.");
    System.out.println("Multislash: A flurry of strikes,"
      + " dealing massive damage.");
    System.out.println("Animecut: The anime sword strike, "
      + "sacrificing all your MP in exchange for huge damage.");
  }

  public int classChange() {
    final Scanner userInput = new Scanner(System.in);
    int classChoice = 0;
    int classInput = 0;
    int choice = 0;
    System.out.println("Knight(1)");
    System.out.println("Mage(2)");
    System.out.println("Ninja(3)");
    while (classChoice == 0) {
      choice = 0;
      try {
        classInput = userInput.nextInt();
        if (classInput <= 0 || classInput >= 4) {
          System.out.println("That is not a viable input"
            + " (must be 1, 2, or 3).");
          choice = 1;
        }
        else if (classInput == 1) {
          classChoice = 1;
          classKnight();
        }
        else if (classInput == 2) {
          classChoice = 2;
          classMage();
        }
        else if (classInput == 3) {
          classChoice = 3;
          classNinja();
        }
      }
      catch (InputMismatchException errorCode) {
        System.out.println("That is not a viable input.");
      }
      if (choice == 0) {
        System.out.println("Confirm (1/0)");
        try {
          int confirm = userInput.nextInt();
          if (confirm == 1) {
            choice = classChoice;
          }
          else if (confirm == 0) {
            classChoice = 0;
          }
          else {
            System.out.println("That is not a valid input");
            classChoice = 0;
          }
        }
        catch (InputMismatchException errorCode) {
          System.out.println("That is not a viable input.");
        }
      }
    }
    return choice;
  }
}
