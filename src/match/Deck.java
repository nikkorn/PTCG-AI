package match;

import java.util.ArrayList;
import java.util.Collections;
import card.ICard;

/**
 * Represents the deck of a participant.
 */
public class Deck extends ArrayList<ICard> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The name of the deck.
	 */
	private String name;
	
	/**
	 * Creates a new instance of the Deck class.
	 * @param name The name of the deck.
	 */
	public Deck(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the name of the deck.
	 * @return The name of the deck.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Shuffle the deck.
	 */
	public void shuffle() {
		Collections.shuffle(this);
	}
	
	/**
	 * Pick up and remove the specified number of cards from the top of the deck.
	 * @param amount The number of cards to pick up.
	 * @return The cards that were picked up.
	 */
	public ArrayList<ICard> pickUpCards(int amount) {
		return null;
	}
	
	/**
	 * Pick up and remove the top cards of the deck.
	 * @return The top card of the deck.
	 */
	public ICard pickUp() {
		return this.pickUpCards(1).get(0);
	}
	
	/**
	 * Peek at the specified number of cards from the top of the deck.
	 * @param amount The number of cards to peek at.
	 * @return The cards that were picked up.
	 */
	public ArrayList<ICard> peekAtCards(int amount) {
		return null;
	}
	
	/**
	 * Peek at the top card of the deck.
	 * @return The top card of the deck.
	 */
	public ICard peek() {
		return this.peekAtCards(1).get(0);
	}
}
