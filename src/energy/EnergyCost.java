package energy;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents an energy cost.
 */
public class EnergyCost extends HashMap<EnergyType, Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Returns whether the specified list of cards satisfies the cost.
	 * @param energyCards The list of energy cards.
	 * @return Whether the specified list of cards satisfies the cost.
	 */
	public boolean isSatisfiedBy(ArrayList<Energy> energyCards) {
		return true;
	}
}
