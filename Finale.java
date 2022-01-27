import java.util.Random;

public class Finale extends Character {

  /**
  * The starting hp value of the final boss.
  */
  private int hp = 100;

  /**
  * The starting strength value of the final boss.
  */
  private int str = 30;

  /**
  * The starting intelligence value of the final boss.
  */
  private int intel = 15;

  /**
  * The starting def value of the final boss.
  */
  private int def = 20;

  /**
  * The starting mdf value of the final boss.
  */
  private int mdf = 20;

  /**
  * The starting stage of the final boss.
  */
  private int stage = 1;

  /**
  * The typing of the boss.
  */
  private String type = "none";

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
  * @param Pdef the player's defence value.
  *
  * @return damage the damage dealt.
  */
  public int attack(final int Pdef) {
    int damage = super.attack(str, Pdef);
    damage = Math.round(damage / (4 - stage));
    return damage;
  }

  /**
  * The fireball method.
  *
  * @param Pmdf the player's magic defence value.
  *
  * @return fireDmg the damage dealt.
  */
  public int fireball(final int Pmdf) {
    final int fireDmg = super.fireball(intel, Pmdf);
    return fireDmg;
  }

  /**
  * The zap method.
  *
  * @param Pmdf the player's magic defence value.
  *
  * @return zapDmg the damage dealt.
  */
  public int zap(final int Pmdf) {
    final int zapDmg = super.zap(intel, Pmdf);
    return zapDmg;
  }

  /**
  * The frostblast method.
  *
  * @param Pmdf the player's magic defence value.
  *
  * @return frostDmg the damage dealt.
  */
  public int frostblast(final int Pmdf) {
    final int frostDmg = super.frostblast(intel, Pmdf);
    return frostDmg;
  }

  /**
  * The getDef method.
  *
  * @return finalDefence
  */
  public int getDef() {
    int finalDefence = Math.round(def / stage);
    return finalDefence;
  }

  /**
  * The getMdf method.
  *
  * @return finalMdf
  */
  public int getMdf() {
    int finalMdf = Math.round(mdf / stage);
    return finalMdf;
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

  /**
  * The revive method.
  *
  * @return hp.
  */
  public int revive() {
    stage += 1;
    return hp;
  }

  /**
  * The checkStage method.
  *
  * @return stage.
  */
  public int checkStage() {
    return stage;
  }
}
