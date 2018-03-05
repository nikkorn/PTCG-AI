package trainer;

import card.CardType;
import card.ICard;

/**
 * Represents a trainer card.
 */
public class Trainer implements ICard {
	/**
	 * The name of the trainer card.
	 */
	private String name;
	
	/**
	 * Creates a new instance of the Trainer class.
	 * @param name The name of the trainer card.
	 */
	public Trainer(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the name of the trainer card.
	 * @return The name of the trainer card.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the card type.
	 * @return The card type.
	 */
	@Override
	public CardType getType() { return CardType.TRAINER; }
}
