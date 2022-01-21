public class Player extends Character {
  
  private int hp = 30;

  private int mp = 6;

  private int str = 20;

  private int intel = 4;

  private int def = 2;

  private int mdf = 2;

  private int lvl = 1;

  public int attack(final int Edef) {
    // final int damage = super.attack(str, Edef) + lvl;
    final int damage = 50;
    return damage;
  }

  public int fireball(final int Emdf) {
    final int fireDmg = super.fireball(intel, Emdf);
    return fireDmg;
  }

  public int zap(final int Emdf) {
    final int zapDmg = super.zap(intel, Emdf);
    return zapDmg;
  }

  public int frostblast(final int Emdf) {
    final int frostDmg = super.frostblast(intel, Emdf);
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

  public int getMp() {
    return mp;
  }

  public void levelUp() {
    str += 2;
    hp += 5;
    mp += 1;
    intel += 1;
    def += 1;
    mdf += 1;
    lvl += 1;
  }

  public int getLevel() {
    return lvl;
  }
}
