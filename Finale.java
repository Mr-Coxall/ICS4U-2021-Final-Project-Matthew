import java.util.Random;

public class Finale extends Boss {
  
  private int hp = 300;

  private int str = 60;

  private int intel = 30;

  private int def = 40;

  private int mdf = 40;

  private int lvl = 100;

  private int stage = 1;

  private String type = "none";

  public String getWeakness() {
    return type;
  }

  public int attack(final int Edef) {
    int damage = super.attack(str, Edef);
    damage = damage / (4 - stage);
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
    return (def / stage);
  }

  public int getMdf() {
    return (mdf / stage);
  }

  public int getHp() {
    return hp;
  }

  public int heal() {
    final Random random = new Random();
    final int healing = random.nextInt(intel);
    return healing;
  }

  public int revive() {
    stage += 1;
    return hp;
  }

  public int checkStage() {
    return stage;
  }
}
