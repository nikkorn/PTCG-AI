package pokemon;

import energy.Energy;

/**
 * Represents a type weakness.
 */
public class Weakness {
	/**
	 * The energy there is a weakness to.
	 */
	private Energy weakness;
	/**
	 * The weakness multiplier.
	 */
	private int multiplier;
	
	/**
	 * Creates a new instance of the Weakness class.
	 * @param weakness The energy there is a weakness to.
	 * @param multiplier The weakness multiplier.
	 */
	public Weakness(Energy weakness, int multiplier) {
		this.weakness   = weakness;
		this.multiplier = multiplier;
	}
	
	/**
	 * Gets the weakness type.
	 * @return The weakness type.
	 */
	public Energy getWeaknessType() {
		return this.weakness;
	}
	
	/**
	 * Gets the weakness multiplier.
	 * @return The weakness multiplier.
	 */
	public int getMultiplier() {
		return this.multiplier;
	}
}
