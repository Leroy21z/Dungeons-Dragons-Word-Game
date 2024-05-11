/**
 * Spell.java is for creating apells for BasicRPG including
 * its name, the cost of casting the spell, and the effect
 * of the spell. For the healing spell, the effect will increase
 * health points. The others have the chance of decreasing
 * health points. The spells for the game are
 * defined in this class and the list of all of the spells
 * for wizards in BasicRPG.
 */

import java.util.Arrays;
import java.util.List;
//Do not change this class!
public class Spell implements Chooseable{

	public static final Spell FIREBALL = new Spell("fireball", 3, 5);
	public static final Spell LIGHTNING_BOLT = new Spell("lightning bolt", 10, 10);
	public static final Spell CONE_OF_COLD = new Spell("cone of cold", 15, 20);
	public static final Spell HEAL = new Spell("heal", 6, -6);

	public static final List<Spell> ALL_SPELL_LIST = Arrays.asList(FIREBALL, LIGHTNING_BOLT, CONE_OF_COLD, HEAL);

	private String name;  // the name of the spell
	private int cost;     // the number of spell points required to cast this spell
	private int effect;   // the number of heath points lost for gained by this spell's target
	                      //   if the spell has effected the target
	
	/**
	 * Constructs a spell with a name, cost, and effect
	 * @param name - the name of this spell
	 * @param cost - the number of spell points required to case this spell
	 * @param effect - the number of health points lost or gained by this spell's target
	 *                 if the spell has effected the target
	 */
	public Spell(String name, int cost, int effect) {
		this.name = name;
		this.cost = cost;
		this.effect = effect;
	}

	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the cost, in spell points, of casting this spell
	 * @return the number of spell points required to cast this spell
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * Returns the number of health points gained or lost by the target
	 * of the spell if the spell has effected the target
	 * @return the number of health points gained or lost by the target
	 */
	public int getEffect() {
		return effect;
	}

	@Override
	public String toString() {
		return "Spell name: " + name + ", Cost: " + cost + ", Effect: " + effect;
	}

	
	
}
