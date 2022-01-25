public class Ninja extends Character {

  private int hp = 40;

  private int mp = 8;

  private int str = 6;

  private int intel = 6;

  private int def = 6;

  private int mdf = 6;

  private int lvl = 6;

  public int attack(final int Edf) {
    final int physicalDamage = super.attack(str, Edf);
    final int magicalDamage = super.attack(intel, Edf);
    final int damage = physicalDamage + magicalDamage;
    return damage;
  }

  public int multislash(final int Edef) {
    final int damage = super.attack((str + intel), Edef);
    return damage;
  }

  public int slash(final int Edef) {
    final int damage = super.attack(str, Edef);
    return (damage + lvl);
  }

  public int animeCut(final int Ehp) {
    final int damage = Math.round(Ehp / 3);
    return damage;
  }

  public void levelUp() {
    hp += 4;
    mp += 2;
    intel += 1;
    str += 1;
    def += 1;
    mdf += 1;
    lvl += 1;
  }

  /**
  * The fireball method.
  *
  * @param Emdf the enemy magic defence value.
  *
  * @return fireDmg the damage dealt.
  */
  public int fireball(final int Emdf) {
    return super.fireball(intel, Emdf);
  }

  /**
  * The zap method.
  *
  * @param Emdf the enemy magic defence value.
  *
  * @return zapDmg the damage dealt.
  */
  public int zap(final int Emdf) {
    return super.zap(intel, Emdf);
  }

  /**
  * The frostblast method.
  *
  * @param Emdf the enemy magic defence value.
  *
  * @return frostDmg the damage dealt.
  */
  public int frostblast(final int Emdf) {
    return super.frostblast(intel, Emdf);
  }
}
