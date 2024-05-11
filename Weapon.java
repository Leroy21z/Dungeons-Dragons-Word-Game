/**
 * Weapon.java is for creating weapons for BasicRPG including

 * its name and its damage points. The weapons for the game are
 * defined in this class and the list of basic weapons
 * for characters in BasicRPG.
 */

import java.util.Arrays;
import java.util.List;
// Do not change this class!
public class Weapon implements Chooseable{
	
	public static final Weapon DAGGER = new Weapon("dagger", 4);
	public static final Weapon AXE = new Weapon("axe", 6);
	public static final Weapon STAFF = new Weapon("staff", 6);
	public static final Weapon SWARD = new Weapon("sward", 10);
	public static final Weapon HANDS = new Weapon("hands", 1);
	public static final Weapon SPEAR = new Weapon("spear", 5);
	public static final Weapon WAR_HAMMER = new Weapon("war hammer", 8);

	public static final List<Weapon> BASIC_WEAPON_LIST = Arrays.asList(DAGGER, AXE, STAFF, SPEAR);
	
	private String name;         // the name of this weapon
	private int damagePoints;    // the number of damage points this weapon can inflict
	
	/**
	 * Constucts a weapon with a name and a number of damage points
	 * @param name - the name of this weapon
	 * @param damagePoints - the number of damage points this weapon can inflict
	 */
	public Weapon(String name, int damagePoints) {
		this.name = name;
		this.damagePoints = damagePoints;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the number of damage points this weapon can inflict
	 * @return the number of damage points this weapon can inflict
	 */
	public int getDamagePoints() {
		return damagePoints;
	}
	
	@Override
	public String toString() {
		return "Weapon name: " + name + ", Damage points: " + damagePoints;
	}
}
