import java.util.Random;

public class Boss extends Character {
  
  private int hp = 50;

  private int str = 10;

  private int intel = 5;

  private int def = 10;

  private int mdf = 10;

  private int lvl = 0;

  private String type = "none";

  public String getWeakness() {
    lvl += 1;
    final Random random = new Random();
    final int weak = random.nextInt(3);
    if (weak == 1) {
      type = "fire";
    }
    else if (weak == 2) {
      type = "ice";
    }
    else if (weak == 3) {
      type = "lightning";
    }
    System.out.println(type);
    return type;
  }

  public int attack(final int Edef) {
    final Random random = new Random();
    final int damage = random.nextInt(str - Edef) + Edef;
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

  public void getStr(final int level) {
    str = str + (8 * (level - 1));
  }

  public int getDef(final int level) {
    def = def + (5 * (level - 1));
    return def;
  }

  public int getMdf(final int level) {
    mdf = mdf + (5 * (level - 1));
    return mdf;
  }

  public int getHp(final int level) {
    hp = hp + (50 * (level - 1));
    return hp;
  }

  public int heal() {
    final Random random = new Random();
    final int healing = random.nextInt(intel);
    return healing;
  }

  public int revive() {
    return hp;
  }
}
