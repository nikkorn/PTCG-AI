package pokemon;

import energy.Energy;

/**
 * Represents a type resistance.
 */
public class Resistance {
	/**
	 * The energy there is a resistance to.
	 */
	private Energy resistance;
	/**
	 * The resistance multiplier.
	 */
	private int multiplier;
	
	/**
	 * Creates a new instance of the Resistance class.
	 * @param resistance The energy there is a resistance to.
	 * @param multiplier The resistance multiplier.
	 */
	public Resistance(Energy resistance, int multiplier) {
		this.resistance = resistance;
		this.multiplier = multiplier;
	}
	
	/**
	 * Gets the resistance type.
	 * @return The resistance type.
	 */
	public Energy getResistanceType() {
		return this.resistance;
	}
	
	/**
	 * Gets the resistance multiplier.
	 * @return The resistance multiplier.
	 */
	public int getMultiplier() {
		return this.multiplier;
	}
}
