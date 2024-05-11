
/**
 * TextChoice class allows Strings to be Chooseable
 * objects in a menu. Basically, since we can't 
 * make the String class implement the Chooseable
 * interface, we'll use this class instead.
 */
// Do not change this class
public class TextChoice implements Chooseable {
	private String text;
	
	/**
	 * Constructs a text choice with this text
	 * @param text - the choice for this object
	 */
	public TextChoice(String text) {
		this.text = text;
	}

	@Override
	public String getName() {
		return text;
	}
	
	@Override
	public String toString() {
		return text;
	}
}
