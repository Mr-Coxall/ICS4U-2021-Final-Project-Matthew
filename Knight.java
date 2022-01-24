public class Knight extends Player {

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
    final int damage = Math.round(str * 1.5);
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
}
