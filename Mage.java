public class Mage extends Character {

  private int hp = 35;

  private int mp = 20;

  private int str = 4;

  private int intel = 12;

  private int def = 4;

  private int mdf = 4;

  private int lvl = 6;

  public int attack(final int Edef) {
    final int damage = super.attack(str, Edef) + lvl;
    return damage;
  }

  public int Thunder(final int Emdf) {
    final int zapDmg = super.zap(intel, Emdf);
    return (zapDmg + 3);
  }

  public int Inferno(final int Emdf) {
    final int fireDmg = super.fireball((intel + 3), Emdf);
    return fireDmg;
  }

  public int IcicleSpear(final int Emdf) {
    final int frostDmg = super.frostblast((intel + 2), (Emdf - 1));
    return frostDmg;
  }

  public void levelUp() {
    hp += 4;
    mp += 5;
    intel += 2;
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
