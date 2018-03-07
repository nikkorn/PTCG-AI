package match;

import java.util.Random;

/**
 * Represents a coin to flip
 */
public class Coin {
	/**
	 * The rng to use for coin flips.
	 */
	private Random rng;
	/**
	 * Enumeration for coin flip results.
	 */
	public enum FlipResult { HEADS, TAILS }
	
	/**
	 * Creates a new instance of the Coin class.
	 * @param rng The rng to use for coin flips.
	 */
	public Coin(Random rng) {
		this.rng = rng;
	}
	
	/**
	 * Flip the coin!
	 * @return The flip result.
	 */
	public FlipResult flip() {
		return this.rng.nextBoolean() ? FlipResult.HEADS : FlipResult.TAILS;
	}
}
