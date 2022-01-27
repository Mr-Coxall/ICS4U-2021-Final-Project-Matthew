import java.util.Random;

public class Boss extends Character {

  /**
  * The boss hp value.
  */
  private final int hp = 50;

  /**
  * The boss strength value.
  */
  private final int str = 10;

  /**
  * The boss intelligence value.
  */
  private final int intel = 5;

  /**
  * The boss defence value.
  */
  private final int def = 10;

  /**
  * The boss magic defence value.
  */
  private final int mdf = 10;

  /**
  * The boss starting type.
  */
  private final String type = "none";

  /**
  * The getType method.
  *
  * @return type the enemy's typing.
  */
  public String getType() {
    return type;
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
    final int damage = random.nextInt(str - pDef) + pDef;
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
