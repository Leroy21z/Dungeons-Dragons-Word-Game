/**
 * Some test code to check Fighter class independent of BasicRPGDriver.
 * This assumes your RPGCharacter class was correct and so it testing
 * the methods added in the Fighter class.
 * 
 * To thoroughly test the Fighter class, you would need to add more statements.
 * Feel free to do so.
 * 
 * Realize that the fight method rolls a die which is random so take that into
 * consideration when you compare to my output.
 *
 */

import java.util.List;

public class FighterTest {

	public static void main(String[] args) {
		Fighter fred = new Fighter("Fred");
		
		List<Action> actionsList = fred.getActionList();
		for (int i = 0; i < actionsList.size(); i++) {
			System.out.println(actionsList.get(i).getName());
		}
		
		List<Weapon> weaponsList = fred.getAllowedWeaponList();
		System.out.println("\n" + weaponsList);
		
		List<Armor> armorList = fred.getAllowedArmorList();
		System.out.println("\n" + armorList);
		
		System.out.println("\n" + fred + "\n");
		
		fred.putOnArmor(Armor.CHAIN);
		System.out.println(fred + "\n");
		
		fred.takeOffArmor();
		System.out.println(fred + "\n");
		
		fred.wield(Weapon.AXE);
		System.out.println(fred + "\n");
		
		Fighter felix = new Fighter("Felix");
		felix.putOnArmor(Armor.LEATHER);
		felix.wield(Weapon.SPEAR);
		System.out.println("\n" + felix);
		System.out.println();
		
		System.out.println("\nWhen Fred has won " + Fighter.NUMBER_FIGHTS_WON_TO_LEVEL_UP + " fights, his level should increase.");
		boolean wonFight = fred.fight(felix);
		System.out.println("\nFred won? " + wonFight);
		System.out.println(fred);
		
		wonFight = fred.fight(felix);
		System.out.println("\nFred won? " + wonFight);
		System.out.println(fred);
		
		System.out.println("\nFred switches weapons");
		fred.unwield();
		fred.wield(Weapon.DAGGER);
		wonFight = fred.fight(felix);
		System.out.println("\nFred won? " + wonFight);
		System.out.println(fred);
		
		wonFight = fred.fight(felix);
		System.out.println("\nFred won? " + wonFight);
		System.out.println(fred);
		
		System.out.println("\nIf Fred has leveled up, he should have additional weapon choices and armor choices.");
		weaponsList = fred.getAllowedWeaponList();
		System.out.println("\n" + weaponsList);
		
		armorList = fred.getAllowedArmorList();
		System.out.println("\n" + armorList);
		
	}

}
