import java.util.Random;

public class Enemy extends Character {

  /**
  * The starting enemy hp value.
  */
  private final int hp = 20;

  /**
  * The starting enemy strength value.
  */
  private final int str = 4;

  /**
  * The starting enemy intelligence value.
  */
  private final int intel = 1;

  /**
  * The starting enemy defence value.
  */
  private final int def = 3;

  /**
  * The starting enemy magic defence value.
  */
  private final int mdf = 2;

  /**
  * The starting enemy level value.
  */
  private int lvl = 1;

  /**
  * The value that hp goes up by.
  */
  private final int hpUpAmount = 5;

  /**
  * The starting enemy element type value.
  */
  private String element = "none";

  /**
  * The empty string for the enemy name.
  */
  private String name;

  /**
  * The value used every time a 3 is needed.
  */
  private final int choiceC = 3;

  /**
  * The getType method.
  *
  * @return type the enemy's typing.
  */
  public String getType() {
    final Random random = new Random();
    final int type = random.nextInt(4) + 1;
    if (type == 1) {
      element = "fire";
    } else if (type == 2) {
      element = "ice";
    } else if (type == choiceC) {
      element = "lightning";
    }
    return element;
  }

  /**
  * The getName method.
  *
  * @return name of enemy.
  */
  public String getName() {
    final Random random = new Random();
    final int randName = random.nextInt(3) + 1;
    name = "Skeleton";
    if (element == "fire") {
      if (randName == 1) {
        name = "Fire Spirit";
      } else if (randName == 2) {
        name = "Pyro";
      } else {
        name = "Flame Golem";
      }
    } else if (element == "ice") {
      if (randName == 1) {
        name = "Frost giant";
      } else if (randName == 2) {
        name = "Ice Golem";
      } else {
        name = "Frozen Soul";
      }
    } else if (element == "lightning") {
      if (randName == 1) {
        name = "Conduit";
      } else if (randName == 2) {
        name = "Thunder Spirit";
      } else {
        name = "Robot";
      }
    }
    return name;
  }

  /**
  * The attack method.
  *
  * @param pDef the player's defence value.
  *
  * @return damage the damage dealt.
  */
  public int attack(final int pDef) {
    final Random random = new Random();
    int times = 1;
    int strength = str;
    while (times != lvl) {
      int strUp = random.nextInt(2) + 1;
      strength += strUp;
      times += 1;
    }
    final int damage = super.attack(strength, pDef);
    return damage;
  }

  /**
  * The fireball method.
  *
  * @param pMdf the player's magic defence value.
  *
  * @return fireDmg the damage dealt.
  */
  public int fireball(final int pMdf) {
    final int fireDmg = super.fireball(intel, pMdf);
    return fireDmg;
  }

  /**
  * The zap method.
  *
  * @param pMdf the player's magic defence value.
  *
  * @return zapDmg the damage dealt.
  */
  public int zap(final int pMdf) {
    final int zapDmg = super.zap(intel, pMdf);
    return zapDmg;
  }

  /**
  * The frostblast method.
  *
  * @param pMdf the player's magic defence value.
  *
  * @return frostDmg the damage dealt.
  */
  public int frostblast(final int pMdf) {
    final int frostDmg = super.frostblast(intel, pMdf);
    return frostDmg;
  }

  /**
  * The getDef method.
  *
  * @return newDef.
  */
  public int getDef() {
    final Random random = new Random();
    int newDef = def;
    int times = 1;
    while (times != lvl) {
      final int defUp = random.nextInt(1) + 1;
      newDef += defUp;
      times += 1;
    }
    return newDef;
  }

  /**
  * The getMdf method.
  *
  * @return newMdf.
  */
  public int getMdf() {
    final Random random = new Random();
    int newMdf = mdf;
    int times = 1;
    while (times != lvl) {
      final int mdfUp = random.nextInt(1) + 1;
      newMdf += mdfUp;
      times += 1;
    }
    return newMdf;
  }

  /**
  * The getHp method.
  *
  * @return newHp.
  */
  public int getHp() {
    final Random random = new Random();
    int newHp = hp;
    int times = 1;
    while (times != lvl) {
      int hpUp = random.nextInt(hpUpAmount) + hpUpAmount;
      newHp += hpUp;
      times += 1;
    }
    return newHp;
  }

  /**
  * The levelup method.
  */
  public void levelUp() {
    lvl += 1;
  }

  /**
  * The getLevel method.
  *
  * @return lvl.
  */
  public int getLevel() {
    return lvl;
  }
}
