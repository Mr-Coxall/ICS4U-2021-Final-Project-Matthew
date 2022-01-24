import java.util.Scanner;
import java.util.InputMismatchException;

public class Actions {

  public void actions() {
    System.out.println("Attack(1)");
    System.out.println("Skills(2)");
    System.out.println("Defend(3)");
  }

  public void skills() {
    System.out.println("\nSkills:");
    System.out.println("Fireball(1): 2Mp");
    System.out.println("Zap(2): 2Mp");
    System.out.println("Frostblast(3): 2Mp");
    System.out.println("Back(4)");
  }

  public void knightSkills() {
    System.out.println("\nSkills:");
    System.out.println("Slam(1): 1Mp");
    System.out.println("Piercing Strike(2): 2Mp");
    System.out.println("Frenzy(3): 4Mp");
    System.out.println("Back(4)");
  }

  public void mageSkills() {
    System.out.println("\nSkills:");
    System.out.println("Inferno(1): 5Mp");
    System.out.println("Thunder(2): 5Mp");
    System.out.println("Icicle Spear(3): 5Mp");
    System.out.println("Back(4)");
  }

  public void ninjaSkills() {
    System.out.println("\nSkills:");
    System.out.println("Multislash: 4Mp");
    System.out.println("Slash: 2Mp");
    System.out.println("Evade: 2Mp");
    System.out.println("Back(4)");
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
}
