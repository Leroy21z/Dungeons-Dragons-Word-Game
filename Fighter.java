
/**
 * Name: Leroy Gawu-Mensah

 * Date: 3/20/2024
 * CSC 202
 * Project 2--Fighter class
 *  
 * Description: This class models a Fighter character in a basic
 *              role playing game. Fighters have restricted armor
 *              and weapons, but after winning a certain number
 *              of fights can increase a level to receive additional
 *              armor and weapon choices
 * 
 * Citations of Assistance (who and what OR declare no assistance):
 * 	Professor Mueller helped with the fight method. I had to store the value from super 
 * 	fight into a variable and return it instead of calling the super fight twice.
 * 
 */
import java.util.ArrayList;
import java.util.List;

public class Fighter extends RPGCharacter {
	// Data fields
	private int fighterLevel;
	private int fightsWon;

	/**
	 * The initial and maximum number of health points for a Fighter
	 */
	public static final int MAX_HEALTH_POINTS = 40;

	/**
	 * When a Fighter wins his third fight, then he moves to level 2
	 */
	public static final int NUMBER_FIGHTS_WON_TO_LEVEL_UP = 3;

	/**
	 * The initial level for a Fighter with restricted armor and weapons
	 */
	public static final int INITIAL_LEVEL = 1;

	/**
	 * Constructs the Wizard character by calling the RPG class
	 * 
	 * @param name - sets the name of Fighter character
	 */
	public Fighter(String name) {
		super(name, MAX_HEALTH_POINTS);
		fighterLevel = INITIAL_LEVEL;
		fightsWon = 0;
	}

	@Override
	public List<Action> getActionList() {
		List<Action> actions = new ArrayList<>();// focus on this later ,How to return
		if (getArmor() == Armor.NO_ARMOR) {
			actions.add(Action.PUT_ON_ARMOR);
		} else {
			actions.add(Action.REMOVE_ARMOR);
		}
		actions.addAll(super.getActionList());
		return actions;
	}

	@Override
	public List<Weapon> getAllowedWeaponList() {
		List<Weapon> weapons = new ArrayList<>();
		if (fighterLevel >= 1) {
			weapons.addAll(Weapon.BASIC_WEAPON_LIST);
		}
		if (fighterLevel == 2) {
			weapons.add(Weapon.SWARD);
			weapons.add(Weapon.WAR_HAMMER);
		}
		return weapons;
	}

	@Override
	public List<Armor> getAllowedArmorList() {
		List<Armor> armorList = new ArrayList<>();
		if (fighterLevel == 1) {
			armorList.addAll(Armor.BASIC_ARMOR_LIST);
		} else if (fighterLevel >= 2) {
			armorList.addAll(Armor.BASIC_ARMOR_LIST);
			armorList.add(Armor.PLATE);
		}

		return armorList;
	}

	/**
	 * Calls the set armor from the RPG class and prints the armor collected
	 * 
	 * @param newArmor - the armor being worn by the Fighter character
	 */
	public void putOnArmor(Armor newArmor) {
		super.setArmor(newArmor);
		System.out.print(super.getName() + " now wearing " + super.getArmor().getName() + " armor.\n");
	}

	/**
	 * Sets the armor of the Fighter character to no armor
	 */
	public void takeOffArmor() {
		super.setArmor(Armor.NO_ARMOR);
		System.out.print(super.getName() + " no longer wearing armor.\n");
	}

	@Override
	public boolean fight(RPGCharacter other) {
		boolean wonFight = super.fight(other);
		if (wonFight) { // problem here
			fightsWon++;
			if (fightsWon == NUMBER_FIGHTS_WON_TO_LEVEL_UP) {
				fighterLevel++;
			}
		}
		return wonFight;
		// call from RPG and add if else statements
	}

	@Override
	public String toString() {

		return ("Fighter " + super.toString() + "\n   Level: " + fighterLevel + "\n   Fights won: " + fightsWon);

	}

}
