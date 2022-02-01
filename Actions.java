import java.util.Scanner;

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
  * The Knight's starting strength.
  */
  private final int knightStr = 10;

  /**
  * The Knight's starting defence.
  */
  private final int knightDef = 8;

  /**
  * The Knight's starting health.
  */
  private final int knightHp = 50;

  /**
  * The Knight's starting mp.
  */
  private final int knightMp = 4;

  /**
  * The Knight's starting intelligence.
  */
  private final int knightInt = 2;

  /**
  * The Mage's starting intelligence.
  */
  private final int mageInt = 12;

  /**
  * The Mage's starting strength.
  */
  private final int mageStr = 4;

  /**
  * The Mage's starting defence.
  */
  private final int mageDef = 4;

  /**
  * The Mage's starting health.
  */
  private final int mageHp = 35;

  /**
  * The Mage's starting intelligence.
  */
  private final int mageMp = 20;

  /**
  * The ninja's starting health.
  */
  private final int ninjaHp = 40;

  /**
  * The ninja's starting offensive values.
  */
  private final int ninjaOffense = 8;

  /**
  * The ninja's starting defensive values.
  */
  private final int ninjaDefence = 6;

  /**
  * The basics method, used for basic info.
  */
  public void basics() {
    final Scanner userInput = new Scanner(System.in);
    System.out.println("Welcome to Battle Blitz!");
    System.out.println("\nWelcome trainee to the arena! Here "
      + "we will see if you are ready to join the army."
      + " You are tasked with fighting 10 monsters in a row. "
      + "If you defeat all 10 you will become a new member "
      + "of the kingdom's army!");
    System.out.println("During the first 5 battles, you can use both "
      + "your physical and magical abilities to defeat these monsters."
      + " But behold, you have a limited amount of points so choose your"
      + " attack wisely. Your points will be replenished after you"
      + " successfully defeat a monster."
      + " After the 5th fight, you will choose a guild"
      + " to join, learning their special skills and tactics!"
      + " You will get stronger as the fights go on, but be"
      + " warned, the monsters will also get stronger as time goes on.");
    System.out.println("\nHP (health points): Indicates the amount of "
      + "damage you can take before losing.");
    System.out.println("MP (mana points): The amount of points you have "
      + "for your magical abilities. Refilled after defeating a monster.");
    System.out.println("Strength stat : identifies how strong "
      + "you are when you physically attack the enemy.");
    System.out.println("Magic stat: identifies how "
      + "strong your magical abilities are.");
    System.out.println("\nThere are 4 types of monsters: fire, frost, "
      + "lightning, and neutral. The type of monster will impact your "
      + "magic attacks. Eg. Fire is more effective against a frost "
      + "monster compared to a lightning monster.");
    System.out.println("\nBasic actions:");
    System.out.println("Attack: inflict physical damage on the monster.");
    System.out.println("Skills:");
    System.out.println("   Fireball: Shoot a ball of fire at "
      + "the enemy, dealing magic fire damage.");
    System.out.println("   Zap: Shoot a small burst of "
      + "electricity at the enemy, dealing magic lightning damage.");
    System.out.println("   Frostblast: Shoot a freezing blast"
      + " at the enemy, dealing magic frost damage.");
    System.out.println("Defend: Raise your guard, temporarily"
      + " increasing your defence for one enemy attack.");
    System.out.println("\nUse your asdf keys for choosing what you want"
      + " to do, then press enter to confirm your choice.");
    System.out.println("To open the help menu, input 'h' "
      + "into the action spot.");
    System.out.println("Press enter to begin");
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
  * The classKnight method, used for showing.
  * The basic info about the knight class.
  */
  public void classKnight() {
    System.out.println("Knight");
    System.out.println("High strength and defence, "
      + "low MP and magic.");
    System.out.println("The Knight uses strength for skills.");
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
    System.out.println("High magic and MP, low strength and defence.");
    System.out.println("Skills:");
    System.out.println("Inferno: Incinerate the enemy, dealing large"
      + " fire damage.");
    System.out.println("Thunder: Call upon the storm gods,"
      + " dealing large lightning damage.");
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
    System.out.println("Balanced in all stats, uses a magical sword "
      + " that uses both strength and magic for its attacks.");
    System.out.println("Skills:");
    System.out.println("Prepare: Increases strength and "
      + "magic slightly for one attack.");
    System.out.println("Multislash: A flurry of strikes,"
      + " dealing massive damage.");
    System.out.println("Animecut: The anime sword strike, "
      + "sacrificing all your MP in exchange for huge damage.");
  }

  /**
  * The continueBattle method.
  *
  * @return true or false.
  */
  public boolean continueBattle() {
    final Scanner userInput = new Scanner(System.in);
    String battleContinue = "e";
    int finish = 0;
    while (finish == 0) {
      battleContinue = userInput.nextLine();
      battleContinue = battleContinue.toLowerCase();
      if (battleContinue.equals("y") || battleContinue.equals("n")) {
        finish = 1;
      } else {
        System.out.println("That is not a valid input.");
        finish = 0;
        System.out.println("Continue? (y/n)");
      }
    }
    return battleContinue.equals("y");
  }

  /**
  * The class change method, used for changing to one of the advanced classes.
  *
  * @return class value.
  */
  public int classChange() {
    final Scanner userInput = new Scanner(System.in);
    int classChoice = 0;
    String classInput = "0";
    int decision = 0;
    System.out.println("Time to choose a guild to join! "
      + "Will you choose the steadfast knights, the spell-casting mages, "
      + "or the stealthy ninjas? "
      + "(Warning: this decision cannot be changed later.)");
    System.out.println("Knight(A)");
    System.out.println("Mage(S)");
    System.out.println("Ninja(D)");
    while (classChoice == 0) {
      classInput = userInput.nextLine();
      classInput = classInput.toLowerCase();
      if (classInput.equals("a")) {
        classKnight();
        decision = 1;
      } else if (classInput.equals("s")) {
        classMage();
        decision = 2;
        reminder();
      } else if (classInput.equals("d")) {
        classNinja();
        decision = choiceC;
      }
      if (classInput.equals("a") || classInput.equals("s")
        || classInput.equals("d")) {
        System.out.println("Confirm: (y)es/(n)o");
        String confirm = userInput.nextLine();
        confirm = confirm.toLowerCase();
        if (confirm.equals("y")) {
          classChoice = decision;
        } else if (confirm.equals("n")) {
          classChoice = 0;
        } else {
          System.out.println("That is not a valid input");
          classChoice = 0;
        }
      }
    }
    return classChoice;
  }
}
