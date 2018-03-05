package moves;

import energy.EnergyCost;

/**
 * Represents a move that a pokemon can perform.
 */
public class Move {
	/**
	 * The name of the move.
	 */
	private String name;
	/**
	 * The energy cost of the move.
	 */
	private EnergyCost cost;
	
	/**
	 * Creates a new instance of the Move class.
	 * @param name The name of the move.
	 * @param cost The energy cost of the move.
	 */
	public Move(String name, EnergyCost cost) {
		this.name = name;
		this.cost = cost;
	}
	
	/**
	 * Gets the name of the move.
	 * @return The name of the move.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the energy cost of the move.
	 * @return The energy cost of the move.
	 */
	public EnergyCost getEnergyCost() {
		return this.cost;
	}
}
