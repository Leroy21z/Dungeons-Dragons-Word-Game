
/**
 * Name: Leroy Gawu-Mensah
 * Date: 3/16/2024
 * CSC 202
 * Project 2- RPGCharacter class
 * 
 * Description: This class models one character in a basic roll playing game
 * 
 * Citations of Assistance (who and what OR declare no assistance):
 * 	No assistance for this code.
 */
import java.util.ArrayList;
import java.util.List;

public abstract class RPGCharacter implements Chooseable {
	/**
	 * Number of sides for the die used in attacks
	 */
	public static final int NUMBER_SIDES_FOR_ATTACK = 12;

	/**
	 * The die with NUMBER_SIDES_FOR_ATTACK sides to be rolls when a fight ensues or
	 * a damaging spell is cast
	 */
	public static MultiSidedDie attackDie = new MultiSidedDie(NUMBER_SIDES_FOR_ATTACK);

	// Data fields
	private String name;
	private int maxHealthPoints;
	private int currentHealthPoints;
	private Armor armor;
	private Weapon weapon;

	/**
	 * Constructs the RPG character object with name and maximum health points It
	 * also initializes the character armor and weapon to no armor and hands
	 * respectfully
	 * 
	 * @param name            - name set to the RPG character
	 * @param maxHealthPoints - maximum health points for a character
	 */
	public RPGCharacter(String name, int maxHealthPoints) {
		this.name = name;
		this.maxHealthPoints = maxHealthPoints;
		this.currentHealthPoints = maxHealthPoints;
		this.armor = Armor.NO_ARMOR;
		this.weapon = Weapon.HANDS;
	}

	/**
	 * Note: subclasses should override this method to provide a set of actions
	 * specific to that class. Usually, the subclass should call RPGCharacter's
	 * getActionList() and prepend any additional character-specific actions to the
	 * front of it.
	 * 
	 * @return list of actions currently available for this character
	 */
	public List<Action> getActionList() {
		List<Action> actions = new ArrayList<>();
		if (weapon == Weapon.HANDS) {
			actions.add(Action.WIELD);
		} else {
			actions.add(Action.UNWIELD);
		}
		actions.add(Action.FIGHT);
		actions.add(Action.CHECK_STATUS);
		actions.add(Action.END_TURN);
		return actions;
	}

	/**
	 * Returns a list of weapons allowed to the RPG character
	 * 
	 * @return list of weapons to be used by the RPG character
	 */
	public abstract List<Weapon> getAllowedWeaponList();

	/**
	 * Returns a list of armor allowed to RPG character
	 * 
	 * @return list of armor to be used by the RPG character
	 */
	public abstract List<Armor> getAllowedArmorList();

	/**
	 * Returns the name of the RPG character
	 * 
	 * @return the name of the RPG character
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the maximum health points assigned to RPG character
	 * 
	 * @return the maximum health points for the RPG character
	 */
	public int getMaxHealthPoints() {
		return maxHealthPoints;
	}

	/**
	 * Returns the current health points of the RPG character
	 * 
	 * @return the current health points of the RPG character
	 */
	public int getHealthPoints() {
		// setHealthPoints(currentHealthPoints);
		return currentHealthPoints;
	}

	/**
	 * Returns current armor on the RPG character
	 * 
	 * @return the armor on the RPG character
	 */
	public Armor getArmor() {
		return armor;
	}

	/**
	 * Returns current weapon wielded by the RPG character
	 * 
	 * @return the weapon wielded by the RPG character
	 */
	public Weapon getWeapon() {
		return weapon;
	}

	/**
	 * Sets armor to RPG character specific armor
	 * 
	 * @param newArmor - the new armor assigned
	 */
	public void setArmor(Armor newArmor) {
		armor = newArmor;

	}

	/**
	 * Sets RPG character health points to specified value
	 * 
	 * @param newHealthPoints - the value set as the new health point of the RPG
	 *                        character
	 */
	public void setHealthPoints(int newHealthPoints) {
		if (newHealthPoints < 0) {
			currentHealthPoints = 0;
		} else if (newHealthPoints > maxHealthPoints) {
			currentHealthPoints = maxHealthPoints;

		} else {
			currentHealthPoints = newHealthPoints;
		}
	}

	/**
	 * Gives the character a new weapon and prints a message
	 * 
	 * @param newWeapon - the new weapon assigned to the RPG character
	 */
	public void wield(Weapon newWeapon) {
		weapon = newWeapon;
		System.out.print(name + " now wielding " + weapon.getName() + ".\n");
	}

	/**
	 * Sets the weapon for the character to
	 */
	public void unwield() {
		weapon = Weapon.HANDS;
		System.out.print(name + " no longer wielding a weapon.\n");
	}

	/**
	 * Checks if the charcter's health is less than zero
	 * 
	 * @return - true of the character has been defeated else returns false
	 */
	public boolean checkForDefeat() {
		return (currentHealthPoints <= 0);
	}

	/**
	 * Sets up a fight between this character and another character
	 * 
	 * @param other - the character being fought against
	 * @return true if the character wins the fight
	 */
	public boolean fight(RPGCharacter other) {
		attackDie.roll();
		System.out.println("Die rolled: " + attackDie.getValue());
		System.out.println(this.getName() + " attacks " + other.getName() + " with " + this.weapon.getName() + ".");
		if (attackDie.getValue() > other.armor.getArmorClass()) {
			// might change the subtraction below. also add does damage
			System.out.println(
					this.getName() + " does " + this.weapon.getDamagePoints() + " damage to " + other.getName() + ".");
			System.out.println(other.getName() + " now has "
					+ damage(other.getHealthPoints(), this.weapon.getDamagePoints()) + " health points.");
			other.setHealthPoints(other.currentHealthPoints - this.weapon.getDamagePoints());
			return true;
		} else {
			System.out.println(other.getName() + "'s armor defended him. No loss of health points.");
			return false;
		}
	}

	/**
	 * Returns a string representation of this RPG character
	 */
	public String toString() {
		return (name + "\n   Current Health: " + getHealthPoints() + "\n   Wielding: " + weapon.getName()
				+ "\n   Wearing: " + armor.getName()); // Finish this tonight
	}

	/**
	 * Calculates the remaining health points after taking damage
	 * 
	 * @param healthPoints - current health points before taking damage
	 * @param weaponDamage - amount of damager inflicted
	 * @return remaining health points after damage
	 */
	private int damage(int healthPoints, int weaponDamage) {
		if ((healthPoints - weaponDamage) <= 0) {
			return 0;
		} else {
			return (healthPoints - weaponDamage);
		}
	}

}
