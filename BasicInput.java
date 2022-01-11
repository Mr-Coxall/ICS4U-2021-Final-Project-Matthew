import java.util.Scanner;
import java.util.InputMismatchException;

final class BasicInput {

  /**
  * Prevent instantiation
  * Throw an exception IllegalStateException.
  * if this ever is called
  *
  * @throws IllegalStateException
  *
  */
  private BasicInput() {
    throw new IllegalStateException("Cannot be initiated.");
  }

  /**
  * The starting main() function.
  *
  * @param args Name of file containing a
  string of numbers.
  */
  public static void main(final String[] args) {
    final Scanner userInput = new Scanner(System.in);
    System.out.println("Input 1, 2, or 3: ");
    try {
        final int input = userInput.nextInt();
        if (input <= 0 || input >= 4) {
            System.out.println("That is not a viable input (must be 1, 2, or 3).");
        }
        else {
            System.out.println("You inputed " + input + ".");
        }
    }
    catch (InputMismatchException errorCode) {
        System.out.println("That is not a viable input.");
    }
    System.out.println("\nDone.");
}
}
