public class Player extends Character {

  /**
  * The starting hp value.
  */
  private int hp = 30;

  /**
  * The starting mp value.
  */
  private int mp = 6;

  /**
  * The starting str (strength) value.
  */
  private int str = 5;

  /**
  * The starting intel (intelligence) value.
  */
  private int intel = 4;

  /**
  * The starting def (defence) value.
  */
  private int def = 2;

  /**
  * The starting mdf (magic defence) value.
  */
  private int mdf = 2;

  /**
  * The starting level value.
  */
  private int lvl = 1;

  /**
  * The actions method, used to show the basic actions.
  */
  public void actions() {
    System.out.println("Attack(1)");
    System.out.println("Skills(2)");
    System.out.println("Defend(3)");
  }

  /**
  * The skills menu, showing the starting class' skills.
  */
  public void skills() {
    System.out.println("\nSkills:");
    System.out.println("Fireball(1): 2Mp");
    System.out.println("Zap(2): 2Mp");
    System.out.println("Frostblast(3): 2Mp");
    System.out.println("Back(4)");
  }

  /**
  * The attack method.
  *
  * @param Edef the enemy defence value.
  *
  * @return damage the damage dealt.
  */
  public int attack(final int Edef) {
    // final int damage = super.attack(str, Edef) + lvl;
    final int damage = 50;
    return damage;
  }

  /**
  * The fireball method.
  *
  * @param Emdf the enemy magic defence value.
  * @param type the enemy's elemental type.
  *
  * @return fireDmg the damage dealt.
  */
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

  /**
  * The zap method.
  *
  * @param Emdf the enemy magic defence value.
  * @param type the enemy's elemental type.
  *
  * @return zapDmg the damage dealt.
  */
  public int zap(final int Emdf, final String type) {
    int zapDmg = super.zap(intel, Emdf);
    if (type.equals("fire")) {
      zapDmg = zapDmg * 3;
    }
    else if (type.equals("lightning")) {
      zapDmg = 1;
    }
    return zapDmg;
  }

  /**
  * The frostblast method.
  *
  * @param Emdf the enemy magic defence value.
  * @param type the enemy's elemental type.
  *
  * @return frostDmg the damage dealt.
  */
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
