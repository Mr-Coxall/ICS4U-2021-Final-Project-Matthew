import java.util.Random;

public class Finale extends Character {

  /**
  * The starting hp value of the final boss.
  */
  private final int hp = 150;

  /**
  * The starting strength value of the final boss.
  */
  private final int str = 15;

  /**
  * The starting intelligence value of the final boss.
  */
  private final int intel = 15;

  /**
  * The starting def value of the final boss.
  */
  private final int def = 12;

  /**
  * The starting mdf value of the final boss.
  */
  private final int mdf = 12;

  /**
  * The typing of the boss.
  */
  private final String type = "none";

  /**
  * The getType method.
  *
  * @return type.
  */
  public String getType() {
    return type;
  }

  /**
  * The attack method.
  *
  * @param pDef the player's defence value.
  *
  * @return damage the damage dealt.
  */
  public int attack(final int pDef) {
    final int damage = super.attack(str, pDef);
    System.out.println("The amalgamation dealt " + damage + " damage!");
    return damage;
  }

  /**
  * The fireball method.
  *
  * @param pMdf the player's magic defence value.
  *
  * @return fireDmg the damage dealt.
  */
  public int fireball(final int pMdf) {
    final int fireDmg = super.fireball(intel, pMdf);
    return fireDmg;
  }

  /**
  * The zap method.
  *
  * @param pMdf the player's magic defence value.
  *
  * @return zapDmg the damage dealt.
  */
  public int zap(final int pMdf) {
    final int zapDmg = super.zap(intel, pMdf);
    return zapDmg;
  }

  /**
  * The frostblast method.
  *
  * @param pMdf the player's magic defence value.
  *
  * @return frostDmg the damage dealt.
  */
  public int frostblast(final int pMdf) {
    final int frostDmg = super.frostblast(intel, pMdf);
    return frostDmg;
  }

  /**
  * The getDef method.
  *
  * @return finalDefence
  */
  public int getDef() {
    return def;
  }

  /**
  * The getMdf method.
  *
  * @return finalMdf
  */
  public int getMdf() {
    return mdf;
  }

  /**
  * The getHp method.
  *
  * @return hp
  */
  public int getHp() {
    return hp;
  }

  /**
  * The heal method.
  *
  * @return healing.
  */
  public int heal() {
    final Random random = new Random();
    final int healing = random.nextInt(intel);
    return healing;
  }
}
