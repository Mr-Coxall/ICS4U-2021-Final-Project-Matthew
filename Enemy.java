import java.util.Random;

public class Enemy extends Character {

  /**
  * The starting enemy hp value.
  */
  private int hp;

  /**
  * The starting enemy strength value.
  */
  private int str;

  /**
  * The starting enemy intelligence value.
  */
  private int intel;

  /**
  * The starting enemy defence value.
  */
  private int def;

  /**
  * The starting enemy magic defence value.
  */
  private int mdf;

  /**
  * The starting enemy level value.
  */
  private int lvl;

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

  public Enemy() {
    hp = 20;
    str = 4;
    intel = 1;
    def = 3;
    mdf = 2;
    lvl = 1;
  }

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
    final int damage = super.attack(str, pDef);
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
    return def;
  }

  /**
  * The getMdf method.
  *
  * @return mdf.
  */
  public int getMdf() {
    return mdf;
  }

  /**
  * The getHp method.
  *
  * @return hp.
  */
  public int getHp() {
    return hp;
  }

  /**
  * The levelup method.
  */
  public void levelUp() {
    final Random random = new Random();
    lvl += 1;
    str += random.nextInt(2) + 1;
    hp += random.nextInt(hpUpAmount) + hpUpAmount;
    def += random.nextInt(1) + 1;
    mdf += random.nextInt(1) + 1;
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
