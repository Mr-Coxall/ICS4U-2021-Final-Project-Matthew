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
  * @param eDef the enemy defence value.
  *
  * @return damage the damage dealt.
  */
  public int attack(final int strength, final int eDef) {
    final Random random = new Random();
    int range = strength - eDef;
    int damage = 1;
    if (range <= 0) {
      damage = 1;
    } else {
      damage = random.nextInt(range) + Math.round(strength / 2);
    }
    return damage;
  }

  /**
  * The fireball method.
  *
  * @param intelligence the character intelligence value.
  * @param eMdf the enemy magic defence value.
  *
  * @return fireDmg the damage dealt.
  */
  public int fireball(final int intelligence, final int eMdf) {
    final Random fireRand = new Random();
    final int range = intelligence - eMdf;
    int fireDmg = 0;
    if (range <= 0) {
      fireDmg = 1;
    } else {
      fireDmg = fireRand.nextInt(range) + Math.round(intelligence / 2);
    }
    return fireDmg;
  }

  /**
  * The zap method.
  *
  * @param intelligence the character intelligence value.
  * @param eMdf the enemy magic defence value.
  *
  * @return zapDmg the damage dealt.
  */
  public int zap(final int intelligence, final int eMdf) {
    final Random zapRand = new Random();
    final int range = intelligence - eMdf;
    int zapDmg = 0;
    if (range <= 0) {
      zapDmg = 1;
    } else {
      zapDmg = zapRand.nextInt(range) + 2;
    }
    return zapDmg;
  }

  /**
  * The frostblast method.
  *
  * @param intelligence the character intelligence value.
  * @param eMdf the enemy magic defence value.
  *
  * @return frostDmg the damage dealt.
  */
  public int frostblast(final int intelligence, final int eMdf) {
    final Random frostRand = new Random();
    int frostDmg = 0;
    final int range = intelligence - eMdf;
    if (range <= 0) {
      frostDmg = 1;
    } else {
      frostDmg = frostRand.nextInt(range) + Math.round(intelligence / 2);
    }
    return frostDmg;
  }
}
