/**
 * MultiSidesDie represents a die with any number of sides.
 * 
 */
import java.util.*;
//Do not change this class!
public class MultiSidedDie {
	public static final int DEFAULT_NUM_SIDES = 6;
	private static Random randGen = new Random();
	// data fields
	private int numSides;
	private int value;
	
	/**
	 * Constructs a Die with the number of sides received
	 * @param numSides - the number of sides for the die
	 */
	public MultiSidedDie(int numSides) {
		this.numSides = numSides;
		roll();	
	}
	
	/**
	 * Constructs a die with 6 sides
	 */
	public MultiSidedDie() {
		this(DEFAULT_NUM_SIDES);
	}

	/**
	 * Rolls the die
	 */
	public void roll() {
		value = randGen.nextInt(1, numSides + 1);
	}
	
	/**
	 * Returns the current value of this die
	 * @return the current value of this die
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Returns the number of sides of this die
	 * @return the number of sides of this die
	 */
	public int getNumSides() {
		return numSides;
	}
	
	/**
	 * Returns a string representation of this die
	 * @return a string representation of this die
	 */
	public String toString() {
		return "MultiSidedDie [numSides = " + numSides + ", value = " + value + "]";
	}
}
