import java.util.Random;

public class Boss extends Character {

  /**
  * The boss hp value.
  */
  private int hp = 50;

  /**
  * The boss strength value.
  */
  private int str = 10;

  /**
  * The boss intelligence value.
  */
  private int intel = 5;

  /**
  * The boss defence value.
  */
  private int def = 10;

  /**
  * The boss magic defence value.
  */
  private int mdf = 10;

  /**
  * The boss starting type.
  */
  private String type = "none";

  /**
  * The getType method.
  *
  * @return type the enemy's typing.
  */
  public String getType() {
    final Random random = new Random();
    final int weak = random.nextInt(3);
    if (weak == 1) {
      type = "fire";
    } else if (weak == 2) {
      type = "ice";
    } else if (weak == 3) {
      type = "lightning";
    }
    System.out.println(type);
    return type;
  }

  /**
  * The attack method.
  *
  * @param Pdef the player's defence value.
  *
  * @return damage the damage dealt.
  */
  public int attack(final int Pdef) {
    final Random random = new Random();
    final int damage = random.nextInt(str - Pdef) + Pdef;
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

  /**
  * The getDef method.
  *
  * @return def
  */
  public int getDef() {
    return def;
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
  * The heal method.
  *
  * @return healing.
  */
  public int heal() {
    final Random random = new Random();
    final int healing = random.nextInt(intel);
    return healing;
  }

  /**
  * The revive method.
  *
  * @return hp.
  */
  public int revive() {
    return hp;
  }
}
