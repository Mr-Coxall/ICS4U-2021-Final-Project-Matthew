import java.util.Random;

public class Enemy extends Character {

  /**
  * The starting enemy hp value.
  */
  private int hp = 20;

  /**
  * The starting enemy strength value.
  */
  private int str = 4;

  /**
  * The starting enemy intelligence value.
  */
  private int intel = 1;

  /**
  * The starting enemy defence value.
  */
  private int def = 3;

  /**
  * The starting enemy magic defence value.
  */
  private int mdf = 2;

  /**
  * The starting enemy level value.
  */
  private int lvl = 1;

  /**
  * The starting enemy element type value.
  */
  private String element = "none";

  /**
  * The empty string for the enemy name.
  */
  private String name;

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
    }
    else if (type == 2) {
      element = "ice";
    }
    else if (type == 3) {
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
    final int randName = random.nextInt(2) + 1;
    name = "Skeleton";
    if (element == "fire") {
      if (randName == 1) {
        name = "Fire Spirit";
      }
      else if (randName == 2) {
        name = "Pyro";
      }
      else {
        name = "Flame Golem";
      }
    }
    else if (element == "ice") {
      if (randName == 1) {
        name = "Frost giant";
      }
      else if (randName == 2) {
        name = "Ice Golem";
      }
      else {
        name = "Frozen Soul";
      }
    }
    else if (element == "lightning") {
      if (randName == 1) {
        name = "Conduit";
      }
      else if (randName == 2) {
        name = "Thunder Spirit";
      }
      else {
        name = "Robot";
      }
    }
    return name;
  }

  /**
  * The attack method.
  *
  * @param Pdef the player's defence value.
  *
  * @return damage the damage dealt.
  */
  public int attack(final int Pdef) {
    final int damage = super.attack(str, Pdef);
    return damage;
  }

  /**
  * The fireball method.
  *
  * @param Pmdf the player's magic defence value.
  *
  * @return fireDmg the damage dealt.
  */
  public int fireball(final int Pmdf) {
    final int fireDmg = super.fireball(intel, Pmdf);
    return fireDmg;
  }

  /**
  * The zap method.
  *
  * @param Pmdf the player's magic defence value.
  *
  * @return zapDmg the damage dealt.
  */
  public int zap(final int Pmdf) {
    final int zapDmg = super.zap(intel, Pmdf);
    return zapDmg;
  }

  /**
  * The frostblast method.
  *
  * @param Pmdf the player's magic defence value.
  *
  * @return frostDmg the damage dealt.
  */
  public int frostblast(final int Pmdf) {
    final int frostDmg = super.frostblast(intel, Pmdf);
    return frostDmg;
  }

  public int getDef() {
    return def;
  }

  public int getMdf() {
    return mdf;
  }
  
  public int getHp() {
    return hp;
  }

  public void levelUp() {
    final Random random = new Random();
    final int strUp = random.nextInt(2) + 1;
    final int defUp = random.nextInt(1) + 1;
    final int mdfUp = random.nextInt(1) + 1;
    final int hpUp = random.nextInt(5) + 5;
    str += strUp;
    hp += hpUp;
    def += defUp;
    mdf += mdfUp;
    lvl += 1;
  }

  public int getLevel() {
    return lvl;
  }
}
