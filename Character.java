import java.util.Random;

public abstract class Character {

  /**
  * The placeholder for the hp (health point) value.
  */
  private int hp = 1;

  /**
  * The placeholder for the str (strength) value.
  */
  private int str = 1;

  /**
  * The placeholder for the intel (intelligence) value.
  */
  private int intel = 1;

  /**
  * The placeholder for the def (defence) value.
  */
  private int def = 1;

  /**
  * The placeholder for the mdf (magic defence) value.
  */
  private int mdf = 1;

  /**
  * The placeholder for the level value.
  */
  private int lvl = 1;

  /**
  * The attack method.
  *
  * @param strength the character strength value.
  * @param Edef the enemy defence value.
  *
  * @return damage the damage dealt.
  */
  public int attack(final int strength, final int Edef) {
    final Random random = new Random();
    final int damage = random.nextInt(strength - Edef)
      + Math.round(strength / 2);
    return damage;
  }

  /**
  * The fireball method.
  *
  * @param intelligence the character intelligence value.
  * @param Emdf the enemy magic defence value.
  *
  * @return fireDmg the damage dealt.
  */
  public int fireball(final int intelligence, final int Emdf) {
    final Random fireRand = new Random();
    final int fireDmg = fireRand.nextInt(intelligence - Emdf)
      + Math.round(intelligence / 2);
    return fireDmg;
  }

  /**
  * The zap method.
  *
  * @param intelligence the character intelligence value.
  * @param Emdf the enemy magic defence value.
  *
  * @return zapDmg the damage dealt.
  */
  public int zap(final int intelligence, final int Emdf) {
    final Random zapRand = new Random();
    final int zapDmg = zapRand.nextInt(intelligence - Emdf) + 3;
    return zapDmg;
  }

  /**
  * The frostblast method.
  *
  * @param intelligence the character intelligence value.
  * @param Emdf the enemy magic defence value.
  *
  * @return frostDmg the damage dealt.
  */
  public int frostblast(final int intelligence, final int Emdf) {
    final Random frostRand = new Random();
    final int frostDmg = frostRand.nextInt(intelligence - Emdf)
      + Math.round(intelligence / 2);
    return frostDmg;
  }
}
