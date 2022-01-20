import java.util.Random;

public class Boss extends Character {
  
  private int hp = 50;

  private int str = 10;

  private int intel = 5;

  private int def = 10;

  private int mdf = 10;

  private int lvl = 1;

  private String weakness = "none";

  public String getWeakness() {
    final Random random = new Random();
    final int weak = random.nextInt(3);
    if (weak == 1) {
      weakness = "fire";
    }
    else if (weak == 2) {
      weakness = "ice";
    }
    else if (weak == 3) {
      weakness = "lightning";
    }
    System.out.println(weakness);
    return weakness;
  }

  public int attack(final int Edef) {
    final int damage = super.attack(str, Edef) + (lvl * 5);
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

  public int heal() {
    final Random random = new Random();
    final int healing = random.nextInt(intel);
    return healing;
  }
}
