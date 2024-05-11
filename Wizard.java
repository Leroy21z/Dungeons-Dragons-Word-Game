
/**
 * Name: Leroy Gawu-Mensah

 * Date: 3/16/2024
 * CSC 202
 * Project 2--Wizard class
 *  
 * Description: This class models a Wizard character in a basic
 *              role playing game. Wizards have no armor and
 *              restricted weapons, but can regain spell points. 
 *              Additionally, wizards can use spell points to cast
 *              spells which can either heal or do damage.
 * 
 * Citations of Assistance (who and what OR declare no assistance):
 *	No assistance for this code.
 */

import java.util.ArrayList;
import java.util.List;

public class Wizard extends RPGCharacter {
	// Data field
	private int spellPoints;
	/**
	 * The initial and maximum number of health points for a Wizard
	 */
	public static final int MAX_HEALTH_POINTS = 30;

	/**
	 * The initial and maximum number of spell points for a Wizard
	 */
	public static final int MAX_SPELL_POINTS = 20;

	/**
	 * The number of sides on the die rolled to try to regain
	 */
	public static final int NUMBER_SIDES_TO_REGAIN__SPELL_POINTS = 10;

	/**
	 * The die with NUMBER_SIDES_TO_REGAIN_SPELL_POINTS sides to be rolls when a
	 * fight ensues or a damaging spell is cast
	 */
	public static MultiSidedDie dieToRegainPoints = new MultiSidedDie(NUMBER_SIDES_TO_REGAIN__SPELL_POINTS);

	/**
	 * Constructs the Wizard character by calling the RPG class
	 * 
	 * @param name - sets the name
	 */
	public Wizard(String name) {
		super(name, MAX_HEALTH_POINTS);
		spellPoints = MAX_SPELL_POINTS;
	}

	@Override
	public List<Action> getActionList() {
		List<Action> actions = new ArrayList<>();
		actions.add(Action.CAST_SPELL); // what about the shortcut
		actions.add(Action.REGAIN_SPELL_POINTS);
		actions.addAll(super.getActionList());
		return actions;
	}

	@Override
	public List<Weapon> getAllowedWeaponList() {
		List<Weapon> weapons = new ArrayList<>();
		weapons.add(Weapon.DAGGER);
		weapons.add(Weapon.STAFF);
		return weapons;
	}

	@Override
	public List<Armor> getAllowedArmorList() {
		List<Armor> armorList = new ArrayList<>();
		armorList.add(Armor.NO_ARMOR);
		return armorList;
	}

	/**
	 * Casts a spell on another RPG character
	 * 
	 * @param spell - the spell being cast
	 * @param other - the RPG character affected by the spell
	 */
	public void castSpell(Spell spell, RPGCharacter other) {
		if (spell.getCost() > spellPoints) {
			System.out.println(super.getName() + " doesn't have enough spell points to cast this spell.");
		} else if (spell.getName().equals(Spell.HEAL.getName())) {
			spellPoints -= spell.getCost();
			System.out.println(super.getName() + " casts heal spell at " + other.getName() + ".");
			if (other.getHealthPoints() - Spell.HEAL.getEffect() > other.getMaxHealthPoints()) {
				System.out.println(
						other.getName() + "'s health points cannot exceed " + other.getMaxHealthPoints() + ".");
			} else {
				other.setHealthPoints(other.getHealthPoints() - spell.getEffect());
			}
			System.out.println(other.getName() + " now has " + other.getHealthPoints() + " health points.");
		} else {
			spellPoints -= spell.getCost();
			attackDie.roll();// uses attack die don't forget
			System.out.println(super.getName() + " casts " + spell.getName() + " spell at " + other.getName() + ".");
			System.out.println("Die rolled: " + attackDie.getValue());
			if (attackDie.getValue() > other.getArmor().getArmorClass()) {
				other.setHealthPoints(other.getHealthPoints() - spell.getEffect()); //
				System.out.println(
						super.getName() + " does " + spell.getEffect() + " damage to " + other.getName() + ".");
				System.out.println(other.getName() + " now has " + other.getHealthPoints() + " health points.");
			} else {
				System.out.println(other.getName() + "'s armor defended him. No loss of health points.");// Aldof's
																											// armor
																											// defended
																											// him. No
																											// loss of
																											// health
																											// points.
			}

		}

	}

	/**
	 * Gives the Wizard character a chance to regain spell points
	 */
	public void regainSpellPoints() {
		dieToRegainPoints.roll();
		System.out.println("Die rolled: " + dieToRegainPoints.getValue());
		if (dieToRegainPoints.getValue() + spellPoints > MAX_SPELL_POINTS) {
			System.out.println(super.getName() + "'s spell points cannot exceed 20.");
			spellPoints = MAX_SPELL_POINTS;
		} else {
			this.spellPoints += dieToRegainPoints.getValue();
		}
		System.out.println(super.getName() + " now has " + spellPoints + " spell points.");

	}

	@Override
	public String toString() {

		return ("Wizard " + super.toString() + "\n   Spell Points: " + spellPoints);
	}

}
