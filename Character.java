import java.util.Random;

public abstract class Character {

  private int hp = 1;

  private int str = 1;

  private int intel = 1;

  private int def = 1;

  private int mdf = 1;

  private int agl = 1;

  private int lvl = 1;

  public int attack(final int strength, final int Edef) {
    final Random random = new Random();
    final int damage = random.nextInt(strength - Edef) + Edef;
    return damage;
  }

  public int fireball(final int intelligence, final int Emdf) {
    final Random fireRand = new Random();
    final int fireDmg = fireRand.nextInt(intelligence - Emdf) + Emdf;
    return fireDmg;
  }

  public int zap(final int intelligence, final int Emdf) {
    final Random zapRand = new Random();
    final int zapDmg = zapRand.nextInt(intelligence - Emdf) + Emdf;
    return zapDmg;
  }

  public int frostblast(final int intelligence, final int Emdf) {
    final Random frostRand = new Random();
    final int frostDmg = frostRand.nextInt(intelligence - Emdf) + Emdf;
    return frostDmg;
  }
}
