public class Player extends Character {
  
  private int hp = 30;

  private int mp = 10;

  private int str = 5;

  private int intel = 4;

  private int def = 3;

  private int mdf = 3;

  private int agl = 4;

  private int lvl = 1;

  public int attack(final int Edef) {
    final int damage = super.attack(str, Edef);
    return damage;
  }

  public int fireball(final int Emdf) {
    final int fireDmg = super.fireball(Emdf);
    return fireDmg;
  }

  public int zap(final int Emdf) {
    final int zapDmg = super.zap(Emdf);
    return zapDmg;
  }

  public int frostblast(final int Emdf) {
    final int frostDmg = super.frostblast(Emdf);
    return frostDmg;
  }

  public int getDef() {
    return def;
  }

  public int getMdf() {
    return mdf;
  }

  public int getHp(final int harm) {
    hp = hp - harm;
    return hp;
  }
}
