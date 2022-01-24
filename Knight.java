public class Knight extends Character {

  private int hp = 50;

  private int mp = 4;

  private int str = 14;

  private int intel = 2;

  private int def = 10;

  private int mdf = 10;

  private int lvl = 6;

  public int attack(final int Edef) {
    final int damage = super.attack(str, Edef) + lvl;
    return damage;
  }

  public int slam(final int Edef) {
    final int damage = super.attack(str, (Edef - 3));
    return damage;
  }

  public int piercingStrike() {
    int damage = str;
    int extra = Math.round(str / 2);
    damage += extra;
    return damage;
  }

  public void frenzy() {
    str += 3;
    def -= 3;
    mdf -= 3;
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

  public int getMp() {
    return mp;
  }

  public void levelUp() {
    str += 3;
    hp += 8;
    mp += 1;
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
