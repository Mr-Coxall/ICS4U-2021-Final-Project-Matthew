public class Player extends Character {
  
  private int hp = 30;

  private int mp = 6;

  private int str = 5;

  private int intel = 4;

  private int def = 2;

  private int mdf = 2;

  private int lvl = 1;

  public void skills() {
    System.out.println("\nSkills:");
    System.out.println("Fireball(1): 2Mp");
    System.out.println("Zap(2): 2Mp");
    System.out.println("Frostblast(3): 2Mp");
    System.out.println("Back(4)");
  }

  public int attack(final int Edef) {
    // final int damage = super.attack(str, Edef) + lvl;
    final int damage = 50;
    return damage;
  }

  public int fireball(final int Emdf, final String type) {
    int fireDmg = super.fireball(intel, Emdf);
    if (type.equals("ice")) {
      fireDmg += 3;
    }
    else if (type.equals("fire")) {
      fireDmg = 0;
    }
    else if (type.equals("lightning")) {
      fireDmg -= 2;
    }
    return fireDmg;
  }

  public int zap(final int Emdf, final String type) {
    int zapDmg = super.zap(intel, Emdf);
    if (type.equals("fire")) {
      zapDmg = zamDmg * 3;
    }
    else if (type.equals("lightning")) {
      zapDmg = 1;
    }
    return zapDmg;
  }

  public int frostblast(final int Emdf, final String type) {
    int frostDmg = super.frostblast(intel, Emdf);
    if (type.equals("lightning")) {
      frostDmg += 3;
    }
    else if (type.equals("ice")) {
      frostDmg = 0;
    }
    else if (type.equals("fire")) {
      frostDmg -= 2;
    }
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
