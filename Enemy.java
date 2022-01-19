public class Enemy extends Character {
  
  private int hp = 30;

  private int mp = 10;

  private int str = 5;

  private int intel = 4;

  private int def = 3;

  private int mdf = 2;

  private int agl = 4;

  private int lvl = 1;

  public int attack(final int Edef) {
    final int damage = super.attack(str, Edef);
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
}
