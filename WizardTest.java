import java.util.List;

/**
 * Some test code to check Wizard class independent of BasicRPGDriver.
 * This assumes your RPGCharacter class was correct and so it testing
 * the methods added in the Wizard class.
 * 
 * To thoroughly test the Wizard class, you would need to add more statements.
 * Feel free to do so.
 * 
 * Realize that the caseSpell and regainSpell methods roll a die which is random
 * so take that into consideration when you compare to my output. Since only a
 * Fighter can have armor, this test code also uses a Fighter to for some
 * testing of castSpell.
 *
 */
public class WizardTest {
	
	public static void main(String[] args) {
		Wizard willy = new Wizard("Willy");
		
		List<Action> actionsList = willy.getActionList();
		for (int i = 0; i < actionsList.size(); i++) {
			System.out.println(actionsList.get(i).getName());
		}
		
		List<Weapon> weaponsList = willy.getAllowedWeaponList();
		System.out.println("\n" + weaponsList);
		
		List<Armor> armorList = willy.getAllowedArmorList();
		System.out.println("\n" + armorList);
		
		System.out.println("\n" + willy);
		
		Fighter fred = new Fighter("Fred");
		System.out.println("\n" + fred + "\n");	
		
		willy.castSpell(Spell.FIREBALL, fred);		
		System.out.println(willy);
		System.out.println(fred + "\n");
		
		willy.castSpell(Spell.LIGHTNING_BOLT, fred);	
		System.out.println(willy);
		System.out.println(fred + "\n");
		
		willy.castSpell(Spell.CONE_OF_COLD, fred);	
		System.out.println(willy);
		System.out.println(fred + "\n");
		
		willy.regainSpellPoints();
		System.out.println(willy + "\n");
		
		willy.regainSpellPoints();
		System.out.println(willy + "\n");

		willy.regainSpellPoints();
		System.out.println(willy + "\n");
		
		System.out.println("Give Fred some armor to defend himself.");
		fred.putOnArmor(Armor.PLATE);
		willy.castSpell(Spell.FIREBALL, fred);
		System.out.println(willy);
		System.out.println(fred);
		System.out.println();
		
		willy.castSpell(Spell.HEAL, fred);
		System.out.println(willy);
		System.out.println(fred);
		System.out.println();
		
		willy.castSpell(Spell.HEAL, willy);
		System.out.println(willy);		
	}

}
